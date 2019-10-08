package com.hfad.stopwatch;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

public class StopwatchActivity extends Activity {

    boolean running=false;
    boolean wasrunning=false;
    int seconds=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch);
        if(savedInstanceState != null)
        {
            seconds=savedInstanceState.getInt("seconds");
            running=savedInstanceState.getBoolean("running");
            wasrunning=savedInstanceState.getBoolean("wasrunning");
        }
        runTimer();
    }
    @Override
    public void onSaveInstanceState(Bundle x)  {
        x.putInt("seconds",seconds);
        x.putBoolean("running",running);
        x.putBoolean("wasrunning",wasrunning);
    }
    /*@Override
    protected void onStop()  {
        super.onStop();
        wasrunning=running;
        running=false;
    }
    @Override
    protected void onRestart()  {
        super.onStart();
        if(wasrunning)  {
            running = true;
        }
    }*/
    @Override
    protected void onPause()  {
        super.onPause();
        wasrunning=running;
        running=false;
    }
    @Override
    protected void onResume()  {
        super.onResume();
        if (wasrunning) {
            running=true;
        }
    }

    public void onClickStart(View  view)  {
        running=true;
    }

    public void onClickStop(View view)  {
        running=false;
    }

    public void onClickReset(View view)  {
        running=false;
        seconds=0;
    }

    private void runTimer()  {
        final TextView timeView = (TextView) findViewById(R.id.time_view);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds/3600;
                int minutes = (seconds%3600)/60;
                int sec= seconds%60;
                String time = String.format(Locale.getDefault(), "%d:%02d:%02d",hours,minutes,sec);
                timeView.setText(time);
                if (running) {
                    seconds++;
                }
                handler.postDelayed(this,1000);
            }
        });
    }
}
