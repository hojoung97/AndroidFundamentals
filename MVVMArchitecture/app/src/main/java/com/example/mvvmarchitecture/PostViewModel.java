package com.example.mvvmarchitecture;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class PostViewModel extends AndroidViewModel {
    private PostRepository mRepository;

    private LiveData<List<PostData>> mAllPosts;

    public PostViewModel(Application application) {
        super(application);
        mRepository = new PostRepository(application);
        mAllPosts = mRepository.getAllPosts();
    }

    LiveData<List<PostData>> getmAllPosts() {
        return mAllPosts;
    }

    public void insert(PostData postData) {
        mRepository.insert(postData);
    }
}
