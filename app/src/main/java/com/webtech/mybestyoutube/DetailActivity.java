package com.webtech.mybestyoutube;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.webtech.mybestyoutube.database.VideoDatabase;
import com.webtech.mybestyoutube.pojo.Video;

public class DetailActivity extends AppCompatActivity {
    private Context context;
    private TextView Title;
    private TextView Category;
    private TextView YTCreator;
    private Video youtubeVideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);
        context = getApplicationContext();

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        Long id = (Long)intent.getSerializableExtra(MainActivity.KEY_INDEX);

        youtubeVideo = VideoDatabase.getDb(context).videoDAO().find(id);

        Title = findViewById(R.id.title);
        Category = findViewById(R.id.category);
        YTCreator = findViewById(R.id.creator);

        Title.setText(youtubeVideo.title);
        Category.setText(youtubeVideo.category);
        YTCreator.setText(youtubeVideo.creator);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
