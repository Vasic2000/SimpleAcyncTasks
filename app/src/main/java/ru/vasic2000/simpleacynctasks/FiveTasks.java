package ru.vasic2000.simpleacynctasks;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

public class FiveTasks extends AppCompatActivity {
    private ProgressBar mProgressBar1, mProgressBar2, mProgressBar3, mProgressBar4, mProgressBar5;
    MyAsyncTask asyncTask1, asyncTask2, asyncTask3, asyncTask4, asyncTask5;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fivetasks);

        mProgressBar1 = findViewById(R.id.progressBar1);
        mProgressBar2 = findViewById(R.id.progressBar2);
        mProgressBar3 = findViewById(R.id.progressBar3);
        mProgressBar4 = findViewById(R.id.progressBar4);
        mProgressBar5 = findViewById(R.id.progressBar5);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonStart:
                asyncTask1 = new MyAsyncTask(mProgressBar1);
                asyncTask1.execute();
                asyncTask2 = new MyAsyncTask(mProgressBar2);
                asyncTask2.execute();
                asyncTask3 = new MyAsyncTask(mProgressBar3);
                asyncTask3.execute();
                asyncTask4 = new MyAsyncTask(mProgressBar4);
                startAsyncTaskInParallel(asyncTask4);
                asyncTask5 = new MyAsyncTask(mProgressBar5);
                startAsyncTaskInParallel(asyncTask5);
                break;
            case R.id.back:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }

    public void startAsyncTaskInParallel(MyAsyncTask task) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB)
            task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        else
            task.execute();
    }
}