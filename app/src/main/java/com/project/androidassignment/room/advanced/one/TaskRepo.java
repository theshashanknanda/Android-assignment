package com.project.androidassignment.room.advanced.one;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.project.androidassignment.adapter.two.ListView;

import java.util.List;

public class TaskRepo {
    public LiveData<List<TaskEntity>> entities;
    private TaskDatabase database;
    private TaskDao dao;
    public TaskRepo(Application application){
        database = TaskDatabase.getInstance(application);
        dao = database.dao();
        entities = dao.getAll();
    }

    public void insert(TaskEntity entity){
        dao.insert(entity);
    }

    public void update(TaskEntity entity){
        dao.update(entity);
    }

    public void complete(int id){{
        dao.complete(id);
    }
    }
}
