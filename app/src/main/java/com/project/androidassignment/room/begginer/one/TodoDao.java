package com.project.androidassignment.room.begginer.one;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Entity;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface TodoDao {
    @Insert
    public void insert(TodoEntity object);

    @Update
    public void update(TodoEntity object);

    @Query("DELETE FROM todoTable WHERE id=:id")
    public void delete(int id);

    @Query("SELECT * FROM todoTable")
    public LiveData<List<TodoEntity>> getAll();
}
