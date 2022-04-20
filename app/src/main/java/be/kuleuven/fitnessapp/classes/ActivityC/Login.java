package be.kuleuven.fitnessapp.classes.ActivityC;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;

import be.kuleuven.fitnessapp.R;

public class Login extends AppCompatActivity {

    private TextView LoginText;
    private Button LoginButton;
    private Button SignUpButton;

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
        SignUpButton = (Button) findViewById(R.id.SignUpButton);
    }

    public void onSignUpButtonClicked(View caller){
        Intent signup = new Intent(this, SignUpScreen.class);
        startActivity(signup);
    }

    public void onLoginButtonClicked(View caller){
        encryptPassword("yo");
    }

    public void onDebugClicked(View caller){
        Intent debug = new Intent(this, Categories.class);
        startActivity(debug);
    }

    public String encryptPassword(String pw){
        String sha256hex = Hashing.sha256().hashString(pw, StandardCharsets.UTF_8).toString();
        System.out.println(sha256hex);
        return sha256hex;
    }


}