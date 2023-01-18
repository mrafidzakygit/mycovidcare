package com.example.mycovidcarefinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class VaksinasiSaya extends AppCompatActivity {
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaksinasi_saya);
        TextView hNama = (TextView) findViewById(R.id.tnama);
        TextView hnik = (TextView) findViewById(R.id.tnik);
        TextView halamat = (TextView) findViewById(R.id.talamat);
        TextView hdomisili = (TextView) findViewById(R.id.tdomisili);
        TextView hjenis = (TextView) findViewById(R.id.tjenis);
        TextView hlokasi = (TextView) findViewById(R.id.tlokasi);
        TextView hvaksinke = (TextView) findViewById(R.id.tvaksinke);

        Intent getIntent = getIntent();
        hNama.setText(getIntent.getStringExtra("nama"));
        hnik.setText(getIntent.getStringExtra("nik"));
        halamat.setText(getIntent.getStringExtra("alamat"));
        hdomisili.setText(getIntent.getStringExtra("domisili"));
        hjenis.setText(getIntent.getStringExtra("jenis"));
        hlokasi.setText(getIntent.getStringExtra("lokasi"));
        hvaksinke.setText(getIntent.getStringExtra("vaksinke"));

        //button kembali saya
        btn = findViewById(R.id.btnKembaliSaya);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(VaksinasiSaya.this, Main2Activity.class));
            }
        });

    }
}