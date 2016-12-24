package com.isanalva.footballteams.ui.teams;

import com.isanalva.footballteams.domain.FootballTeam;
import com.isanalva.footballteams.domain.LeagueTeam;

import java.util.List;

public interface TeamsInteractor {

    interface OnFinishedListener {
        void onFinished(List<LeagueTeam> items);
    }

    void findTeams(OnFinishedListener listener);
}
