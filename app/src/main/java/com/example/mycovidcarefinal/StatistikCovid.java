package com.example.mycovidcarefinal;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class StatistikCovid extends AppCompatActivity {
    TextView tv_sembuh, tv_positif, tv_rawat, tv_meninggal;
    ImageButton imgbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistik_covid);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();



        tv_sembuh = findViewById(R.id.tv_sembuh);
        tv_positif = findViewById(R.id.tv_positif);
        tv_rawat = findViewById(R.id.tv_rawat);
        tv_meninggal = findViewById(R.id.tv_meninggal);



        tampilData();

    }
    private void tampilData() {

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://covidapi-a1bbd-default-rtdb.asia-southeast1.firebasedatabase.app/datacovid.json";
        JSONObject jsonObject = new JSONObject();
        final String requestBody = jsonObject.toString();

        StringRequest stringRequest = new StringRequest(
                Request.Method.GET, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jo = new JSONObject(response.toString());
                            String sembuh = jo.getJSONObject("-NKS2vU1MfGigGT7-Y3D").getString("sembuh");
                            String positif = jo.getJSONObject("-NKS2vU1MfGigGT7-Y3D").getString("positif");
                            String dirawat = jo.getJSONObject("-NKS2vU1MfGigGT7-Y3D").getString("dirawat");
                            String meninggal = jo.getJSONObject("-NKS2vU1MfGigGT7-Y3D").getString("meninggal");


                            tv_sembuh.setText(sembuh);
                            tv_positif.setText(positif);
                            tv_rawat.setText(dirawat);
                            tv_meninggal.setText(meninggal);
                            Toast.makeText(StatistikCovid.this, "Data Berhasil Ditampilkan", Toast.LENGTH_SHORT).show();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
        },  new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(StatistikCovid.this, "Data Gagal Ditampilkan" + error, Toast.LENGTH_SHORT).show();
            }
        }
        );
        queue.add(stringRequest);

    }


        }


