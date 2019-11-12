package com.luis.test.kinedu.RecyclerAdapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.luis.test.kinedu.Interfaces.OnItemArticleClickListener;
import com.luis.test.kinedu.POJO.Article;
import com.luis.test.kinedu.R;
import com.squareup.picasso.Picasso;
import java.util.List;

public class ArticlesRecyclerAdapter extends RecyclerView.Adapter<ArticlesRecyclerAdapter.ViewHolder> implements View.OnClickListener {

    List<Article> articles;
    Context context;
    private OnItemArticleClickListener listener;

    public ArticlesRecyclerAdapter(List<Article> articles, Context context, OnItemArticleClickListener listener){
        this.articles = articles;
        this.context=context;
        this.listener=listener;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.articles_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {

        holder.title.setText(articles.get(position).getName());
        holder.description.setText(articles.get(position).getShortDescription());

        Picasso.get()
                .load(articles.get(position).getPicture())
                .fit()
                .centerCrop()
                .into(holder.imageView);

        holder.cardView.setOnClickListener(this);
        holder.cardView.setTag(position);

    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    @Override
    public void onClick(View view) {

        listener.onItemArticleClick(articles,Integer.parseInt(String.valueOf(view.getTag())));

    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView title;
        TextView description;
        CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.acticle_image);
            title = itemView.findViewById(R.id.article_title_text);
            description = itemView.findViewById(R.id.article_description_text);
            cardView = itemView.findViewById(R.id.article_cardView);

        }
    }
}

