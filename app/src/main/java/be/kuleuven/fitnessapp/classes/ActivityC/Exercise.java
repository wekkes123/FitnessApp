package be.kuleuven.fitnessapp.classes.ActivityC;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Person;
import android.content.Context;
import android.content.Intent;
import android.icu.text.CaseMap;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.IntStream;

import be.kuleuven.fitnessapp.R;
import be.kuleuven.fitnessapp.classes.Models.ExersizeAction;



public class Exercise extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener {
    String[] Card = {"Running", "Swimming", "Biking", "Rowing"};
    String[] Heav = {"Bench", "Squad", "Deadlift"};
    String[] Cali = {"Pushups", "Pullups", "Planking","Muscle up", "Handstand Push-Ups","Box Jumps", "1 Legged Squads"};
    String[] Stret = {"Why strech?","Lower back", "Triceps","Biceps","Shoulders","Hamstrings","Quads and Glutes"};
    String[] StringNumbers = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen", "twenty"};
    int[] IntNumbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};

    public String title;
    private TextView tv1;
    private TextView titleText;
    private TextView strechText;
    private String Username;
    private ExersizeAction Action;
    private EditText insert1;
    private EditText insert2;
    private String ID;
    private String exercise;
    private Button update;
    private ImageView showcase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    //zorgt voor fullscreen
    requestWindowFeature(Window.FEATURE_NO_TITLE);
    getSupportActionBar().hide();
    this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
    WindowManager.LayoutParams.FLAG_FULLSCREEN);
    //end
    setContentView(R.layout.activity_exercise);
    Bundle extras = getIntent().getExtras();
    title = (String) extras.get(title);
    tv1 = (TextView) findViewById(R.id.title_exercise);
    tv1.setText(title);
    this.insert1 = (EditText) findViewById(R.id.insert1);
    this.insert2 = (EditText) findViewById(R.id.insert2);
    this.titleText = (TextView) findViewById(R.id.Title);
    this.strechText = (TextView) findViewById(R.id.strechText);
    this.update = (Button) findViewById(R.id.button2);
    this.showcase = (ImageView) findViewById(R.id.showcase);
    exercise = "Running";
    //
    //initiate variables
    extras = getIntent().getExtras();
    this.Username = extras.get("Username").toString();
    Action = new ExersizeAction(Username, title, this,this);
    //initiate tables
    // set spinner
    spinner(WhatArToUse());
    }

    public String getEX(){
        return exercise;
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

    public void onGoBackClicked(View view){
        Intent Cat = new Intent(this, Categories.class);
        startActivity(Cat);

    }

    public void spinner(String[] Ex)
    {
        Spinner spin = (Spinner) findViewById(R.id.spinner);
        spin.setOnItemSelectedListener(this);

        //Creating the ArrayAdapter instance having the list
        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, Ex);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spin.setAdapter(aa);
        //setInserts();
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String[] ex = WhatArToUse();
        Toast.makeText(getApplicationContext(), ex[i], Toast.LENGTH_SHORT).show();
        exercise = ex[i];
        setInserts();
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public void setInserts(){
        Spinner spin = (Spinner) findViewById(R.id.spinner);
        String exer = spin.getSelectedItem().toString();
        if(exer.equals("Running") || exer.equals("Biking")){
            Action.initializeTables();
            insert1.setVisibility(View.INVISIBLE);
            insert2.setHint("Add km's");
        }
        else if(exer.equals("Swimming") || exer.equals("Rowing")){
            insert1.setVisibility(View.INVISIBLE);
            Action.initializeTables();
            insert2.setHint("Add m's");
        }
        else if(Arrays.asList(Heav).contains(exer)){
            Action.initializeTables();
            insert1.setHint("Add Weight");
            insert2.setHint("Add Reps");
        }
        else if(Arrays.asList(Cali).contains(exer)){
            insert1.setVisibility(View.INVISIBLE);
            Action.initializeTables();
            insert2.setHint("Add Reps");
        }
        else if(title.equals("Stretches")){
            titleText.setText(exer);
            insert1.setVisibility(View.INVISIBLE);
            insert2.setVisibility(View.INVISIBLE);
            update.setVisibility(View.INVISIBLE);
            switch(exer){
                case "Why strech?":{
                    strechText.setText(getResources().getString(R.string.Strech3));
                    break;
                }
                case "Hamstrings":{
                    strechText.setText(getResources().getString(R.string.Strech1));
                    showcase.setImageResource(R.drawable.hamstrings);
                    break;
                }
                case "Lower back":{
                    strechText.setText(getResources().getString(R.string.Strech2));
                    showcase.setImageResource(R.drawable.lower_back);
                    break;
                }
                case "Triceps":{
                    strechText.setText(getResources().getString(R.string.Strech4));
                    showcase.setImageResource(R.drawable.triceps);
                    break;
                }
                case "Biceps":{
                    strechText.setText(getResources().getString(R.string.Strech6));
                    showcase.setImageResource(R.drawable.biceps);
                    break;
                }
                case "Shoulders":{
                    strechText.setText(getResources().getString(R.string.Strech5));
                    showcase.setImageResource(R.drawable.shoulders);
                    break;
                }
                case "Quads and Glutes":{
                    strechText.setText(getResources().getString(R.string.Strech7));
                    showcase.setImageResource(R.drawable.quads_and_glutes);
                    break;
                }
            }
        }
    }

    public int getReps(String weight) {
        String reps = "";
        int amount = 0;
        for(int i = 2 ; i <=20 ; i++) {
            String WeightIdName = getID(i, 1);
            int Weightid = getResources().getIdentifier(WeightIdName, "id", this.getPackageName());
            if (Weightid != 0) {
                tv1 = (TextView) findViewById(Weightid);
                if (tv1.getText().toString().equals(weight)){
                    String nameRep = getID(i, 2);
                    int repID = getResources().getIdentifier(nameRep, "id", this.getPackageName());
                    if(repID !=0){
                        tv1 = (TextView) findViewById(repID);
                        reps = tv1.getText().toString();
                        try{amount = Integer.parseInt(reps);}
                        catch (NumberFormatException ex){}
                    }

                }
            }
        }
        return amount;
    }


    public void onUpdateButtonClicked(View caller) {
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        v.vibrate(50);
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
            tv1 = (TextView) findViewById(R.id.two_two);
            String CurrentReps = tv1.getText().toString();
            try{
                km2 = Integer.parseInt(CurrentReps);
            }

            catch (NumberFormatException ex){ System.out.println("km2 error");
            }
            int newKm = km + km2;
            if(newKm<0){newKm = 0;};
            Action.setExactReps(() -> Action.initializeTables(), exer,"Total_km", newKm);
        }


        else if (Arrays.asList(Heav).contains(exer)) {
            int w2 = 0;
            try{
                w2 = Integer.parseInt(insert2.getText().toString());
            }
            catch (NumberFormatException ex){}
            int newReps = getReps(insert1.getText().toString()) + w2;
            Action.setReps(() -> Action.initializeTables(), exer,insert1.getText().toString(), newReps);

        }
        else if (Arrays.asList(Cali).contains(exer)) {
            int rep = 0;
            int rep2 = 0;
            try{
                rep = Integer.parseInt(insert2.getText().toString());
            }
            catch (NumberFormatException ex){
            }
            tv1 = (TextView) findViewById(R.id.two_two);
            String CurrentReps = tv1.getText().toString();
            try{
                rep2 = Integer.parseInt(CurrentReps);
            }

            catch (NumberFormatException ex){ System.out.println("rep2 error");
            }
            int newKm = rep + rep2;
            if(newKm<0){newKm = 0;};
            Action.setExactReps(() -> Action.initializeTables(), exer,"reps", newKm);
        }
    }



    public String getID(int row, int column) {
        ID = StringNumbers[IntNumbers[row]] + "_" + StringNumbers[IntNumbers[column]];
        return ID;
    }

    public void FillTables(JSONArray response){
        try {
            JSONObject RespObj = response.getJSONObject(0);
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

            
            case "Heavy Lifting": {
                    int standardWeight = 20;
                    tv1 = (TextView) findViewById(R.id.one_one);
                    tv1.setText("Weight(kg)");
                    tv1 = (TextView) findViewById(R.id.one_two);
                    tv1.setText("Reps");

              for (int i = 2; i <= 18; i++) {
                        String name = getID(i, 1);
                        int id = getResources().getIdentifier(name, "id", this.getPackageName());
                        if (id != 0) {
                            TextView test = (TextView) findViewById(id);
                            test.setText(Integer.toString(standardWeight));
                        }
                        standardWeight += 5;
                    }
                    try {
                        for (int i = 1; i <= response.length(); i++) {
                            if(i == response.length()){
                                i=0;
                            }
                            JSONObject curObject = response.getJSONObject(i);
                            String reps = curObject.getString("Reps");
                            if(i == 0){
                                i=response.length();
                            }
                            String Repsid = getID(i+1, 2);
                            int Theid = getResources().getIdentifier(Repsid, "id", this.getPackageName());
                            if (Theid != 0) {
                                tv1 = (TextView) findViewById(Theid);
                                tv1.setText(reps);
                            }

                        }
                    } catch (JSONException e) {}
                    break;
                }
            case "Calisthenics":{
                tv1 = (TextView) findViewById(R.id.two_one);
                tv1.setText("Total reps");
                tv1 = (TextView) findViewById(R.id.two_two);
                tv1.setText(RespObj.getString("Reps"));
                break;
            }

        }
        } catch (JSONException e) {System.out.println("error e");}

    }
}

