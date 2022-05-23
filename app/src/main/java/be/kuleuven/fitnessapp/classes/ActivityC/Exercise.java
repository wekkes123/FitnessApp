package be.kuleuven.fitnessapp.classes.ActivityC;

import androidx.appcompat.app.AppCompatActivity;

import android.icu.text.CaseMap;
import android.os.Bundle;
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
import java.util.Arrays;

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
    private TextView uitleg;
    private TextView strechText;
    private Bundle extras;
    private String Username;
    private ExersizeAction Action;
    private EditText insert1;
    private EditText insert2;
    private EditText linkText;
    private String ID;
    private String exercise;
    private Button update;
    private ImageView showcase;
    private String weight;
    private ImageView showcase2;

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
    this.linkText = (EditText) findViewById(R.id.linkText);
    this.uitleg = (TextView) findViewById(R.id.uitleg);
    this.titleText = (TextView) findViewById(R.id.Title);
    this.strechText = (TextView) findViewById(R.id.strechText);
    this.update = (Button) findViewById(R.id.button2);
    this.showcase = (ImageView) findViewById(R.id.showcase);
    this.showcase2 = (ImageView) findViewById(R.id.showcase2);
    //Als dit hier niet staat dan kan de app crashen bij het initalizeren van de cardio tables omdat de variable niet snel genoeg
    //wordt aangemaak door dit hier early te zetten gebeurt dit nooit
    exercise = "Running";
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

    public void spinner(String[] Ex)
    {
        Spinner spin = (Spinner) findViewById(R.id.spinner);
        spin.setOnItemSelectedListener(this);

        //Creating the ArrayAdapter instance having the country list
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
        // Auto-generated method stub
    }

    public void setInserts(){
        uitleg.setText("Add your favorite " + title + " playlist");
        Spinner spin = (Spinner) findViewById(R.id.spinner);
        String exer = spin.getSelectedItem().toString();
        if(exer.equals("Running") || exer.equals("Biking")){
            showcase2.setImageResource(R.drawable.spotify_logo_without_text);
            Action.initializeTables();
            insert2.setHint("distance(km)");
        }
        else if(exer.equals("Swimming") || exer.equals("Rowing")){
            showcase2.setImageResource(R.drawable.spotify_logo_without_text);
            Action.initializeTables();
            insert2.setHint("distance(m)");
        }
        else if(Arrays.asList(Heav).contains(exer)){
            showcase2.setImageResource(R.drawable.spotify_logo_without_text);
            Action.initializeTables();
            insert1.setHint("Weight(Kg)");
            insert2.setHint("Reps");
        }
        else if(Arrays.asList(Cali).contains(exer)){
            showcase2.setImageResource(R.drawable.spotify_logo_without_text);
            Action.initializeTables();
            insert2.setHint("Reps");
        }
        else if(title.equals("Stretches")){
            titleText.setText(exer);
            uitleg.setVisibility(View.INVISIBLE);
            linkText.setVisibility(View.INVISIBLE);
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
                    tv1 = (TextView) findViewById(repID);
                    reps = tv1.getText().toString();
                    try{
                        amount = Integer.parseInt(reps);
                    }
                    catch (NumberFormatException ex){}
                }
            }
        }
        return amount;
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
            tv1 = (TextView) findViewById(R.id.two_two);
            String CurrentReps = tv1.getText().toString();
            try{
                km2 = Integer.parseInt(CurrentReps);
            }

            catch (NumberFormatException ex){ System.out.println("km2 error");
            }
            int newKm = km + km2;
            if(newKm<0){newKm = 0;};
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
            catch (NumberFormatException ex){}
            int newReps = getReps(insert1.getText().toString()) + w2;
            Action.setReps(new ExersizeAction.ECallback2() {
                @Override
                public void onSucces() {}
            }, exer,insert1.getText().toString(), newReps);

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
            Action.setExactReps(new ExersizeAction.ECallback2() {
                @Override
                public void onSucces() {
                    Action.initializeTables();
                }
            }, exer,"reps", newKm);
        }
    }

    public String getID(int row, int column) {
        ID = StringNumbers[IntNumbers[row]] + "_" + StringNumbers[IntNumbers[column]];
        return ID;
    }

    public void FillTables(JSONArray resp){
        try {
            JSONObject RespObj = resp.getJSONObject(0);switch (title) {
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
                int standardWeight = 20;
                tv1 = (TextView) findViewById(R.id.one_one);
                tv1.setText("Weight");
                tv1 = (TextView) findViewById(R.id.one_two);
                tv1.setText("Reps");

                for(int i = 2 ; i <=18 ; i++) {
                    String name = getID(i, 1);
                    int id = getResources().getIdentifier(name, "id", this.getPackageName());
                    if (id != 0) {
                        tv1 = (TextView) findViewById(id);
                        tv1.setText(Integer.toString(standardWeight));
                    }
                    standardWeight += 5;
                }

                for(int j = 2 ; j <=18 ; j++) {
                    String reps = RespObj.getString("Reps");
                        String Reps = getID(j, 2);
                        int Theid = getResources().getIdentifier(Reps, "id", this.getPackageName());
                        if (Theid != 0) {
                            tv1 = (TextView) findViewById(Theid);
                            tv1.setText(reps);
                        }
                    }
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
        } catch (JSONException e) {System.out.println("56456456546546");}

    }

}

