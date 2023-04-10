package com.webtech.mybestyoutube.pojo;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class Video implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private long id;
    @ColumnInfo(name = "title")
    public String title;
    @ColumnInfo(name = "creator")
    public String creator;
    @ColumnInfo(name = "url")
    public String url;
    @ColumnInfo(name = "category")
    public String category;

    public Video() {
    }

    public Video(long id, String title, String creator, String url, String category) {
        this.id = id;
        this.title = title;
        this.creator = creator;
        this.url = url;
        this.category = category;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
