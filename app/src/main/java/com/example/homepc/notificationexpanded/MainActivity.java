package com.example.homepc.notificationexpanded;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    Button notification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notification = findViewById(R.id.notificationBtn);

        //converting a drawable to bitmap
        final Bitmap bitmap = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.mybitmap);

        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String summary = "This is a tiny summary";

                // setting up style for inboxstyle
                NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();

                inboxStyle.setBigContentTitle("Big ENough ?");
                inboxStyle.setSummaryText(summary);
                inboxStyle.addLine("Line 1");
                inboxStyle.addLine("Line 2");
                inboxStyle.addLine("Line 3");
                inboxStyle.addLine("Line 4");
                inboxStyle.addLine("Line 5");
                inboxStyle.addLine("Line 6 ");
                inboxStyle.addLine("Line 7");
                inboxStyle.addLine("Line 8");


                //setting up notification builder and binding it to style
                NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext());
                builder.setAutoCancel(true);
                builder.setSmallIcon(R.drawable.ic_launcher_background);
                builder.setLargeIcon(bitmap);
                builder.setStyle(inboxStyle);

                //setting up notification manager and binding it to NotificationCompat builder
                NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                notificationManager.notify(0, builder.build());
            }
        });
    }


}
