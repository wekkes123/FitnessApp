package be.kuleuven.fitnessapp.classes.ActivityC;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;

import be.kuleuven.fitnessapp.R;



public class Categories extends AppCompatActivity {
    private ImageButton Cardio;
    private ImageButton Heavy_lifting;
    private ImageButton Calesthetics;
    private ImageButton Stretches;
    private TextView welcomeTxt;

    private boolean ButtonCardio;
    private boolean ButtonHeavyLift;
    private boolean ButtonCalisthenics;
    private boolean ButtonStretches;


    public String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //zorgt voor fullscreen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //end
        welcomeTxt = (TextView) findViewById(R.id.welcomeTxt);
        ButtonCalisthenics = false;
        ButtonCardio = false;
        ButtonStretches = false;
        ButtonHeavyLift = false;

        setContentView(R.layout.activity_categories);
        Cardio = (ImageButton) findViewById(R.id.first_exercise);
        Heavy_lifting = (ImageButton) findViewById(R.id.second_exercise);
        Calesthetics = (ImageButton)findViewById(R.id.third_exercise);
        Stretches = (ImageButton) findViewById(R.id.fourth_exercise);
    }


    public void onExerciseClicked ()
    {
        if (ButtonCardio) {
            final ImageButton Cardio = (ImageButton) findViewById(R.id.first_exercise);
            Intent CardIntent = new Intent(this, exercise.class);
            CardIntent.putExtra(title, "Cardio");
            startActivity(CardIntent);
        }

        else if (ButtonHeavyLift) {
            final ImageButton Heavy_lifting = (ImageButton) findViewById(R.id.second_exercise);
            Intent LiftIntent = new Intent(this, exercise.class);
            LiftIntent.putExtra(title, "Heavy Lifting");
            startActivity(LiftIntent);

        }

        else if(ButtonCalisthenics)
        {
            final ImageButton Calisthenics = (ImageButton) findViewById(R.id.third_exercise);
            Intent CaliIntent = new Intent(this, exercise.class);
            CaliIntent.putExtra(title, "Calisthenics");
            startActivity(CaliIntent);
        }

        else if (ButtonStretches) {
            final ImageButton Stretches = (ImageButton) findViewById(R.id.fourth_exercise);
            Intent StretIntent = new Intent(this, exercise.class);
            StretIntent.putExtra(title, "Stretches");
            startActivity(StretIntent);
        }
    }

    public void onCardioClicked(View caller) {
        ButtonCardio = true;
        onExerciseClicked();
    }

    public void onHeavyLiftingClicked(View caller) {
        ButtonHeavyLift = true;
        onExerciseClicked();
    }

    public void onCalistheticsClicked(View caller) {
        ButtonCalisthenics = true;
        onExerciseClicked();
    }

    public void onStretchesClicked(View caller) {
        ButtonStretches = true;
        onExerciseClicked();
    }

}