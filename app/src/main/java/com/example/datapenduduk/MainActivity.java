package com.example.datapenduduk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText nama, email, NIK, TTL, alamat, phone;
    RadioButton gender;
    RadioGroup Gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Text input
        nama = (EditText) findViewById(R.id.nama);
        email = (EditText) findViewById(R.id.email);
        NIK = (EditText) findViewById(R.id.NIK);
        TTL = (EditText) findViewById(R.id.TTL);
        alamat = (EditText) findViewById(R.id.alamat);
        phone = (EditText) findViewById(R.id.telpon);

        //Radio button
        Gender = (RadioGroup) findViewById(R.id.gender);

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void Submit(View view) {
        int radioId = Gender.getCheckedRadioButtonId();
        gender = (RadioButton) findViewById(radioId);

        Intent hubung = new Intent(this, HasilActivity.class);
        hubung.putExtra("nama", nama.getText().toString());
        hubung.putExtra("email", email.getText().toString());
        hubung.putExtra("NIK", NIK.getText().toString());
        hubung.putExtra("jeniskelamin", gender.getText().toString());
        hubung.putExtra("TTL", TTL.getText().toString());
        hubung.putExtra("alamat", alamat.getText().toString());
        hubung.putExtra("phone", phone.getText().toString());
        startActivity(hubung);

    }

}
