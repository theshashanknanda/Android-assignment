package com.project.androidassignment.sharedPreferences.advanced.one_two;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShopViewModel extends ViewModel {

    public MutableLiveData<List<ShopItem>> liveData;
    public List<ShopItem> itemList;

    public ShopViewModel(){
        liveData = new MutableLiveData<>();
        itemList = new ArrayList<>();
    }

    public void add(ShopItem item) {
        itemList.add(item);
        liveData.postValue(itemList);
    }

    public MutableLiveData<List<ShopItem>> getLiveData() {
        return liveData;
    }
}
