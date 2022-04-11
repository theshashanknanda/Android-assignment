package com.project.androidassignment.room.begginer.one;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.project.androidassignment.room.begginer.two.NoteEntity;

import java.util.List;

public class NoteViewModel extends AndroidViewModel {
    private NoteRepository repo;
    public LiveData<List<NoteEntity>> entities;
    public NoteViewModel(@NonNull Application application) {
        super(application);

        repo = new NoteRepository(application);
        entities = repo.entities;
    }

    public void insert(NoteEntity entity){
        repo.insert(entity);
    }

    public void update(NoteEntity entity){
        repo.update(entity);
    }

    public void delete(int id){
        repo.delete(id);
    }
}
