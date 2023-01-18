package com.example.mycovidcarefinal;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class LokasiVaksin extends AppCompatActivity {
    List<ListLokasi> elements;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lokasi_vaksin);
        setTitle("Lokasi");
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();


        init();
    }

    public void init(){
        elements = new ArrayList<>();
        elements.add(new ListLokasi("#775447", "Rsup Hasan Sadikin", "Jl.Pasteur No 38                                 ", "Aktif"));
        elements.add(new ListLokasi("#607D8B", "Puskesmas Balai Kota", "Jl.Wastukencana No 2                             ", "Aktif"));
        elements.add(new ListLokasi("#607D8B", "RSKIA Bandung", "Jl Raya Kopo No.311                                   ", "Aktif"));
        elements.add(new ListLokasi("#607D8B", "Rs Advent", "Jl Cihampelas No 161                            ", "Aktif"));
        elements.add(new ListLokasi("#607D8B", "Medika Antapani", "Jl Purwakarta No 3                                       ", "Aktif"));



        ListAdapter listAdapter = new ListAdapter(elements, this);
        RecyclerView recyclerView = findViewById(R.id.listRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapter);

    }
}