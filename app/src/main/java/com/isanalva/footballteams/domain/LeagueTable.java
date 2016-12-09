package com.isanalva.footballteams.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by amegia on 09/12/2016.
 */

public class LeagueTable {

    private String leagueCaption;
    private int matchDay;
    private List<LeagueTeam> standing = new ArrayList<LeagueTeam>();

    public String getLeagueCaption() {
        return leagueCaption;
    }

    public void setLeagueCaption(String leagueCaption) {
        this.leagueCaption = leagueCaption;
    }

    public int getMatchDay() {
        return matchDay;
    }

    public void setMatchDay(int matchDay) {
        this.matchDay = matchDay;
    }

    public List<LeagueTeam> getStanding() {
        return standing;
    }

    public void setStanding(List<LeagueTeam> standing) {
        this.standing = standing;
    }
}
