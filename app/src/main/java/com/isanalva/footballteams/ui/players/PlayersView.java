package com.isanalva.footballteams.ui.players;

import com.isanalva.footballteams.domain.LeagueTeam;
import com.isanalva.footballteams.domain.TeamPlayer;

import java.util.List;

public interface PlayersView {

    void showProgress();

    void hideProgress();

    void setPlayers(List<TeamPlayer> items);

    void showMessage(String message);
}
