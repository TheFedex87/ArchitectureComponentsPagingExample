package it.pagingexample.thefedex87.pagingexample.data;

import android.arch.paging.PagedList;
import android.content.Context;
import android.support.annotation.NonNull;

public class RepoBoundaryCallback extends PagedList.BoundaryCallback<Team> {
    private final Context context;

    public RepoBoundaryCallback(Context context){
        this.context = context;
    }

    @Override
    public void onZeroItemsLoaded() {
        //super.onZeroItemsLoaded();
        DbPopulator.populateDbWithTeams(context, null);
    }

    @Override
    public void onItemAtEndLoaded(@NonNull Team itemAtEnd) {
        //super.onItemAtEndLoaded(itemAtEnd);
        DbPopulator.populateDbWithTeams(context, itemAtEnd);
    }
}
