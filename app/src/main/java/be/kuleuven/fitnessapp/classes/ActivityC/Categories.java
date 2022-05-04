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
    private Button Endurance;
    private ImageButton Calesthetics;
    private ImageButton Stretches;
    public String type_of_ex = "nothingATM";


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
        Cardio = (ImageButton) findViewById(R.id.first_exercise);
        Heavy_lifting = (ImageButton) findViewById(R.id.second_exercise);
        Calesthetics = (ImageButton)findViewById(R.id.third_exercise);
        //Endurance = (Button) findViewById(R.id.fourth_exercise);
        Stretches = (ImageButton) findViewById(R.id.fifth_exercise);
    }


    public void onExerciseClicked (String type_of_ex)
    {
        if (type_of_ex == "cardio")
        {
            final ImageButton Cardio = (ImageButton) findViewById(R.id.first_exercise);
            Cardio.setOnClickListener(new View.OnClickListener() {
                public void onClick(View caller) {
                    Intent cardioChosen = new Intent( Categories.this, exercise.class);
                    exercise ex1 = new exercise();
                    ex1.MakeTitle();
                    startActivity(cardioChosen);
                }
            });
        }
        else if (type_of_ex == "heavy_lift")
        {
            final ImageButton Heavy_lifting = (ImageButton) findViewById(R.id.second_exercise);
            Heavy_lifting.setOnClickListener(new View.OnClickListener() {
                public void onClick(View caller) {
                    Intent HeavyChosen = new Intent( Categories.this, exercise.class);
                    exercise ex1 = new exercise();
                    ex1.MakeTitle();
                    startActivity(HeavyChosen);
                }
            });
        }
        else if(type_of_ex == "cali")
        {
            final ImageButton Calisthetics = (ImageButton) findViewById(R.id.third_exercise);
            Calisthetics.setOnClickListener(new View.OnClickListener() {
                public void onClick(View caller) {
                    Intent CaliChosen = new Intent( Categories.this, exercise.class);
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
                    Intent StretChosen = new Intent( Categories.this, exercise.class);
                    exercise ex1 = new exercise();
                    ex1.MakeTitle();
                    startActivity(StretChosen);
                }
            });
        }
    }

    public void onCardioClicked(View caller){
        type_of_ex = "cardio";
        onExerciseClicked(type_of_ex);
    }

    public void onHeavyLiftingClicked(){
        type_of_ex = "heavy_lift";
        onExerciseClicked(type_of_ex);
    }

    public void onCalistheticsClicked(){
        type_of_ex = "cali";
        onExerciseClicked(type_of_ex);
    }

    public void onEnduranceClicked(){
        type_of_ex = "endur";
        onExerciseClicked(type_of_ex);
    }

    public void onStretchesClicked(){
        type_of_ex = "stret";
        onExerciseClicked(type_of_ex);
    }

    public String getType_of_ex()
    {
        return type_of_ex;
    }
}