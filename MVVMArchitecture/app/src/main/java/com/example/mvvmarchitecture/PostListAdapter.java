package com.example.mvvmarchitecture;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PostListAdapter extends RecyclerView.Adapter<PostListAdapter.PostViewHolder> {

    // ViewHolder class that defines UI components for single list item
    class PostViewHolder extends RecyclerView.ViewHolder {
        // single list item UI components
        private TextView userIdTextView;
        private TextView idTextView;
        private TextView titleTextView;
        private TextView bodyTextView;

        private PostViewHolder(View view) {
            super(view);
            userIdTextView = view.findViewById(R.id.user_id_textview);
            idTextView = view.findViewById(R.id.id_textview);
            titleTextView = view.findViewById(R.id.title_textview);
            bodyTextView = view.findViewById(R.id.body_textview);
        }
    }

    private final LayoutInflater mInflater;
    private List<PostData> mPosts;

    // Constructor
    PostListAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        if (mPosts != null) {
            PostData postData = mPosts.get(position);
            holder.userIdTextView.append(Integer.toString(postData.getUserId()));
            holder.idTextView.append(Integer.toString(postData.getId()));
            holder.titleTextView.append(postData.getTitle());
            holder.bodyTextView.append(postData.getBody());
        } else {
            holder.titleTextView.setText("n/a");
            holder.bodyTextView.setText("n/a");
        }
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new PostViewHolder(itemView);
    }

    @Override
    public int getItemCount() {
        if (mPosts != null) {
            return mPosts.size();
        } else {
            return 0;
        }
    }
}
