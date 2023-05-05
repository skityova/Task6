package com.corylab.task5.data.repositories;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;

import com.corylab.task5.data.database.EntityItem;
import com.corylab.task5.data.database.ItemDatabase;
import com.corylab.task5.data.datasource.DataItems;
import com.corylab.task5.data.model.Item;

import java.util.List;
import java.util.stream.Collectors;

public class ItemsRepository {
    ItemDatabase databaseSource;


    public ItemsRepository(Context context) {
        databaseSource = ItemDatabase.getDatabase(context);
    }

    public void addTextBlock(Item textBlock) {
        ItemDatabase.databaseWriteExecutor.execute(() -> {
            databaseSource.itemDao().insert(new EntityItem(textBlock.getText()));
        });
    }

    public void removeTextBlock() {
        databaseSource.itemDao().deleteAll();
    }

    public LiveData<List<Item>> getTextBlocksLive() {
        return Transformations.map(
                databaseSource.itemDao().getAll(),
                (values) -> values.stream().map(EntityItem::toDomainModel).collect(Collectors.toList())
        );
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
