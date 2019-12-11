package com.example.appthanhlong.fragment;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.appthanhlong.R;
import com.github.lzyzsd.circleprogress.ArcProgress;
import com.github.lzyzsd.circleprogress.CircleProgress;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.kwabenaberko.openweathermaplib.constants.Lang;
import com.kwabenaberko.openweathermaplib.constants.Units;
import com.kwabenaberko.openweathermaplib.implementation.OpenWeatherMapHelper;

import com.kwabenaberko.openweathermaplib.implementation.callbacks.ThreeHourForecastCallback;

import com.kwabenaberko.openweathermaplib.models.threehourforecast.ThreeHourForecast;

import java.net.URLEncoder;

import static android.content.ContentValues.TAG;
import static androidx.core.content.ContextCompat.getSystemService;


public class ThongSoFragment extends Fragment {

    ArcProgress nhietdo, doam, doamdat;
    CircleProgress mucnuoc;
    TextView tvnhietdo, tvgio, tvvitri,tvtrangthaivuon,tvttkhu1,tvttkhu2,tvttkhu3,tvttkhu4,tvcbmua, tvttkhu11,tvttkhu22,tvttkhu33,tvttkhu44;
    ImageView imgthoitiet;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference nhietdodb = database.getReference("ThongSo/NhietDo");
    DatabaseReference doamdb = database.getReference("ThongSo/DoAm");
    DatabaseReference muadb = database.getReference("ThongSo/Mua");
    DatabaseReference doamdatdb = database.getReference("ThongSo/DoAmDat");
    DatabaseReference mucnuocdb = database.getReference("ThongSo/MucNuoc");
    DatabaseReference khu1 = database.getReference("DieuKien/Khu1");
    DatabaseReference khu2 = database.getReference("DieuKien/Khu2");
    DatabaseReference khu3 = database.getReference("DieuKien/Khu3");
    DatabaseReference khu4 = database.getReference("DieuKien/Khu4");
    DatabaseReference khu11 = database.getReference("DieuKien/Khu11");
    DatabaseReference khu22 = database.getReference("DieuKien/Khu22");
    DatabaseReference khu33 = database.getReference("DieuKien/Khu33");
    DatabaseReference khu44 = database.getReference("DieuKien/Khu44");

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_thong_so, container, false);
        tvttkhu1 = (TextView) view.findViewById(R.id.tvttkhu1);
        tvttkhu2 = (TextView) view.findViewById(R.id.tvttkhu2);
        tvttkhu3 = (TextView) view.findViewById(R.id.tvttkhu3);
        tvttkhu4 = (TextView) view.findViewById(R.id.tvttkhu4);
        tvttkhu11 = (TextView) view.findViewById(R.id.tvkhu11);
        tvttkhu22 = (TextView) view.findViewById(R.id.tvkhu22);
        tvttkhu33 = (TextView) view.findViewById(R.id.tvkhu33);
        tvttkhu44 = (TextView) view.findViewById(R.id.tvkhu44);
        tvcbmua  = (TextView) view.findViewById(R.id.tvcbmua);
        nhietdo = (ArcProgress) view.findViewById(R.id.nhietdo_progress);
        doam = (ArcProgress) view.findViewById(R.id.doam_progress);
        doamdat = (ArcProgress) view.findViewById(R.id.doamdat_progress);
        mucnuoc = (CircleProgress) view.findViewById(R.id.mucnuoc_progress);
        tvnhietdo = (TextView) view.findViewById(R.id.tvnhietdo);
        tvgio = (TextView) view.findViewById(R.id.tvgio);
        tvtrangthaivuon = (TextView) view.findViewById(R.id.tvtrangthaivuon);
        tvvitri = (TextView) view.findViewById(R.id.tvvitri);
        imgthoitiet =(ImageView) view.findViewById(R.id.imgthoitiet);
        final NotificationManager notificationManager = (NotificationManager) getContext().getSystemService(Context.NOTIFICATION_SERVICE);
        //khu1
        khu1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                int khu1 = dataSnapshot.getValue(Integer.class);
                if(khu1==1){
                    tvttkhu1.setText("Đang Tưới");
                }else {
                    tvttkhu1.setText("");
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
        //khu4
        khu4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                int khu4 = dataSnapshot.getValue(Integer.class);
                if(khu4==1){
                    tvttkhu4.setText("Đang Tưới");
                }else {
                    tvttkhu4.setText("");
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        //khu2
        khu2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                int khu2 = dataSnapshot.getValue(Integer.class);
                if(khu2==1){
                    tvttkhu2.setText("Đang Tưới");
                }else {
                    tvttkhu2.setText("");
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        //khu3
        khu3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                int khu3 = dataSnapshot.getValue(Integer.class);
                if(khu3==1){
                    tvttkhu3.setText("Đang Tưới");
                }else {
                    tvttkhu3.setText("");
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });



        //khu11
        khu11.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                int khu11 = dataSnapshot.getValue(Integer.class);
                if(khu11==1){
                    tvttkhu11.setText("Đang Tưới");
                }else {
                    tvttkhu11.setText("");
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
        //khu4
        khu44.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                int khu44 = dataSnapshot.getValue(Integer.class);
                if(khu44==1){
                    tvttkhu44.setText("Đang Tưới");
                }else {
                    tvttkhu44.setText("");
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        //khu2
        khu22.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                int khu22 = dataSnapshot.getValue(Integer.class);
                if(khu22==1){
                    tvttkhu22.setText("Đang Tưới");
                }else {
                    tvttkhu22.setText("");
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        //khu3
        khu33.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                int khu33 = dataSnapshot.getValue(Integer.class);
                if(khu33==1){
                    tvttkhu33.setText("Đang Tưới");
                }else {
                    tvttkhu33.setText("");
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });


        // Read Nhiet Do
        nhietdodb.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int tsnhiet = dataSnapshot.getValue(Integer.class);
                nhietdo.setProgress(tsnhiet);
                if(tsnhiet > 40){
                    tvtrangthaivuon.setText("Nhiệt Độ Cao");
                }else {
                    tvtrangthaivuon.setText("Ổn Định");
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        // Read Do Am
        doamdb.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int tsdoam = dataSnapshot.getValue(Integer.class);
                doam.setProgress(tsdoam);
            }
            @Override
            public void onCancelled(DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        // Read Do Am Dat
        doamdatdb.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int tsdoamdat = dataSnapshot.getValue(Integer.class);
                doamdat.setProgress(tsdoamdat);
                if(tsdoamdat < 10){
                    tvtrangthaivuon.setText("Độ Ẩm Đất Thấp");
                    NotificationCompat.Builder builder = new NotificationCompat.Builder(getContext())
                            .setContentTitle("Vườn Của Bạn")
                            .setContentText("Độ ẩm đất thấp các khu đang tưới")
                            .setSmallIcon(R.drawable.logo)
                            .setPriority(Notification.PRIORITY_DEFAULT)
                            .setAutoCancel(true)
                            .setDefaults(Notification.DEFAULT_ALL)
                            .setVisibility(NotificationCompat.VISIBILITY_PUBLIC);
                    notificationManager.notify(0, builder.build());
                    Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                    builder.setSound(alarmSound);
                }else {
                    tvtrangthaivuon.setText("Ổn Định");
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        // Read Muc Nuoc
        mucnuocdb.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int tsmucnuoc = dataSnapshot.getValue(Integer.class);
                mucnuoc.setProgress(tsmucnuoc);
                if(tsmucnuoc < 20){
                    tvtrangthaivuon.setText("Mực Nước Dưới 20%");
                    NotificationCompat.Builder builder = new NotificationCompat.Builder(getContext())
                            .setContentTitle("Vườn Của Bạn")
                            .setContentText("Mực nước Trong Bể Còn Dưới 20%")
                            .setSmallIcon(R.drawable.logo)
                            .setPriority(Notification.PRIORITY_DEFAULT)
                            .setAutoCancel(true)
                            .setDefaults(Notification.DEFAULT_ALL)
                            .setVisibility(NotificationCompat.VISIBILITY_PUBLIC);
                    notificationManager.notify(0, builder.build());
                    Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                    builder.setSound(alarmSound);

                }else {
                    tvtrangthaivuon.setText("Ổn Định");
                }

            }
            @Override
            public void onCancelled(DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        // Read Mua
        muadb.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int tsmua = dataSnapshot.getValue(Integer.class);
                if(tsmua == 0){
                    imgthoitiet.setImageResource(R.drawable.muoiba);
                    tvcbmua.setText("Không Mưa");
                }else {
                    imgthoitiet.setImageResource(R.drawable.muoichin);
                    tvcbmua.setText("Đang Mưa");
                    NotificationCompat.Builder builder = new NotificationCompat.Builder(getContext())
                            .setContentTitle("Vườn Của Bạn")
                            .setContentText("Đang Mưa")
                            .setSmallIcon(R.drawable.logo)
                            .setPriority(Notification.PRIORITY_DEFAULT)
                            .setAutoCancel(true)
                            .setDefaults(Notification.DEFAULT_ALL)
                            .setVisibility(NotificationCompat.VISIBILITY_PUBLIC);
                    notificationManager.notify(1, builder.build());
                    Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                    builder.setSound(alarmSound);
                }

            }
            @Override
            public void onCancelled(DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });


        OpenWeatherMapHelper helper = new OpenWeatherMapHelper(getString(R.string.OPEN_WEATHER_MAP_API_KEY));
        helper.setUnits(Units.METRIC);
        helper.setLang(Lang.VIETNAMESE);
        helper.getThreeHourForecastByCityName("Thanh pho Ho Chi Minh", new ThreeHourForecastCallback() {
            @Override
            public void onSuccess(ThreeHourForecast threeHourForecast) {
                Log.v(TAG, "City/Country: " + threeHourForecast.getCity().getName() + "/" + threeHourForecast.getCity().getCountry() + "\n"
                        + "Forecast Array Count: " + threeHourForecast.getCnt() + "\n"
                        //For this example, we are logging details of only the first forecast object in the forecasts array
                        + "First Forecast Date Timestamp: " + threeHourForecast.getList().get(0).getDt() + "\n"
                        + "First Forecast Weather Description: " + threeHourForecast.getList().get(0).getWeatherArray().get(0).getDescription() + "\n"
                        + "First Forecast Max Temperature: " + threeHourForecast.getList().get(0).getMain().getTempMax() + "\n"
                        + "First Forecast Wind Speed: " + threeHourForecast.getList().get(0).getWind().getSpeed() + "\n"
                );

                int nhietdo1 = (int) threeHourForecast.getList().get(0).getMain().getTempMax();
                int gio1 = (int) threeHourForecast.getList().get(0).getWind().getSpeed();
                String thoitiet = threeHourForecast.getList().get(0).getWeatherArray().get(0).getDescription();

                //mưa vừa
                String s1 = URLEncoder.encode(thoitiet);
                //mưa nhẹn
                tvnhietdo.setText(nhietdo1+" °C");
                tvgio.setText(gio1+" m/s");
                tvvitri.setText(thoitiet);
//                if(s1.equals("m%C6%B0a+v%E1%BB%ABa")){
//                    imgthoitiet.setImageResource(R.drawable.bay);
//                }else if (s1.equals("m%C6%B0a+nh%E1%BA%B9")){
//                    imgthoitiet.setImageResource(R.drawable.muoibon);
//                }

            }

            @Override
            public void onFailure(Throwable throwable) {
                Log.v(TAG, throwable.getMessage());
            }
        });
        return view;
    }
}

