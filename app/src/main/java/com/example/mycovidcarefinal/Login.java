package com.example.mycovidcarefinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;




    public class Login extends AppCompatActivity {
        private EditText editEmail, editPassword;
        private Button btnLogin, btnRegisterBaru;
        private ProgressDialog progressDialog;
        private FirebaseAuth mAuth;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login);
            ActionBar actionBar = getSupportActionBar();
            actionBar.hide();
            editEmail = findViewById(R.id.email);
            editPassword = findViewById(R.id.password);
            btnLogin = findViewById(R.id.btnLogin);
            btnRegisterBaru = findViewById(R.id.btnRegisterBaru);
            mAuth = FirebaseAuth.getInstance();
            progressDialog = new ProgressDialog(Login.this);
            progressDialog.setTitle("Loading");
            progressDialog.setMessage("Silahkan Tunggu");
            progressDialog.setCancelable(false);

            //Mengarahkan button register
            btnRegisterBaru.setOnClickListener(v -> {
                startActivity(new Intent(getApplicationContext(), Register.class));
            });
            //Mengarahkan button login
            btnLogin.setOnClickListener(v -> {
                if (editEmail.getText().length() > 0 && editPassword.getText().length() > 0) {
                    login(editEmail.getText().toString(), editPassword.getText().toString());
                } else {
                    Toast.makeText(getApplicationContext(), "Silahkan isi semua data", Toast.LENGTH_SHORT).show();
                }
            });

        }

        private void login(String email, String password) {
            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful() && task.getResult() != null) {
                        if (task.getResult().getUser() != null) {
                            reload();

                        } else {
                            Toast.makeText(getApplicationContext(), "Login gagal", Toast.LENGTH_SHORT).show();
                        }

                    } else {
                        Toast.makeText(getApplicationContext(), "Login gagal", Toast.LENGTH_SHORT).show();
                    }

                }
            });

        }

        private void reload() {
            startActivity(new Intent(getApplicationContext(), Main2Activity.class));
        }

        @Override
        public void onStart() {
            super.onStart();
            // Check if user is signed in (non-null) and update UI accordingly.
            FirebaseUser currentUser = mAuth.getCurrentUser();
            if (currentUser != null) {
                reload();
            }
        }
    }
