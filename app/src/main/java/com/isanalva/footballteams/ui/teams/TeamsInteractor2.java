package com.isanalva.footballteams.ui.teams;

import com.isanalva.footballteams.domain.FootballTeam;
import com.isanalva.footballteams.domain.LeagueTeam;

import java.util.List;

public interface TeamsInteractor2 {

    interface OnFinishedListener {
        void onFinished(List<LeagueTeam> items);
    }

    void findTeams(OnFinishedListener listener);
}
