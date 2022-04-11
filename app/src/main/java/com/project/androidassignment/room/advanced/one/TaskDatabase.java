package com.project.androidassignment.room.advanced.one;

import android.app.Application;

import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {TaskEntity.class}, version = 1, exportSchema = false)
public abstract class TaskDatabase extends RoomDatabase {
    public abstract TaskDao dao();
    public static TaskDatabase database;

    public static TaskDatabase getInstance(Application application){
        if(database == null){
            database = Room.databaseBuilder(application, TaskDatabase.class,
                    "taskDatabase").allowMainThreadQueries().build();
        }
        return database;
    }
}
