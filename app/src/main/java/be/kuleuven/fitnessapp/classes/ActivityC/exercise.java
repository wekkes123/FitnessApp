package be.kuleuven.fitnessapp.classes.ActivityC;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import be.kuleuven.fitnessapp.R;

public class exercise extends AppCompatActivity {

    public String title;
    public String info;
    public int PR;
    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);

        Bundle extras = getIntent().getExtras();
        title = (String) extras.get(title);

        tv1 = (TextView)findViewById(R.id.title_exercise);
        tv1.setText(title);
    }

}