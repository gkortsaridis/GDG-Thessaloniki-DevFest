package com.gkortsaridis.gdgthessalonikidevfest.News;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.CardView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.gkortsaridis.gdgthessalonikidevfest.App;
import com.gkortsaridis.gdgthessalonikidevfest.R;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class NewsFeedFragment extends Fragment {

    //ListView twitterFeed;
    LinearLayout twitterFeed;
    SwipeRefreshLayout swipeRefreshLayout;

    public NewsFeedFragment() {
        // Required empty public constructor
    }

    @Override
    public void onResume() {
        super.onResume();

        if(App.checkNetworkConnectivity(getActivity())) {
            getTwitterFeed();
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void getTwitterFeed(){
        AsyncHttpClient client = new AsyncHttpClient();
        client.get("http://83.212.118.131/twitter.php", new AsyncHttpResponseHandler() {

            ProgressDialog pd;

            @Override
            public void onStart() {
                // called before request is started
                pd = new ProgressDialog(getContext());
                pd.setTitle("Please Wait");
                pd.setMessage("We are downloading your news feed");
                pd.setCancelable(false);
                pd.show();

                swipeRefreshLayout.setRefreshing(false);
            }

            @Override
            public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers, byte[] responseBody) {
                pd.cancel();
                twitterFeed.removeAllViews();

                String response = new String(responseBody);
                try {
                    JSONArray responseJson = new JSONObject(response).getJSONArray("statuses");
                    Log.i("Twitter",responseJson.length()+"");

                    for(int i=0; i<responseJson.length(); i++){
                        JSONObject status = responseJson.getJSONObject(i);
                        createRow(status);
                    }
                    //twitterFeed.setAdapter(new TwitterNewsFeedAdapter(getActivity(),names,screen_names,texts,images));
                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }

            @Override
            public void onFailure(int statusCode, cz.msebera.android.httpclient.Header[] headers, byte[] responseBody, Throwable error) {
                pd.cancel();
            }

        });
    }

    public void createRow(JSONObject status){
        String statusStr = null;
        try {
            statusStr = status.getString("text");
            String name = status.getJSONObject("user").getString("name");
            String screen_name = status.getJSONObject("user").getString("screen_name");
            String imageUrl = "-1";

            JSONObject entities = status.getJSONObject("entities");
            try {
                JSONArray media = entities.getJSONArray("media");
                if(media != null){
                    String image = media.getJSONObject(0).getString("media_url");
                    imageUrl = image;
                }
            }catch (JSONException e){
            }

            CardView cardView = new CardView(getContext());
            ViewGroup.MarginLayoutParams params = new ViewGroup.MarginLayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            cardView.setLayoutParams(params);
            setMargins(cardView,convertDpToPixel(16,getContext()),convertDpToPixel(8,getContext()),convertDpToPixel(16,getContext()),convertDpToPixel(8,getContext()));

            LinearLayout linearLayout = new LinearLayout(getContext());
            linearLayout.setOrientation(LinearLayout.VERTICAL);

            TextView nameTV = new TextView(getContext());
            nameTV.setText(name);
            nameTV.setTypeface(null, Typeface.BOLD);
            nameTV.setPadding(convertDpToPixel(8,getContext()),convertDpToPixel(8,getContext()),0,0);
            nameTV.setTextSize(20);
            nameTV.setTextColor(getResources().getColor(R.color.black));
            linearLayout.addView(nameTV);

            TextView screennameTV = new TextView(getContext());
            screennameTV.setText("@"+screen_name);
            screennameTV.setPadding(convertDpToPixel(8,getContext()),convertDpToPixel(2,getContext()),0,0);
            screennameTV.setTextColor(getResources().getColor(R.color.twitterBlue));
            linearLayout.addView(screennameTV);

            RelativeLayout divider = new RelativeLayout(getContext());
            divider.setLayoutParams(new RelativeLayout.MarginLayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,convertDpToPixel(1,getContext())));
            setMargins(divider,convertDpToPixel(8,getContext()),convertDpToPixel(2,getContext()),convertDpToPixel(8,getContext()),0);
            divider.setBackgroundResource(R.color.black);

            linearLayout.addView(divider);

            TextView textTV = new TextView(getContext());
            textTV.setText(statusStr);
            textTV.setPadding(convertDpToPixel(8,getContext()),convertDpToPixel(2,getContext()),convertDpToPixel(8,getContext()),convertDpToPixel(8,getContext()));
            linearLayout.addView(textTV);

            if(!imageUrl.equals("-1")) {
                ImageView imageView = new ImageView(getContext());
                imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,convertDpToPixel(150,getContext())));
                imageView.setBackgroundResource(R.color.black);
                Picasso.with(getContext()).load(imageUrl).into(imageView);
                linearLayout.addView(imageView);
            }

            cardView.addView(linearLayout);
            //RelativeLayout relativeLayout = new RelativeLayout(getContext());
            //relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,convertDpToPixel(16,getContext())));

            twitterFeed.addView(cardView);
            //twitterFeed.addView(relativeLayout);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static int convertDpToPixel(float dp, Context context){
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        int px = (int)(dp * ((float)metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT));
        return px;
    }

    private void setMargins (View view, int left, int top, int right, int bottom) {
        //if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams p = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            p.setMargins(left, top, right, bottom);
            view.requestLayout();
        //}
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_news_feed, container, false);
        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipeRefresh);
        twitterFeed = (LinearLayout) view.findViewById(R.id.twitter_feed);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getTwitterFeed();
            }
        });

        return view;
    }

}
