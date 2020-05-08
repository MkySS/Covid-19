package com.example.covid_19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Sintomas extends AppCompatActivity {

    Spinner dropdownSintomasP1;
    Spinner dropdownSintomasP2;
    Spinner dropdownSintomasP3;
    Spinner dropdownSintomasS1;
    Spinner dropdownSintomasS2;
    Spinner dropdownSintomasS3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sintomas);

        dropdownSintomasP1 = (Spinner) findViewById(R.id.spinnerS1);
        dropdownSintomasP2 = (Spinner) findViewById(R.id.spinnerS2);
        dropdownSintomasP3 = (Spinner) findViewById(R.id.spinnerS3);
        dropdownSintomasS1 = (Spinner) findViewById(R.id.spinnerS4);
        dropdownSintomasS2 = (Spinner) findViewById(R.id.spinnerS5);
        dropdownSintomasS3 = (Spinner) findViewById(R.id.spinnerS6);

        final List<String> Sp = new ArrayList<>();
        Sp.add(getString(R.string.dfSpinner));
        Sp.add(getString(R.string.s1));
        Sp.add(getString(R.string.s2));
        Sp.add(getString(R.string.s3));

        final List<String> Ss = new ArrayList<>();
        Ss.add(getString(R.string.dfSpinner));
        Ss.add(getString(R.string.s4));
        Ss.add(getString(R.string.s5));
        Ss.add(getString(R.string.s6));
        Ss.add(getString(R.string.s7));
        Ss.add(getString(R.string.s8));
        Ss.add(getString(R.string.s9));

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Sp);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Ss);


        dropdownSintomasP1.setAdapter(adapter);
        dropdownSintomasP2.setAdapter(adapter);
        dropdownSintomasP3.setAdapter(adapter);
        dropdownSintomasS1.setAdapter(adapter1);
        dropdownSintomasS2.setAdapter(adapter1);
        dropdownSintomasS3.setAdapter(adapter1);

        dropdownSintomasP1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String strSintoma1 = parent.getItemAtPosition(position).toString();

                Toast.makeText(Sintomas.this, "Selecionado: "+strSintoma1, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        dropdownSintomasP2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String strSintoma2 = parent.getItemAtPosition(position).toString();

                Toast.makeText(Sintomas.this, "Selecionado: "+strSintoma2, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        dropdownSintomasP3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String strSintoma3 = parent.getItemAtPosition(position).toString();

                Toast.makeText(Sintomas.this, "Selecionado: "+strSintoma3, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        dropdownSintomasS1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String strSintoma4 = parent.getItemAtPosition(position).toString();

                Toast.makeText(Sintomas.this, "Selecionado: "+strSintoma4, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        dropdownSintomasS2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String strSintoma5 = parent.getItemAtPosition(position).toString();

                Toast.makeText(Sintomas.this, "Selecionado: "+strSintoma5, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        dropdownSintomasS3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String strSintoma6 = parent.getItemAtPosition(position).toString();

                Toast.makeText(Sintomas.this, "Selecionado: "+strSintoma6, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
    Intent intentS = getIntent();
}
