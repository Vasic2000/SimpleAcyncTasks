package ru.vasic2000.simpleacynctasks;

import android.os.AsyncTask;
import android.os.SystemClock;
import android.widget.ProgressBar;

public class MyAsyncTask extends AsyncTask<Void, Integer, Void> {

    private ProgressBar mProgressBar;

    public MyAsyncTask(ProgressBar target) {
        mProgressBar = target;
    }

    @Override
    protected Void doInBackground(Void... params) {
        for (int i = 0; i < 100; i++) {
            publishProgress(i);
            SystemClock.sleep(100);
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        mProgressBar.setProgress(values[0]);
    }
}
