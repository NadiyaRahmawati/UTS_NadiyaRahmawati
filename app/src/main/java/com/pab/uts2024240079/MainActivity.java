package com.pab.uts2024240079;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText etName, etNumber;
    private Spinner spJalurPendaftaran;
    private CheckBox cbKonfirmasi;
    private Button btnDaftar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.et_name);
        etNumber = findViewById(R.id.et_number);
        spJalurPendaftaran = findViewById(R.id.sp_jalurpendaftaran);
        cbKonfirmasi = findViewById(R.id.cb_konfirmasi);
        btnDaftar = findViewById(R.id.btn_daftar);

        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name, number, jalurPendaftaran;

                name = etName.getText().toString();
                number = etNumber.getText().toString();
                jalurPendaftaran = spJalurPendaftaran.getSelectedItem().toString();

                if (name.trim().equals("")){
                    etName.setError("Silahkan Isi Nama Terlebih Dahulu!");
                }
                else if (number.trim().equals("")){
                    etNumber.setError("Silahkan Isi Nomor Pendaftaran Terlebih Dahulu!");
                }
                else if (jalurPendaftaran.equals("Jalur Pendaftaran")){
                    Toast.makeText(MainActivity.this, "Silahkan Pilih Jalur Pendaftaran Terlebih Dahulu!", Toast.LENGTH_SHORT).show();
                }
                else if (cbKonfirmasi.isChecked() == false){
                    Toast.makeText(MainActivity.this, "Silahkan Centang Kotak Konfirmasi Pendaftaran Terlebih Dahulu", Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent = new Intent(MainActivity.this, KonfirmasiPendaftaranActivity.class);
                    intent.putExtra("kirimName", name);
                    intent.putExtra("kirimNumber", number);
                    intent.putExtra("kirimJalurPendaftaran", jalurPendaftaran);
                    startActivity(intent);
                }
            }
        });
    }
}