package com.je.newxwsgame.service;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;

public class MyService2 extends Service {
    private static final String TAG = "MyService2";
    int count;
    boolean startCommanding = true;
    public MyService2() {
    }

    @Override
    public void onCreate() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Notification notification = new Notification.Builder(getApplicationContext(),"message").build();
            startForeground(1,notification);
        }
        Log.i(TAG,"onCreate - Thread ID = ");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent,int flags,int index){
        count = 0;
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (startCommanding){
                    try {
                        Thread.sleep(1000);
                        count++;
                        Log.d(TAG, "count====== : "+count);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }).start();
        return super.onStartCommand(intent,flags,index);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onDestroy(){
        startCommanding = false;
        Log.d(TAG,"onDestroy - Thread ID = ");
        super.onDestroy();
    }
}