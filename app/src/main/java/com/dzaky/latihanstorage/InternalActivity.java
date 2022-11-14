package com.dzaky.latihanstorage;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class InternalActivity extends AppCompatActivity implements View.OnClickListener{

    public static final String FILENAME = "namafile.txt";
    Button buatFile, ubahFile, bacaFile, deleteFile;
    TextView textBaca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internal);

        buatFile = findViewById(R.id.buttonBuatFile);
        ubahFile = findViewById(R.id.buttonUbahFile);
        bacaFile = findViewById(R.id.buttonBacaFile);
        deleteFile = findViewById(R.id.buttonHapusFile);
        textBaca = findViewById(R.id.textBaca);

        buatFile.setOnClickListener(this);
        ubahFile.setOnClickListener(this);
        bacaFile.setOnClickListener(this);
        deleteFile.setOnClickListener(this);
    }

    void buatFile() {
        String isiFile = "Ini adalah isi file\n";
        File file = new File(getFilesDir(), FILENAME);
        FileOutputStream outputStream = null;
        try {
            file.createNewFile();
            outputStream = new FileOutputStream(file, true);
            outputStream.write(isiFile.getBytes());
            outputStream.flush();
            outputStream.close();
            Toast.makeText(this, "Berhasil membuat file", Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    void ubahFile(){
        File file = new File(getFilesDir(), FILENAME);
        if (file.exists()){
            String isiFile = "Update data myFile";
            FileOutputStream outputStream;
            try {
                outputStream = openFileOutput(FILENAME, Context.MODE_PRIVATE);
                outputStream.write(isiFile.getBytes());
                outputStream.close();
                Toast.makeText(this, "success", Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
            Toast.makeText(getBaseContext(),"success",Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getBaseContext(),"file not found",Toast.LENGTH_SHORT).show();
        }
    }

    private void bacaFile() {
        try {
            FileInputStream fin = openFileInput(FILENAME);
            int c;
            String temp="";
            while( (c = fin.read()) != -1){
                temp = temp + Character.toString((char)c);
            }
            textBaca.setText(temp);
            Toast.makeText(getBaseContext(),"success",Toast.LENGTH_SHORT).show();
        } catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    void hapusFile() {
        File file = new File(getFilesDir(), FILENAME);
        if (file.exists()){
            file.delete();
            Toast.makeText(getBaseContext(),"success",Toast.LENGTH_SHORT).show();
            textBaca.setText("");
        } else {
            Toast.makeText(getBaseContext(),"file not found",Toast.LENGTH_SHORT).show();
        }
    }

    public void jalanPerintah(int id) {
        switch (id) {
            case R.id.buttonBuatFile:
                buatFile();
                break;
            case R.id.buttonBacaFile:
                bacaFile();
                break;
            case R.id.buttonUbahFile:
                ubahFile();
                break;
            case R.id.buttonHapusFile:
                hapusFile();
                break;
        }
    }

    @Override
    public void onClick(View v) {
        jalanPerintah(v.getId());
    }
}