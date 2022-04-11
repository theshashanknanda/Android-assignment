package com.project.androidassignment.room.intermediate.one;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "userTable")
public class UserEntity {
    @PrimaryKey
    @NonNull
    String email;

    @ColumnInfo(name = "password")
    String password;

    public UserEntity(){}

    public UserEntity(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
