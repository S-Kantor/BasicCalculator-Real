package com.kantor.sam.basiccalculator;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import java.util.Timer;

public class MyService extends Service {

    @Override
    public IBinder onBind(Intent arg0) {
        return null;
    }

    @Override
    public void onCreate() {
        Toast.makeText(this, "Congrats! MyService Created", Toast.LENGTH_SHORT).show();
        Log.d("Service", "OnCreate" );
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "My Service Started", Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "HelloDOOFUS", Toast.LENGTH_LONG).show();
        Log.d("Service", "Start" );
        //Note: You can start a new thread and use it for long background processing from here.

        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this, "MyService Stopped", Toast.LENGTH_LONG).show();
        Log.d("Service", "onDestroy" );
    }

}
