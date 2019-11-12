package com.luis.test.kinedu;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.luis.test.kinedu.Fragments.ActivitiesFragment;
import com.luis.test.kinedu.Fragments.ArticlesFragment;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    Context context;
    public ViewPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context=context;
    }

    @Override
    public Fragment getItem(int position) {
        ActivitiesFragment activitiesFragment = new ActivitiesFragment(context);
        ArticlesFragment articlesFragment = new ArticlesFragment(context);
        Fragment fragment = new Fragment();

        if (position==0) {
            fragment = activitiesFragment;
        }else if (position==1){
            fragment = articlesFragment;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        position = position+1;
        String tabTittle="Activities";
        if (position==2){
            tabTittle = "Articles";
        }
        return tabTittle;
    }
}
