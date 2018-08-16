package it.pagingexample.thefedex87.pagingexample.data;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.v7.util.DiffUtil;

@Entity(tableName = "teams")
public class Team {
    @PrimaryKey(autoGenerate = true)
    private long id;

    private String name;
    private int founded;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFounded() {
        return founded;
    }

    public void setFounded(int founded) {
        this.founded = founded;
    }

    public static final DiffUtil.ItemCallback<Team> DIFF_CALLBACK = new DiffUtil.ItemCallback<Team>() {

        @Override
        public boolean areItemsTheSame(Team oldItem, Team newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(Team oldItem, Team newItem) {
            return oldItem.equals(newItem);
        }
    };
}
