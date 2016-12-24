package com.isanalva.footballteams.ui.teams;

import android.content.Context;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.isanalva.footballteams.FootballTeamsApp;
import com.isanalva.footballteams.R;
import com.isanalva.footballteams.domain.LeagueTeam;
import com.isanalva.footballteams.utils.TeamLogo;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by amegia on 08/12/2016.
 */

public class TeamsAdapter extends RecyclerView.Adapter<TeamsAdapter.TeamViewHolder> {

    private Context mContext;
    private List<LeagueTeam> items;

    public static class TeamViewHolder extends RecyclerView.ViewHolder {

        public ImageView teamPhoto;
        public TextView teamName;
        public TextView teamPoints;
        public TextView teamGoals;
        public TextView teamGoalsAgainst;
        public ImageView overFlow;

        public TeamViewHolder(View v) {
            super(v);
            teamPhoto = (ImageView) v.findViewById(R.id.team_logo);
            teamName = (TextView) v.findViewById(R.id.team_name);
            teamGoals = (TextView) v.findViewById(R.id.team_goals);
            teamPoints = (TextView) v.findViewById(R.id.team_points);
            teamGoalsAgainst = (TextView) v.findViewById(R.id.team_goals_against);
            overFlow = (ImageView) v.findViewById(R.id.overflow);
        }
    }

    public TeamsAdapter(Context context, List<LeagueTeam> items) {
        this.mContext = context;
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
    public void onBindViewHolder(final TeamViewHolder viewHolder, int i) {
        String urlImg = TeamLogo.getInstance().getUrlTeamLogo(items.get(i).getTeamName());
        Picasso.with(FootballTeamsApp.getContext()).load(urlImg).into(viewHolder.teamPhoto);
        String teamNameText = "" + (i + 1) + " " + items.get(i).getTeamName();
        viewHolder.teamName.setText(teamNameText);
        viewHolder.teamPoints.setText("Puntos: " + items.get(i).getPoints());
        viewHolder.teamGoals.setText("Goles a favor: " + items.get(i).getGoals());
        viewHolder.teamGoalsAgainst.setText("Goles en contra: " + items.get(i).getGoalsAgainst());
        viewHolder.overFlow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupMenu(viewHolder.overFlow);
            }
        });
    }

    private void showPopupMenu(View view) {
        PopupMenu popup = new PopupMenu(mContext, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu_teams, popup.getMenu());
        popup.setOnMenuItemClickListener(new MyMenuItemClickListener());
        popup.show();
    }

    class MyMenuItemClickListener implements PopupMenu.OnMenuItemClickListener {

        public MyMenuItemClickListener() {
        }

        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.action_matches:
                    Toast.makeText(mContext, "Partidos", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.action_players:
                    Toast.makeText(mContext, "Jugadores", Toast.LENGTH_SHORT).show();
                    return true;
                default:
            }
            return false;
        }
    }
}
