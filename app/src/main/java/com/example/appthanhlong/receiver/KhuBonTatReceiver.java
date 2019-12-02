package com.example.appthanhlong.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class KhuBonTatReceiver extends BroadcastReceiver {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference khu4 = database.getReference("DieuKien/Khu4");
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("anhvan","Khu4T");
        khu4.setValue(0);
    }
}
