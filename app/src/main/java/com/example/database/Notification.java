package com.example.database;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.IBinder;

import androidx.core.app.NotificationCompat;

public class Notification extends Service {
    private  static final String ChannelID=" Yanal Channel  Id";
    public Notification() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
    private void createChannel()
    {


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            NotificationChannel x;
            x=new NotificationChannel (ChannelID,"My  Hi Channel with you"  , NotificationManager.IMPORTANCE_HIGH);

            NotificationManager  man= (NotificationManager)getSystemService ( NOTIFICATION_SERVICE );

            man.createNotificationChannel ( x );


        }



    }



    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String h="dffd";



        System.out.println("\nForeGroundService t the OnStartCommand() is been called...");

        createChannel();
        NotificationCompat.Builder notefor=null;

        notefor = new NotificationCompat.Builder ( getApplicationContext (),ChannelID )
                .setAutoCancel ( true )
                .setContentText (h)
                .setSmallIcon (R.drawable.ic_home_black_24dp )
                .setOngoing ( true )
                .setColor ( Color.BLUE )
                .setUsesChronometer ( true );

        startForeground ( 101, notefor.build () );
        return START_NOT_STICKY;
    }



    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}