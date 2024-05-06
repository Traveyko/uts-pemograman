package com.example.datapenduduk;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.Objects;

public class HasilActivity extends AppCompatActivity {
TextView nama, email, gender1, gender2, date, adrs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil);

        nama = findViewById(R.id.txt_nama);
        email = findViewById(R.id.txt_email);
        gender1 = findViewById(R.id.gender1);
        gender2 = findViewById(R.id.gender2);
        date = findViewById(R.id.txt_bd);
        adrs = findViewById(R.id.txt_adrs);

        String get_nama = Objects.requireNonNull(getIntent().getExtras()).getString("nama");
        String get_email = getIntent().getExtras().getString("email");
        String get_gender1 = getIntent().getExtras().getString("jeniskelamin");
        String get_gender2 = getIntent().getExtras().getString("jeniskelamin");
        String get_date = getIntent().getExtras().getString("date");
        String get_adrs = getIntent().getExtras().getString("alamat");

        nama.setText("Name : "+get_nama);
        email.setText("Email : "+get_email);
        gender1.setText("Gender : "+get_gender1);
        gender2.setText("Gender : "+get_gender2);
        date.setText("Date : "+get_date);
        adrs.setText("Address : "+get_adrs);
    }
}