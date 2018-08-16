package it.pagingexample.thefedex87.pagingexample.ui.activity;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import it.pagingexample.thefedex87.pagingexample.R;
import it.pagingexample.thefedex87.pagingexample.ui.TeamsAdapter.TeamPagedAdapter;
import it.pagingexample.thefedex87.pagingexample.ui.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.teams)
    RecyclerView teamsRv;

    private TeamPagedAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        adapter = new TeamPagedAdapter();

        teamsRv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        teamsRv.setAdapter(adapter);

        setupViewModel();
    }

    private void setupViewModel() {
        MainViewModel mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        mainViewModel.getTeams().observe(this, adapter::submitList);
    }
}
