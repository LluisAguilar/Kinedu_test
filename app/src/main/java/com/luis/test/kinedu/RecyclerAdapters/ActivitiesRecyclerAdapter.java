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

import com.luis.test.kinedu.Interfaces.OnItemActivityClickListener;
import com.luis.test.kinedu.POJO.Activity_;
import com.luis.test.kinedu.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ActivitiesRecyclerAdapter extends RecyclerView.Adapter<ActivitiesRecyclerAdapter.ViewHolder> implements View.OnClickListener {

    List<Activity_> activities;
    Context context;
    private OnItemActivityClickListener listener;

    public ActivitiesRecyclerAdapter(List<Activity_> activities, Context context, OnItemActivityClickListener listener){
        this.activities = activities;
        this.context=context;
        this.listener=listener;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activities_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        holder.title.setText(activities.get(position).getName());
        holder.purpose.setText(activities.get(position).getPurpose());

        Picasso.get()
                .load(activities.get(position).getThumbnail())
                .fit()
                .centerCrop()
                .into(holder.imageView);

        holder.cardView.setOnClickListener(this);
        holder.cardView.setTag(position);

    }

    @Override
    public int getItemCount() {
        return activities.size();
    }

    @Override
    public void onClick(View view) {

        listener.onItemClick(activities,Integer.parseInt(String.valueOf(view.getTag())));

    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView title;
        TextView purpose;
        CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.activity_image);
            title = itemView.findViewById(R.id.activity_title_text);
            purpose = itemView.findViewById(R.id.activity_purpose_text);
            cardView = itemView.findViewById(R.id.activity_cardView);

        }
    }

}

