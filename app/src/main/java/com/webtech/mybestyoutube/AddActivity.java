package com.webtech.mybestyoutube;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.webtech.mybestyoutube.database.VideoDatabase;
import com.webtech.mybestyoutube.pojo.Video;

public class AddActivity extends AppCompatActivity {

    private Spinner categorySpinner;
    private EditText title;
    private EditText creator;
    private EditText url;
    private Button addButton;
    private Button cancelButton;
    private AddActivity context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        initializeViews();

        addButton.setOnClickListener(v -> {
            Video video = new Video();
            video.setCategory(categorySpinner.getSelectedItem().toString());
            video.setTitle(title.getText().toString());
            video.setCreator(creator.getText().toString());
            video.setUrl(url.getText().toString());
            VideoDatabase.getDb(context).videoDAO().add(video);
            finish();
        });

        cancelButton.setOnClickListener(v -> {
            finish();
        });
    }

    private void initializeViews() {
        categorySpinner = findViewById(R.id.video_category);
        title = findViewById(R.id.video_title);
        creator = findViewById(R.id.video_creator);
        url = findViewById(R.id.video_url);
        addButton = findViewById(R.id.add_button);
        cancelButton = findViewById(R.id.cancel_button);
    }
}