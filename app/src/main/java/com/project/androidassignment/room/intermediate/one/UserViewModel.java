package com.project.androidassignment.room.intermediate.one;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public class UserViewModel extends AndroidViewModel {
    private UserRepo repo;
    public UserViewModel(@NonNull Application application) {
        super(application);
        repo = new UserRepo(application);
    }

    public void insert(UserEntity entity){
        repo.insert(entity);
    }

    public UserEntity login(String email){
        return repo.login(email);
    }
}
