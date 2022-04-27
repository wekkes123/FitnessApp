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
    private String type_of_ex;

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
        Cardio = (Button) findViewById(R.id.first_exercise);
        Heavy_lifting = (Button) findViewById(R.id.second_exercise);
        Calesthetics = (Button)findViewById(R.id.third_exercise);
        Endurance = (Button) findViewById(R.id.fourth_exercise);
        Stretches = (Button) findViewById(R.id.fifth_exercise);
    }



    public void onExerciseClicked (View caller, String type_of_ex)
    {
        Cardio.setOnClickListener(new View.OnClickListener() {
            public void onClick(View caller) {

            }
        });
        if (type_of_ex == "cardio")
        {
            Intent cardioChosen = new Intent(this, Cardio.class);
            startActivity(cardioChosen);
        }

        else if (type_of_ex == "heavy_lift")
        {
            Intent HeavyLiftChosen = new Intent(this, Heavy_Lifting.class);
            startActivity(HeavyLiftChosen);
        }

        else if (type_of_ex == "cali")
        {
            Intent CaliChosen = new Intent(this, Calisthetics.class);
            startActivity(CaliChosen);
        }

        else if (type_of_ex == "endur")
        {
            Intent EndurChosen = new Intent(this, Endurance.class);
            startActivity(EndurChosen);
        }

        else if (type_of_ex == "stret")
        {
            Intent StretchChosen = new Intent(this, Stretches.class);
            startActivity(StretchChosen);
        }

    }

    public String onCardioClicked(){
        type_of_ex = "cardio";
    return type_of_ex;
    }

    public String onHeavyLiftingClicked(){
        type_of_ex = "heavy_lift";
        return type_of_ex;
    }

    public String onCalistheticsClicked(){
        type_of_ex = "cali";
        return type_of_ex;
    }

    public String onEnduranceClicked(){
        type_of_ex = "endu";
        return type_of_ex;
    }

    public String onStretchesClicked(){
        type_of_ex = "stret";
        return type_of_ex;

    }

}