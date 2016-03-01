package com.example.yinnan.interactivestory.UI;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yinnan.interactivestory.R;

public class StoryActivity extends AppCompatActivity {

    public static final String TAG = StoryActivity.class.getSimpleName();
    private TextView mStoryTextView;
    private ImageView mStoryImageView;
    private Button mChoice1Button, mChoice2Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        mStoryTextView = (TextView) findViewById(R.id.storyTextView);
        mStoryImageView = (ImageView) findViewById(R.id.storyImageView);
        mChoice1Button = (Button) findViewById(R.id.choice1Button);
        mChoice2Button = (Button) findViewById(R.id.choice2Button);

        Intent intent = getIntent();
        String userName = intent.getStringExtra(getString(R.string.key_name));
        //mDisplay.setText(userName);
        Log.d(TAG, "the user name is "+userName);
    }

}
