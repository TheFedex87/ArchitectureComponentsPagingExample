package it.pagingexample.thefedex87.pagingexample.data;

import android.arch.paging.DataSource;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

@Dao
public interface PlayerDao {
    @Query("SELECT * FROM teams")
    DataSource.Factory<Integer, Team> allTeams();

    @Insert
    void insert(Team... teams);
}
