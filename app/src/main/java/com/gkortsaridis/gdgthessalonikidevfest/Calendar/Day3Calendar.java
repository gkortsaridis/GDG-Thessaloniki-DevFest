package com.gkortsaridis.gdgthessalonikidevfest.Calendar;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gkortsaridis.gdgthessalonikidevfest.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Day3Calendar extends Fragment {


    public Day3Calendar() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_day2_calendar, null);
        return view;
    }

}
