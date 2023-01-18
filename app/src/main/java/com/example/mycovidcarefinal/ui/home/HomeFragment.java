package com.example.mycovidcarefinal.ui.home;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.mycovidcarefinal.Berita;
import com.example.mycovidcarefinal.DaftarVaksin;
import com.example.mycovidcarefinal.Login;
import com.example.mycovidcarefinal.LokasiVaksin;
import com.example.mycovidcarefinal.R;
import com.example.mycovidcarefinal.StatistikCovid;
import com.example.mycovidcarefinal.databinding.FragmentHomeBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class HomeFragment extends Fragment {

    View view;
    Button data,berita, btnlogout;
    ImageButton daftarvaksin,lokasi;
    private FirebaseUser firebaseUser;
    private TextView textname;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);

        textname = (TextView)view.findViewById(R.id.namakamu);
        btnlogout = (Button)view.findViewById(R.id.btnlogout);

        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        if (firebaseUser!=null) {
            textname.setText(firebaseUser.getDisplayName());
        }else{
            textname.setText("Login gagal");
        }
        btnlogout.setOnClickListener(v -> {
            FirebaseAuth.getInstance().signOut();
            startActivity(new Intent(getActivity(), Login.class));
        });

        data = (Button)view.findViewById(R.id.data);
        data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pindah = new Intent(getActivity(), StatistikCovid.class);
                startActivity(pindah);
            }
        });

        berita = (Button)view.findViewById(R.id.berita);
        berita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pindah2 = new Intent(getActivity(), Berita.class);
                startActivity(pindah2);
            }
        });

        daftarvaksin = (ImageButton) view.findViewById(R.id.daftarvaksin);
        daftarvaksin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pindah3 = new Intent(getActivity(), DaftarVaksin.class);
                startActivity(pindah3);
            }
        });

        lokasi = (ImageButton)view.findViewById(R.id.lokasi);
        lokasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pindah4 = new Intent(getActivity(), LokasiVaksin.class);
                startActivity(pindah4);
            }
        });




        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}