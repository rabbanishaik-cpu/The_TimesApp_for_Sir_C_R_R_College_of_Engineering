package com.example.meratimetable;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class FUI extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    protected Button btn_f;
    Spinner spin4;
    Spinner spin5;

    String sp4,sp5;

    private SharedPreferences sharedPreferences2;
    private SharedPreferences.Editor editor2;

    String[] branches = {"CSE", "ECE", "IT", "CIVIL", "EEE", "MECH"};
    String[] names = {"Dr.A Yesubabu", "Dr.M Krishna", "Dr.G Nirmala", "Dr.N.Deepak","J.S.V.Gopala Krishna","Dr B.Madhava Rao","S M B Chowdary",
                "K Srinivas","K N Madhavi Latha","K.Chaitanya Deepthi","K.Varada Rajkumar","M.Ganesh Babu","G Satyanarayana",
            "B.H.Benny","Ch Ramadevi","S K Chaitanya.R","Samparthi V S Kumar","P Naga Deepthi","M Madhava Rao","V Shariff","D V V Deepthi",
                "V Pranav","K.Swathi","S.Jaya Prakash","Ch.Srinivas","T.Koti Mani Kumar","B.Rama Lakshmi","K.B.V.Prasad","M.S.Ekambaresh"};
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fui);

        spin4 =findViewById(R.id.spinner4);
        spin4.setOnItemSelectedListener(this);
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, branches);
        //Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //attaching dataAdapter to spinner
        spin4.setAdapter(dataAdapter);

        spin5 = findViewById(R.id.spinner5);
        spin5.setOnItemSelectedListener(this);
        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, names);
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin5.setAdapter(dataAdapter2);

        btn_f =findViewById(R.id.fdisplay);
        btn_f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(FUI.this,F1.class);
                sp4 = spin4.getSelectedItem().toString();
                sp5 = spin5.getSelectedItem().toString();
                i.putExtra("branch",sp4);
                i.putExtra("name",sp5);
                startActivity(i);
            }});

        //declaring shared preferences file
        sharedPreferences2= getSharedPreferences("faculty_prefs",MODE_PRIVATE);
        //retrieving values from shared prefernces file
        int settings4 = sharedPreferences2.getInt("spinnerselection4",0);
        int settings5 = sharedPreferences2.getInt("spinnerselection5",0);

        //setting values retrieved from shared pref file to spinners
        spin4.setSelection(settings4);
        spin5.setSelection(settings5);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //on selecting a spinner item
            parent.getItemAtPosition(position);
        //Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();

        try{
            int selectedposition4 = spin4.getSelectedItemPosition();
            int selectedposition5 = spin5.getSelectedItemPosition();

            //storing values in shared prefs
            editor2 = sharedPreferences2.edit();

            editor2.putInt("spinnerselection4",selectedposition4);
            editor2.putInt("spinnerselection5",selectedposition5);
            editor2.apply();
        }
        catch (Exception e){
            //e.printStackTrace();
            Log.i("tag", "onItemSelected: Error here");
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
}
