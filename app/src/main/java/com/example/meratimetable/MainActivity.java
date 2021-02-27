package com.example.meratimetable;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.NotificationCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /*private final String CHANNEL_ID = "personal notification";
    private final  int NOTIFICATION_ID = 001;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CardView studentcard = findViewById(R.id.student);
        studentcard.setOnClickListener(this);

        CardView facultycard = findViewById(R.id.faculty);
        facultycard.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i;
        switch (v.getId()) {
            case R.id.student:
                i = new Intent(this, SUI.class);
                startActivity(i);
                //issueNotification();
                break;
            case R.id.faculty:
                i = new Intent(this, FUI.class);
                startActivity(i);
                break;
            default:
                break;
        }
    }

    public void open_dev(View view) {
        Intent intent = new Intent(this,dev.class);
        startActivity(intent);
    }
}

    /*@RequiresApi(api = Build.VERSION_CODES.O)
    void makeNotificationChannel(String id, String name, int importance)
    {
        NotificationChannel channel = new NotificationChannel(id, name, importance);
        channel.setShowBadge(true); // set false to disable badges, Oreo exclusive

        NotificationManager notificationManager =
                (NotificationManager)getSystemService(NOTIFICATION_SERVICE);

        assert notificationManager != null;
        notificationManager.createNotificationChannel(channel);
    }

    void issueNotification()
    {

        // make the channel. The method has been discussed before.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            makeNotificationChannel("CHANNEL_1", "Example channel", NotificationManager.IMPORTANCE_DEFAULT);
        }
        // the check ensures that the channel will only be made
        // if the device is running Android 8+

        NotificationCompat.Builder notification =
                new NotificationCompat.Builder(this, "CHANNEL_1");
        // the second parameter is the channel id.
        // it should be the same as passed to the makeNotificationChannel() method

        notification
                .setSmallIcon(R.mipmap.ic_launcher) // can use any other icon
                .setContentTitle("Notification!")
                .setContentText("This is an Oreo notification!")
                .setNumber(3); // this shows a number in the notification dots

        Intent notificationintent = new Intent(this,MainActivity.class);
        PendingIntent contentintent = PendingIntent.getActivity(this,0,notificationintent,PendingIntent.FLAG_UPDATE_CURRENT);
        notification.setContentIntent(contentintent);
        notification.setAutoCancel(true);

        NotificationManager notificationManager =
                (NotificationManager)getSystemService(NOTIFICATION_SERVICE);

        assert notificationManager != null;
        notificationManager.notify(1, notification.build());
        // it is better to not use 0 as notification id, so used 1.
    }*/