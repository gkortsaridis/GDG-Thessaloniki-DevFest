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

/**
 * A simple {@link Fragment} subclass.
 */
public class Day3Calendar extends Fragment {

    spClass kortsaridis, stavroulakis, tzinis,tzinis1, pittas,nalbantis;
    LinearLayout kortsaridisLL, stavroulakisLL, tzinisLL,tzinisLL1, pittasLL, nalbantisLL;

    public Day3Calendar() {
        // Required empty public constructor
        pittas = new spClass("Facebook Messenger Bots","George Pittas", "Every month, over 900 million people around the world communicate with friends, families and over 50 million businesses on Messenger. Over the past year Facebook has been expanding what people can do on Messenger. Part of that effort are the Bots. Bots can provide anything from automated subscription content like weather and news updates, to customized communications like receipts, shipping notifications, and live automated messages all by interacting directly with the people who want to get them. On that session we will focus on the Messenger’s capabilities, benefits for the businesses and how we can build our own Bot using wit.ai for human-like conversations.", R.drawable.pittas, "Facebook Room\nE1 | Fifth Floor" , "13.30");
        pittas.setWebUrl("http://www.obstechnologies.com/");

        kortsaridis = new spClass("Hack the Real World with ANDROID THINGS","George Kortsaridis", "ANROID THINGS is coming to town! Together, we will dive into more details about the I.O.T architecture, and we will learn how to code our awesome projects and hack our way to the top!", R.drawable.kortsaridis, "Android Things Room\nB3 | Second Floor" , "13.30");
        kortsaridis.setGplusUrl("https://plus.google.com/u/0/+GeorgeKortsaridis1");
        kortsaridis.setLinkedinUrl("https://www.linkedin.com/in/georgekortsaridis/");
        kortsaridis.setGithubUrl("https://github.com/gkortsaridis");
        kortsaridis.setFbUrl("https://www.facebook.com/gkortsaridis");

        stavroulakis = new spClass("Getting Started with Progressive Web Apps","Bill Stavroulakis", "Progressive Web Apps consist of a new palette of technologies such as the web app manifest, homescreen install support, service workers and the app shell. These bridge the gap between native and web apps offering new capabilities for web developers to create amazing desktop and mobile experiences.", R.drawable.stavroulakis, "PWA Room\nA1 | First Floor" , "13.30");
        stavroulakis.setTwitterUrl("https://twitter.com/bstavroulakis");
        stavroulakis.setGithubUrl("https://github.com/bstavroulakis");

        tzinis = new spClass("See more of your world\nDigital Skills\nMoral Machine","Panayotis Tzinis", "1. Introducing Tango devices and what you can do with AR (Augmented Reality)\n" +
                "\n" +
                "2. Digital Skills | Participants will choose what codelabs between Google Analytics and AdWords they would like to follow\n" +
                "\n" +
                "3. Getting Started with Machine Learning | Introduction to the world of Machine Learning", R.drawable.tzinis, "THEATER" , "13.30");
        tzinis.setWebUrl("http://mustafar.xyz/");
        tzinis.setTwitterUrl("https://twitter.com/ptzinis");
        tzinis.setGplusUrl("https://plus.google.com/u/0/+PanayotisTzinis");

        tzinis1 = new spClass("See more of your world\nDigital Skills\nMoral Machine","Panayotis Tzinis", "1. Introducing Tango devices and what you can do with AR (Augmented Reality)\n" +
                "\n" +
                "2. Digital Skills | Participants will choose what codelabs between Google Analytics and AdWords they would like to follow\n" +
                "\n" +
                "3. Getting Started with Machine Learning | Introduction to the world of Machine Learning", R.drawable.tzinis, "THEATER" , "17.30");
        tzinis1.setWebUrl("http://mustafar.xyz/");
        tzinis1.setTwitterUrl("https://twitter.com/ptzinis");
        tzinis1.setGplusUrl("https://plus.google.com/u/0/+PanayotisTzinis");

        nalbantis = new spClass("Exponential Growth. What next?","Michael E. Nalbantis", "Discussing about humanity’ s growth in general and also how techonlogy will affect our every day lives", R.drawable.nalbantis, "THEATER" , "17.00");
        nalbantis.setFbUrl("https://www.facebook.com/Brand4cosmos/");
        nalbantis.setWebUrl("http://b4c.gr/");
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_day3_calendar, null);

        kortsaridisLL = (LinearLayout) view.findViewById(R.id.kortsaridis);
        stavroulakisLL = (LinearLayout) view.findViewById(R.id.stavroulakis);
        tzinisLL = (LinearLayout) view.findViewById(R.id.tzinis);
        tzinisLL1 = (LinearLayout) view.findViewById(R.id.tzinis1);
        pittasLL = (LinearLayout) view.findViewById(R.id.pittas);
        nalbantisLL = (LinearLayout) view.findViewById(R.id.nalbantis);

        kortsaridisLL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openIntent(kortsaridis);
            }
        });

        stavroulakisLL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openIntent(stavroulakis);
            }
        });

        tzinisLL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openIntent(tzinis);
            }
        });

        tzinisLL1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openIntent(tzinis1);
            }
        });

        pittasLL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openIntent(pittas);
            }
        });

        nalbantisLL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openIntent(nalbantis);
            }
        });

        return view;
    }

    public void openIntent(spClass speaker){
        Intent intent = new Intent(getContext(),SpeakerActivity.class);
        intent.putExtra("title",speaker.getTitle());
        intent.putExtra("name",speaker.getName());
        intent.putExtra("room",speaker.getRoom());
        intent.putExtra("time",speaker.getTime());
        intent.putExtra("talkDescription",speaker.getDesc());
        intent.putExtra("prof",speaker.getPicture());

        intent.putExtra("fb",speaker.getFbUrl());
        intent.putExtra("gplus",speaker.getGplusUrl());
        intent.putExtra("twitter",speaker.getTwitterUrl());
        intent.putExtra("github",speaker.getGithubUrl());
        intent.putExtra("insta",speaker.getInstaUrl());
        intent.putExtra("web",speaker.getWebUrl());
        intent.putExtra("linkedin",speaker.getLinkedinUrl());
        startActivity(intent);
    }

}
