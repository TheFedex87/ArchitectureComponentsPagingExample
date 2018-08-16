package it.pagingexample.thefedex87.pagingexample;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import it.pagingexample.thefedex87.pagingexample.data.DbPopulator;

public class PagingExampleApplication extends Application {
    private Context context;
    private static final String IS_DB_POPULATED_KEY = "DB_POPULATED_KEY";

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        //initDb();
    }

    private void initDb(){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        if(!sharedPreferences.getBoolean(IS_DB_POPULATED_KEY, false)){
            DbPopulator.populateDbWithTeams(this, null);
            sharedPreferences.edit().putBoolean(IS_DB_POPULATED_KEY, true).apply();
        }
    }
}
