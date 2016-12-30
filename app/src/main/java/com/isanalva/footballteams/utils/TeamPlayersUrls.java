package com.isanalva.footballteams.utils;

import android.content.res.AssetManager;

import com.isanalva.footballteams.FootballTeamsApp;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by amegia on 09/12/2016.
 */

public class TeamPlayersUrls {

    private static TeamPlayersUrls teamPlayers;
    private final static String TEAM_PLAYERS = "teams_players_urls.properties";
    private static Properties teamPlayersUrlsProperties;
    private static final String DEFAULT_TEAM_PLAYER_IMAGE = "jersey";

    private TeamPlayersUrls(){
        try {
            AssetManager assetManager = FootballTeamsApp.getContext().getAssets();
            InputStream inputStream = assetManager.open(TEAM_PLAYERS);
            teamPlayersUrlsProperties = new Properties();
            teamPlayersUrlsProperties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static TeamPlayersUrls getInstance() {
        if (teamPlayers == null) {
            teamPlayers = new TeamPlayersUrls();
        }
        return teamPlayers;
    }

    public String getTeamPlayerImageUrl(String teamName, int number) {
        StringBuffer teamPlayerKey = new StringBuffer();
        teamPlayerKey.append(teamName);
        teamPlayerKey.append("-");
        teamPlayerKey.append(number);
        String teamPlayerImageUrl =  teamPlayersUrlsProperties.getProperty(teamPlayerKey.toString());
        return teamPlayerImageUrl;
    }
}
