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

public class SignUpAction {
    private String username;
    private String password;
    private Context SignUpContext;

    public SignUpAction(String username, String password, Context context){
        this.username = username;
        this.password = password;
        SignUpContext = context;
    }

    public interface SignUpCallBack{
        void onSucces();
        void onFail();
    }


    public void requestSignUpValidation(final SignUpAction.SignUpCallBack callBack){
        RequestQueue requestqueue = Volley.newRequestQueue(SignUpContext);
        String requestURL = "https://studev.groept.be/api/a21pt213/SelectAll";

        StringRequest submitRequest = new StringRequest(Request.Method.GET, requestURL,

                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray responseArray = new JSONArray(response);
                            boolean a = false;
                            for(int i = 0; i < responseArray.length(); i++){
                                JSONObject curObject = responseArray.getJSONObject(i);
                                if(curObject.getString("Username").equals(username)){
                                    a = true;
                                    callBack.onFail();
                                    return;
                                }
                            }
                            //extra veiligheid met if kan later weg worden gehaald?
                            if(!a){
                                callBack.onSucces();
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
