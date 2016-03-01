package com.example.yinnan.interactivestory.UI;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.example.yinnan.interactivestory.R;

public class StoryActivity extends AppCompatActivity {

    public static final String TAG = StoryActivity.class.getSimpleName();
    private TextView mDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        Intent intent = getIntent();
        String userName = intent.getStringExtra(getString(R.string.key_name));
        //mDisplay.setText(userName);
        Log.d(TAG, "the user name is "+userName);
    }

}
