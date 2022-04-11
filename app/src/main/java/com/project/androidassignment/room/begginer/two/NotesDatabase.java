package com.project.androidassignment.room.begginer.two;

import android.app.Application;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
@Database(entities = {NoteEntity.class}, version = 1, exportSchema = false)
public abstract class NotesDatabase extends RoomDatabase {
    public abstract NoteDao dao();
    public static NotesDatabase database;

    public static NotesDatabase getINSTANCE(Application application){
        if(database == null){
            database = Room.databaseBuilder(application.getApplicationContext(),
                    NotesDatabase.class, "notesDatabase")
                    .allowMainThreadQueries().build();
        }
        return database;
    }
}
