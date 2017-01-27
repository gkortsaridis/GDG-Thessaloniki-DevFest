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

public class Day2Calendar extends Fragment {

    spClass kortsaridis, stavroulakis, tzinis, pittas,katsoulieri, economidou;
    LinearLayout kortsaridisLL, stavroulakisLL, tzinisLL, pittasLL, katsoulieriLL, economidouLL;

    public Day2Calendar() {
        // Required empty public constructor
        pittas = new spClass("Facebook Messenger Bots","George Pittas", "Every month, over 900 million people around the world communicate with friends, families and over 50 million businesses on Messenger. Over the past year Facebook has been expanding what people can do on Messenger. Part of that effort are the Bots. Bots can provide anything from automated subscription content like weather and news updates, to customized communications like receipts, shipping notifications, and live automated messages all by interacting directly with the people who want to get them. On that session we will focus on the Messenger’s capabilities, benefits for the businesses and how we can build our own Bot using wit.ai for human-like conversations.", R.drawable.pittas, "Facebook Room\nE1 | Fifth Floor" , "13.30");
        pittas.setWebUrl("http://www.obstechnologies.com/");

        katsoulieri = new spClass("Startup Marketing 101","Evi Katsoulieri", "It’s common for startups to focus on development and design, but without marketing, no one will see what you’ve created. In this session we will explore available resources for your team, how to start your Marketing Strategy and tools to save you time and money.", R.drawable.katsoulieri, "THEATER" , "17.00");
        katsoulieri.setTwitterUrl("https://twitter.com/EKatsoulieri");
        katsoulieri.setLinkedinUrl("https://www.linkedin.com/in/evikatsoulieri/");

        kortsaridis = new spClass("Hack the Real World with ANDROID THINGS","George Kortsaridis", "ANROID THINGS is coming to town! Together, we will dive into more details about the I.O.T architecture, and we will learn how to code our awesome projects and hack our way to the top!", R.drawable.kortsaridis, "Android Things Room\nB3 | Second Floor" , "13.30");
        kortsaridis.setGplusUrl("https://plus.google.com/u/0/+GeorgeKortsaridis1");
        kortsaridis.setLinkedinUrl("https://www.linkedin.com/in/georgekortsaridis/");
        kortsaridis.setGithubUrl("https://github.com/gkortsaridis");
        kortsaridis.setFbUrl("https://www.facebook.com/gkortsaridis");

        stavroulakis = new spClass("Getting Started with Progressive Web Apps","Bill Stavroulakis", "Progressive Web Apps consist of a new palette of technologies such as the web app manifest, homescreen install support, service workers and the app shell. These bridge the gap between native and web apps offering new capabilities for web developers to create amazing desktop and mobile experiences.", R.drawable.stavroulakis, "PWA Room\nA1 | First Floor" , "13.30");
        stavroulakis.setTwitterUrl("https://twitter.com/bstavroulakis");
        stavroulakis.setGithubUrl("https://github.com/bstavroulakis");

        tzinis = new spClass("See more of your world\nDigital Skills","Panayotis Tzinis", "1. Introducing Tango devices and what you can do with AR (Augmented Reality)\n" +
                "\n" +
                "2. Digital Skills | Participants will choose what codelabs between Google Analytics and AdWords they would like to follow\n" +
                "\n" +
                "3. Moral Machine | An open debate on Morality – Humanity – Machinery", R.drawable.tzinis, "THEATER" , "13.30");
        tzinis.setWebUrl("http://mustafar.xyz/");
        tzinis.setTwitterUrl("https://twitter.com/ptzinis");
        tzinis.setGplusUrl("https://plus.google.com/u/0/+PanayotisTzinis");

        economidou = new spClass("Women Techmakers Greece","Christina Economidou", "Google’s Women Techmakers program provides visibility, community, and resources for women in technology. The talk is focused on thw WTM Greek chapter, how to join it, share with other members your experiences and support women in pursuing their dreams.", R.drawable.economidou, "THEATER" , "17.30");
        economidou.setFbUrl("https://www.facebook.com/xristina.economidou");
        economidou.setLinkedinUrl("https://www.linkedin.com/in/christina-economidou/");
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_day2_calendar, null);
        kortsaridisLL = (LinearLayout) view.findViewById(R.id.kortsaridis);
        stavroulakisLL = (LinearLayout) view.findViewById(R.id.stavroulakis);
        tzinisLL = (LinearLayout) view.findViewById(R.id.tzinis);
        pittasLL = (LinearLayout) view.findViewById(R.id.pittas);
        katsoulieriLL = (LinearLayout) view.findViewById(R.id.katsoulieri);
        economidouLL = (LinearLayout) view.findViewById(R.id.economidou);

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

        pittasLL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openIntent(pittas);
            }
        });

        katsoulieriLL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openIntent(katsoulieri);
            }
        });

        economidouLL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openIntent(economidou);
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
