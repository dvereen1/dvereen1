package com.example.darianvereen.dvereen1.activity;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.darianvereen.dvereen1.R;

public class NotificationActivity extends AppCompatActivity {

    private Button small, big, pic;
    private NotificationManager mNotificationManager;
    private final int notifyId = 100;
    private final String channelId = "EXAMPLE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);


        small = findViewById(R.id.notifi_small_bt);
        big = findViewById(R.id.notifi_big_bt);
        pic = findViewById(R.id.notifi_pic_bt);


        //when clicked generates small notification
        small.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Toast.makeText(NotificationActivity.this, "small clicked", Toast.LENGTH_SHORT).show();
                //This builder builds a notification bar that we see
                NotificationCompat.Builder mBuilder =
                        new NotificationCompat.Builder(NotificationActivity.this, channelId);
                mBuilder.setContentTitle("Title")
                        .setContentText("Text")
                        .setContentIntent(getDefaultIntent(Notification.FLAG_AUTO_CANCEL))
                        .setNumber(10)
                        .setTicker("Ticker")
                        .setWhen(System.currentTimeMillis())
                        .setPriority(Notification.PRIORITY_DEFAULT)
                        .setAutoCancel(true)
                        .setOngoing(false)
                        .setDefaults(Notification.DEFAULT_SOUND)
                        .setDefaults(Notification.DEFAULT_VIBRATE)
                        .setSmallIcon(R.mipmap.ic_launcher);
                mNotificationManager.notify(notifyId, mBuilder.build());

            }
        });

        //when clicked generates big notification
        big.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationCompat.Builder mBuilder =
                        new NotificationCompat.Builder(NotificationActivity.this, channelId);
                mBuilder.setContentTitle("Title")
                        .setContentText("Text")
                        .setContentIntent(getDefaultIntent(Notification.FLAG_AUTO_CANCEL))
                        .setNumber(10)
                        .setTicker("Ticker")
                        .setWhen(System.currentTimeMillis())
                        .setPriority(Notification.PRIORITY_DEFAULT)
                        .setAutoCancel(true)
                        .setOngoing(false)
                        .setDefaults(Notification.DEFAULT_SOUND)
                        .setDefaults(Notification.DEFAULT_VIBRATE)
                        .setSmallIcon(R.mipmap.ic_launcher);

                NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
                String[] events = new String[]{"Line1", "Line2", "Line3", "Line4", "Line5"};

                //sets title for the inbox styl big view
                inboxStyle.setBigContentTitle("BigContentTitle");
                //Moves events into th big view
                for(int i = 0; i < events.length; i++){
                    inboxStyle.addLine(events[i]);
                }
                inboxStyle.setBuilder(mBuilder);
                mBuilder.setStyle(inboxStyle);
                mNotificationManager.notify(notifyId, mBuilder.build());

            }
        });

        //when clicked generates picture notification
        pic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationCompat.Builder mBuilder =
                        new NotificationCompat.Builder(NotificationActivity.this, channelId);
                mBuilder.setContentTitle("Title")
                        .setContentText("Text")
                        .setContentIntent(getDefaultIntent(Notification.FLAG_AUTO_CANCEL))
                        .setNumber(10)
                        .setTicker("Ticker")
                        .setWhen(System.currentTimeMillis())
                        .setPriority(Notification.PRIORITY_DEFAULT)
                        .setAutoCancel(true)
                        .setOngoing(false)
                        .setDefaults(Notification.DEFAULT_SOUND)
                        .setDefaults(Notification.DEFAULT_VIBRATE)
                        .setSmallIcon(R.mipmap.ic_launcher);

                NotificationCompat.BigPictureStyle bigPictureStyle =
                        new NotificationCompat.BigPictureStyle();
                mBuilder.setStyle(bigPictureStyle);
                bigPictureStyle.setBuilder(mBuilder);
                bigPictureStyle.setBigContentTitle("BigContentTitle");
                bigPictureStyle.setSummaryText("SummaryText");
                Bitmap bitmap1 = BitmapFactory.decodeResource(getResources(), R.mipmap.pic1 );
                bigPictureStyle.bigPicture(bitmap1);
                mBuilder.setStyle(bigPictureStyle);

                mNotificationManager.notify(notifyId, mBuilder.build());

            }
        });

        //clickListeners();
    }

    //here we define our button listeners
    //private void clickListeners(){


    //}

    public PendingIntent getDefaultIntent(int flags){
        PendingIntent pendingIntent =
                PendingIntent.getActivity(this, 1, new Intent(), flags);

        return pendingIntent;
    }

}
