package com.corylab.task5.data.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ItemDAO {
    @Query("SELECT * FROM EntityItem")
    LiveData<List<EntityItem>> getAll();

    @Query("SELECT * FROM EntityItem WHERE text IN (:text)")
    LiveData<List<EntityItem>> loadAllByTitle(String text);

    @Insert
    void insertAll(List<EntityItem> comment);

    @Insert
    void insert(EntityItem comment);

    @Query("DELETE FROM EntityItem")
    void deleteAll();
}
