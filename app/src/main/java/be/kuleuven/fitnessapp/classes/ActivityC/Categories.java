package be.kuleuven.fitnessapp.classes.ActivityC;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;

import be.kuleuven.fitnessapp.R;




public class Categories extends AppCompatActivity {
    private ImageButton Cardio;
    private ImageButton Heavy_lifting;
    private ImageButton Calesthetics;
    private ImageButton Stretches;
    public String type_of_ex = "nothingATM";

    private boolean ButtonCardio;
    private boolean ButtonHeavyLift;
    private boolean ButtonEndurance;
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
        ButtonEndurance = false;
        ButtonStretches = false;
        ButtonHeavyLift = false;

        setContentView(R.layout.activity_categories);
        Cardio = (ImageButton) findViewById(R.id.first_exercise);
        Heavy_lifting = (ImageButton) findViewById(R.id.second_exercise);
        Calesthetics = (ImageButton)findViewById(R.id.third_exercise);
        Stretches = (ImageButton) findViewById(R.id.fifth_exercise);
    }


    public void onExerciseClicked ()
    {
        if (type_of_ex == "cardio")
        {
            final ImageButton Cardio = (ImageButton) findViewById(R.id.first_exercise);
            Cardio.setOnClickListener(new View.OnClickListener() {
                public void onClick(View caller) {
                    Intent cardioChosen = new Intent(Categories.this, exercise.class);
                    cardioChosen.putExtra("title", "Cardio");
                    exercise ex1 = new exercise();
                    ex1.MakeTitle();
                    startActivity(cardioChosen);
                }
            });
        } else if (ButtonHeavyLift) {
            final ImageButton Heavy_lifting = (ImageButton) findViewById(R.id.second_exercise);
        }
        else if (type_of_ex == "heavy_lift")
        {
            final ImageButton Heavy_lifting = (ImageButton) findViewById(R.id.second_exercise);
            Heavy_lifting.setOnClickListener(new View.OnClickListener() {
                public void onClick(View caller) {
                    Intent HeavyChosen = new Intent(Categories.this, exercise.class);
                    startActivity(HeavyChosen);
                    exercise ex1 = new exercise();
                    ex1.MakeTitle();
                    startActivity(HeavyChosen);
                }
            });
        } else if (ButtonCalisthetics) {
            final ImageButton Calisthetics = (ImageButton) findViewById(R.id.third_exercise);
        }
        else if(type_of_ex == "cali")
        {
            final ImageButton Calisthetics = (ImageButton) findViewById(R.id.third_exercise);
            Calisthetics.setOnClickListener(new View.OnClickListener() {
                public void onClick(View caller) {
                    Intent CaliChosen = new Intent(Categories.this, exercise.class);
                    startActivity(CaliChosen);
                    exercise ex1 = new exercise();
                    ex1.MakeTitle();
                    startActivity(CaliChosen);
                }
            });
        }

        else if (type_of_ex == "stret")
        {
            final ImageButton Stretches = (ImageButton) findViewById(R.id.fifth_exercise);
            Stretches.setOnClickListener(new View.OnClickListener() {
                public void onClick(View caller) {
                    Intent StretChosen = new Intent(Categories.this, exercise.class);
                    startActivity(StretChosen);
                    exercise ex1 = new exercise();
                    ex1.MakeTitle();
                    startActivity(StretChosen);
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

    public String getType_of_ex()
    {
        return type_of_ex;
    }
}