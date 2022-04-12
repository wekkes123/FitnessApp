package be.kuleuven.fitnessapp;

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

    }
}