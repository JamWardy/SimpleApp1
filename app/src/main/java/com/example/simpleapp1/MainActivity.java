package com.example.simpleapp1;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public String name = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void hello(View v){
        Button button = (Button) v;
        name = getName();
        TextView t = findViewById(R.id.textView);
        t.setText("Hello " + name);
        NotificationChannel channel = new NotificationChannel("1", "General Channel", NotificationManager.IMPORTANCE_HIGH);
        channel.setDescription("General channel");
        channel.setShowBadge(true);
        channel.setLockscreenVisibility(Notification.VISIBILITY_PUBLIC);
        NotificationManager notificationManager = getSystemService(NotificationManager.class);
        notificationManager.createNotificationChannel(channel);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this,"1");
        builder.setSmallIcon(android.R.drawable.ic_notification_overlay);
        builder.setContentTitle("Hello");
        builder.setContentText("Hello there " + name + "! :)");
        builder.setDefaults(Notification.DEFAULT_ALL);
        builder.setPriority(Notification.PRIORITY_MAX);
        notificationManager.notify(1,builder.build());
    }

    public String getName(){
        TextView t = findViewById(R.id.source1);
        return t.getText().toString();
    }
}