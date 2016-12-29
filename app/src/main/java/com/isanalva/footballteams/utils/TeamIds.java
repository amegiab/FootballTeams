package com.isanalva.footballteams.utils;

import android.content.res.AssetManager;

import com.isanalva.footballteams.FootballTeamsApp;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by amegia on 09/12/2016.
 */

public class TeamIds {

    private static TeamIds teamIds;
    private final static String TEAM_IDS = "teams_ids.properties";
    private static Properties teamIdsProperties;

    private TeamIds(){
        try {
            AssetManager assetManager = FootballTeamsApp.getContext().getAssets();
            InputStream inputStream = assetManager.open(TEAM_IDS);
            teamIdsProperties = new Properties();
            teamIdsProperties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static TeamIds getInstance() {
        if (teamIds == null) {
            teamIds = new TeamIds();
        }
        return teamIds;
    }

    public String getTeamId(String teamName) {
        String teamId =  teamIdsProperties.getProperty(teamName);
        return teamId;
    }
}
