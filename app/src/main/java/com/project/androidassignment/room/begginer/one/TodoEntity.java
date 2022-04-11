package com.project.androidassignment.room.begginer.one;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "todoTable")
public class TodoEntity {
    public TodoEntity(){

    }

    public TodoEntity(String name){
        this.task = name;
    }

    @PrimaryKey(autoGenerate = true)
    int id;

    @ColumnInfo(name = "task")
    String task;

    @Override
    public String toString() {
        return "TodoEntity{" +
                "id=" + id +
                ", task='" + task + '\'' +
                '}';
    }
}
