package com.gkortsaridis.gdgthessalonikidevfest.Speakers;

/**
 * Created by yoko on 07/01/2017.
 */


import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.gkortsaridis.gdgthessalonikidevfest.R;

public class spAdapter extends ArrayAdapter<spClass> {

    private spClass[] splist;
    private int resource;


    public spAdapter(Context context, int resource, spClass[] splist) {
        super(context, resource, splist);
        this.resource = resource;
        this.splist = splist;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View spe;
        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        spe = layoutInflater.inflate(resource, null);

        TextView name = (TextView) spe.findViewById(R.id.name);
        TextView desc = (TextView) spe.findViewById(R.id.desc);
        ImageView picture = (ImageView) spe.findViewById(R.id.picture);

        spClass speak = splist[position];
        name.setText(speak.getName());
        desc.setText(speak.getDesc());
        picture.setImageResource(speak.getPicture());

        return spe;

    }


}