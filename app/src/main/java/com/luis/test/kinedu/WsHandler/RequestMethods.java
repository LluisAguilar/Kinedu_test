package com.luis.test.kinedu.WsHandler;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.util.Pair;

import com.luis.test.kinedu.Detailed_article;
import com.luis.test.kinedu.Interfaces.ActivitiesResponse;
import com.luis.test.kinedu.Interfaces.ArticlesResponse;
import com.luis.test.kinedu.POJO.Response;
import com.luis.test.kinedu.R;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;

public class RequestMethods {

    Context context;
    private HttpConectionHandler conectionHandler;
    private Map<String, String> map = new HashMap<>();
    private Call<Response> responseService;
    private ActivitiesResponse activitiesResponse;
    private ArticlesResponse articlesResponse;
    private Dialog customDialog;

    public RequestMethods(Context context){
        this.context = context;
        conectionHandler = RetrofitClientUtils.getApi().create(HttpConectionHandler.class);
        map.put("Authorization","Token token=5105f4358e45f6f98057a654c882b7742c3ac5241c81a706acc48c84f8acde9f8a344993ac42369627ae9f2caf1eed42ff1be9562fe2167c9c80908e76e95c49");
        map.put("Content-Type","application/json");
        customDialog = new Dialog(context);
    }

    public void getActivities(String skillId, String babyID, final int age) {
        responseService = conectionHandler.getActivities(map,skillId,babyID);
        responseService.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                Response responseService = response.body();
                if (response.isSuccessful()){
                        activitiesResponse.getActivities(responseService.getData().getActivities(),true);
                }else {
                    activitiesResponse.getActivities(null,false);
                    if (!customDialog.isShowing()) {
                        infoAlert(context.getResources().getString(R.string.Alert_title), context.getResources().getString(R.string.Alert_msg2));
                    }
                }
            }
            @Override
            public void onFailure(Call<Response> call, Throwable t) {

                activitiesResponse.getActivities(null,false);
                if (!customDialog.isShowing()) {
                infoAlert(context.getResources().getString(R.string.Alert_title),context.getResources().getString(R.string.Alert_msg1));
            }
            }
        });
    }

    public void getArticles(String skillId, String babyID) {
        responseService = conectionHandler.getArticles(map,skillId,babyID);
        responseService.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                Response responseService = response.body();
                if (response.isSuccessful()){
                        articlesResponse.getArticles(responseService.getData().getArticles(),true);
                }else {
                    articlesResponse.getArticles(null,false);
                    if (!customDialog.isShowing()) {
                        infoAlert(context.getResources().getString(R.string.Alert_title), context.getResources().getString(R.string.Alert_msg2));
                    }
                }
            }
            @Override
            public void onFailure(Call<Response> call, Throwable t) {

                articlesResponse.getArticles(null,false);
                if (!customDialog.isShowing()) {
                    infoAlert(context.getResources().getString(R.string.Alert_title), context.getResources().getString(R.string.Alert_msg1));
                }
            }
        });
    }

    public void getArticleDetail(Integer articleId, final View view) {

        String url = "articles/"+articleId;
        System.out.println("myJson "+url);
        responseService = conectionHandler.getArticleDetail(map,url);
        responseService.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                Response responseService = response.body();
                if (response.isSuccessful()){
                    try {

                        Intent intent = new Intent(context, Detailed_article.class);
                        intent.putExtra("title",responseService.getData().getArticle().getTitle());
                        intent.putExtra("body",responseService.getData().getArticle().getBody());
                        intent.putExtra("picture",responseService.getData().getArticle().getPicture());
                        intent.putExtra("link",responseService.getData().getArticle().getLink());

                        ActivityOptionsCompat activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) context,
                                //Now we provide a list of Pair items which contain the view we can transitioning
                                //from, and the name of the view it is transitioning to, in the launched activity
                                new Pair<>(view.findViewById(R.id.acticle_image), Detailed_article.VIEW_IMAGE),
                                new Pair<>(view.findViewById(R.id.article_title_text), Detailed_article.VIEW_TITLE),
                                new Pair<>(view.findViewById(R.id.article_description_text), Detailed_article.VIEW_DESCRIPTION));

                        // Now we can start the Activity, providing the activity options as a bundle
                        ActivityCompat.startActivity(context, intent, activityOptions.toBundle());

                    }catch (NullPointerException e){
                        Log.e("response_data","Null values on list");
                    }
                }else {
                    Log.e("response_data","Error request");
                }
            }
            @Override
            public void onFailure(Call<Response> call, Throwable t) {

                Log.e("response_data","Error: "+t.getMessage());
            }
        });

    }

    public void infoAlert(String title, String body) {
        customDialog = new Dialog(context, R.style.Theme_Dialog_Translucent);
        customDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        customDialog.setCancelable(true);
        customDialog.setContentView(R.layout.alert_dialog_kinedu);
        customDialog.getWindow().setBackgroundDrawable(new ColorDrawable(context.getResources().getColor(R.color.transparent)));

        ((Button) customDialog.findViewById(R.id.confirm_button_check)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                customDialog.dismiss();

            }
        });

        ((TextView)customDialog.findViewById(R.id.title_alert)).setText(title);
        ((TextView)customDialog.findViewById(R.id.body_alert)).setText(body);

        customDialog.show();
    }


    public void onActivityResponse(ActivitiesResponse activitiesResponse){
        this.activitiesResponse=activitiesResponse;
    }

    public void onArticlesResponse(ArticlesResponse articlesResponse){
        this.articlesResponse=articlesResponse;
    }
}
