package it.pagingexample.thefedex87.pagingexample.ui.TeamsAdapter;

import android.arch.paging.PagedListAdapter;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import it.pagingexample.thefedex87.pagingexample.R;
import it.pagingexample.thefedex87.pagingexample.data.Team;

public class TeamPagedAdapter extends PagedListAdapter<Team, TeamViewHolder> {
    public TeamPagedAdapter() {
        super(Team.DIFF_CALLBACK);
    }

    @NonNull
    @Override
    public TeamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.team_single_line, parent, false);
        return new TeamViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TeamViewHolder holder, int position) {
        Team team = getItem(position);
        if (team != null)
            holder.bind(team);
//        else
//            holder.cle
    }
}
