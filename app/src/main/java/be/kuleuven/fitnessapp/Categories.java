package be.kuleuven.fitnessapp;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Bundle;


public class Categories extends AppCompatActivity {
    private Button Cardio;
    private Button Heavy_lifting;
    private Button Endurance;
    private Button Calesthetics;
    private Button Stretches;

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

    public void onCardioClicked(View caller){
    Intent cardioChosen = new Intent(this, Cardio.class);
    startActivity(cardioChosen);
    }

    public void onHeavyLiftingClicked(View caller){
        Intent HeavyLiftChosen = new Intent(this, Heavy_Lifting.class);
        startActivity(HeavyLiftChosen);
    }

    public void onCalistheticsClicked(View caller){
        Intent CaliChosen = new Intent(this, Calisthetics.class);
        startActivity(CaliChosen);
    }

    public void onEnduranceClicked(View caller){
        Intent EndurChosen = new Intent(this, Endurance.class);
        startActivity(EndurChosen);
    }

    public void onStretchesClicked(View caller){
        Intent StretchChosen = new Intent(this, Stretches.class);
        startActivity(StretchChosen);
    }
}