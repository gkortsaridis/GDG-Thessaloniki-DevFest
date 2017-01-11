package com.gkortsaridis.gdgthessalonikidevfest;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;


/**
 * Created by yoko on 08/01/2017.
 */

public class App {

    public static String getTag() {
        String tag = "";
        final StackTraceElement[] ste = Thread.currentThread().getStackTrace();
        for (int i = 0; i < ste.length; i++) {
            if (ste[i].getMethodName().equals("getTag")) {
                tag = "("+ste[i + 1].getFileName() + ":" + ste[i + 1].getLineNumber()+")";
            }
        }
        return tag;
    }

    public static String getAndroidVersion() {
        String release = Build.VERSION.RELEASE;
        int sdkVersion = Build.VERSION.SDK_INT;
        return "Android " + sdkVersion + " (" + release +")";
    }

    public static boolean isNetworkAvailable(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetInfo = connectivityManager.getActiveNetworkInfo();
        return (activeNetInfo != null && activeNetInfo.isConnected());
    }

    public static boolean checkNetworkConnectivity(final Activity activity){
        if(!isNetworkAvailable(activity)) {
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(activity);
            builder
                    .setTitle("No internet connection")
                    .setMessage("There seems to be no internet connection. In order to continue, you need to be connected to the internet.")
                    .setPositiveButton("WiFi Settings", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            activity.startActivity(new Intent(WifiManager.ACTION_PICK_WIFI_NETWORK));
                        }
                    })
                    .setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            Intent intent = new Intent(Intent.ACTION_MAIN);
                            intent.addCategory(Intent.CATEGORY_HOME);
                            activity.startActivity(intent);
                        }
                    });
            android.app.AlertDialog alert = builder.create();
            alert.show();

            return false;
        }else{
            return true;
        }
    }
}

