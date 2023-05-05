package com.corylab.task5.data.datasource;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.corylab.task5.data.model.Item;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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

    public static void saveToFile(String fileName, String data, Context context) {
        File file = new File(context.getFilesDir(), fileName + ".txt");
        try {
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(data.getBytes());
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
