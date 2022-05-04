package be.kuleuven.fitnessapp.classes.Models;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ExersizeAction {
    private Context ExersizeC;
    private String Username;
    private String Title;

    public ExersizeAction(String Username,String Title,Context context){
        this.Username = Username;
        this.Title = Title;
        ExersizeC = context;
    }

    public void initializeTables(){
        if(Title.equals("Streches")){
            return;
        }
        checkForTables(new ExersizeAction.ECallback() {
            @Override
            public void onSucces() {

            }

            @Override
            public void onFail() {
                switch(Title) {
                    case "Cardio":

                    case "Heavy Lifting":

                    case "Calisthenics":
                }
            }
        });
    }

    public interface ECallback{
        void onSucces();
        void onFail();
    }

    public void checkForTables(final ExersizeAction.ECallback callBack){
        RequestQueue requestqueue = Volley.newRequestQueue(ExersizeC);
        String requestURL = "https://studev.groept.be/api/a21pt213/SelectExersizeUsernames";

        StringRequest submitRequest = new StringRequest(Request.Method.GET, requestURL,

                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray responseArray = new JSONArray(response);
                            for(int i = 0; i < responseArray.length(); i++) {
                                JSONObject curObject = responseArray.getJSONObject(i);
                                if (curObject.getString("Username").equals(Username)) {
                                    callBack.onSucces();
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


    public void makeCardio(){

    }

    public void makeHL(){

    }

    public void makeCal(){

    }
}