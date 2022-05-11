package be.kuleuven.fitnessapp.classes.ActivityC;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.Arrays;

import be.kuleuven.fitnessapp.R;
import be.kuleuven.fitnessapp.classes.Models.ExersizeAction;

public class Exercise extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener {

    String[] Card = {"Running" , "Swimming", "Biking", "Rowing"};
    String[] Heav = {"Bench", "Squad" , "Deadlift"};
    String[] Cali = {"pushups" , "pullups"};
    String[] Stret ={"back", "triceps"};


    public String title;
    private TextView tv1;
    private Bundle extras;
    private String Username;
    private ExersizeAction Action;
    private EditText insert1;
    private EditText insert2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    //
    setContentView(R.layout.activity_exercise);
    Bundle extras = getIntent().getExtras();
    title = (String) extras.get(title);
    tv1 = (TextView) findViewById(R.id.title_exercise);
    tv1.setText(title);
    this.insert1 = (EditText) findViewById(R.id.insert1);
    this.insert2 = (EditText) findViewById(R.id.insert2);
        //

    //initiate variables
    extras = getIntent().getExtras();
    this.Username = extras.get("Username").toString();
    Action = new ExersizeAction(Username, title, this,this);
    //initiate tables
    initiateTables();
    // set spinner
    spinner(WhatArToUse());
    }

    public String getEX(){
        return "Running";
    }

    public String[] WhatArToUse()
    {
        String[] ArToUse = new String[] {};
        switch(title) {
            case "Heavy Lifting" :{
            ArToUse = Heav;
            break;}
            case "Cardio":{
                ArToUse = Card;
                break;}
            case "Stretches" :{
                ArToUse = Stret;
                break;}
            case "Calisthenics" :{
                ArToUse = Cali;
                break;}
        }
        return ArToUse;
    }


    public void spinner(String[] Ex)
    {
        Spinner spin = (Spinner) findViewById(R.id.spinner);
        spin.setOnItemSelectedListener(this);

        //Creating the ArrayAdapter instance having the country list
        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, Ex);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spin.setAdapter(aa);
        setInserts();
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String[] ex = WhatArToUse();
        Toast.makeText(getApplicationContext(), ex[i], Toast.LENGTH_SHORT).show();
        setInserts();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        // Auto-generated method stub
    }

    public void setInserts(){
        Spinner spin = (Spinner) findViewById(R.id.spinner);
        String exer = spin.getSelectedItem().toString();
        if(exer.equals("Running") || exer.equals("Biking")){
            insert2.setHint("distance(km)");
        }
        else if(exer.equals("Swimming") || exer.equals("Rowing")){
            insert2.setHint("distance(m)");
        }
        else if(Arrays.asList(Heav).contains(exer)){
            insert1.setHint("Weight(Kg)");
            insert2.setHint("Reps");
        }
    }

    public void initiateTables() {
            Action.initializeTables();
        }
}
