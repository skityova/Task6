package com.corylab.task5.ui.viewmodels;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.corylab.task5.data.model.Item;
import com.corylab.task5.data.repositories.ItemsRepository;

import java.util.List;

public class ItemsViewModel extends ViewModel {

    private Context context;
    private LiveData<List<Item>> itemsLive;
    private ItemsRepository itemsRepository;


    public void init(Context context) {
        this.context = context;
        itemsRepository = new ItemsRepository();
        itemsLive = itemsRepository.getRandomData();
    }

    public LiveData<List<Item>> getTextBlocks() {
        return itemsLive;
    }

    public void addTextBlock(Item textBlock) {
        itemsRepository.saveToFile("test", textBlock.getText(), context);
        itemsRepository.addTextBlock(textBlock);
    }

    public void removeTextBlock(Item textBlock) {
        itemsRepository.removeTextBlock(textBlock);
    }
}
