package com.example.datapenduduk;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.Objects;

public class HasilActivity extends AppCompatActivity {
TextView txt1, txt2, txt3, txt4, txt5, txt6, txt7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil);

        txt1 = findViewById(R.id.namawarga);
        txt2 = findViewById(R.id.emailwarga);
        txt3 = findViewById(R.id.NIKwarga);
        txt4 = findViewById(R.id.jenisklmn);
        txt5 = findViewById(R.id.TTLwarga);
        txt6 = findViewById(R.id.alamatwarga);
        txt7 = findViewById(R.id.nomerwarga);

        String nama = Objects.requireNonNull(getIntent().getExtras()).getString("nama");
        String email = getIntent().getExtras().getString("email");
        String NIK = getIntent().getExtras().getString("NIK");
        String gender = getIntent().getExtras().getString("gender");
        String TTL = getIntent().getExtras().getString("TTL");
        String alamat = getIntent().getExtras().getString("alamat");
        String phone = getIntent().getExtras().getString("phone");

        txt1.setText("Nama\n"+nama);
        txt2.setText("email\n"+email);
        txt3.setText("NIK\n"+NIK);
        txt4.setText("gender\n"+gender);
        txt5.setText("TTL\n"+TTL);
        txt6.setText("alamat\n"+alamat);
        txt7.setText("phone\n"+phone);
    }
}