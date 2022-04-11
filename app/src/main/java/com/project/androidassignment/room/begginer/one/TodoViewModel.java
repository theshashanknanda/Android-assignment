package com.project.androidassignment.room.begginer.one;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class TodoViewModel extends AndroidViewModel {
    public TodoDao dao;
    public TodoDatabase database;
    public LiveData<List<TodoEntity>> items;

    public TodoViewModel(@NonNull Application application) {
        super(application);

        database = TodoDatabase.getInstance(application);
        dao = database.dao();
        items = dao.getAll();
    }

    public void insert(TodoEntity entity){
        dao.insert(entity);
    }

    public void update(TodoEntity entity){
        dao.update(entity);
    }

    public void delete(int id){
        dao.delete(id);
    }
}
