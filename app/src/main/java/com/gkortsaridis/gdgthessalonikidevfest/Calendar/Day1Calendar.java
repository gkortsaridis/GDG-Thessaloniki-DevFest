package com.gkortsaridis.gdgthessalonikidevfest.Calendar;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.gkortsaridis.gdgthessalonikidevfest.R;
import com.gkortsaridis.gdgthessalonikidevfest.Speakers.SpeakerActivity;
import com.gkortsaridis.gdgthessalonikidevfest.Speakers.spClass;

public class Day1Calendar extends Fragment {

    LinearLayout tzinis;
    spClass tzinisSp;

    public Day1Calendar() {
        // Required empty public constructor
        tzinisSp = new spClass("See more of your world\nDigital Skills","Panayotis Tzinis", "1. Introducing Tango devices and what you can do with AR (Augmented Reality)\n" +
                "\n" +
                "2. Digital Skills | Participants will choose what codelabs between Google Analytics and AdWords they would like to follow\n" +
                "\n" +
                "3. Moral Machine | An open debate on Morality – Humanity – Machinery", R.drawable.tzinis, "THEATER" , "17.00");
        tzinisSp.setWebUrl("http://mustafar.xyz/");
        tzinisSp.setTwitterUrl("https://twitter.com/ptzinis");
        tzinisSp.setGplusUrl("https://plus.google.com/u/0/+PanayotisTzinis");

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_day1_calendar, null);

        tzinis = (LinearLayout) view.findViewById(R.id.tzinis);
        tzinis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),SpeakerActivity.class);
                intent.putExtra("title",tzinisSp.getTitle());
                intent.putExtra("name",tzinisSp.getName());
                intent.putExtra("room",tzinisSp.getRoom());
                intent.putExtra("time",tzinisSp.getTime());
                intent.putExtra("talkDescription",tzinisSp.getDesc());
                intent.putExtra("prof",tzinisSp.getPicture());

                intent.putExtra("fb",tzinisSp.getFbUrl());
                intent.putExtra("gplus",tzinisSp.getGplusUrl());
                intent.putExtra("twitter",tzinisSp.getTwitterUrl());
                intent.putExtra("github",tzinisSp.getGithubUrl());
                intent.putExtra("insta",tzinisSp.getInstaUrl());
                intent.putExtra("web",tzinisSp.getWebUrl());
                intent.putExtra("linkedin",tzinisSp.getLinkedinUrl());
                startActivity(intent);
            }
        });

        return view;
    }

}
