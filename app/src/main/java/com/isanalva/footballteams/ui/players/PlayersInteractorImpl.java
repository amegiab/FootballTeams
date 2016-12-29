package com.isanalva.footballteams.ui.players;

import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.isanalva.footballteams.FootballTeamsApp;
import com.isanalva.footballteams.domain.LeagueTable;
import com.isanalva.footballteams.domain.Players;
import com.isanalva.footballteams.domain.TeamPlayer;
import com.isanalva.footballteams.services.impl.FootballTeamApiVolleyClient;
import com.isanalva.footballteams.utils.TeamIds;


public class PlayersInteractorImpl implements PlayersInteractor {

    private static final String TAG = "PlayersInteractorImpl";

    @Override
    public void findTeams(String teamName, final OnFinishedListener listener) {
        String teamId = TeamIds.getInstance().getTeamId(teamName);
        FootballTeamApiVolleyClient client = new FootballTeamApiVolleyClient();
        client.getFootballTeamPlayers(teamId,FootballTeamsApp.getContext(), new Response.Listener<Players>() {
            @Override
            public void onResponse(Players response) {
                listener.onFinished(response.getPlayers());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(TAG,error.getMessage());
            }
        });
    }

}
