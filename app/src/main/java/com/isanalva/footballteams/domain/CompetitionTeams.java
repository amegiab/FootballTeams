package com.isanalva.footballteams.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by amegia on 06/12/2016.
 */

public class CompetitionTeams {

    private int count;
    private List<FootballTeam> teams = new ArrayList<FootballTeam>();

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<FootballTeam> getTeams() {
        return teams;
    }

    public void setTeams(List<FootballTeam> teams) {
        this.teams = teams;
    }
}
