package be.kuleuven.fitnessapp.classes.ActivityC;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import be.kuleuven.fitnessapp.R;
import be.kuleuven.fitnessapp.classes.Models.SignUpAction;

public class SignUpScreen extends AppCompatActivity {

    private EditText SignUpUsername;
    private EditText SignUpPassword;
    private Button LoginButton;
    //private TextView errorText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //zorgt voor fullscreen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //end
        setContentView(R.layout.activity_sign_up_screen);
        SignUpPassword = (EditText) findViewById(R.id.SignUpPassword);
        SignUpUsername = (EditText) findViewById(R.id.SignUpUsername);

    }

    public void onSignUpButtonSUClicked(View caller){
        SignUpAction signup = new SignUpAction(SignUpUsername.getText().toString(), SignUpPassword.getText().toString(), this);
        signup.requestSignUpValidation(new SignUpAction.SignUpCallBack() {
            @Override
            public void onSucces() {
                signup.requestSignUpToDB(() -> {
                    signup.makeEmptytables();
                    showPopupWindow(caller, false);
                });
            }

            @Override
            public void onFail() {
                TextView errorText = (TextView) findViewById(R.id.ErrorMessage);
                errorText.setVisibility(View.VISIBLE);
                showPopupWindow(caller, true);
            }
        });
    }



    public void showPopupWindow(View view, boolean fail){
        // inflate the layout of the popup window
        LayoutInflater inflater = (LayoutInflater)
                getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.popup_window_fail, null);
        if(!fail) {
            popupView = inflater.inflate(R.layout.popup_window_succes, null);
        }

        // create the popup window
        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;
        boolean focusable = true; // lets taps outside the popup also dismiss it
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

        // show the popup window
        // which view you pass in doesn't matter, it is only used for the window tolken
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

        // dismiss the popup window when touched
        popupView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                popupWindow.dismiss();
                if (!fail) {
                    Intent backLogin = new Intent(SignUpScreen.this, Login.class);
                    SignUpScreen.this.startActivity(backLogin);
                }
                return true;
            }
        });
    }

}
