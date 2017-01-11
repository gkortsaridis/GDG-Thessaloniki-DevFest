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

        spClass[] spe = new spClass[]{
                new spClass("Speaker1", "Making your app awesome", R.drawable.person),
                new spClass("Speaker2", "Adding VR in your app", R.drawable.person),
                new spClass("Speaker3", "Android things all the way", R.drawable.person),
                new spClass("Speaker4", "Super Gmaps APIs", R.drawable.person),
                new spClass("Speaker5", "Another awesome talk", R.drawable.person),
        };
        spAdapter adapter = new spAdapter(getContext(), R.layout.listview_item_speakers, spe);
        speakers.setAdapter(adapter);
        speakers.setDivider(null);

        return view;
    }

}
