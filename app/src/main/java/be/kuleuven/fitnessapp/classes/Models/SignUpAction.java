package be.kuleuven.fitnessapp.classes.Models;

import android.content.Context;

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

import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import be.kuleuven.fitnessapp.classes.Abstract.ASign;

public class SignUpAction extends ASign {
    private String username;
    private String password;
    private Context SignUpContext;

    public SignUpAction(String username, String password, Context context){
        this.username = username;
        this.password = encryptPassword(password);
        SignUpContext = context;
    }

    @Override
    public String encryptPassword(String pw){
        String sha256hex = Hashing.sha256().hashString(pw, StandardCharsets.UTF_8).toString();
        System.out.println(sha256hex);
        return sha256hex;
    }
    @Override
    public String getURL(){
        String URL = "https://studev.groept.be/api/a21pt213/InsertSUinfo/" + username + "/" + password + "/";
        return URL;
    }

    public interface SignUpCallBack{
        void onSucces();
        void onFail();
    }

    public interface SignUpToDB{
        void Succes();
    }

    public interface cardio{
        void Succes();
    }

    public interface heavy{
        void Succes();
    }

    public interface cali{
        void Succes();
    }

    @Override
    public void requestSignUpValidation(final SignUpAction.SignUpCallBack callBack){
        if(!username.matches("[a-zA-Z0-9]*") || username.equals("")){
            callBack.onFail();
            return;
        }
        RequestQueue requestqueue = Volley.newRequestQueue(SignUpContext);
        String requestURL = "https://studev.groept.be/api/a21pt213/SelectAll";

        StringRequest submitRequest = new StringRequest(Request.Method.GET, requestURL,

                response -> {
                    try {
                        JSONArray responseArray = new JSONArray(response);
                        boolean a = false;
                        for(int i = 0; i < responseArray.length(); i++){
                            JSONObject curObject = responseArray.getJSONObject(i);
                            if(curObject.getString("Username").toLowerCase().equals(username.toLowerCase())){
                                a = true;
                                callBack.onFail();
                                return;
                            }
                        }
                        if(!a){
                            callBack.onSucces();
                        }
                    }
                    catch( JSONException e ){
                        //display error message
                    }
                },
                error -> System.out.print("error")
        );
        requestqueue.add(submitRequest);
    }
    @Override
    public void requestSignUpToDB(final SignUpAction.SignUpToDB callBack){
        RequestQueue requestqueue = Volley.newRequestQueue(SignUpContext);
        String requestURL = getURL();

        StringRequest submitRequest = new StringRequest(Request.Method.GET, requestURL,

                response -> {
                        callBack.Succes();
                },

                error -> System.out.print("error")
        );
        requestqueue.add(submitRequest);
    }
    @Override
    public void makeEmptyCardio(final SignUpAction.cardio callBack){
        RequestQueue requestqueue = Volley.newRequestQueue(SignUpContext);
        String requestURL = "https://studev.groept.be/api/a21pt213/makeEmptyCardio/" + username + "/" + username + "/" + username + "/" + username;

        StringRequest submitRequest = new StringRequest(Request.Method.GET, requestURL,

                response -> callBack.Succes(),

                error -> System.out.print("error")
        );
        requestqueue.add(submitRequest);
    }
    @Override
    public void makeEmptyHeavyBench(final SignUpAction.heavy callBack){
        RequestQueue requestqueue = Volley.newRequestQueue(SignUpContext);
        String requestURL = "https://studev.groept.be/api/a21pt213/makeEmptyWeightBench/" + username + "/" + username + "/" + username + "/" + username + "/" + username + "/" + username + "/" + username + "/" + username + "/" + username + "/" + username + "/" + username + "/" + username + "/" + username + "/" + username + "/" + username + "/" + username + "/" + username + "/";

        StringRequest submitRequest = new StringRequest(Request.Method.GET, requestURL,

                response -> {
                        callBack.Succes();
                },

                error -> System.out.print("error")
        );
        requestqueue.add(submitRequest);
    }
    @Override
    public void makeEmptyHeavyDeadlift(final SignUpAction.heavy callBack){
        RequestQueue requestqueue = Volley.newRequestQueue(SignUpContext);
        String requestURL = "https://studev.groept.be/api/a21pt213/makeEmptyWeightDeadlift/" + username + "/" + username + "/" + username + "/" + username + "/" + username + "/" + username + "/" + username + "/" + username + "/" + username + "/" + username + "/" + username + "/" + username + "/" + username + "/" + username + "/" + username + "/" + username + "/" + username + "/";

        StringRequest submitRequest = new StringRequest(Request.Method.GET, requestURL,

                response -> {
                        callBack.Succes();
                },

                error -> System.out.print("error")
        );
        requestqueue.add(submitRequest);
    }
    @Override
    public void makeEmptyHeavyCali(final SignUpAction.cali callBack){
        RequestQueue requestqueue = Volley.newRequestQueue(SignUpContext);
        String requestURL = "https://studev.groept.be/api/a21pt213/makeEmptyCali/" + username + "/" + username + "/" + username + "/" + username + "/" + username + "/" + username + "/" + username;

        StringRequest submitRequest = new StringRequest(Request.Method.GET, requestURL,

                response -> {
                        callBack.Succes();
                },

                error -> System.out.print("error")
        );
        requestqueue.add(submitRequest);
    }
    @Override
    public void makeEmptyHeavySquad(final SignUpAction.heavy callBack){
        RequestQueue requestqueue = Volley.newRequestQueue(SignUpContext);
        String requestURL = "https://studev.groept.be/api/a21pt213/makeEmptyWeightSquad/" + username + "/" + username + "/" + username + "/" + username + "/" + username + "/" + username + "/" + username + "/" + username + "/" + username + "/" + username + "/" + username + "/" + username + "/" + username + "/" + username + "/" + username + "/" + username + "/" + username + "/";

        StringRequest submitRequest = new StringRequest(Request.Method.GET, requestURL,

                response -> {
                        callBack.Succes();
                },
                error -> System.out.print("error")
        );
        requestqueue.add(submitRequest);
    }
    @Override
    public void makeEmptytables(){
        makeEmptyCardio(() -> makeEmptyHeavyBench(()
                           -> makeEmptyHeavySquad(()
                           -> makeEmptyHeavyDeadlift(()
                           -> makeEmptyHeavyCali(()
                           -> {})))));
    }
}
