package be.kuleuven.fitnessapp.classes.Models;

public class SignUpAction {
    private String username;
    private String password;

    public SignUpAction(String username, String password){
        username = username;
        password = password;
    }

    public boolean checkValidUsername(){
        if(username != null){
            return true;
        }
        else{
            return true;

        }
    }
}
