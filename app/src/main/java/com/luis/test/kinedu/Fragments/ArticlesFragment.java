package com.luis.test.kinedu.Fragments;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.luis.test.kinedu.Interfaces.ArticlesResponse;
import com.luis.test.kinedu.Interfaces.OnItemArticleClickListener;
import com.luis.test.kinedu.Interfaces.OnSpinnerItemSelectedArt;
import com.luis.test.kinedu.MainActivity;
import com.luis.test.kinedu.POJO.Article;
import com.luis.test.kinedu.R;
import com.luis.test.kinedu.RecyclerAdapters.ArticlesRecyclerAdapter;
import com.luis.test.kinedu.WsHandler.RequestMethods;

import java.util.ArrayList;
import java.util.List;
/**
 * A simple {@link Fragment} subclass.
 */
public class ArticlesFragment extends Fragment implements ArticlesResponse, OnSpinnerItemSelectedArt {

    private RecyclerView articleRecycler;
    private ArticlesRecyclerAdapter articlesRecyclerAdapter;
    RequestMethods requestMethods;
    Context context;
    View view;
    private int age;
    private List<Article> activityList = new ArrayList<>();
    private ProgressBar articleProgressBar;

    public ArticlesFragment(Context context) {
        this.context=context;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_articles, container, false);

        articleRecycler = v.findViewById(R.id.articles_recycler);
        articleProgressBar = v.findViewById(R.id.article_progress_bar);

        requestMethods= new RequestMethods(context);
        requestMethods.getArticles("5","2064732");
        requestMethods.onArticlesResponse(this);
        setListener();
        view=v;
        return v;
    }

    public void setListener(){
        ((MainActivity) getActivity()).getAgeArt(this);
    }

    @Override
    public void getArticles(List<Article> list, boolean isCorrect) {

        if (isCorrect) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
            linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
            articleRecycler.setLayoutManager(linearLayoutManager);

            int listPos = 0;
            if (age == 0) {
                activityList = list;
            } else {
                for (int x = 0; x < list.size(); x++) {
                    if (list.get(x).getMinAge() >= age && list.get(x).getMaxAge() <= age) {
                        activityList.add(listPos, list.get(x));
                        listPos++;
                    }
                }
            }

            articlesRecyclerAdapter = new ArticlesRecyclerAdapter(list, context, new OnItemArticleClickListener() {
                @Override
                public void onItemArticleClick(List<Article> list, int position) {
                    requestMethods.getArticleDetail(list.get(position).getId(), view);
                }
            });
            articleRecycler.setAdapter(articlesRecyclerAdapter);
        }
        articleProgressBar.setVisibility(View.GONE);
    }

    public void update(int age){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        articleRecycler.setLayoutManager(linearLayoutManager);

        List<Article> list = new ArrayList<>();
        int listPos=0;
        if (age==0){
            list = activityList;
        }else{
            for (int x =0;x<activityList.size();x++){
                if (activityList.get(x).getMinAge()<=age && activityList.get(x).getMaxAge()>=age){
                    list.add(listPos,activityList.get(x));
                    listPos++;
                }
            }}
        articlesRecyclerAdapter = new ArticlesRecyclerAdapter(list, context, new OnItemArticleClickListener() {
            @Override
            public void onItemArticleClick(List<Article> list, int position) {
                requestMethods.getArticleDetail(list.get(position).getId(),view);
            }
        });
        articleRecycler.setAdapter(articlesRecyclerAdapter);

    }

    @Override
    public void getSpinnerPositionArt(int age) {
        update(age);
    }
}
