package com.example.mvvmarchitecture;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface PostDao {
    // conflict resolution strategy
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(PostData pData);

    @Query("DELETE FROM post_data_table")
    void deleteAll();

    @Query("SELECT * FROM post_data_table")
    LiveData<List<PostData>> selectAll();
}
