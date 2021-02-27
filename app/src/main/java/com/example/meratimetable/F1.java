package com.example.meratimetable;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.solver.Cache;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class F1 extends AppCompatActivity {

    TextView M1;
    TextView M2;
    TextView M3;
    TextView M4;
    TextView M5;
    TextView M6;
    TextView M7;
    TextView M8;
    TextView M9;

    TextView T1;
    TextView T2;
    TextView T3;
    TextView T4;
    TextView T5;
    TextView T6;
    TextView T7;
    TextView T8;
    TextView T9;

    TextView W1;
    TextView W2;
    TextView W3;
    TextView W4;
    TextView W5;
    TextView W6;
    TextView W7;
    TextView W8;
    TextView W9;


    TextView TH1;
    TextView TH2;
    TextView TH3;
    TextView TH4;
    TextView TH5;
    TextView TH6;
    TextView TH7;
    TextView TH8;
    TextView TH9;


    TextView F1;
    TextView F2;
    TextView F3;
    TextView F4;
    TextView F5;
    TextView F6;
    TextView F7;
    TextView F8;
    TextView F9;

    TextView S1;
    TextView S2;
    TextView S3;
    TextView S4;
    TextView S5;

    TextView X1;
    TextView X2;
    TextView X3;
    TextView X4;
    TextView X5;
    TextView X6;
    TextView X7;
    TextView X8;

    DatabaseReference dRef;
    DatabaseReference dRef2;

    ArrayList<String> data= new ArrayList<>();

    String a1,a2;
    String branch,name,combined;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f1);

        DayOfWeek dof = LocalDate.now().getDayOfWeek();
        String str = dof.toString();

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String dte = simpleDateFormat.format(date);

        TextView txt = findViewById(R.id.day);
        txt.setText(str);

        TextView txt2 = findViewById(R.id.date);
        txt2.setText(dte);

        branch = getIntent().getStringExtra("branch");
        name = getIntent().getStringExtra("name");
        combined = name +" - "+ branch;
        TextView tx =findViewById(R.id.fName);
        tx.setText(combined);


        M1 = findViewById(R.id.m1);
        M2 = findViewById(R.id.m2);
        M3 = findViewById(R.id.m3);
        M4 = findViewById(R.id.m4);
        M5 = findViewById(R.id.m5);
        M6 = findViewById(R.id.m6);
        M7 = findViewById(R.id.m7);
        M8 = findViewById(R.id.m8);
        M9 = findViewById(R.id.m9);

        T1 = findViewById(R.id.t1);
        T2 = findViewById(R.id.t2);
        T3 = findViewById(R.id.t3);
        T4 = findViewById(R.id.t4);
        T5 = findViewById(R.id.t5);
        T6 = findViewById(R.id.t6);
        T7 = findViewById(R.id.t7);
        T8 = findViewById(R.id.t8);
        T9 = findViewById(R.id.t9);

        W1 = findViewById(R.id.w1);
        W2 = findViewById(R.id.w2);
        W3 = findViewById(R.id.w3);
        W4 = findViewById(R.id.w4);
        W5 = findViewById(R.id.w5);
        W6 = findViewById(R.id.w6);
        W7 = findViewById(R.id.w7);
        W8 = findViewById(R.id.w8);
        W9 = findViewById(R.id.w9);


        TH1 = findViewById(R.id.th1);
        TH2 = findViewById(R.id.th2);
        TH3 = findViewById(R.id.th3);
        TH4 = findViewById(R.id.th4);
        TH5 = findViewById(R.id.th5);
        TH6 = findViewById(R.id.th6);
        TH7 = findViewById(R.id.th7);
        TH8 = findViewById(R.id.th8);
        TH9 = findViewById(R.id.th9);


        F1 = findViewById(R.id.f1);
        F2 = findViewById(R.id.f2);
        F3 = findViewById(R.id.f3);
        F4 = findViewById(R.id.f4);
        F5 = findViewById(R.id.f5);
        F6 = findViewById(R.id.f6);
        F7 = findViewById(R.id.f7);
        F8 = findViewById(R.id.f8);
        F9 = findViewById(R.id.f9);

        S1 = findViewById(R.id.s1);
        S2 = findViewById(R.id.s2);
        S3 = findViewById(R.id.s3);
        S4 = findViewById(R.id.s4);
        S5 = findViewById(R.id.s5);

        X1 = findViewById(R.id.x1);
        X2 = findViewById(R.id.x2);
        X3 = findViewById(R.id.x3);
        X4 = findViewById(R.id.x4);
        X5 = findViewById(R.id.x5);
        X6 = findViewById(R.id.x6);
        X7 = findViewById(R.id.x7);
        X8 = findViewById(R.id.x8);

        X1.setBackground(getResources().getDrawable(R.drawable.first_column_color));
        X2.setBackground(getResources().getDrawable(R.drawable.first_column_color));
        X3.setBackground(getResources().getDrawable(R.drawable.first_column_color));
        X4.setBackground(getResources().getDrawable(R.drawable.first_column_color));
        X5.setBackground(getResources().getDrawable(R.drawable.first_column_color));
        X6.setBackground(getResources().getDrawable(R.drawable.first_column_color));
        X7.setBackground(getResources().getDrawable(R.drawable.first_column_color));
        X8.setBackground(getResources().getDrawable(R.drawable.first_column_color));

        switch (dof) {
            case MONDAY:
                M1.setBackground(getResources().getDrawable(R.drawable.first_column_color));
                M2.setBackground(getResources().getDrawable(R.drawable.border_textfield));
                M3.setBackground(getResources().getDrawable(R.drawable.border_textfield));
                M4.setBackground(getResources().getDrawable(R.drawable.border_textfield));
                M5.setBackground(getResources().getDrawable(R.drawable.border_textfield));
                M6.setBackground(getResources().getDrawable(R.drawable.border_textfield));
                M7.setBackground(getResources().getDrawable(R.drawable.border_textfield));
                M8.setBackground(getResources().getDrawable(R.drawable.border_textfield));
                M9.setBackground(getResources().getDrawable(R.drawable.border_textfield));
                break;
            case TUESDAY:
                T1.setBackground(getResources().getDrawable(R.drawable.first_column_color));
                T2.setBackground(getResources().getDrawable(R.drawable.border_textfield));
                T3.setBackground(getResources().getDrawable(R.drawable.border_textfield));
                T4.setBackground(getResources().getDrawable(R.drawable.border_textfield));
                T5.setBackground(getResources().getDrawable(R.drawable.border_textfield));
                T6.setBackground(getResources().getDrawable(R.drawable.border_textfield));
                T7.setBackground(getResources().getDrawable(R.drawable.border_textfield));
                T8.setBackground(getResources().getDrawable(R.drawable.border_textfield));
                T9.setBackground(getResources().getDrawable(R.drawable.border_textfield));
                break;
            case WEDNESDAY:
                W1.setBackground(getResources().getDrawable(R.drawable.first_column_color));
                W2.setBackground(getResources().getDrawable(R.drawable.border_textfield));
                W3.setBackground(getResources().getDrawable(R.drawable.border_textfield));
                W4.setBackground(getResources().getDrawable(R.drawable.border_textfield));
                W5.setBackground(getResources().getDrawable(R.drawable.border_textfield));
                W6.setBackground(getResources().getDrawable(R.drawable.border_textfield));
                W7.setBackground(getResources().getDrawable(R.drawable.border_textfield));
                W8.setBackground(getResources().getDrawable(R.drawable.border_textfield));
                W9.setBackground(getResources().getDrawable(R.drawable.border_textfield));
                break;
            case THURSDAY:
                TH1.setBackground(getResources().getDrawable(R.drawable.first_column_color));
                TH2.setBackground(getResources().getDrawable(R.drawable.border_textfield));
                TH3.setBackground(getResources().getDrawable(R.drawable.border_textfield));
                TH4.setBackground(getResources().getDrawable(R.drawable.border_textfield));
                TH5.setBackground(getResources().getDrawable(R.drawable.border_textfield));
                TH6.setBackground(getResources().getDrawable(R.drawable.border_textfield));
                TH7.setBackground(getResources().getDrawable(R.drawable.border_textfield));
                TH8.setBackground(getResources().getDrawable(R.drawable.border_textfield));
                TH9.setBackground(getResources().getDrawable(R.drawable.border_textfield));
                break;
            case FRIDAY:
                F1.setBackground(getResources().getDrawable(R.drawable.first_column_color));
                F2.setBackground(getResources().getDrawable(R.drawable.border_textfield));
                F3.setBackground(getResources().getDrawable(R.drawable.border_textfield));
                F4.setBackground(getResources().getDrawable(R.drawable.border_textfield));
                F5.setBackground(getResources().getDrawable(R.drawable.border_textfield));
                F6.setBackground(getResources().getDrawable(R.drawable.border_textfield));
                F7.setBackground(getResources().getDrawable(R.drawable.border_textfield));
                F8.setBackground(getResources().getDrawable(R.drawable.border_textfield));
                F9.setBackground(getResources().getDrawable(R.drawable.border_textfield));
                break;
            case SATURDAY:
                S1.setBackground(getResources().getDrawable(R.drawable.first_column_color));
                S2.setBackground(getResources().getDrawable(R.drawable.border_textfield));
                S3.setBackground(getResources().getDrawable(R.drawable.border_textfield));
                S4.setBackground(getResources().getDrawable(R.drawable.border_textfield));
                S5.setBackground(getResources().getDrawable(R.drawable.border_textfield));
                break;
            default:
                break;
        }
        dbRetrival();
    }

        public void dbRetrival () {
            a1 = getIntent().getStringExtra("branch");
            //Log.i("data", "dbRetrival: branch is "+a1);
            a2 = getIntent().getStringExtra("name");
            //Log.i("data", "dbRetrival: name is "+a2);

            assert a2 != null;
            try {
                assert a1 != null;
                if (a1.equals("CSE") && a2.equals("Dr.A Yesubabu")) {
                    dRef = FirebaseDatabase.getInstance().getReference("Dr_A_Yesubabu");
                    //dRef2 = dRef.child("1A");
                } else if (a1.equals("CSE") && a2.equals("Dr.M Krishna")) {
                    dRef = FirebaseDatabase.getInstance().getReference("Dr_M_Krishna");
                } else if (a1.equals("CSE") && a2.equals("Dr.G Nirmala")) {
                    dRef = FirebaseDatabase.getInstance().getReference("Dr_G_Nirmala");
                } else if (a1.equals("CSE") && a2.equals("Dr.N.Deepak")) {
                    dRef = FirebaseDatabase.getInstance().getReference("Dr_N_Deepak");
                } else if (a1.equals("CSE") && a2.equals("J.S.V.Gopala Krishna")) {
                    dRef = FirebaseDatabase.getInstance().getReference("J_S_V_Gopala_Krishna");
                } else if (a1.equals("CSE") && a2.equals("S M B Chowdary")) {
                    dRef = FirebaseDatabase.getInstance().getReference("S_M_B_Chowdary");
                } else if (a1.equals("CSE") && a2.equals("K Srinivas")) {
                    dRef = FirebaseDatabase.getInstance().getReference("K_Srinivas");
                } else if (a1.equals("CSE") && a2.equals("K N Madhavi Latha")) {
                    dRef = FirebaseDatabase.getInstance().getReference("K_N_Madhavi_Latha");
                } else if (a1.equals("CSE") && a2.equals("K.Chaitanya Deepthi")) {
                    dRef = FirebaseDatabase.getInstance().getReference("K_Chaitanya_Deepthi");
                } else if (a1.equals("CSE") && a2.equals("K.Varada Rajkumar")) {
                    dRef = FirebaseDatabase.getInstance().getReference("K_Varada_Rajkumar");
                } else if (a1.equals("CSE") && a2.equals("M.Ganesh Babu")) {
                    dRef = FirebaseDatabase.getInstance().getReference("M_Ganesh_Babu");
                } else if (a1.equals("CSE") && a2.equals("G Satyanarayana")) {
                    dRef = FirebaseDatabase.getInstance().getReference("G_Satyanarayana");
                } else if (a1.equals("CSE") && a2.equals("B.H.Benny")) {
                    dRef = FirebaseDatabase.getInstance().getReference("B_H_Benny");
                } else if (a1.equals("CSE") && a2.equals("Ch Ramadevi")) {
                    dRef = FirebaseDatabase.getInstance().getReference("Ch_Ramadevi");
                } else if (a1.equals("CSE") && a2.equals("S K Chaitanya.R")) {
                    dRef = FirebaseDatabase.getInstance().getReference("S_K_Chaitanya_R");
                } else if (a1.equals("CSE") && a2.equals("Samparthi V S Kumar")) {
                    dRef = FirebaseDatabase.getInstance().getReference("Samparthi_V_S_Kumar");
                } else if (a1.equals("CSE") && a2.equals("P Naga Deepthi")) {
                    dRef = FirebaseDatabase.getInstance().getReference("P_Naga_Deepthi");
                } else if (a1.equals("CSE") && a2.equals("M Madhava Rao")) {
                    dRef = FirebaseDatabase.getInstance().getReference("M_Madhava_Rao");
                } else if (a1.equals("CSE") && a2.equals("V Shariff")) {
                    dRef = FirebaseDatabase.getInstance().getReference("V_Shariff");
                } else if (a1.equals("CSE") && a2.equals("D V V Deepthi")) {
                    dRef = FirebaseDatabase.getInstance().getReference("D_V_V_Deepthi");
                } else if (a1.equals("CSE") && a2.equals("V Pranav")) {
                    dRef = FirebaseDatabase.getInstance().getReference("V_Pranav");
                } else if (a1.equals("CSE") && a2.equals("K.Swathi")) {
                    dRef = FirebaseDatabase.getInstance().getReference("K_Swathi");
                } else if (a1.equals("CSE") && a2.equals("S.Jaya Prakash")) {
                    dRef = FirebaseDatabase.getInstance().getReference("S_Jaya_Prakash");
                } else if (a1.equals("CSE") && a2.equals("Ch.Srinivas")) {
                    dRef = FirebaseDatabase.getInstance().getReference("Ch_Srinivas");
                } else if (a1.equals("CSE") && a2.equals("T.Koti Mani Kumar")) {
                    dRef = FirebaseDatabase.getInstance().getReference("T_Koti_Mani_Kumar");
                } else if (a1.equals("CSE") && a2.equals("B.Rama Lakshmi")) {
                    dRef = FirebaseDatabase.getInstance().getReference("B_Rama_Lakshmi");
                } else if (a1.equals("CSE") && a2.equals("Dr B.Madhava Rao")) {
                    dRef = FirebaseDatabase.getInstance().getReference("B_Madhava_Rao");
                } else if (a1.equals("CSE") && a2.equals("K.B.V.Prasad")) {
                    dRef = FirebaseDatabase.getInstance().getReference("K_B_V_Prasad");
                } else if (a1.equals("CSE") && a2.equals("M.S.Ekambaresh")) {
                    dRef = FirebaseDatabase.getInstance().getReference("M_S_Ekambaresh");
                }
            }catch(NullPointerException npe) {
                Toast.makeText(this, "Check your input", Toast.LENGTH_SHORT).show();
            }

            try {
                dRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for (DataSnapshot dsp : dataSnapshot.getChildren()) {
                            data.add((String) dsp.getValue());
                        }
                        //Log.i("dataVerification", "onDataChange: data in data is"+data);
                        try {
                            if (data != null) {
                                M2.setText(data.get(0));
                                M3.setText(data.get(1));
                                M4.setText(data.get(2));
                                M5.setText(data.get(3));
                                M6.setText(data.get(4));
                                M7.setText(data.get(5));
                                M8.setText(data.get(6));
                                M9.setText(data.get(7));

                                T2.setText(data.get(8));
                                T3.setText(data.get(9));
                                T4.setText(data.get(10));
                                T5.setText(data.get(11));
                                T6.setText(data.get(12));
                                T7.setText(data.get(13));
                                T8.setText(data.get(14));
                                T9.setText(data.get(15));

                                W2.setText(data.get(16));
                                W3.setText(data.get(17));
                                W4.setText(data.get(18));
                                W5.setText(data.get(19));
                                W6.setText(data.get(20));
                                W7.setText(data.get(21));
                                W8.setText(data.get(22));
                                W9.setText(data.get(23));

                                TH2.setText(data.get(24));
                                TH3.setText(data.get(25));
                                TH4.setText(data.get(26));
                                TH5.setText(data.get(27));
                                TH6.setText(data.get(28));
                                TH7.setText(data.get(29));
                                TH8.setText(data.get(30));
                                TH9.setText(data.get(31));

                                F2.setText(data.get(32));
                                F3.setText(data.get(33));
                                F4.setText(data.get(34));
                                F5.setText(data.get(35));
                                F6.setText(data.get(36));
                                F7.setText(data.get(37));
                                F8.setText(data.get(38));
                                F9.setText(data.get(39));

                                S2.setText(data.get(40));
                                S3.setText(data.get(41));
                                S4.setText(data.get(42));
                                S5.setText(data.get(43));
                            }
                        } catch (IndexOutOfBoundsException ioe) {
                            int size = data.size();
                            Toast.makeText(F1.this, " size is " + size, Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }catch (NullPointerException npe){
                Toast.makeText(this,"Check your input",Toast.LENGTH_SHORT).show();
            }
        }
}