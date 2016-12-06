package com.isanalva.footballteams;


import android.app.Application;
import android.content.Context;

/**
 * Created by amegia on 06/12/2016.
 */

public class FootballTeamsApp extends Application {
    private static FootballTeamsApp instance;

    public static FootballTeamsApp getInstance() {
        return instance;
    }

    public static Context getContext(){
        return instance;
    }

    @Override
    public void onCreate() {
        instance = this;
        super.onCreate();
    }
}