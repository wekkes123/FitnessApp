package be.kuleuven.fitnessapp.classes.ActivityC;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.concurrent.ThreadLocalRandom;

import be.kuleuven.fitnessapp.R;



public class Categories extends AppCompatActivity {

    String[] tip = {"Tip: Always use the full range of motion of your exercise", "Tip: Always look up the correct form of an exercise before you attempt it", "Tip: Try minimizing the use of momentum when lifting any weight", "Tip: Always take 2-3 minute breaks between heavy lifting sets","Tip: Its ok to lower your weights sometimes, not every day can be your best","Tip: For every push exercise of a muscle you should try to have a pull exercise"};

    private ImageButton Cardio;
    private ImageButton Heavy_lifting;
    private ImageButton Calesthetics;
    private ImageButton Stretches;
    private TextView welcomeTxt;
    private TextView tips;
    private Bundle extras;
    public String exercise;

    private String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //zorgt voor fullscreen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //end
        setContentView(R.layout.activity_categories);
        welcomeTxt = (TextView) findViewById(R.id.welcomeTxt);
        this.tips = (TextView) findViewById(R.id.tips);
        extras = getIntent().getExtras();
        welcomeTxt.setText("Hello " + extras.get("Username").toString() + " !");
        Cardio = (ImageButton) findViewById(R.id.first_exercise);
        Heavy_lifting = (ImageButton) findViewById(R.id.second_exercise);
        Calesthetics = (ImageButton)findViewById(R.id.third_exercise);
        Stretches = (ImageButton) findViewById(R.id.fourth_exercise);
        int i = ThreadLocalRandom.current().nextInt(0, tip.length);
        tips.setText(tip[i]);
    }


    public void onExerciseClicked ()
    {
        switch (exercise) {
            case "Cardio" : {
                final ImageButton Cardio = (ImageButton) findViewById(R.id.first_exercise);
                Intent CardIntent = new Intent(this, Exercise.class);
                CardIntent.putExtra(title, "Cardio");
                CardIntent.putExtra("Username", extras.get("Username").toString());
                startActivity(CardIntent);
                break;
            }

            case "HeavyLift" : {
                final ImageButton Heavy_lifting = (ImageButton) findViewById(R.id.second_exercise);
                Intent LiftIntent = new Intent(this, Exercise.class);
                LiftIntent.putExtra(title, "Heavy Lifting");
                LiftIntent.putExtra("Username", extras.get("Username").toString());
                startActivity(LiftIntent);
                break;
            }

            case "Calisthenics" : {
                final ImageButton Calisthenics = (ImageButton) findViewById(R.id.third_exercise);
                Intent CaliIntent = new Intent(this, Exercise.class);
                CaliIntent.putExtra(title, "Calisthenics");
                CaliIntent.putExtra("Username", extras.get("Username").toString());
                startActivity(CaliIntent);
                break;
            }

            case "Stretches" :{
                final ImageButton Stretches = (ImageButton) findViewById(R.id.fourth_exercise);
                Intent StretIntent = new Intent(this, Exercise.class);
                StretIntent.putExtra(title, "Stretches");
                StretIntent.putExtra("Username", extras.get("Username").toString());
                startActivity(StretIntent);
                break;
            }
        }
    }

    public void onCardioClicked(View caller) {
        exercise = "Cardio";
        onExerciseClicked();
    }

    public void onHeavyLiftingClicked(View caller) {
        exercise = "HeavyLift";
        onExerciseClicked();
    }

    public void onCalistheticsClicked(View caller) {
        exercise = "Calisthenics";
        onExerciseClicked();
    }

    public void onStretchesClicked(View caller) {
        exercise = "Stretches";
        onExerciseClicked();
    }

}