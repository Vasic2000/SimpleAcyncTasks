package ru.vasic2000.simpleacynctasks;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.view.View;

import java.util.concurrent.TimeUnit;

class CatTask extends AsyncTask<Void, Integer, Void> {
    @SuppressLint("StaticFieldLeak")
    private final MainActivity mainActivity;

    public CatTask(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        mainActivity.mInfoTextView.setText("Кот полез на крышу");
        mainActivity.mStartButton.setVisibility(View.INVISIBLE);
    }

    @Override
    protected Void doInBackground(Void... voids) {
        try{
            int counter = 0;

            for(int i = 0; i < 14; i++){
                getFloor(counter);
                publishProgress(++counter);
            }
            TimeUnit.SECONDS.sleep(1);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        mainActivity.mInfoTextView.setText("Кот залез на крышу");
        mainActivity.mStartButton.setVisibility(View.VISIBLE);
        mainActivity.mHorizontalProgressBar.setProgress(14);
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        mainActivity.mInfoTextView.setText("Этаж: " + values[0]);
        mainActivity.mHorizontalProgressBar.setProgress(values[0]);
    }

    private void getFloor(int floor) throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
    }
}
