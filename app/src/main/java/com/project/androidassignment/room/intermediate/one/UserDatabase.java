package com.project.androidassignment.room.intermediate.one;

import android.app.Application;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {UserEntity.class}, version = 1, exportSchema = false)
public abstract class UserDatabase extends RoomDatabase {
    public abstract UserDao dao();
    public static UserDatabase database;

    public static UserDatabase getInstance(Application application){
        if(database == null){
            database = Room.databaseBuilder(application, UserDatabase.class,
                    "userDatabase").allowMainThreadQueries().build();
        }
        return database;
    }
}
