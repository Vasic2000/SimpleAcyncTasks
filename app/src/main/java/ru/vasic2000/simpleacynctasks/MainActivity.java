package ru.vasic2000.simpleacynctasks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView mInfoTextView;
    ProgressBar mProgressBar;
    Button mStartButton;
    ProgressBar mHorizontalProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mProgressBar = findViewById(R.id.progressBar);
        mInfoTextView = findViewById(R.id.text_info);
        mStartButton = findViewById(R.id.button_start);
        mHorizontalProgressBar = findViewById(R.id.mHorizontalProgressBar);
    }

    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.button_start:
                CatTask catTask = new CatTask(this);
                catTask.execute();
                break;
            case R.id.fiveTasks:
                Intent intent = new Intent(this, FiveTasks.class);
                startActivity(intent);
                finish();
                break;
        }
    }

}