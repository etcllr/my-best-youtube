package com.webtech.mybestyoutube.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.webtech.mybestyoutube.dao.VideoDAO;
import com.webtech.mybestyoutube.pojo.Video;

@Database(entities = {Video.class}, version = 1)
public abstract class VideoDatabase extends RoomDatabase {
    private static final String DB_NAME = "video.db";

    public static VideoDatabase getDb(Context context) {
        return Room.databaseBuilder(context, VideoDatabase.class, DB_NAME).allowMainThreadQueries().build();
    }

    public abstract VideoDAO videoDAO();
}
