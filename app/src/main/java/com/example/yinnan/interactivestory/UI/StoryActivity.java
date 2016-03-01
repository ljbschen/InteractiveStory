package com.example.yinnan.interactivestory.UI;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yinnan.interactivestory.Models.Page;
import com.example.yinnan.interactivestory.Models.Story;
import com.example.yinnan.interactivestory.R;

public class StoryActivity extends AppCompatActivity {

    public static final String TAG = StoryActivity.class.getSimpleName();
    private TextView mStoryTextView;
    private ImageView mStoryImageView;
    private Button mChoice1Button, mChoice2Button;
    private Story mStory = new Story();
    private Page mCurrentPage;
    private String mUserName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        mStoryTextView = (TextView) findViewById(R.id.storyTextView);
        mStoryImageView = (ImageView) findViewById(R.id.storyImageView);
        mChoice1Button = (Button) findViewById(R.id.choice1Button);
        mChoice2Button = (Button) findViewById(R.id.choice2Button);

        Intent intent = getIntent();
        mUserName = intent.getStringExtra(getString(R.string.key_name));
        //update the page
        loadPage(0);
    }

    private void loadPage(int pageNumber) {
        mCurrentPage = mStory.getPage(pageNumber);
        String pageText = mCurrentPage.getText();
        pageText = String.format(pageText, mUserName);
        mStoryTextView.setText(pageText);
        mStoryImageView.setImageResource(mCurrentPage.getImageId());

        if (mCurrentPage.isFinal()) {
            mChoice1Button.setVisibility(View.INVISIBLE);
            mChoice2Button.setText("Play Again!");
            mChoice2Button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }
        else {
            mChoice1Button.setText(mCurrentPage.getChoice1().getText());
            mChoice2Button.setText(mCurrentPage.getChoice2().getText());
            mChoice1Button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    loadPage(mCurrentPage.getChoice1().getNextPage());
                }
            });
            mChoice2Button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    loadPage(mCurrentPage.getChoice2().getNextPage());
                }
            });
        }
    }

}
