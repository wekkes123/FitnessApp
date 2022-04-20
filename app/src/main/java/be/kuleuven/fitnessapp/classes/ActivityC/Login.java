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
        //nog niet klaar
        requestLogin();
        LoginAction logindata = new LoginAction(Username.getText().toString(), Password.getText().toString());
        if(logindata.checkLoginInfo()){
            Intent intent = new Intent(this, Categories.class);
            startActivity(intent);
        }
        else{

        }

    }

    public void onDebugClicked(View caller){
        Intent debug = new Intent(this, Categories.class);
        startActivity(debug);
    }

    public void requestLogin(){
        RequestQueue requestqueue = Volley.newRequestQueue(this);
        String requestURL = "https://studev.groept.be/api/a21pt213/SelectAll";

        StringRequest submitRequest = new StringRequest(Request.Method.GET, requestURL,

                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        System.out.print(response);
                    }
                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        System.out.print("error");
                    }
                }
        );

        requestqueue.add(submitRequest);
    }

}