package com.example.mvvmarchitecture;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user_data_table")
public class UserData {
    @PrimaryKey
    @ColumnInfo(name = "user_id")
    private int userId;
    private int id;
    private String title;
    private String body;

    public UserData(int uid, int id, String title, String body) {
        this.userId = uid;
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }
}
