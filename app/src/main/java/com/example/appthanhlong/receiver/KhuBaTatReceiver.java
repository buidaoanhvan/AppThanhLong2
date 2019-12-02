package com.example.appthanhlong.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class KhuBaTatReceiver extends BroadcastReceiver {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference khu3 = database.getReference("DieuKien/Khu3");
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("anhvan","Khu3T");
        khu3.setValue(0);
    }
}
