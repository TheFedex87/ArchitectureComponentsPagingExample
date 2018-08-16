package it.pagingexample.thefedex87.pagingexample.Retrofit;

import java.util.List;

import it.pagingexample.thefedex87.pagingexample.data.Team;

public class RetrofitResponse {
    private List<Team> teams;

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }
}
