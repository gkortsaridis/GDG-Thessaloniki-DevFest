package com.gkortsaridis.gdgthessalonikidevfest.Sponsors;

/**
 * Created by yoko on 07/01/2017.
 */

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.gkortsaridis.gdgthessalonikidevfest.R;

public class sponAdapter extends ArrayAdapter<sponClass> {

    private sponClass[] sponlist;
    private int resource;
    private Context context;

    public sponAdapter(Context context, int resource, sponClass[] sponlist) {
        super(context, resource, sponlist);
        this.context = context;
        this.resource = resource;
        this.sponlist = sponlist;
    }

    @NonNull
    @Override
    public View getView(int possition, View convertView, ViewGroup parent) {

        View spons;
        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        spons = layoutInflater.inflate(resource, null);
        ImageView picture = (ImageView) spons.findViewById(R.id.picture);

        final sponClass sponsor = sponlist[possition];
        picture.setImageResource(sponsor.getPicture());


        spons.findViewById(R.id.sponsorView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(sponsor.getUrl()));
                context.startActivity(browserIntent);
            }
        });

        return spons;
    }
}
