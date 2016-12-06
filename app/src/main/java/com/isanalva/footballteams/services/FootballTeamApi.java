package com.isanalva.footballteams.services;

import android.content.Context;

import com.android.volley.Response;
import com.isanalva.footballteams.domain.CompetitionTeams;
import com.isanalva.footballteams.domain.FootballTeamListWrapper;

/**
 * Created by amegia on 03/12/2016.
 */

public interface FootballTeamApi {

    public void getFootballTeams(Context context, Response.Listener<CompetitionTeams> patientListener,
                                 Response.ErrorListener errorListener);

}
