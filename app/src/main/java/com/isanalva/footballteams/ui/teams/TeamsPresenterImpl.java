package com.isanalva.footballteams.ui.teams;

import com.isanalva.footballteams.domain.LeagueTeam;

import java.util.List;

public class TeamsPresenterImpl implements TeamsPresenter, TeamsInteractor.OnFinishedListener {

    private TeamsView view;
    private TeamsInteractor findTeamsInteractor;

    public TeamsPresenterImpl(TeamsView view) {
        this.view = view;
        this.findTeamsInteractor = new TeamsInteractorImpl();
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

    public TeamsView getMainView() {
        return view;
    }
}
