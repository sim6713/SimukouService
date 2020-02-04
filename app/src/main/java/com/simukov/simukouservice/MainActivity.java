package com.simukov.simukouservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    //1.Создать сервис.
    //2.Созать задачу
    //3.Создать ресивер, зарегистрировать динамически
    //4.Поймать системное событие
    //5.Поймать событие с сервиса
    //6.Создать уведомление, сделать сервис foreground
    //7.Бонус - статически объявить ресивер в манифесте
    //8.Самостоятельно - boundService
    //

    private Button mStartService;
    private Button mStopService;
    private Button mSendBroadcast;
    private SimpleReceiver mSimpleReceiver;
    private IntentFilter mIntentFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mStartService = findViewById(R.id.start_service);
        mStopService = findViewById(R.id.stop_service);
        mSendBroadcast = findViewById(R.id.btn_send_broadcast);

        mStartService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CountService.class);
                startService(intent);
            }
        });

        mStopService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CountService.class);
                stopService(intent);
            }
        });

        mSendBroadcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendBroadcast(new Intent(SimpleReceiver.SIMPLE_ACTION));
            }
        });

        mSimpleReceiver = new SimpleReceiver();
        mIntentFilter = new IntentFilter(SimpleReceiver.SIMPLE_ACTION);

    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(mSimpleReceiver, mIntentFilter);
    }


    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(mSimpleReceiver);
    }
}
