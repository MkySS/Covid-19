package com.example.covid_19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Menu2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }
    public void passarLocalView(View view) {
        Intent intentLV = new Intent(this, LocalView.class);

        startActivity(intentLV);
    }
    Intent intentM = getIntent();
}