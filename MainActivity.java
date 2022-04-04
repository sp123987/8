package com.example.prac8;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class MainActivity extends AppCompatActivity
{ public final String
        channel_id="Personal_Notification"; public final int
        notification_id=001;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    { super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void displayNotification(View view)
    {
        createNotificationChannel();
        Toast.makeText(getApplicationContext(),"Hi",Toast.LENGTH_SHORT).show();
        NotificationCompat.Builder builder=new NotificationCompat.Builder(this,channel_id);builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setContentTitle("Simple Notification");
        builder.setContentText("This is a test notification");
        NotificationManagerCompat
                notificationManagerCompat= NotificationManagerCompat.from(this);
        notificationManagerCompat.notify(notification_id,builder.build());}

    private void createNotificationChannel()
    {
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O)
        {
            CharSequence name="Personal Notification";
            String description="This is description";
            int importance=NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel notificationChannel=new
                    NotificationChannel(channel_id,name,importance);
            notificationChannel.setDescription(description);
            NotificationManager
                    notificationManager=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);notificationManager.createNotificationChannel(notificationChannel);}
    }
}