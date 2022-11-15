package com.dzaky.latihanstorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnIntActivity = findViewById((R.id.btn_int_activity));
        btnIntActivity.setOnClickListener(this);

        Button btnEksActivity = findViewById((R.id.btn_eks_activity));
        btnEksActivity.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_int_activity) {
            Intent moveIntent = new Intent( MainActivity.this, InternalActivity.class);
            startActivity(moveIntent);
        } else if (view.getId() == R.id.btn_eks_activity) {
            Intent moveIntent = new Intent(MainActivity.this, EksternalActivity.class);
            startActivity(moveIntent);
        }
    }
}