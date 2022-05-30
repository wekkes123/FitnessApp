package be.kuleuven.fitnessapp.classes.Abstract;

import android.content.Context;

import be.kuleuven.fitnessapp.classes.Models.LoginAction;

public abstract class ALog {
    public abstract String encryptPassword(String pw);
    public abstract void requestLogin(LoginAction.LoginCallBack callBack);

}
