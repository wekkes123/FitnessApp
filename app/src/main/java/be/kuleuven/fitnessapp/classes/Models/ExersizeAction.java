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

import be.kuleuven.fitnessapp.classes.Abstract.AEx;
import be.kuleuven.fitnessapp.classes.ActivityC.Exercise;

public class ExersizeAction extends AEx {
    private Context ExersizeC;
    private String Username;
    private String Title;
    private Exercise exercise;

    public ExersizeAction(String Username,String Title,Context context, Exercise exercise){
        this.Username = Username;
        this.Title = Title;
        this.exercise = exercise;
        ExersizeC = context;
    }

    @Override
    public void initializeTables(){
        //exercise.ShowLoadingPopup();
        if(Title.equals("Streches")){
            return;
        }
        String exs = exercise.getEX();
        selectExercise(new ECallback3() {
            @Override
            public void onSucces() {

            }
        }, exs);
    }

    public interface ECallback{
        void onSucces();
        void onFail();
    }

    public interface ECallback2{
        void onSucces();
    }

    public interface ECallback3{
        void onSucces();
    }

    @Override
    public void selectExercise(final ExersizeAction.ECallback3 callBack, String Ex){
        RequestQueue requestqueue = Volley.newRequestQueue(ExersizeC);
        String requestURL = "https://studev.groept.be/api/a21pt213/SelectUserEx/" + Username + "/" + Ex;

        StringRequest submitRequest = new StringRequest(Request.Method.GET, requestURL,

                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray responseArray = new JSONArray(response);
                            exercise.FillTables(responseArray);
                            callBack.onSucces();
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

    @Override
    public void setExactReps(final ExersizeAction.ECallback2 callBack, String Ex, String Weight, int rep){
        RequestQueue requestqueue = Volley.newRequestQueue(ExersizeC);
        String requestURL = "https://studev.groept.be/api/a21pt213/SetExactReps/"+ rep + "/" + Username + "/" + Ex; /*+ "/" + Weight;*/

        StringRequest submitRequest = new StringRequest(Request.Method.GET, requestURL,

                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray responseArray = new JSONArray(response);
                            callBack.onSucces();
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

    @Override
    public void setReps(final ExersizeAction.ECallback2 callBack, String Ex, String Weight, int rep){
        RequestQueue requestqueue = Volley.newRequestQueue(ExersizeC);
        String requestURL = "https://studev.groept.be/api/a21pt213/SetReps/"+ rep + "/" + Username + "/" + Ex + "/" + Weight;

        StringRequest submitRequest = new StringRequest(Request.Method.GET, requestURL,

                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray responseArray = new JSONArray(response);
                            callBack.onSucces();
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
