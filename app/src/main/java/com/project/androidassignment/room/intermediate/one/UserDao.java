package com.project.androidassignment.room.intermediate.one;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface UserDao {
    @Insert
    public void insert(UserEntity entity);

    @Query("SELECT * FROM userTable WHERE email=:email")
    public UserEntity login(String email);
}
