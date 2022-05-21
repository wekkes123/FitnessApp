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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.Arrays;

import be.kuleuven.fitnessapp.R;
import be.kuleuven.fitnessapp.classes.Models.ExersizeAction;


public class Exercise extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener {

    String[] Card = {"Running", "Swimming", "Biking", "Rowing"};
    String[] Heav = {"Bench", "Squad", "Deadlift"};
    String[] Cali = {"pushups", "pullups"};
    String[] Stret = {"back", "triceps"};
    String[] StringNumbers = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen", "twenty"};
    int[] IntNumbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};



    public String title;
    private TextView tv1;
    private Bundle extras;
    private String Username;
    private ExersizeAction Action;
    private EditText insert1;
    private EditText insert2;
    private String ID;
    private String exercise;

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
    Action.initializeTables();
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
        Action.initializeTables();
        exercise = ex[i];
    }

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

    public int getReps(String weight){
        try{
            int gewicht = Integer.parseInt(weight);
        }

        catch (NumberFormatException ex){
            return 0;
        }
        return 0;
    }

    public void onUpdateButtonClicked(View caller) {
        Spinner spin = (Spinner) findViewById(R.id.spinner);
        String exer = spin.getSelectedItem().toString();
        if (insert2.getText().toString().equals(null)) {
            return;
        }


        if (Arrays.asList(Card).contains(exer)) {
            int km = 0;
            int km2 = 0;
            try{
                km = Integer.parseInt(insert2.getText().toString());
            }
            catch (NumberFormatException ex){
            }
            tv1 = (TextView) findViewById(R.id.one_two);
            String CurrentReps = tv1.getText().toString();
            try{
                km2 = Integer.parseInt(CurrentReps);
            }

            catch (NumberFormatException ex){
            }
            int newKm = km + km2;
            Action.setExactReps(new ExersizeAction.ECallback2() {
                @Override
                public void onSucces() {
                    Action.initializeTables();
                }
            }, exer,"Total_km", newKm);
        }


        else if (Arrays.asList(Heav).contains(exer)) {
            int w2 = 0;
            try{
                w2 = Integer.parseInt(insert2.getText().toString());
            }

            catch (NumberFormatException ex){
            }
            int newReps = getReps(insert1.getText().toString()) + w2;
            Action.setExactReps(new ExersizeAction.ECallback2() {
                @Override
                public void onSucces() {

                }
            }, exer,insert1.getText().toString(), newReps);

        }
    }

    public String getID(int row, int column) {
        ID = StringNumbers[IntNumbers[row]] + "_" + StringNumbers[IntNumbers[column]];
        return ID;
    }

    public void FillTables(JSONArray resp){
        try {
            JSONObject RespObj = resp.getJSONObject(0);

        switch (title) {
            case "Cardio":{
                tv1 = (TextView) findViewById(R.id.two_one);
                tv1.setText("Total distance(km)");
                if(exercise.equals("Swimming") || exercise.equals("Rowing")){
                    tv1.setText("Total distance(m)"); }
                tv1 = (TextView) findViewById(R.id.two_two);
                tv1.setText(RespObj.getString("Reps"));
                break;
            }
            case "Heavy Lifting":{
                String reps = RespObj.getString("Reps");
                tv1 = (TextView) findViewById(R.id.two_one);
                tv1.setText("30");
                tv1 = (TextView) findViewById(R.id.three_one);
                tv1.setText("35");
                tv1 = (TextView) findViewById(R.id.four_one);
                tv1.setText("40");
                tv1 = (TextView) findViewById(R.id.five_one);
                tv1.setText("45");
                tv1 = (TextView) findViewById(R.id.six_one);
                tv1.setText("50");
                tv1 = (TextView) findViewById(R.id.seven_one);
                tv1.setText("55");
                tv1 = (TextView) findViewById(R.id.eight_one);
                tv1.setText("60");
                tv1 = (TextView) findViewById(R.id.ten_one);
                tv1.setText("65");
                tv1 = (TextView) findViewById(R.id.eleven_one);
                tv1.setText("70");
                tv1 = (TextView) findViewById(R.id.twelve_one);
                tv1.setText("75");
                tv1 = (TextView) findViewById(R.id.thirtheen_one);
                tv1.setText("80");
                tv1 = (TextView) findViewById(R.id.fourtheen_one);
                tv1.setText("85");
                tv1 = (TextView) findViewById(R.id.fiftheen_one);
                tv1.setText("90");
                tv1 = (TextView) findViewById(R.id.sixteen_one);
                tv1.setText("95");
                tv1 = (TextView) findViewById(R.id.seventeen_one);
                tv1.setText("100");
                tv1 = (TextView) findViewById(R.id.eighteen_one);
                tv1.setText("105");
                tv1 = (TextView) findViewById(R.id.nineteen_one);
                tv1.setText("110");

                
                break;
            }
            case "Calisthenics":{

                tv1 = (TextView) findViewById(R.id.one_one);
                tv1.setText("total");
                tv1 = (TextView) findViewById(R.id.one_two);
                tv1.setText("amount");
                break;
            }
        }
        } catch (JSONException e) {}

    }

}

