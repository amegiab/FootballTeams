package com.isanalva.footballteams.ui.teams;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.isanalva.footballteams.FootballTeamsApp;
import com.isanalva.footballteams.R;
import com.isanalva.footballteams.domain.FootballTeam;
import com.isanalva.footballteams.domain.LeagueTeam;
import com.isanalva.footballteams.utils.TeamLogo;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by amegia on 08/12/2016.
 */

public class TeamsAdapter2 extends RecyclerView.Adapter<TeamsAdapter2.TeamViewHolder> {

    private List<LeagueTeam> items;

    public static class TeamViewHolder extends RecyclerView.ViewHolder {
        public ImageView teamPhoto;

        public TextView teamName;
        public TextView teamMarketValue;

        public TeamViewHolder(View v) {
            super(v);
            teamPhoto = (ImageView) v.findViewById(R.id.team_logo);
            teamName = (TextView) v.findViewById(R.id.team_name);
            teamMarketValue = (TextView) v.findViewById(R.id.team_market_value);
        }
    }

    public TeamsAdapter2(List<LeagueTeam> items) {
        this.items = items;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public TeamViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_team, viewGroup, false);
        return new TeamViewHolder(v);
    }

    @Override
    public void onBindViewHolder(TeamViewHolder viewHolder, int i) {
        String urlImg = TeamLogo.getInstance().getUrlTeamLogo(items.get(i).getTeamName());
        Picasso.with(FootballTeamsApp.getContext()).load(urlImg).into(viewHolder.teamPhoto);
        String teamNameText = "" + (i + 1) + " - " + items.get(i).getTeamName();
        viewHolder.teamName.setText(teamNameText);
        String marketValue = "Gole a favor " + items.get(i).getGoals();
        //viewHolder.teamMarketValue.setText(marketValue);
    }
}
