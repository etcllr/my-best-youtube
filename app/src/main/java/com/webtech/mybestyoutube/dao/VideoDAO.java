package com.webtech.mybestyoutube.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.webtech.mybestyoutube.pojo.Video;
import java.util.List;

@Dao
public interface VideoDAO {

    @Query("SELECT * FROM video WHERE id = :id")
    public Video find(Long id);

    @Query("SELECT * FROM video")
    public List<Video> list();

    @Insert
    public void add(Video... video);

    @Update
    public void update(Video... video);

    @Delete
    public void delete(Video... video);


}
