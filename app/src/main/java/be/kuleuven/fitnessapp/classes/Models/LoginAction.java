package be.kuleuven.fitnessapp.classes.Models;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;

public class LoginAction {
    private String Username;
    private String Password;


    public LoginAction(String username, String password){
        Username = username;
        Password = encryptPassword(password);
    }

    public String encryptPassword(String pw){
        String sha256hex = Hashing.sha256().hashString(pw, StandardCharsets.UTF_8).toString();
        System.out.println(sha256hex);
        return sha256hex;
    }





}
