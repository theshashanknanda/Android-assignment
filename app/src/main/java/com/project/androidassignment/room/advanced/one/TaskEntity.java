package com.project.androidassignment.room.advanced.one;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "taskTable")
public class TaskEntity {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "description")
    public String description;

    @ColumnInfo(name = "time")
    public long time;

    @ColumnInfo(name = "priority")
    public String priority;

    @ColumnInfo(name = "priorityColor")
    public String priorityColor;

    @Override
    public String toString() {
        return "TaskEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", time=" + time +
                ", priority='" + priority + '\'' +
                ", priorityColor='" + priorityColor + '\'' +
                '}';
    }
}
