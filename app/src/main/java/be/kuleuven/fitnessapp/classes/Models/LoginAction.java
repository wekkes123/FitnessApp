package be.kuleuven.fitnessapp.classes.Models;

import android.content.Context;
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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import be.kuleuven.fitnessapp.classes.ActivityC.Login;

public class LoginAction {
    private String Username;
    private String Password;
    private Context LoginContext;
    private RequestQueue requestqueue;
    private boolean LoginInDB;


    public LoginAction(String username, String password, Context context){
        Username = username;
        Password = encryptPassword(password);
        //Password = password;
        LoginContext = context;
        LoginInDB = false;
    }

    public String encryptPassword(String pw){
        String sha256hex = Hashing.sha256().hashString(pw, StandardCharsets.UTF_8).toString();
        System.out.println(sha256hex);
        return sha256hex;
    }

    public interface LoginCallBack{
        void onSucces();
    }

    public void requestLogin(final LoginCallBack callBack){
        RequestQueue requestqueue = Volley.newRequestQueue(LoginContext);
        String requestURL = "https://studev.groept.be/api/a21pt213/SelectAll";

        StringRequest submitRequest = new StringRequest(Request.Method.GET, requestURL,

                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray responseArray = new JSONArray(response);
                            for(int i = 0; i < responseArray.length(); i++){
                                JSONObject curObject = responseArray.getJSONObject(i);
                                if(curObject.getString("Username").equals(Username) && curObject.getString("Password").equals(Password)){
                                    //System.out.println("true");
                                    callBack.onSucces();
                                    return;
                                }
                            }

                        }
                        catch( JSONException e ){
                            //display error message
                        }
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
