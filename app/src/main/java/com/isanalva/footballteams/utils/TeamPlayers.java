package com.isanalva.footballteams.utils;

import android.content.res.AssetManager;

import com.isanalva.footballteams.FootballTeamsApp;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by amegia on 09/12/2016.
 */

public class TeamPlayers {

    private static TeamPlayers teamPlayers;
    private final static String TEAM_PLAYERS = "teams_players.properties";
    private static Properties teamPlayersProperties;
    private static final String DEFAULT_TEAM_PLAYER_IMAGE = "jersey";

    private TeamPlayers(){
        try {
            AssetManager assetManager = FootballTeamsApp.getContext().getAssets();
            InputStream inputStream = assetManager.open(TEAM_PLAYERS);
            teamPlayersProperties = new Properties();
            teamPlayersProperties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static TeamPlayers getInstance() {
        if (teamPlayers == null) {
            teamPlayers = new TeamPlayers();
        }
        return teamPlayers;
    }

    public String getTeamPlayerImage(String team, int number) {
        StringBuffer teamPlayerKey = new StringBuffer();
        teamPlayerKey.append(team);
        teamPlayerKey.append("-");
        teamPlayerKey.append(number);
        String teamPlayerImage =  teamPlayersProperties.getProperty(teamPlayerKey.toString());
        if (teamPlayerImage == null || teamPlayerImage.equals("")) {
            teamPlayerImage = DEFAULT_TEAM_PLAYER_IMAGE;
        }
        return teamPlayerImage;
    }
}
