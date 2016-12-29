package com.isanalva.footballteams.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by amegia on 09/12/2016.
 */

public class Players {

    private int count;
    private List<TeamPlayer> players = new ArrayList<TeamPlayer>();

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<TeamPlayer> getPlayers() {
        return players;
    }

    public void setPlayers(List<TeamPlayer> players) {
        this.players = players;
    }
}
