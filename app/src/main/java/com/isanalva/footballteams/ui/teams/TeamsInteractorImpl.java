package com.isanalva.footballteams.ui.teams;

import android.os.Handler;
import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.isanalva.footballteams.FootballTeamsApp;
import com.isanalva.footballteams.domain.CompetitionTeams;
import com.isanalva.footballteams.domain.FootballTeam;
import com.isanalva.footballteams.domain.FootballTeamListWrapper;
import com.isanalva.footballteams.services.impl.FootballTeamApiVolleyClient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TeamsInteractorImpl implements TeamsInteractor {

    private static final String TAG = "TeamsInteractorImpl";

    /*@Override
    public void findTeams(final OnFinishedListener listener) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                listener.onFinished(createArrayList());
            }
        }, 2000);
    }*/

    @Override
    public void findTeams(final OnFinishedListener listener) {
        FootballTeamApiVolleyClient client = new FootballTeamApiVolleyClient("436");
        client.getFootballTeams(FootballTeamsApp.getContext(), new Response.Listener<CompetitionTeams>() {
            @Override
            public void onResponse(CompetitionTeams response) {
                String name = response.getTeams().get(0).getName();
                Log.d(TAG,name);
                List<String> equipos = new ArrayList<String>();
                for (FootballTeam team: response.getTeams()) {
                    equipos.add(team.getName());
                }
                listener.onFinished(equipos);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(TAG,error.getMessage());
            }
        });
    }

    private List<String> createArrayList() {
        return Arrays.asList(
                "Item 1",
                "Item 2",
                "Item 3",
                "Item 4",
                "Item 5",
                "Item 6",
                "Item 7",
                "Item 8",
                "Item 9",
                "Item 10"
        );
    }
}
