package com.gkortsaridis.gdgthessalonikidevfest.News;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.gkortsaridis.gdgthessalonikidevfest.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by yoko on 24/12/2016.
 */

public class TwitterNewsFeedAdapter extends BaseAdapter {

    private Activity activity;
    private ArrayList<String> names,screen_names,texts,images;
    private static LayoutInflater inflater=null;

    public TwitterNewsFeedAdapter(Activity activity, ArrayList<String> names, ArrayList<String> screen_names, ArrayList<String> texts, ArrayList<String> images) {
        this.activity = activity;
        this.names = names;
        this.screen_names = screen_names;
        this.texts = texts;
        this.images = images;
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public int getCount() {
        return names.size();
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }

    static class HolderView{
        TextView name;
        TextView name_short;
        TextView text;
        ImageView image;
    }



    public View getView(int position, View convertView, ViewGroup parent) {

        HolderView holderView;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.twitter_feed_item, null);
            holderView = new HolderView();

            holderView.name = (TextView)convertView.findViewById(R.id.user_full_name_tv);
            holderView.name_short = (TextView)convertView.findViewById(R.id.user_short_tv);
            holderView.text = (TextView)convertView.findViewById(R.id.status_text_tv);
            holderView.image =(ImageView)convertView.findViewById(R.id.status_image);

            convertView.setTag(holderView);
        } else {
            holderView = (HolderView) convertView.getTag();
        }



        // Setting all values in listview
        holderView.name.setText(names.get(position));
        holderView.name_short.setText(screen_names.get(position));
        holderView.text.setText(texts.get(position));

        if(images.get(position) != "-1") {
            Picasso.with(activity).load(images.get(position)).into(holderView.image);
        }


        return convertView;
    }
}
