package com.example.appthanhlong.fragment;

import android.app.assist.AssistStructure;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.appthanhlong.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.suke.widget.SwitchButton;

import static android.content.ContentValues.TAG;

public class DieuKhienFragment extends Fragment {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference khu1 = database.getReference("DieuKien/Khu1");
    DatabaseReference khu2 = database.getReference("DieuKien/Khu2");
    DatabaseReference khu3 = database.getReference("DieuKien/Khu3");
    DatabaseReference khu4 = database.getReference("DieuKien/Khu4");
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dieu_khien, container, false);
        final com.suke.widget.SwitchButton switch1 = (com.suke.widget.SwitchButton) view.findViewById(R.id.khu1);
        final com.suke.widget.SwitchButton switch2 = (com.suke.widget.SwitchButton) view.findViewById(R.id.khu2);
        final com.suke.widget.SwitchButton switch3 = (com.suke.widget.SwitchButton) view.findViewById(R.id.khu3);
        final com.suke.widget.SwitchButton switch4 = (com.suke.widget.SwitchButton) view.findViewById(R.id.khu4);
        com.suke.widget.SwitchButton switch5 = (com.suke.widget.SwitchButton) view.findViewById(R.id.tatca);

        // tai du lieu khu tuoi
        khu1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int k1 = dataSnapshot.getValue(Integer.class);
                if (k1==1){
                    switch1.setChecked(true);
                }else {
                    switch1.setChecked(false);
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        // tai du lieu khu tuoi
        khu2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int k2 = dataSnapshot.getValue(Integer.class);
                if (k2==1){
                    switch2.setChecked(true);
                }else {
                    switch2.setChecked(false);
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        // tai du lieu khu tuoi
        khu3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int k3 = dataSnapshot.getValue(Integer.class);
                if (k3==1){
                    switch3.setChecked(true);
                }else {
                    switch3.setChecked(false);
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        // tai du lieu khu tuoi
        khu4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int k4 = dataSnapshot.getValue(Integer.class);
                if (k4==1){
                    switch4.setChecked(true);
                }else {
                    switch4.setChecked(false);
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });


        switch1.setOnCheckedChangeListener(new SwitchButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(SwitchButton view, boolean isChecked) {

                if (isChecked == true){
                   khu1.setValue(1);
                }else {
                    khu1.setValue(0);
                }

            }
        });

        switch2.setOnCheckedChangeListener(new SwitchButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(SwitchButton view, boolean isChecked) {

                if (isChecked == true){
                    khu2.setValue(1);
                }else {
                    khu2.setValue(0);
                }

            }
        });

        switch3.setOnCheckedChangeListener(new SwitchButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(SwitchButton view, boolean isChecked) {

                if (isChecked == true){
                    khu3.setValue(1);
                }else {
                    khu3.setValue(0);
                }

            }
        });

        switch4.setOnCheckedChangeListener(new SwitchButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(SwitchButton view, boolean isChecked) {

                if (isChecked == true){
                    khu4.setValue(1);
                }else {
                    khu4.setValue(0);
                }

            }
        });


        switch5.setOnCheckedChangeListener(new SwitchButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(SwitchButton view, boolean isChecked) {

                if (isChecked == true){
                    switch1.setChecked(true);
                    switch2.setChecked(true);
                    switch3.setChecked(true);
                    switch4.setChecked(true);
                    Toast.makeText(getContext(),"Bật Tưới Tất Cả", Toast.LENGTH_SHORT).show();
                }else {
                    switch1.setChecked(false);
                    switch2.setChecked(false);
                    switch3.setChecked(false);
                    switch4.setChecked(false);
                    Toast.makeText(getContext(),"Tắt Tưới Tất Cả", Toast.LENGTH_SHORT).show();
                }

            }



        });
        return view;
    }
}
