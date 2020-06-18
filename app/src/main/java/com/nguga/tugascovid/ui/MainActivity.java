package com.nguga.tugascovid.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.nguga.tugascovid.R;
import com.nguga.tugascovid.helper.ApiInterface;
import com.nguga.tugascovid.helper.ServiceGenerator;
import com.nguga.tugascovid.model.CovidModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
        Button btnsembuh,btnmati,btnkasus;
        TextView tgl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       btnmati = findViewById(R.id.buttonmeninggal);
        btnkasus = findViewById(R.id.button3kasus);
        btnsembuh = findViewById(R.id.button2sembuh);
        tgl = findViewById(R.id.date);
       getCovidData();
    }
    public void getCovidData(){
        ApiInterface service = ServiceGenerator.createService(ApiInterface.class);
        Call<CovidModel> call = service.getAll();
        call.enqueue(new Callback<CovidModel>() {
            @Override
            public void onResponse(Call<CovidModel> call, Response<CovidModel> response) {
                btnmati.setText(String.valueOf(response.body().getDeaths().getValue()));
                btnsembuh.setText(String.valueOf(response.body().getRecovered().getValue()));
                btnkasus.setText(String.valueOf(response.body().getConfirmed().getValue()));
                tgl.setText(response.body().getLastUpdate());
            }

            @Override
            public void onFailure(Call<CovidModel> call, Throwable t) {
                Toast.makeText(MainActivity.this, "salah", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
