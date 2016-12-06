package com.isanalva.footballteams.services.impl;

import android.content.Context;

import com.android.volley.Response;
import com.isanalva.footballteams.domain.CompetitionTeams;
import com.isanalva.footballteams.domain.FootballTeamListWrapper;
import com.isanalva.footballteams.http.ObjectRequest;
import com.isanalva.footballteams.http.VolleyGetRequest;
import com.isanalva.footballteams.services.FootballTeamApi;
import com.isanalva.footballteams.utils.VolleyRequestQueue;

/**
 * Created by amegia on 03/12/2016.
 */

public class FootballTeamApiVolleyClient implements FootballTeamApi {

    private static final String TAG = "FootballTeamApiVolleyClient";
    private static final String BASE_FOOTBALL_TEAMS_API_URL = "http://api.football-data.org/";
    private static final String GET_FOOTBALL_TEAMS_URL = BASE_FOOTBALL_TEAMS_API_URL + "v1/competitions/TEAM_ID/teams";
    private String footballTeamsUrl;

    public FootballTeamApiVolleyClient(String teamId) {
        footballTeamsUrl = GET_FOOTBALL_TEAMS_URL.replace("TEAM_ID", teamId);
    }

    @Override
    public void getFootballTeams(Context context, Response.Listener<CompetitionTeams> footballTeamsListener,
                                 Response.ErrorListener errorListener) {
        VolleyGetRequest<CompetitionTeams> getFootballTeamsRequest = new VolleyGetRequest<CompetitionTeams>(
                footballTeamsUrl, CompetitionTeams.class, null, footballTeamsListener, errorListener);
        VolleyRequestQueue.getInstance(context).addToRequestQueue(getFootballTeamsRequest);
    }
}

