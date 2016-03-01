package com.example.yinnan.interactivestory.UI;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.yinnan.interactivestory.R;

public class MainActivity extends AppCompatActivity {

    private EditText mNameEditText;
    private Button mStartButton;
    private String mUserName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNameEditText = (EditText) findViewById(R.id.nameEditText);
        mStartButton = (Button) findViewById(R.id.startButton);

        mStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUserName = mNameEditText.getText().toString();
                startStory(mUserName);
            }
        });
    }

    private void startStory(String userName) {
        Intent intent = new Intent(MainActivity.this, StoryActivity.class);
        intent.putExtra(getString(R.string.key_name), userName);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mNameEditText.setText("");
    }
}
