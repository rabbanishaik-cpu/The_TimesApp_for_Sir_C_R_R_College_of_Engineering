package com.example.meratimetable;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class SUI extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    public Spinner spin1,spin2,spin3;
    private String sp1,sp2,sp3;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    String[] years = {"1", "2", "3", "4"};
    String[] branches = {"CSE", "ECE", "IT", "CIVIL", "EEE", "MECH"};
    String[] sections = {"A", "B", "C","D"};

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sui);


        spin1 =findViewById(R.id.spinner1);
        spin1.setOnItemSelectedListener(this);
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, years);
        //Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //attaching dataAdapter to spinner
        spin1.setAdapter(dataAdapter);

        spin2 = findViewById(R.id.spinner2);
        spin2.setOnItemSelectedListener(this);
        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, branches);
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin2.setAdapter(dataAdapter2);

        spin3 =findViewById(R.id.spinner3);
        spin3.setOnItemSelectedListener(this);
        ArrayAdapter<String> dataAdapter3 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, sections);
        dataAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin3.setAdapter(dataAdapter3);

        Button btn = findViewById(R.id.display);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 sp1 = spin1.getSelectedItem().toString();
                 sp2 = spin2.getSelectedItem().toString();
                 sp3 = spin3.getSelectedItem().toString();

                 Intent i = new Intent(SUI.this,M2.class);
                 i.putExtra("year",sp1);
                 i.putExtra("branch",sp2);
                 i.putExtra("section",sp3);
                 startActivity(i);
            }});

        sharedPreferences=getSharedPreferences("student_prefs",MODE_PRIVATE);

        int settings1 = sharedPreferences.getInt("spinnerSelection1",0);
        int settings2 = sharedPreferences.getInt("spinnerSelection2",0);
        int settings3 = sharedPreferences.getInt("spinnerSelection3",0);

        spin1.setSelection(settings1);
        spin2.setSelection(settings2);
        spin3.setSelection(settings3);

    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //on selecting a spinner item
        parent.getItemAtPosition(position);
        //Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();

        try {
            editor = sharedPreferences.edit();

            int selectedposition1 = spin1.getSelectedItemPosition();
            int selectedposition2 = spin2.getSelectedItemPosition();
            int selectedposition3 = spin3.getSelectedItemPosition();

            editor.putInt("spinnerSelection1",selectedposition1);
            editor.putInt("spinnerSelection2",selectedposition2);
            editor.putInt("spinnerSelection3",selectedposition3);
            editor.apply();

        } catch (Exception e) {
            Log.i("tag", "onItemSelected: Error here");
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

}