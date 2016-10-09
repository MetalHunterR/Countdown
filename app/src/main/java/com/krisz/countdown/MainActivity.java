package com.krisz.countdown;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;

// API 19+ needed
//import java.util.Objects;

public class MainActivity extends Activity {

    protected static final int MILLIS_PER_SECOND = 1000;
    protected static final int SECONDS_TO_COUNTDOWN = 30;
    protected TextView countDownNumber;
    protected CountDownTimer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countDownNumber = (TextView) findViewById(R.id.numberTxt);

        countDownNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    timer = new CountDownTimer(SECONDS_TO_COUNTDOWN * MILLIS_PER_SECOND, MILLIS_PER_SECOND) {
                        @Override
                        public void onTick(long millisUntilFinished) {
                            // API 19+ needed
                            //String time = Objects.toString(millisUntilFinished / MILLIS_PER_SECOND);
                            countDownNumber.setText(Long.toString( millisUntilFinished / MILLIS_PER_SECOND));
                        }

                        @Override
                        public void onFinish() {
                            countDownNumber.setText("Finished!");
                        }
                    }.start();
                }
                catch (NumberFormatException e) {
                }
            }
        });
    }
}
