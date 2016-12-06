package com.isanalva.footballteams.ui.teams;

import java.util.List;

public interface TeamsView {

    void showProgress();

    void hideProgress();

    void setTeams(List<String> items);

    void showMessage(String message);
}
