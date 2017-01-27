package com.gkortsaridis.gdgthessalonikidevfest.Sponsors;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.gkortsaridis.gdgthessalonikidevfest.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SponsorsFragment extends Fragment {

    private ListView sponsors;

    public SponsorsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sponsors, container, false);

        sponsors = (ListView) view.findViewById(R.id.listview);

        final sponClass[] spons = new sponClass[]{
                new sponClass("Google", R.drawable.google,"https://www.google.gr/"),
                new sponClass("Google Developers", R.drawable.google_developers,"https://developers.google.com/"),
                new sponClass("IEK AKMI", R.drawable.akmi,"http://www.iek-akmi.edu.gr/"),
                new sponClass("Lenovo", R.drawable.lenovo,"http://www.lenovo.com/gr/el/"),
                new sponClass("Women Techmakers", R.drawable.women_techmakers,"http://womentechmakers.gr/"),
                new sponClass("GDG Thessaloniki", R.drawable.gdg_thessaloniki,"http://gdgthess.org/"),
                new sponClass("GDG Heraklion", R.drawable.gdg_heraklion,"http://devfest.gr/"),
                new sponClass("GDG Athens", R.drawable.gdg_athens,"http://devfest.gr/"),
                new sponClass("Moonshot Labs", R.drawable.moonshot_labs,"http://moonshotlab.gr/")
        };
        sponAdapter adapter = new sponAdapter(getContext(), R.layout.listview_item_sponsors, spons);
        sponsors.setAdapter(adapter);
        sponsors.setDivider(null);

        return view;
    }

}
