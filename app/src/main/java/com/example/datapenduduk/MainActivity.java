package com.example.datapenduduk;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText nama, email, date, adrs;
    RadioButton laki, perem;
    Button submit;
    DatePickerDialog datePickerDialog;
    SimpleDateFormat simpleDateFormat;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Text input
        nama = (EditText) findViewById(R.id.nama);
        email = (EditText) findViewById(R.id.email);
        date = (EditText) findViewById(R.id.Birthdate);
        adrs = (EditText) findViewById(R.id.alamat);

        //Radio button
        laki = findViewById(R.id.laki);
        perem = findViewById(R.id.perem);

        submit = findViewById(R.id.btn_smb);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!nama.getText().toString().equals("") && !email.getText().toString().equals("")
                        && !date.getText().toString().equals("")){
                    if (laki.isChecked() || perem.isChecked()){
                        Toast.makeText(MainActivity.this, "Done", Toast.LENGTH_SHORT).show();
                        Intent hubung = new Intent(MainActivity.this, HasilActivity.class);
                        hubung.putExtra("nama", nama.getText().toString());
                        hubung.putExtra("email", email.getText().toString());
                        if (laki.isChecked()) {
                            hubung.putExtra("jeniskelamin", laki.getText().toString());
                        } else {
                            hubung.putExtra("jeniskelamin", perem.getText().toString());
                        }
                        hubung.putExtra("alamat", adrs.getText().toString());
                        hubung.putExtra("date", date.getText().toString());
                        startActivity(hubung);
                        finish();
                    }

                    }else {
                    Toast.makeText(MainActivity.this,"Please Fill In", Toast.LENGTH_SHORT).show();
                }


            }
        });
        simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDate();
            }

            private void showDate() {
                Calendar calendar = Calendar.getInstance();

                datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        Calendar newdate = Calendar.getInstance();
                        newdate.set(year, month, dayOfMonth);

                        date.setText(simpleDateFormat.format(newdate.getTime()));
                    }
                }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.show();
            }

        });
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

//    public void Submit(View view) {
//
//        Intent hubung = new Intent(this, HasilActivity.class);
//        hubung.putExtra("nama", nama.getText().toString());
//        hubung.putExtra("email", email.getText().toString());
//        if (laki.isChecked()) {
//            hubung.putExtra("jeniskelamin", laki.getText().toString());
//        }else {
//            hubung.putExtra("jeniskelamin", perem.getText().toString());
//        }
//        hubung.putExtra("alamat", adrs.getText().toString());
//        startActivity(hubung);
//
//    }


}
