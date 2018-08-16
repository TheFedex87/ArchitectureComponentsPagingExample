package it.pagingexample.thefedex87.pagingexample.ui.TeamsAdapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;
import it.pagingexample.thefedex87.pagingexample.R;
import it.pagingexample.thefedex87.pagingexample.data.Team;

public class TeamViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.team_name)
    TextView teamName;

    @BindView(R.id.team_foundation)
    TextView teamFoundation;

    TeamViewHolder(View itemView) {
        super(itemView);

        ButterKnife.bind(this, itemView);
    }

    public void bind(Team team){
        teamName.setText(team.getName());
        teamFoundation.setText(String.valueOf(team.getFounded()));
    }
}
