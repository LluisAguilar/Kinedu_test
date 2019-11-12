package com.luis.test.kinedu.Interfaces;

import com.luis.test.kinedu.POJO.Activity_;

import java.util.List;

public interface ActivitiesResponse{
    void getActivities(List<Activity_> list,boolean isCorrect);
}
