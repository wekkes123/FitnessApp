package be.kuleuven.fitnessapp.classes.ActivityC;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import be.kuleuven.fitnessapp.R;
import be.kuleuven.fitnessapp.classes.Models.ExersizeAction;

public class Exercise extends AppCompatActivity {

    public String title;
    public String info;
    public int PR;
    private TextView tv1;
    private Bundle extras;
    private String Username;
    private ExersizeAction Action;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //
        setContentView(R.layout.activity_exercise);
        Bundle extras = getIntent().getExtras();
        title = (String) extras.get(title);
        tv1 = (TextView)findViewById(R.id.title_exercise);
        tv1.setText(title);
        //

        //initiate variables
        extras = getIntent().getExtras();
        this.Username = extras.get("Username").toString();
        Action = new ExersizeAction(Username, title,this, this);
        //initiate tables
        System.out.println("yes");
        initiateTables();
        //

    }

    public void ShowLoadingPopup(){
        //nog maken
    }

    public void StopLoadingPopup(){
        //nog maken
    }

    public void initiateTables(){
        Action.initializeTables();
    }

}