package com.example.mycovidcarefinal;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DaftarVaksin extends AppCompatActivity {
    private Button btndaftar;
    private ImageButton imgbtn;
    private EditText ednama,edjenis,edlokasi,edvaksinke;
    DatabaseReference dbref;
    String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
    Pendaftaran pendaftaran;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_vaksin);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        //input data
        ednama=findViewById(R.id.editnama);
        edjenis=findViewById(R.id.editjenis);
        edlokasi=findViewById(R.id.editlokasi);
        edvaksinke=findViewById(R.id.editvaksinke);
        btndaftar=findViewById(R.id.btnDaftarForm);

        //arahkan tombol daftar
        btndaftar.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View view) {
                                             pendaftaran.setNama(ednama.getText().toString());
                                             pendaftaran.setJenis(edjenis.getText().toString());
                                             pendaftaran.setLokasi(edlokasi.getText().toString());
                                             pendaftaran.setVaksinke(edvaksinke.getText().toString());
                                             pendaftaran.getNama();
                                             pendaftaran.getJenis();
                                             pendaftaran.getLokasi();
                                             pendaftaran.getVaksinke();
                                             dbref= FirebaseDatabase.getInstance().getReference().child("DaftarVaksinasi");
                                             dbref.child("DaftarVaksinasi").child(uid).push().setValue(pendaftaran);
                                             startActivity(new Intent(getApplicationContext(),Main2Activity.class));


                                         }
                                     });
        //koneksi database firebase




        //button back
        imgbtn = findViewById(R.id.btnback2);
        imgbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DaftarVaksin.this, Main2Activity.class));
            }
        });

    }
}