package com.isanalva.footballteams.ui.teams;

import java.util.List;

public interface TeamsInteractor {

    interface OnFinishedListener {
        void onFinished(List<String> items);
    }

    void findTeams(OnFinishedListener listener);
}
