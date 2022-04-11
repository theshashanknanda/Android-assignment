package com.project.androidassignment.room.begginer.one;

import android.app.Application;

import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {TodoEntity.class}, version = 1, exportSchema = false)

public abstract class TodoDatabase extends RoomDatabase {
    public abstract TodoDao dao();
    public static TodoDatabase database;

    public static TodoDatabase getInstance(Application application){
        if(database == null){
            database = Room.databaseBuilder(application.getApplicationContext(),
                    TodoDatabase.class, "todoDatabase")
                    .allowMainThreadQueries().build();
        }
        return database;
    }
}
