package be.kuleuven.fitnessapp.classes.Models;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;

import be.kuleuven.fitnessapp.classes.ActivityC.Login;

public class LoginAction {
    private String Username;
    private String Password;
    private RequestQueue requestqueue;


    public LoginAction(String username, String password){
        Username = username;
        Password = encryptPassword(password);
    }

    public String encryptPassword(String pw){
        String sha256hex = Hashing.sha256().hashString(pw, StandardCharsets.UTF_8).toString();
        System.out.println(sha256hex);
        return sha256hex;
    }

    public boolean checkLoginInfo(){
        return false;
    }






}
