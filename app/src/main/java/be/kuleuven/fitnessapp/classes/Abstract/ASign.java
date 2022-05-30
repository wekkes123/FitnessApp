package be.kuleuven.fitnessapp.classes.Abstract;

import be.kuleuven.fitnessapp.classes.Models.SignUpAction;

public abstract class ASign {
    public abstract String encryptPassword(String pw);

    public abstract String getURL();

    public abstract void requestSignUpValidation(SignUpAction.SignUpCallBack callBack);

    public abstract void requestSignUpToDB(SignUpAction.SignUpToDB callBack);

    public abstract void makeEmptyCardio(SignUpAction.cardio callBack);

    public abstract void makeEmptyHeavyBench(SignUpAction.heavy callBack);

    public abstract void makeEmptyHeavyDeadlift(SignUpAction.heavy callBack);

    public abstract void makeEmptyHeavyCali(SignUpAction.cali callBack);

    public abstract void makeEmptyHeavySquad(SignUpAction.heavy callBack);

    public abstract void makeEmptytables();
}
