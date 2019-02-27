package com.example.listview_narwash;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        ImageView narw = (ImageView) findViewById(R.id.imageView);

        Animation myanim = AnimationUtils.loadAnimation(this, R.anim.fade_in);

        narw.startAnimation(myanim);

       openApp(true);

    }

    private void openApp(boolean locationPermission) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity
                        .this, Login.class);
                startActivity(intent);
                finish();
            }
        }, 2000);
    }

}
