package com.luis.test.kinedu;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;

import com.luis.test.kinedu.POJO.Activity_;

import java.util.List;

public class MyDiffCallback extends DiffUtil.Callback{

    List<Activity_> oldActivities;
    List<Activity_> newActivities;

    public MyDiffCallback(List<Activity_> newActivities, List<Activity_> oldActivities) {
        this.newActivities = newActivities;
        this.oldActivities = oldActivities;
    }

    @Override
    public int getOldListSize() {
        return oldActivities.size();
    }

    @Override
    public int getNewListSize() {
        return newActivities.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return oldActivities.get(oldItemPosition).getId() == newActivities.get(newItemPosition).getId();
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return oldActivities.get(oldItemPosition).equals(newActivities.get(newItemPosition));
    }

    @Nullable
    @Override
    public Object getChangePayload(int oldItemPosition, int newItemPosition) {
        //you can return particular field for changed item.
        return super.getChangePayload(oldItemPosition, newItemPosition);
    }
}
