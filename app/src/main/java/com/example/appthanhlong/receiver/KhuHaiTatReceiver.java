package com.example.appthanhlong.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class KhuHaiTatReceiver extends BroadcastReceiver {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference khu2 = database.getReference("DieuKien/Khu2");
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("anhvan","Khu2T");
        khu2.setValue(0);
    }
}
