package com.project.androidassignment.room.advanced.one;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class TaskViewModel extends AndroidViewModel {
    private TaskRepo repo;
    public LiveData<List<TaskEntity>> entities;
    public TaskViewModel(@NonNull Application application) {
        super(application);

        repo = new TaskRepo(application);
        entities = repo.entities;
    }

    public void insert(TaskEntity entity){
        repo.insert(entity);
    }

    public void  update(TaskEntity entity){
        repo.update(entity);
    }

    public void complete(int id){
        repo.complete(id);
    }
}
