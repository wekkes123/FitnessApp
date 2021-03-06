package be.kuleuven.fitnessapp.classes.ActivityC;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;

import be.kuleuven.fitnessapp.R;
import be.kuleuven.fitnessapp.classes.Models.LoginAction;

public class Login extends AppCompatActivity {

    private TextView LoginText;
    private EditText Username;
    private EditText Password;
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
        LoginButton = (Button) findViewById(R.id.LoginButton);
        Username = (EditText) findViewById(R.id.LoginUsername);
        Password = (EditText) findViewById(R.id.LoginPassword);

    }

    public void onSignUpButtonClicked(View caller){
        Intent signup = new Intent(this, SignUpScreen.class);
        startActivity(signup);
    }

    public void onLoginButtonClicked(View caller){
        LoginAction logindata = new LoginAction(Username.getText().toString(), Password.getText().toString(), this);
        logindata.requestLogin(new LoginAction.LoginCallBack() {
            @Override
            public void onSucces() {
                LoginSuccesfull();
            }

            @Override
            public void onFail() {
                TextView tv5 = (TextView) findViewById(R.id.textView9);
                tv5.setVisibility(View.VISIBLE);
            }
        });
    }


    public void LoginSuccesfull(){
        Intent intent = new Intent(this, Categories.class);
        if(Username.getText().toString() != null) {
            intent.putExtra("Username", Username.getText().toString());
        }
        startActivity(intent);
    }

    public void onDebugClicked(View caller){
        Username.setText("Wout");
        Password.setText("123");
        LoginSuccesfull();
    }

}