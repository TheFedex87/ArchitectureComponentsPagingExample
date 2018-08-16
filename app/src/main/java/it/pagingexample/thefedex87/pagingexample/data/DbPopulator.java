package it.pagingexample.thefedex87.pagingexample.data;

import android.content.Context;
import android.support.annotation.Nullable;

import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

import it.pagingexample.thefedex87.pagingexample.Retrofit.RetrofitResponse;
import it.pagingexample.thefedex87.pagingexample.Retrofit.TeamsApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public final class DbPopulator {
    public static void populateDbWithTeams(Context context,@Nullable final Team lastLoadedTeam){
        TeamsApiInterface teamsApiInterface = new Retrofit.Builder()
                .baseUrl("http://api.football-data.org/v2/")
                .addConverterFactory((GsonConverterFactory.create(new GsonBuilder().create())))
                .build()
                .create(TeamsApiInterface.class);

        final AppDatabase db = AppDatabase.getInstance(context);

        teamsApiInterface.responseTeams().enqueue(new Callback<RetrofitResponse>() {
            @Override
            public void onResponse(Call<RetrofitResponse> call, final Response<RetrofitResponse> response) {
                Executors.newSingleThreadExecutor().execute(new Runnable() {
                    @Override
                    public void run() {
                        //Team[] teams = new Team[response.body().getTeams().size()];
                        //teams = response.body().getTeams().toArray(teams);
                        //db.teamDao().insert(teams);

                        //Since this API does not support pagination, I simulate the pagination loading some data (100 elements) every time into the DB
                        int startIndex = 0;

                        if (lastLoadedTeam != null){
                            while(lastLoadedTeam.getId() != response.body().getTeams().get(startIndex).getId()){
                                startIndex++;
                            }
                            startIndex++;
                        }

                        List<Team> teamsAl = new ArrayList<>();
                        for(int i = 0; i < 100; i++){
                            if (i + startIndex > response.body().getTeams().size() - 1) break;
                            teamsAl.add(response.body().getTeams().get(startIndex + i));
                        }

                        if (teamsAl.size() == 0) return;

                        Team[] teams = new Team[teamsAl.size()];
                        teams = teamsAl.toArray(teams);
                        db.teamDao().insert(teams);
                    }
                });
            }

            @Override
            public void onFailure(Call<RetrofitResponse> call, Throwable t) {

            }
        });
    }
}
