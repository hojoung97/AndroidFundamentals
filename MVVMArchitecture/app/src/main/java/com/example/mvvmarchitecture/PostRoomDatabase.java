package com.example.mvvmarchitecture;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// this setting is requires more understanding of the database which I am not familiar with
@Database(entities = {PostData.class}, version = 1, exportSchema = false)
public abstract class PostRoomDatabase extends RoomDatabase {

    // provide abstract getter method for DAO object
    public abstract PostDao postDao();

    // create the database instance and save the access (singleton)
    private static volatile PostRoomDatabase INSTANCE;

    // number of threads that allowed to execute database operations
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    // declare if first time; return the database instance
    static PostRoomDatabase getPostRoomDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (PostRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            PostRoomDatabase.class, "post_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
