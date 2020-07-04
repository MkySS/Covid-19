package com.example.covid_19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }
    public void passarSintomas(View view) {
        Intent intentS = new Intent(this, Display_Sintomas.class);

        startActivity(intentS);
    }
    public void passarDCronicas(View view) {
        Intent intentDC = new Intent(this, Display_Doenca_cronica.class);

        startActivity(intentDC);
    }
    Intent intent = getIntent();
}
