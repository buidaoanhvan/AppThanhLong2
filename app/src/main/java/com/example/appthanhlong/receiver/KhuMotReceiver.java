package com.example.appthanhlong.receiver;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;

import com.example.appthanhlong.service.KhuMotService;

public class KhuMotReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("anhvan","Khu1");
        Intent myIntent = new Intent(context, KhuMotService.class);
        if (Build.VERSION.SDK_INT >= 26)
            context.startForegroundService(myIntent);
        else{
            context.startService(myIntent);
        }
    }
}
