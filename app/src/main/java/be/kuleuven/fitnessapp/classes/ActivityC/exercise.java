package be.kuleuven.fitnessapp.classes.ActivityC;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import be.kuleuven.fitnessapp.R;

public class exercise extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);
    }
    public String title;
    public String info;
    public int PR;




    public String getInfo()
    {

        return info;
    }

    public int getPR()
    {
        return PR;
    }
}