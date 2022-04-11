package com.project.androidassignment.room.advanced.one;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface TaskDao{
    @Insert
    public void insert(TaskEntity entity);

    @Query("SELECT * FROM taskTable ORDER BY time DESC")
    public LiveData<List<TaskEntity>> getAll();

    @Update
    public void update(TaskEntity entity);

    @Query("DELETE FROM taskTable WHERE id=:id")
    public void complete(int id);
}
