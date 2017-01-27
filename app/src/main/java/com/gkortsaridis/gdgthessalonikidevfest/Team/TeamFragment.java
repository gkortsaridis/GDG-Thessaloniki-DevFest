package com.gkortsaridis.gdgthessalonikidevfest.Team;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.gkortsaridis.gdgthessalonikidevfest.R;

public class TeamFragment extends Fragment {

    ListView team;

    public TeamFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_team, container, false);

        team = (ListView) view.findViewById(R.id.listview);

        tmClass[] tem = new tmClass[]{
                new tmClass("Panayotis Tzinis", "GDG Core Organizer\nDarth Vader's descendant", R.drawable.tzinis),
                new tmClass("George Kortsaridis", "GDG Core Organizer\nTeam coordinator", R.drawable.kortsaridis),
                new tmClass("Irene Tsakiridou", "GDG Core Organizer", R.drawable.tsakiridou),
                new tmClass("Katerina Gagi", "GDG Thessaloniki Member", R.drawable.gagi),
                new tmClass("Kiriakos Stefanidis", "GDG Thessaloniki Member\nApplication Developer", R.drawable.stefanidis),
                new tmClass("Nick Antoniou", "GDG Thessaloniki Member\nApplication Developer", R.drawable.antoniou),
                new tmClass("Thodoris Kanelis", "GDG Thessaloniki Member\nApplication Developer", R.drawable.kanelis),
                new tmClass("Theofilos Karkadakis", "GDG Thessaloniki Member\nApplication Developer", R.drawable.karkadakis),
                new tmClass("Stergios Hariopolitis", "GDG Thessaloniki Member", R.drawable.hariopolitis),
                new tmClass("Eleftherios Chatzopoulos", "GDG Thessaloniki Member", R.drawable.chatzopoulos),
                new tmClass("Panagiotis Gorogias", "GDG Thessaloniki Member", R.drawable.gorogias),
                new tmClass("Panagiotis Pilitsis", "GDG Thessaloniki Member", R.drawable.pilitsis),
                new tmClass("Stergios Ntomproudis", "GDG Thessaloniki Member", R.drawable.ntomproudis),
        };

        tmAdapter adapter = new tmAdapter(getContext(), R.layout.listview_item_team, tem);
        team.setAdapter(adapter);
        team.setDivider(null);

        return view;
    }

}
