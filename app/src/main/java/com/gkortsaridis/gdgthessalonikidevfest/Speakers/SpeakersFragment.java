package com.gkortsaridis.gdgthessalonikidevfest.Speakers;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.gkortsaridis.gdgthessalonikidevfest.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SpeakersFragment extends Fragment {

    private ListView speakers;

    public SpeakersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_speakers, container, false);

        speakers = (ListView) view.findViewById(R.id.listview);

        spClass pittas = new spClass("Facebook Messenger Bots","George Pittas", "Every month, over 900 million people around the world communicate with friends, families and over 50 million businesses on Messenger. Over the past year Facebook has been expanding what people can do on Messenger. Part of that effort are the Bots. Bots can provide anything from automated subscription content like weather and news updates, to customized communications like receipts, shipping notifications, and live automated messages all by interacting directly with the people who want to get them. On that session we will focus on the Messenger’s capabilities, benefits for the businesses and how we can build our own Bot using wit.ai for human-like conversations.", R.drawable.pittas, "Facebook Room\nE1 | Fifth Floor" , "13.30");
        pittas.setWebUrl("http://www.obstechnologies.com/");

        spClass katsoulieri = new spClass("Startup Marketing 101","Evi Katsoulieri", "It’s common for startups to focus on development and design, but without marketing, no one will see what you’ve created. In this session we will explore available resources for your team, how to start your Marketing Strategy and tools to save you time and money.", R.drawable.katsoulieri, "THEATER" , "17.00");
        katsoulieri.setTwitterUrl("https://twitter.com/EKatsoulieri");
        katsoulieri.setLinkedinUrl("https://www.linkedin.com/in/evikatsoulieri/");

        spClass kortsaridis = new spClass("Hack the Real World with ANDROID THINGS","George Kortsaridis", "ANROID THINGS is coming to town! Together, we will dive into more details about the I.O.T architecture, and we will learn how to code our awesome projects and hack our way to the top!", R.drawable.kortsaridis, "Android Things Room\nB3 | Second Floor" , "13.30");
        kortsaridis.setGplusUrl("https://plus.google.com/u/0/+GeorgeKortsaridis1");
        kortsaridis.setLinkedinUrl("https://www.linkedin.com/in/georgekortsaridis/");
        kortsaridis.setGithubUrl("https://github.com/gkortsaridis");
        kortsaridis.setFbUrl("https://www.facebook.com/gkortsaridis");

        spClass stavroulakis = new spClass("Getting Started with Progressive Web Apps","Bill Stavroulakis", "Progressive Web Apps consist of a new palette of technologies such as the web app manifest, homescreen install support, service workers and the app shell. These bridge the gap between native and web apps offering new capabilities for web developers to create amazing desktop and mobile experiences.", R.drawable.stavroulakis, "PWA Room\nA1 | First Floor" , "13.30");
        stavroulakis.setTwitterUrl("https://twitter.com/bstavroulakis");
        stavroulakis.setGithubUrl("https://github.com/bstavroulakis");

        spClass nalbantis = new spClass("Exponential Growth. What next?","Michael E. Nalbantis", "Discussing about humanity’ s growth in general and also how techonlogy will affect our every day lives", R.drawable.nalbantis, "THEATER" , "17.00");
        nalbantis.setFbUrl("https://www.facebook.com/Brand4cosmos/");
        nalbantis.setWebUrl("http://b4c.gr/");

        spClass tzinis = new spClass("See more of your world\nDigital Skills\nGetting Started with Machine Learning","Panayotis Tzinis", "1. Introducing Tango devices and what you can do with AR (Augmented Reality)\n" +
                "\n" +
                "2. Digital Skills | Participants will choose what codelabs between Google Analytics and AdWords they would like to follow\n" +
                "\n" +
                "3. Getting Started with Machine Learning | Introduction to the world of Machine Learning", R.drawable.tzinis, "THEATER" , "17.00");
        tzinis.setWebUrl("http://mustafar.xyz/");
        tzinis.setTwitterUrl("https://twitter.com/ptzinis");
        tzinis.setGplusUrl("https://plus.google.com/u/0/+PanayotisTzinis");

        spClass economidou = new spClass("Women Techmakers Greece","Christina Economidou", "Google’s Women Techmakers program provides visibility, community, and resources for women in technology. The talk is focused on thw WTM Greek chapter, how to join it, share with other members your experiences and support women in pursuing their dreams.", R.drawable.economidou, "THEATER" , "17.30");
        economidou.setFbUrl("https://www.facebook.com/xristina.economidou");
        economidou.setLinkedinUrl("https://www.linkedin.com/in/christina-economidou/");


        spClass tsakiridou = new spClass("Women Techmakers Greece","Irene Tsakiridou", "Google’s Women Techmakers program provides visibility, community, and resources for women in technology. The talk is focused on thw WTM Greek chapter, how to join it, share with other members your experiences and support women in pursuing their dreams.", R.drawable.tsakiridou, "THEATER" , "17.30");
        tsakiridou.setWebUrl("http://moonshotlab.gr/");
        tsakiridou.setTwitterUrl("https://twitter.com/Irene_Moonshot");
        tsakiridou.setGplusUrl("https://plus.google.com/u/0/+IreneTsakiridou");
        tsakiridou.setLinkedinUrl("https://www.linkedin.com/in/eirini-irene-tsakiridou-a914b014/");

        spClass[] spe = new spClass[]{pittas,katsoulieri,kortsaridis,stavroulakis,nalbantis, tzinis, economidou,tsakiridou };
        spAdapter adapter = new spAdapter(getContext(), R.layout.listview_item_speakers, spe);
        speakers.setAdapter(adapter);
        speakers.setDivider(null);

        return view;
    }

}
