package it.pagingexample.thefedex87.pagingexample.ui.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.paging.LivePagedListBuilder;
import android.arch.paging.PagedList;
import android.support.annotation.NonNull;

import it.pagingexample.thefedex87.pagingexample.data.AppDatabase;
import it.pagingexample.thefedex87.pagingexample.data.RepoBoundaryCallback;
import it.pagingexample.thefedex87.pagingexample.data.Team;

public class MainViewModel extends AndroidViewModel {
    private LiveData<PagedList<Team>> playerList;

    private static final int PAGE_SIZE = 20;
    private static final int PREFETCH_DISTANCE = 40;

    public MainViewModel(@NonNull Application application) {
        super(application);

        AppDatabase appDatabase = AppDatabase.getInstance(application);
        playerList = new LivePagedListBuilder<>(appDatabase.teamDao().allTeams(), new PagedList.Config.Builder()
                .setPageSize(PAGE_SIZE)
                .setPrefetchDistance(PREFETCH_DISTANCE)
                .setEnablePlaceholders(true)
                .build())
        .setBoundaryCallback(new RepoBoundaryCallback(application.getApplicationContext()))
        .build();
    }

    public final LiveData<PagedList<Team>> getTeams() {
        return playerList;
    }
}
