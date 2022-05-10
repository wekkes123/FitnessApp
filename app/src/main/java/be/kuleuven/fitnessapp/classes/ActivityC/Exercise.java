package be.kuleuven.fitnessapp.classes.ActivityC;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;

import be.kuleuven.fitnessapp.R;
import be.kuleuven.fitnessapp.classes.Models.ExersizeAction;

public class Exercise extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener {

    String[] Card = {"Running" , "Swimming", "Biking", "Rowing"};
    String[] Heav = {"Bench", "Squad" , "Deadlift"};
    String[] Cali = {"pushups" , "pullups"};
    String[] Stret ={"back", "triceps", "biceps"};


    public String title;
    private TextView tv1;
    private Bundle extras;
    private String Username;
    private ExersizeAction Action;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //
        setContentView(R.layout.activity_exercise);
        Bundle extras = getIntent().getExtras();
        title = (String) extras.get(title);
        tv1 = (TextView) findViewById(R.id.title_exercise);
        tv1.setText(title);
        //

        //initiate variables
        extras = getIntent().getExtras();
        this.Username = extras.get("Username").toString();
        Action = new ExersizeAction(Username, title,this, this);
        //initiate tables
        System.out.println("yes");
        initiateTables();
        //
    System.out.println(title);
       spinner(WhatArToUse());

    }

    public String[] WhatArToUse()
    {
        String[] ArToUse = new String[] {};
        if (title == "Heavy Lifting")
           ArToUse = Heav;
        else if (title == "Cardio")
            ArToUse = Card;
        else if (title == "Stretches")
           ArToUse = Stret;
        else if (title == "Calisthenics")
            ArToUse = Cali;

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

    }
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(getApplicationContext(), Card[i], Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        // TODO Auto-generated method stub
    }

    public void ShowLoadingPopup(){
        //nog maken
    }

    public void StopLoadingPopup(){
        //nog maken
    }

    public void initiateTables(){
        Action.initializeTables();
    }

}
