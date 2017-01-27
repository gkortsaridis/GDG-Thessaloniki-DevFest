package com.gkortsaridis.gdgthessalonikidevfest.Speakers;

/**
 * Created by yoko on 07/01/2017.
 */


import android.content.Context;
import android.content.Intent;
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
    private Context context;


    public spAdapter(Context context, int resource, spClass[] splist) {
        super(context, resource, splist);
        this.resource = resource;
        this.splist = splist;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final View spe;
        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        spe = layoutInflater.inflate(resource, null);

        TextView name = (TextView) spe.findViewById(R.id.name);
        TextView desc = (TextView) spe.findViewById(R.id.desc);
        ImageView picture = (ImageView) spe.findViewById(R.id.picture);

        final spClass speak = splist[position];
        name.setText(speak.getName());
        desc.setText(speak.getTitle());
        picture.setImageResource(speak.getPicture());


        spe.findViewById(R.id.speakerView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),SpeakerActivity.class);
                intent.putExtra("title",speak.getTitle());
                intent.putExtra("name",speak.getName());
                intent.putExtra("room",speak.getRoom());
                intent.putExtra("time",speak.getTime());
                intent.putExtra("talkDescription",speak.getDesc());
                intent.putExtra("prof",speak.getPicture());

                intent.putExtra("fb",speak.getFbUrl());
                intent.putExtra("gplus",speak.getGplusUrl());
                intent.putExtra("twitter",speak.getTwitterUrl());
                intent.putExtra("github",speak.getGithubUrl());
                intent.putExtra("insta",speak.getInstaUrl());
                intent.putExtra("web",speak.getWebUrl());
                intent.putExtra("linkedin",speak.getLinkedinUrl());
                context.startActivity(intent);
            }
        });

        return spe;

    }


}