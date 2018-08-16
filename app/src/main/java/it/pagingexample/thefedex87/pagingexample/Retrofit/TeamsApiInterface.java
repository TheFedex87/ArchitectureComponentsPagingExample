package it.pagingexample.thefedex87.pagingexample.Retrofit;

import java.util.List;

import it.pagingexample.thefedex87.pagingexample.data.Team;
import retrofit2.Call;
import retrofit2.http.GET;

public interface TeamsApiInterface {
    @GET("teams")
    Call<RetrofitResponse> responseTeams();
}
