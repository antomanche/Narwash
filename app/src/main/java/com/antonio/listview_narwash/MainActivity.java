package com.antonio.listview_narwash;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
       openApp(true);
        ImageView imageView = findViewById(R.id.imageView);
       Animation animacion = AnimationUtils.loadAnimation(getApplicationContext(),
               R.anim.fade_out);
       imageView.startAnimation(animacion);

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
