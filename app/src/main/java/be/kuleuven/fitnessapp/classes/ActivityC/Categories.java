package be.kuleuven.fitnessapp.classes.ActivityC;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import be.kuleuven.fitnessapp.R;


public class Categories extends AppCompatActivity {
    private Button Cardio;
    private Button Heavy_lifting;
    private Button Endurance;
    private Button Calesthetics;
    private Button Stretches;

    private boolean ButtonCardio;
    private boolean ButtonHeavyLift;
    private boolean ButtonEndurance;
    private boolean ButtonCalisthetics;
    private boolean ButtonStretches;

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
        ButtonEndurance = false;
        ButtonStretches = false;
        ButtonHeavyLift = false;
        setContentView(R.layout.activity_categories);
        Cardio = (Button) findViewById(R.id.first_exercise);
        Heavy_lifting = (Button) findViewById(R.id.second_exercise);
        Calesthetics = (Button) findViewById(R.id.third_exercise);
        Endurance = (Button) findViewById(R.id.fourth_exercise);
        Stretches = (Button) findViewById(R.id.fifth_exercise);
    }


    public void onExerciseClicked() {
        if (ButtonCardio) {
            final Button Cardio = (Button) findViewById(R.id.first_exercise);
            Cardio.setOnClickListener(new View.OnClickListener() {
                public void onClick(View caller) {
                    Intent cardioChosen = new Intent(Categories.this, exercise.class);
                    exercise ex1 = new exercise();
                    ex1.MakeTitle();
                    startActivity(cardioChosen);
                }
            });
        } else if (ButtonHeavyLift) {
            final Button Heavy_lifting = (Button) findViewById(R.id.second_exercise);
            Heavy_lifting.setOnClickListener(new View.OnClickListener() {
                public void onClick(View caller) {
                    Intent HeavyChosen = new Intent(Categories.this, exercise.class);
                    startActivity(HeavyChosen);
                    exercise ex1 = new exercise();
                    ex1.MakeTitle();
                }
            });
        } else if (ButtonCalisthetics) {
            final Button Calisthetics = (Button) findViewById(R.id.third_exercise);
            Calisthetics.setOnClickListener(new View.OnClickListener() {
                public void onClick(View caller) {
                    Intent CaliChosen = new Intent(Categories.this, exercise.class);
                    startActivity(CaliChosen);
                    exercise ex1 = new exercise();
                    ex1.MakeTitle();
                }
            });
        } else if (ButtonEndurance) {
            final Button Endurance = (Button) findViewById(R.id.fourth_exercise);
            Endurance.setOnClickListener(new View.OnClickListener() {
                public void onClick(View caller) {
                    Intent EndurChosen = new Intent(Categories.this, exercise.class);
                    startActivity(EndurChosen);
                    exercise ex1 = new exercise();
                    ex1.MakeTitle();
                }
            });
        } else if (ButtonStretches) {
            final Button Stretches = (Button) findViewById(R.id.fifth_exercise);
            Stretches.setOnClickListener(new View.OnClickListener() {
                public void onClick(View caller) {
                    Intent StretChosen = new Intent(Categories.this, exercise.class);
                    startActivity(StretChosen);
                    exercise ex1 = new exercise();
                    ex1.MakeTitle();
                }
            });
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

    public void onEnduranceClicked(View caller) {
        ButtonEndurance = true;
        onExerciseClicked();
    }

    public void onStretchesClicked(View caller) {
        ButtonStretches = true;
        onExerciseClicked();
    }

}