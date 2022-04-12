package be.kuleuven.fitnessapp;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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
        setContentView(R.layout.activity_categories);
        Cardio = (Button) findViewById(R.id.first_exercise);
        Heavy_lifting = (Button) findViewById(R.id.second_exercise);
        Calesthetics = (Button)findViewById(R.id.third_exercise);
        Endurance = (Button) findViewById(R.id.fourth_exercise);
        Stretches = (Button) findViewById(R.id.fifth_exercise);
    }

    public void onCardioClicked(View caller){
    Intent intent = new Intent(this, Cardio.class);
    startActivity(intent);
    }
}