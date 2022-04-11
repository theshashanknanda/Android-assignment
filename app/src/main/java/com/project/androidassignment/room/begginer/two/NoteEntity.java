package com.project.androidassignment.room.begginer.two;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "notesTable")
public class NoteEntity {
    public NoteEntity(){

    }

    public NoteEntity(String title, String description) {
        this.title = title;
        this.description = description;
    }

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "title")
    public String title;

    @ColumnInfo(name = "description")
    public String description;
}
