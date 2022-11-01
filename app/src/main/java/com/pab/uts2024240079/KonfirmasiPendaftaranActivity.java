package com.pab.uts2024240079;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class KonfirmasiPendaftaranActivity extends AppCompatActivity {
    private TextView tvName, tvNumber, tvJalurPendaftaran;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_konfirmasi_pendaftaran);

        tvName = findViewById(R.id.tv_name);
        tvNumber = findViewById(R.id.tv_number);
        tvJalurPendaftaran = findViewById(R.id.tv_jalurpendaftaran);

        Intent intentTerima = getIntent();
        tvName.setText(intentTerima.getStringExtra("kirimName"));
        tvNumber.setText(intentTerima.getStringExtra("kirimNumber"));
        tvJalurPendaftaran.setText(intentTerima.getStringExtra("kirimJalurPendaftaran"));
    }
}