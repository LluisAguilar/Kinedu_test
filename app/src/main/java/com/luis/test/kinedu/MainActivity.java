package com.luis.test.kinedu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.luis.test.kinedu.Interfaces.OnSpinnerItemSelected;
import com.luis.test.kinedu.Interfaces.OnSpinnerItemSelectedArt;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Spinner rangeSpinner;
    ImageView back;
    List<String> rangeList = new ArrayList<>();
    Toolbar toolbar;
    ViewPager viewPager;
    private TabLayout tabLayout;
    boolean first=true;
    int value=0;
    private OnSpinnerItemSelected onSpinnerItemSelected;
    private OnSpinnerItemSelectedArt onSpinnerItemSelectedArt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rangeSpinner = findViewById(R.id.range_spinner);
        back = findViewById(R.id.back_arrow);
        toolbar = findViewById(R.id.actionBar_toolbar);
        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabs);
        updateViewPager(this);
        dataToList();
        setSpinnerAdapter();

        rangeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (!first) {
                    value=position;
                    onSpinnerItemSelected.getSpinnerPosition(position);
                    onSpinnerItemSelectedArt.getSpinnerPositionArt(position);
                }else{
                    first=false;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    public void updateViewPager(Context context) {
        setSupportActionBar(toolbar);
        ViewPagerAdapter adapterpager = new ViewPagerAdapter(getSupportFragmentManager(),context);
        viewPager.setAdapter(adapterpager);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void dataToList() {
        rangeList.add("ALL MONTHS");
        rangeList.add("0-1 MONTH");
        rangeList.add("2 MONTHS");
        rangeList.add("3 MONTHS");
        rangeList.add("4 MONTHS");
        rangeList.add("5 MONTHS");
        rangeList.add("6 MONTHS");
        rangeList.add("7 MONTHS");
        rangeList.add("8 MONTHS");
        rangeList.add("9 MONTHS");
        rangeList.add("10 MONTHS");
        rangeList.add("11 MONTHS");
        rangeList.add("12 MONTHS");
        rangeList.add("13 MONTHS");
        rangeList.add("14 MONTHS");
        rangeList.add("15 MONTHS");
        rangeList.add("16 MONTHS");
    }

    private void setSpinnerAdapter() {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_style,rangeList) {

            public View getView(int position, View convertView,ViewGroup parent) {
                View v= super.getView(position, convertView, parent);
                ((TextView) v).setTextSize(15);
                return v;
            }

            public View getDropDownView(int position, View convertView, ViewGroup parent) {
                View v = super.getView(position, convertView, parent);
                ((TextView) v).setGravity(Gravity.CENTER);
                ((TextView) v).setTextColor(getResources().getColor(R.color.colorPrimary));
                v.setPadding(10,15,10,15);
                Log.e("textV",((TextView) v).getText().toString());
                (v).setBackgroundColor(getResources().getColor(R.color.white));
                return v;
            }
        };
        rangeSpinner.setAdapter(adapter);
    }

        public void getAge(OnSpinnerItemSelected onSpinnerItemSelected){
        this.onSpinnerItemSelected=onSpinnerItemSelected;
    }

    public void getAgeArt(OnSpinnerItemSelectedArt onSpinnerItemSelectedArt){
        this.onSpinnerItemSelectedArt=onSpinnerItemSelectedArt;
    }

}
