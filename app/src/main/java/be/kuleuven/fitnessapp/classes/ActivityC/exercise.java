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
        tv1 = (TextView) findViewById(R.id.title_exercise);
        tv1.setText((String)getIntent().getExtras().get("title"));
    }


    public void MakeTitle()
    {
        Categories Object1 = new Categories();
        title = Object1.getType_of_ex();

        tv1 = (TextView)findViewById(R.id.title_exercise);
        tv1.setText(title);
    }

    public void MakeInfo()
    {
        if (title == "Cardio")
        {
            info = "";
        }
        else if (title == "Heavy Lifting")
        {
            info = "";
        }
        else if (title == "Calisthetics")
        {
            info = "";
        }
        else if (title == "Endurance")
        {
            info = "";
        }
        else if (title == "Stretches") {
            info = "";
        }
    }

    public void MakePR()
    {
        TextView tv1 = (TextView)findViewById(R.id.PR_exercise);
        tv1.setText(PR);
    }
}