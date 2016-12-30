package com.isanalva.footballteams.ui.players;

import android.content.Context;
import android.graphics.drawable.Drawable;
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
import com.isanalva.footballteams.domain.TeamPlayer;
import com.isanalva.footballteams.utils.TeamLogo;
import com.isanalva.footballteams.utils.TeamPlayers;
import com.isanalva.footballteams.utils.TeamPlayersUrls;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by amegia on 08/12/2016.
 */

public class PlayersAdapter extends RecyclerView.Adapter<PlayersAdapter.PlayerViewHolder> {

    private Context mContext;
    private List<TeamPlayer> items;

    private String teamName;

    public static class PlayerViewHolder extends RecyclerView.ViewHolder {

        public ImageView playerPhoto;
        public TextView playerName;
        public TextView playerDateOfBirth;
        public TextView playerNationality;
        public TextView playerMarketValue;

        public PlayerViewHolder(View v) {
            super(v);
            playerPhoto = (ImageView) v.findViewById(R.id.player_logo);
            playerName = (TextView) v.findViewById(R.id.player_name);
            playerDateOfBirth = (TextView) v.findViewById(R.id.player_birth);
            playerNationality = (TextView) v.findViewById(R.id.player_nationality);
            playerMarketValue = (TextView) v.findViewById(R.id.player_market_value);
        }
    }

    public PlayersAdapter(Context context, List<TeamPlayer> items, String teamName) {
        this.mContext = context;
        this.items = items;
        this.teamName = teamName;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public PlayerViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_player, viewGroup, false);
        return new PlayerViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final PlayerViewHolder viewHolder, int i) {
        String imagePlayerUrl = TeamPlayersUrls.getInstance().getTeamPlayerImageUrl(teamName,items.get(i).getJerseyNumber());
        Picasso.with(FootballTeamsApp.getContext()).load(imagePlayerUrl).into(viewHolder.playerPhoto);
        //Drawable drawablePlayer = getDrawable(TeamPlayers.getInstance().getTeamPlayerImage(teamName,items.get(i).getJerseyNumber()));
        //viewHolder.playerPhoto.setImageDrawable(drawablePlayer);
        StringBuffer strHeader = new StringBuffer();
        strHeader.append(items.get(i).getJerseyNumber());
        strHeader.append(" - ");
        strHeader.append(items.get(i).getName());
        viewHolder.playerName.setText(strHeader.toString());
        viewHolder.playerDateOfBirth.setText(items.get(i).getDateOfBirth());
        viewHolder.playerNationality.setText(items.get(i).getNationality());
        viewHolder.playerMarketValue.setText(items.get(i).getMarketValue());
    }

    private Drawable getDrawable(String name) {
        name = name.replace(".jpg","");
        int resourceId = mContext.getResources().getIdentifier(name, "drawable", mContext.getPackageName());
        return mContext.getResources().getDrawable(resourceId);
    }

}
