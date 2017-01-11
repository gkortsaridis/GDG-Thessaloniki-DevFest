package com.gkortsaridis.gdgthessalonikidevfest.Team;

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

public class tmAdapter extends ArrayAdapter<tmClass> {

    private tmClass[] tmlist;
    private int resource;


    public tmAdapter(Context context, int resource, tmClass[] tmlist) {
        super(context, resource, tmlist);
        this.resource = resource;
        this.tmlist = tmlist;


    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View tem;
        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        tem = layoutInflater.inflate(resource, null);

        TextView name = (TextView) tem.findViewById(R.id.name);
        TextView desc = (TextView) tem.findViewById(R.id.desc);
        ImageView picture = (ImageView) tem.findViewById(R.id.picture);

        tmClass team = tmlist[position];
        name.setText(team.getName());
        desc.setText(team.getDesc());
        picture.setImageResource(team.getPicture());

        return tem;

    }


}