package com.corylab.task5.data.repositories;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.corylab.task5.data.datasource.DataItems;
import com.corylab.task5.data.model.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemsRepository {
    private List<Item> textBlocks;

    private final MutableLiveData<List<Item>> textBlocksLive = new MutableLiveData<>();

    public ItemsRepository() {
        textBlocks = new ArrayList<>();
        textBlocks.add(new Item("example_text_1"));
        textBlocks.add(new Item("example_text_2"));
        textBlocks.add(new Item("example_text_3"));
        textBlocksLive.setValue(textBlocks);
    }

    public void addTextBlock(Item textBlock) {
        textBlocks.add(textBlock);
        textBlocksLive.setValue(textBlocks);
    }

    public void removeTextBlock(Item textBlock) {
        textBlocks.remove(textBlock);
        textBlocksLive.setValue(textBlocks);
    }

    public LiveData<List<Item>> getTextBlocksLive() {
        return textBlocksLive;
    }

    public LiveData<List<Item>> getRandomData() {
        return DataItems.createList();
    }

    public void saveToFile(String fileName, String data, Context context) {
        DataItems.saveToFile(fileName, data, context);
    }

    public void saveToFileExternalStorage(String fileName, String data, Context context) {
        DataItems.saveToFileExternalStorage(fileName, data, context);
    }

    public void saveToFileSharedStorage(String key, String data, SharedPreferences sharedPreferences) {
        DataItems.saveToFileSharedStorage(key, data, sharedPreferences);
    }
}
