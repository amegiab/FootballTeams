package com.isanalva.footballteams.utils;

import android.content.res.AssetManager;

import com.isanalva.footballteams.FootballTeamsApp;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by amegia on 09/12/2016.
 */

public class TeamLogo {

    private static TeamLogo teamLogo;
    private final static String TEAM_LOGOS = "teams_logos3.properties";
    private static Properties teamLogosProperties;

    private TeamLogo(){
        try {
            AssetManager assetManager = FootballTeamsApp.getContext().getAssets();
            InputStream inputStream = assetManager.open(TEAM_LOGOS);
            teamLogosProperties = new Properties();
            teamLogosProperties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static TeamLogo getInstance() {
        if (teamLogo == null) {
            teamLogo = new TeamLogo();
        }
        return teamLogo;
    }

    public String getUrlTeamLogo(String team) {
        return teamLogosProperties.getProperty(team);
    }
}
