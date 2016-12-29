package com.isanalva.footballteams.ui.players;

import com.isanalva.footballteams.domain.LeagueTeam;
import com.isanalva.footballteams.domain.TeamPlayer;

import java.util.List;

public interface PlayersInteractor {

    interface OnFinishedListener {
        void onFinished(List<TeamPlayer> items);
    }

    void findTeams(String teamName, OnFinishedListener listener);
}
