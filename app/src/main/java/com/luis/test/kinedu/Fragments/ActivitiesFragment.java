package com.luis.test.kinedu.Fragments;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.luis.test.kinedu.Interfaces.ActivitiesResponse;
import com.luis.test.kinedu.Interfaces.OnItemActivityClickListener;
import com.luis.test.kinedu.Interfaces.OnSpinnerItemSelected;
import com.luis.test.kinedu.MainActivity;
import com.luis.test.kinedu.POJO.Activity_;
import com.luis.test.kinedu.R;
import com.luis.test.kinedu.RecyclerAdapters.ActivitiesRecyclerAdapter;
import com.luis.test.kinedu.WsHandler.RequestMethods;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ActivitiesFragment extends Fragment implements ActivitiesResponse , OnSpinnerItemSelected{

    private RecyclerView activityRecycler;
    private ProgressBar activityProgressBar;
    private RequestMethods req;
    private String skillId="5";
    private String babyId="2064732";
    private int age;
    Context context;
    private ActivitiesRecyclerAdapter activitiesRecyclerAdapter;
    private List<Activity_> activityList = new ArrayList<>();

    public ActivitiesFragment(Context context) {
        this.context=context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_activities, container, false);
        activityRecycler = v.findViewById(R.id.activities_recycler);
        activityProgressBar = v.findViewById(R.id.activity_progress_bar);


        req = new RequestMethods(context);
        req.getActivities(skillId,babyId,0);
        req.onActivityResponse(this);
        setListener();
        return v;
    }

    public void setListener(){
        ((MainActivity) getActivity()).getAge(this);
    }

    @Override
    public void getActivities(List<Activity_> list, boolean isCorrect) {

        if (isCorrect){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        activityRecycler.setLayoutManager(linearLayoutManager);

        int listPos=0;
        if (age==0){
            activityList = list;
        }else{
        for (int x =0;x<list.size();x++){
            if (list.get(x).getAge()==age){
                activityList.add(listPos,list.get(x));
                listPos++;
            }
        }}
        activitiesRecyclerAdapter = new ActivitiesRecyclerAdapter(activityList, context, new OnItemActivityClickListener() {
            @Override
            public void onItemClick(List<Activity_> list, int position) {
                //TODO: action for onclick
            }
        });
        activityRecycler.setAdapter(activitiesRecyclerAdapter);
    }
        activityProgressBar.setVisibility(View.GONE);

    }

    public void update(int age){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        activityRecycler.setLayoutManager(linearLayoutManager);

        List<Activity_> list = new ArrayList<>();
        int listPos=0;
        if (age==0){
            list = activityList;
        }else{
            for (int x =0;x<activityList.size();x++){
                if (activityList.get(x).getAge()==age){
                    list.add(listPos,activityList.get(x));
                    listPos++;
                }
            }}
        activitiesRecyclerAdapter = new ActivitiesRecyclerAdapter(list, context, new OnItemActivityClickListener() {
            @Override
            public void onItemClick(List<Activity_> list, int position) {

            }
        });
        activityRecycler.setAdapter(activitiesRecyclerAdapter);
    }

    @Override
    public void getSpinnerPosition(int age) {
        update(age);
    }
}
