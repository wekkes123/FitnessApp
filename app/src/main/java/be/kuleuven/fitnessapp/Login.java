package be.kuleuven.fitnessapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    private TextView LoginText;
    private Button LoginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //zorgt voor fullscreen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //end
        setContentView(R.layout.activity_main);
    }


    public void onDebugClicked(View caller){
        Intent debug = new Intent(this, Categories.class);
        startActivity(debug);
    }
}