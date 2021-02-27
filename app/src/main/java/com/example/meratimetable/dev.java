package com.example.meratimetable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.List;

public class dev extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dev);
    }

    public void insta(View view) {
        Uri uri = Uri.parse("https://www.instagram.com/r_a_bb_a_n_i/?igshid=1kv5zx4erjkse");
        Intent instagram = new Intent(Intent.ACTION_VIEW, uri);
        //instagram.setPackage("com.instagram.android");

        PackageManager packageManager = getPackageManager();
        List<ResolveInfo> activities = packageManager.queryIntentActivities(instagram,PackageManager.MATCH_DEFAULT_ONLY);
        boolean isIntentSafe = activities.size() >0;

        if(isIntentSafe) {
            startActivity(instagram);
        }

        /*try{
            startActivity(instagram);
        }catch (ActivityNotFoundException e){
            Log.d("instaLog", "insta: here, this one");
            startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.instagram.com/r_a_bb_a_n_i/?igshid=1kv5zx4erjkse")));
        }*/
    }

    public void linkedIn(View view) {
        Uri uri = Uri.parse("https://www.linkedin.com/in/rabbani-shaik-a2637a187/");
        Intent linkedIn = new Intent(Intent.ACTION_VIEW, uri);

        //verify it resolves
        PackageManager packageManager = getPackageManager();
        List<ResolveInfo> activities = packageManager.queryIntentActivities(linkedIn,PackageManager.MATCH_DEFAULT_ONLY);
        boolean isIntentSafe = activities.size()>0;

        if(isIntentSafe) {
            startActivity(linkedIn);
        }
    }

    public void gmail(View view) {
        try{
            Intent emailIntent = new Intent (Intent.ACTION_VIEW , Uri.parse("mailto:" + "rabbanishaik998@gmail.com"));
            //emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Feedback");
            //emailIntent.putExtra(Intent.EXTRA_TEXT, "your_text");
            startActivity(emailIntent);
        }catch(ActivityNotFoundException e){
            //TODO smth
            Log.d("gmail", "gmail: Problem is here");
        }
    }
}