package com.corylab.task5.data.datasource;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.corylab.task5.data.model.Item;

import java.util.ArrayList;
import java.util.List;

public class DataItems {
    public static LiveData<List<Item>> createList() {
        MutableLiveData<List<Item>> list = new MutableLiveData<>();
        ArrayList<Item> comments = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Item temp = new Item("example_text_" + i);
            comments.add(temp);
        }
        list.setValue(comments);
        return list;
    }
}
