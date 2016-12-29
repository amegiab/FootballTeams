package com.isanalva.footballteams.ui.players;

import com.isanalva.footballteams.domain.LeagueTeam;
import com.isanalva.footballteams.domain.TeamPlayer;

import java.util.List;

public class PlayersPresenterImpl implements PlayersPresenter, PlayersInteractor.OnFinishedListener {

    private PlayersView view;
    private PlayersInteractor findPlayersInteractor;
    private String teamName;

    public PlayersPresenterImpl(String teamName, PlayersView view) {
        this.teamName = teamName;
        this.view = view;
        this.findPlayersInteractor = new PlayersInteractorImpl();
    }

    @Override
    public void onResume() {
        if (view != null) {
            view.showProgress();
        }
        findPlayersInteractor.findTeams(teamName,this);
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
    public void onFinished(List<TeamPlayer> items) {
        if (view != null) {
            view.setPlayers(items);
            view.hideProgress();
        }
    }

    public PlayersView getMainView() {
        return view;
    }
}
