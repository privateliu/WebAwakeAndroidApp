package com.je.xwsgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

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
            Log.d(TAG, "value======== = "+uri.getQueryParameter("teaminvitationcode"));
        }

     }

    private void initButtonClick(){
        Button jumpActivityBtn = findViewById(R.id.button);
        jumpActivityBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                v.getContext().startActivity(intent);
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