package com.isanalva.footballteams.ui.teams;

import com.isanalva.footballteams.domain.FootballTeam;
import com.isanalva.footballteams.domain.LeagueTeam;

import java.util.List;

public interface TeamsView2 {

    void showProgress();

    void hideProgress();

    void setTeams(List<LeagueTeam> items);

    void showMessage(String message);
}
