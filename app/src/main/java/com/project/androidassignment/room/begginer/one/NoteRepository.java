package com.project.androidassignment.room.begginer.one;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.project.androidassignment.room.begginer.two.NoteDao;
import com.project.androidassignment.room.begginer.two.NoteEntity;
import com.project.androidassignment.room.begginer.two.NotesDatabase;

import java.util.List;

public class NoteRepository {
    public NoteDao dao;
    public NotesDatabase database;
    public LiveData<List<NoteEntity>> entities;
    public NoteRepository(Application application){
        database = NotesDatabase.getINSTANCE(application);
        dao = database.dao();
        entities = dao.getNotes();
    }

    public void insert(NoteEntity entity){
        dao.insert(entity);
    }

    public void update(NoteEntity entity){
        dao.update(entity);
    }

    public void delete(int id){
        dao.delete(id);
    }
}
