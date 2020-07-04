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

public class Display_Doenca_cronica extends AppCompatActivity {

    Spinner dropdownDoencasC;
    Spinner dropdownDoencasC2;
    Spinner dropdownDoencasC3;
    Spinner dropdownDoencasC4;
    Spinner dropdownDoencasC5;
    Spinner dropdownDoencasC6;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doenca_cronica);

        dropdownDoencasC = (Spinner) findViewById(R.id.spinner7);
        dropdownDoencasC2 = (Spinner) findViewById(R.id.spinner8);
        dropdownDoencasC3 = (Spinner) findViewById(R.id.spinner9);
        dropdownDoencasC4 = (Spinner) findViewById(R.id.spinner10);
        dropdownDoencasC5 = (Spinner) findViewById(R.id.spinner11);
        dropdownDoencasC6 = (Spinner) findViewById(R.id.spinner12);


        final List<String> DC = new ArrayList<>();
        DC.add(getString(R.string.dfSpinner));

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, DC);

        dropdownDoencasC.setAdapter(adapter);
        dropdownDoencasC2.setAdapter(adapter);
        dropdownDoencasC3.setAdapter(adapter);
        dropdownDoencasC4.setAdapter(adapter);
        dropdownDoencasC5.setAdapter(adapter);
        dropdownDoencasC6.setAdapter(adapter);

        dropdownDoencasC.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String strDC1 = parent.getItemAtPosition(position).toString();

                Toast.makeText(Display_Doenca_cronica.this, "Selecionado: "+strDC1, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        dropdownDoencasC2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String strDC2 = parent.getItemAtPosition(position).toString();

                Toast.makeText(Display_Doenca_cronica.this, "Selecionado: "+strDC2, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        dropdownDoencasC3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String strDC3 = parent.getItemAtPosition(position).toString();

                Toast.makeText(Display_Doenca_cronica.this, "Selecionado: "+strDC3, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        dropdownDoencasC4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String strDC4 = parent.getItemAtPosition(position).toString();

                Toast.makeText(Display_Doenca_cronica.this, "Selecionado: "+strDC4, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        dropdownDoencasC5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String strDC5 = parent.getItemAtPosition(position).toString();

                Toast.makeText(Display_Doenca_cronica.this, "Selecionado: "+strDC5, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        dropdownDoencasC6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String strDC6 = parent.getItemAtPosition(position).toString();

                Toast.makeText(Display_Doenca_cronica.this, "Selecionado: "+strDC6, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    Intent intentDC = getIntent();
}
