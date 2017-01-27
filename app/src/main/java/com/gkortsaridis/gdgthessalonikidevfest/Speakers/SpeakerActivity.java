package com.gkortsaridis.gdgthessalonikidevfest.Speakers;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.gkortsaridis.gdgthessalonikidevfest.R;

public class SpeakerActivity extends AppCompatActivity {

    String talkName;
    String fullName;
    int image;
    String roomName;
    String time;
    String talkDescription;
    String twitterUrl,gplusUrl,githubUrl,webUrl,fbUrl,instaUrl,linkedinUrl;

    TextView fullNameTV;
    ImageView profIV;
    TextView roomTV;
    TextView timeTV;
    TextView talkDescrTV;

    Toolbar toolbar;
    LinearLayout socialContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speaker);

        toolbar = (Toolbar) findViewById(R.id.toolbar);

        talkName = getIntent().getExtras().getString("title");
        fullName = getIntent().getExtras().getString("name");
        image = getIntent().getExtras().getInt("prof");
        roomName = getIntent().getExtras().getString("room");
        time = getIntent().getExtras().getString("time");
        talkDescription = getIntent().getExtras().getString("talkDescription");

        webUrl = getIntent().getExtras().getString("web");
        fbUrl = getIntent().getExtras().getString("fb");
        instaUrl = getIntent().getExtras().getString("insta");
        twitterUrl = getIntent().getExtras().getString("twitter");
        gplusUrl = getIntent().getExtras().getString("gplus");
        githubUrl = getIntent().getExtras().getString("github");
        linkedinUrl = getIntent().getExtras().getString("linkedin");

        Log.i("Name",fullName);

        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null){
            final Drawable upArrow = ContextCompat.getDrawable(getBaseContext(), R.drawable.back);
            upArrow.setColorFilter(ContextCompat.getColor(getBaseContext(), R.color.white), PorterDuff.Mode.SRC_ATOP);

            getSupportActionBar().setHomeAsUpIndicator(upArrow);
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle(talkName);
        }

        fullNameTV = (TextView) findViewById(R.id.sp_name);
        profIV = (ImageView) findViewById(R.id.profile_pic);
        roomTV = (TextView) findViewById(R.id.room);
        timeTV = (TextView) findViewById(R.id.time);
        talkDescrTV = (TextView) findViewById(R.id.talkDescrTV);
        socialContainer = (LinearLayout) findViewById(R.id.social_container);

        if(webUrl != null){ addImageButton(R.drawable.web,webUrl); }
        if(fbUrl != null){ addImageButton(R.drawable.fb,fbUrl); }
        if(gplusUrl != null){ addImageButton(R.drawable.gplus,gplusUrl);}
        if(twitterUrl != null){ addImageButton(R.drawable.twitter,twitterUrl); }
        if(githubUrl != null){ addImageButton(R.drawable.github,githubUrl); }
        if(instaUrl != null){ addImageButton(R.drawable.instagram,instaUrl); }
        if(linkedinUrl != null){ addImageButton(R.drawable.linkedin,linkedinUrl); }



        fullNameTV.setText(fullName);
        profIV.setImageResource(image);
        roomTV.setText(roomName);
        timeTV.setText(time);
        talkDescrTV.setText(talkDescription);
    }

    public void addImageButton(int drawable, final String link){
        View view = new View(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(convertDpToPixel(8,this),convertDpToPixel(60,this));
        view.setLayoutParams(layoutParams);
        socialContainer.addView(view);

        Resources r = getResources();
        int px = (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 50, r.getDisplayMetrics());

        ImageButton imageButton = new ImageButton(this);
        imageButton.setBackgroundResource(drawable);
        ViewGroup.MarginLayoutParams params = new ViewGroup.MarginLayoutParams(px, px);
        imageButton.setLayoutParams(params);
        //setMargins(imageButton,convertDpToPixel(16,this),convertDpToPixel(16,this),convertDpToPixel(16,this),convertDpToPixel(16,this));
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(link));
                startActivity(browserIntent);
            }
        });

        socialContainer.addView(imageButton);

        View view1 = new View(this);
        view.setLayoutParams(layoutParams);
        //socialContainer.addView(view1);

    }

    public static int convertDpToPixel(float dp, Context context){
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        int px = (int)(dp * ((float)metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT));
        return px;
    }

    private void setMargins (View view, int left, int top, int right, int bottom) {
        //if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
        RelativeLayout.MarginLayoutParams p = (RelativeLayout.MarginLayoutParams) view.getLayoutParams();
        p.setMargins(left, top, right, bottom);
        view.requestLayout();
        //}
    }

    public void openTwitter(View view){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(twitterUrl));
        startActivity(browserIntent);
    }

    public void openGplus(View view){
        //Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(gplusUrl));
        //startActivity(browserIntent);
    }

    public void openGithub(View view){
        //Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(githubUrl));
        //startActivity(browserIntent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }

        return super.onOptionsItemSelected(item);
    }
}
