package com.gkortsaridis.gdgthessalonikidevfest.Team;


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
                new tmClass("Panayotis Tzinis", "GDG Core Organizer\nDarth Vader's descendant", R.drawable.person),
                new tmClass("George Kortsaridis", "GDG Core Organizer\nTeam coordinator", R.drawable.person),
                new tmClass("Irene Tsakiridou", "GDG Core Organizer", R.drawable.person),
                new tmClass("TEST", "APPLICATION DEVELOPER", R.drawable.person),
                new tmClass("TEST", "APPLICATION DEVELOPER", R.drawable.person),
                new tmClass("TEST", "APPLICATION DEVELOPER", R.drawable.person)
        };

        tmAdapter adapter = new tmAdapter(getContext(), R.layout.listview_item_team, tem);
        team.setAdapter(adapter);
        team.setDivider(null);

        return view;
    }

}
