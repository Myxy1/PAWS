package com.example.paws;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class LoadingActivity extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 4000; //A betöltési időt itt lehet beállítani.
    private ImageView textViewLoading;
    private Animation fade_in, fade_out, bounce;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        textViewLoading.startAnimation(bounce);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(LoadingActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        },SPLASH_TIME_OUT);
    }

    public void init()
    {
        textViewLoading = (ImageView) findViewById(R.id.imageViewLoading);
        fade_in = AnimationUtils.loadAnimation(LoadingActivity.this,R.anim.fade_in);
        fade_out = AnimationUtils.loadAnimation(LoadingActivity.this,R.anim.fade_out);
        bounce = AnimationUtils.loadAnimation(LoadingActivity.this,R.anim.bounce);
    }
}
