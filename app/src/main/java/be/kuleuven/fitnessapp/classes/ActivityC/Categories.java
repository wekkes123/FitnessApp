package be.kuleuven.fitnessapp.classes.ActivityC;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;

import be.kuleuven.fitnessapp.R;

public class Categories extends AppCompatActivity {
    private ImageButton Cardio;
    private ImageButton Heavy_lifting;
    private ImageButton Calesthetics;
    private ImageButton Stretches;

    private boolean ButtonCardio;
    private boolean ButtonHeavyLift;
    private boolean ButtonCalisthetics;
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
        ButtonCalisthetics = false;
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
            LiftIntent.putExtra(title, "Cardio");
            startActivity(LiftIntent);

        }

        else if(ButtonCalisthetics)
        {
            final ImageButton Calisthetics = (ImageButton) findViewById(R.id.third_exercise);
            Intent CaliIntent = new Intent(this, exercise.class);
            CaliIntent.putExtra(title, "Cardio");
            startActivity(CaliIntent);
        }

        else if (ButtonStretches) {
            final ImageButton Stretches = (ImageButton) findViewById(R.id.fourth_exercise);
            Intent StretIntent = new Intent(this, exercise.class);
            StretIntent.putExtra(title, "Cardio");
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
        ButtonCalisthetics = true;
        onExerciseClicked();
    }

    public void onStretchesClicked(View caller) {
        ButtonStretches = true;
        onExerciseClicked();
    }

}