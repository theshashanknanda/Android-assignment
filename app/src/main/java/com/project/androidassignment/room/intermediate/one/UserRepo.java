package com.project.androidassignment.room.intermediate.one;

import android.app.Application;

public class UserRepo {
    private UserDatabase database;
    private UserDao dao;
    public UserRepo(Application application){
        database = UserDatabase.getInstance(application);
        dao = database.dao();
    }

    public void insert(UserEntity entity){
        dao.insert(entity);
    }

    public UserEntity login(String email){
        return dao.login(email);
    }
}
