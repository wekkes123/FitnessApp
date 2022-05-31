package be.kuleuven.fitnessapp.classes.Abstract;

import be.kuleuven.fitnessapp.classes.Models.ExersizeAction;

public abstract class AEx {
    public abstract void initializeTables();

    public abstract void selectExercise(ExersizeAction.ECallback3 callBack, String Ex);

    public abstract void setExactReps(ExersizeAction.ECallback2 callBack, String Ex, String Weight, int rep);

    public abstract void setReps(ExersizeAction.ECallback2 callBack, String Ex, String Weight, int rep);
}
