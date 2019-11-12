package com.luis.test.kinedu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import java.util.Objects;

public class Detailed_article extends AppCompatActivity implements View.OnClickListener {

    private Spinner spinner;
    private String body;
    private String imageUrl;
    private String title;
    private String link;
    private TextView title_view;
    private WebView webView;
    private ImageView detaiImage;
    private TextView toolbar_title;
    private ImageView share_image;
    private ImageView back;

    public static final String VIEW_IMAGE="image";
    public static final String VIEW_TITLE="title";
    public static final String VIEW_DESCRIPTION="description";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_article);

        spinner = findViewById(R.id.range_spinner);
        detaiImage = findViewById(R.id.detail_image);
        webView = findViewById(R.id.article_description_wv);
        toolbar_title = findViewById(R.id.app_toolbar_title);
        title_view = findViewById(R.id.article_title_detail_text);
        share_image = findViewById(R.id.share_icon_img);
        back = findViewById(R.id.back_arrow);

        spinner.setVisibility(View.GONE);
        toolbar_title.setVisibility(View.GONE);

        title =Objects.requireNonNull(getIntent().getStringExtra("title"));
        body =Objects.requireNonNull(getIntent().getStringExtra("body"));
        imageUrl = Objects.requireNonNull(getIntent().getStringExtra("picture"));
        link =Objects.requireNonNull(getIntent().getStringExtra("link"));

            String html = body;
            String mime = "text/html";
            String encoding = "utf-8";

            webView.loadDataWithBaseURL(null, html, mime, encoding, null);
            Picasso.get().load(imageUrl).into(detaiImage);
            title_view.setText(title);

        ViewCompat.setTransitionName(title_view,VIEW_TITLE);
        ViewCompat.setTransitionName(webView,VIEW_DESCRIPTION);
        ViewCompat.setTransitionName(detaiImage,VIEW_IMAGE);

            share_image.setOnClickListener(this);
            back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.share_icon_img:
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, title);
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, link);
                startActivity(Intent.createChooser(sharingIntent, "Share this article!"));
                break;

            case R.id.back_arrow:
                onBackPressed();
                break;

        }
    }
}


