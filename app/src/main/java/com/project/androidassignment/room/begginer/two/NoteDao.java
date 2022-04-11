package com.project.androidassignment.room.begginer.two;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.project.androidassignment.adapter.two.ListView;

import java.util.List;

@Dao
public interface NoteDao {
    @Insert
    public void insert(NoteEntity entity);

    @Update
    public void update(NoteEntity entity);

    @Query("DELETE FROM notesTable WHERE id=:id")
    public void delete(int id);

    @Query("SELECT * FROM notesTable")
    LiveData<List<NoteEntity>> getNotes();
}
