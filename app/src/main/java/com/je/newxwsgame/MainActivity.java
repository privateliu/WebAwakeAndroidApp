package com.je.newxwsgame;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.je.newxwsgame.service.MyService2;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: ");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initButtonClick();

        // 获取uri参数
        Intent intent = getIntent();
        String scheme = intent.getScheme();
        Log.d(TAG, "scheme======== = "+scheme);
        Uri uri = intent.getData();
        Log.d(TAG, "uri======== = "+uri);
        if(uri != null){
            if(uri.getQueryParameter("jumpType") != null){
                Log.d(TAG, "jumpType======== = "+uri.getQueryParameter("jumpType"));
            }
            if(uri.getQueryParameter("jumpValue") != null){
                Log.d(TAG, "jumpValue======== = "+uri.getQueryParameter("jumpValue"));
            }
        }

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            @SuppressLint("WrongConstant") NotificationChannel nc = new NotificationChannel("message","目标督办", NotificationManager.IMPORTANCE_MAX);
            NotificationManager notificationManager = (NotificationManager) this.getSystemService(
                    this.getBaseContext().NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(nc);
        }


//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(70*1000);
//                    Intent intent1 = new Intent(MainActivity.this,MyService2.class);
//                    startService(intent1);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//
//            }
//        }).start();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent1 = new Intent(MainActivity.this,MyService2.class);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    startForegroundService(intent1);
                }else{
                    startService(intent1);
                }
            }
        },70*1000);
     }

    private void initButtonClick(){
        Button jumpActivityBtn = findViewById(R.id.button);
        jumpActivityBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,VibratorDemoActivity.class);
                v.getContext().startActivity(intent);
            }
        });

        Button startServiceBtn = findViewById(R.id.button2);
        startServiceBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent1 = new Intent(v.getContext(),MyService2.class);
                startService(intent1);
            }
        });

        Button vibBtn = findViewById(R.id.button4);
        vibBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
//                TextInputLayout tt = (TextInputLayout) findViewById(R.id.testInput);

//                Log.d(TAG, "onClick: "+tt.toString());
                Vibrator vibrator = (Vibrator)getSystemService(VIBRATOR_SERVICE);
                vibrator.vibrate(100);
            }
        });
    }

    @Override
    protected void onStart(){
        Log.d(TAG, "onStart: ");
        super.onStart();
    }

    @Override
    protected void onResume(){
        Log.d(TAG, "onResume: ");
        super.onResume();
    }

    @Override
    protected void onNewIntent(Intent intent){
        Log.d(TAG, "onNewIntent: ");
        super.onNewIntent(intent);

        String scheme = intent.getScheme();
        Log.d(TAG, "onNewIntentscheme======== = "+scheme);
        Uri uri = intent.getData();
        Log.d(TAG, "onNewIntenturi======== = "+uri);
    }
}