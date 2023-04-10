package com.webtech.mybestyoutube;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.webtech.mybestyoutube.database.VideoDatabase;
import com.webtech.mybestyoutube.pojo.Video;
import com.webtech.mybestyoutube.pojo.VideoAdapter;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String KEY_INDEX = "key_index";
    public Context context;
    public RecyclerView YoutubeVideoList;

    @Override
    protected void onStart() {
        super.onStart();
        MainActivity.YoutubeVideoAsyncTask youtubeVideoAsyncTasks = new MainActivity.YoutubeVideoAsyncTask();
        youtubeVideoAsyncTasks.execute();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = getApplicationContext();

        YoutubeVideoList = findViewById(R.id.list);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
        YoutubeVideoList.setHasFixedSize(true);
        YoutubeVideoList.setLayoutManager(layoutManager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add:
                Intent intent = new Intent(context, AddActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public class YoutubeVideoAsyncTask extends AsyncTask<Nullable, Nullable, List<Video>> {
        @Override
        protected List<Video> doInBackground(Nullable... nullables) {
            List<Video> youtubeVideoList = VideoDatabase.getDb(context).videoDAO().list();

            return youtubeVideoList;
        }
        @Override
        protected void onPostExecute(List<Video> youtubeVideoList) {
            VideoAdapter youtubeVideoAdapter = new VideoAdapter(youtubeVideoList, new VideoAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(Video item) {
                    Context context = getApplicationContext();
                    Intent intent = new Intent(context, DetailActivity.class);
                    intent.putExtra(KEY_INDEX, item.getId());
                    startActivity(intent);
                }
            });
            YoutubeVideoList.setAdapter(youtubeVideoAdapter);
        }
    }
}