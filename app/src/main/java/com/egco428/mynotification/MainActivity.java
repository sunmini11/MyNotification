package com.egco428.mynotification;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button sendNotification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sendNotification = (Button)findViewById(R.id.button);

        sendNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NotificationReceiverActivity.class);
                PendingIntent pIntent = PendingIntent.getActivity(MainActivity.this, (int) System.currentTimeMillis(), intent, 0);

                NotificationCompat.Action callAction = new NotificationCompat.Action.Builder(R.drawable.ic_call, "Call", pIntent).build();
                NotificationCompat.Action settingAction = new NotificationCompat.Action.Builder(R.drawable.ic_setting, "Setting", pIntent).build();
                NotificationCompat.Action warningAction = new NotificationCompat.Action.Builder(R.drawable.ic_warning, "Warning", pIntent).build();

                NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this);
                builder.setSmallIcon(R.drawable.ic_message);
                builder.setContentTitle("New Message from text@example.com");
                builder.setContentText("This is a test message");
                builder.addAction(callAction);
                builder.addAction(settingAction);
                builder.addAction(warningAction);
                builder.setWhen(System.currentTimeMillis()+10);

                NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
                notificationManager.notify(0,builder.build());

            }
        });
    }


}
