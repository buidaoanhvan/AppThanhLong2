package com.example.appthanhlong.fragment;

import android.os.Bundle;

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



public class ThongSoFragment extends Fragment {

    ArcProgress nhietdo, doam, doamdat;
    CircleProgress mucnuoc;
    TextView tvnhietdo, tvgio, tvvitri;
    ImageView imgthoitiet;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference nhietdodb = database.getReference("ThongSo/NhietDo");
    DatabaseReference doamdb = database.getReference("ThongSo/DoAm");
    DatabaseReference doamdatdb = database.getReference("ThongSo/DoAmDat");
    DatabaseReference mucnuocdb = database.getReference("ThongSo/MucNuoc");
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_thong_so, container, false);
        nhietdo = (ArcProgress) view.findViewById(R.id.nhietdo_progress);
        doam = (ArcProgress) view.findViewById(R.id.doam_progress);
        doamdat = (ArcProgress) view.findViewById(R.id.doamdat_progress);
        mucnuoc = (CircleProgress) view.findViewById(R.id.mucnuoc_progress);
        tvnhietdo = (TextView) view.findViewById(R.id.tvnhietdo);
        tvgio = (TextView) view.findViewById(R.id.tvgio);
        tvvitri = (TextView) view.findViewById(R.id.tvvitri);
        imgthoitiet =(ImageView) view.findViewById(R.id.imgthoitiet);

        // Read Nhiet Do
        nhietdodb.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int tsnhiet = dataSnapshot.getValue(Integer.class);
                nhietdo.setProgress(tsnhiet);
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
                if(s1.equals("m%C6%B0a+v%E1%BB%ABa")){
                    imgthoitiet.setImageResource(R.drawable.bay);
                }else if (s1.equals("m%C6%B0a+nh%E1%BA%B9")){
                    imgthoitiet.setImageResource(R.drawable.muoibon);
                }

            }

            @Override
            public void onFailure(Throwable throwable) {
                Log.v(TAG, throwable.getMessage());
            }
        });
        return view;
    }
}

