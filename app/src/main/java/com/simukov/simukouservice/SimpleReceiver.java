package com.simukov.simukouservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class SimpleReceiver extends BroadcastReceiver {

    public static final String SIMPLE_ACTION = "com.simukov.simukouservice.SIMPLE_ACTION";

    @Override
    public void onReceive(Context context, Intent intent) {
        long time = intent.getLongExtra(CountService.TIME, 0L);
        Toast.makeText(context, "current time is: " + time, Toast.LENGTH_SHORT).show();
    }
}
