package com.isanalva.footballteams.ui.teams;

import com.isanalva.footballteams.domain.FootballTeam;
import com.isanalva.footballteams.domain.LeagueTeam;

import java.util.List;

public class TeamsPresenterImpl2 implements TeamsPresenter2, TeamsInteractor2.OnFinishedListener {

    private TeamsView2 view;
    private TeamsInteractor2 findTeamsInteractor;

    public TeamsPresenterImpl2(TeamsView2 view) {
        this.view = view;
        this.findTeamsInteractor = new TeamsInteractorImpl2();
    }

    @Override
    public void onResume() {
        if (view != null) {
            view.showProgress();
        }
        findTeamsInteractor.findTeams(this);
    }

    @Override
    public void onItemClicked(int position) {
        if (view != null) {
            view.showMessage(String.format("Position %d clicked", position + 1));
        }
    }

    @Override
    public void onDestroy() {
        view = null;
    }

    @Override
    public void onFinished(List<LeagueTeam> items) {
        if (view != null) {
            view.setTeams(items);
            view.hideProgress();
        }
    }

    public TeamsView2 getMainView() {
        return view;
    }
}
