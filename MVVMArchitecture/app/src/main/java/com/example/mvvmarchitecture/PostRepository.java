package com.example.mvvmarchitecture;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class PostRepository {

    private PostDao mPostDao;
    private LiveData<List<PostData>> mAllPosts;

    // In order to unit test the PostRepository, Application dependency has to be removed
    // This requires more complexity and more code. I will look into this
    PostRepository(Application application) {
        PostRoomDatabase db = PostRoomDatabase.getPostRoomDatabase(application);
        mPostDao = db.postDao();
        mAllPosts = mPostDao.selectAll();
    }

    // Room executes all queries on a separate thread
    // Observed LiveData will notify the observer when the data has changed
    LiveData<List<PostData>> getAllPosts() {
        return mAllPosts;
    }

    // Room ensures that we are not doing any long running operations on the main thread,
    // blocking UI
    void insert(final PostData postData) {
        PostRoomDatabase.databaseWriteExecutor.execute(() -> {
            mPostDao.insert(postData);
        });
    }
}
