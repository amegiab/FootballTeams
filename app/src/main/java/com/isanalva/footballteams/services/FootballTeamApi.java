package com.isanalva.footballteams.services;

import android.content.Context;

import com.android.volley.Response;
import com.isanalva.footballteams.domain.CompetitionTeams;
import com.isanalva.footballteams.domain.LeagueTable;
import com.isanalva.footballteams.domain.Players;
import com.isanalva.footballteams.domain.TeamPlayer;

/**
 * Created by amegia on 03/12/2016.
 */

public interface FootballTeamApi {

    public void getFootballTeams(String teamId, Context context, Response.Listener<CompetitionTeams> patientListener,
                                 Response.ErrorListener errorListener);

    public void getFootballTableLeague(String leagueId, Context context, Response.Listener<LeagueTable> patientListener,
                                         Response.ErrorListener errorListener);

    public void getFootballTeamPlayers(String teamId, Context context, Response.Listener<Players> playersListener,
                                       Response.ErrorListener errorListener);

}
