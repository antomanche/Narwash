package com.example.listview_narwash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class VisorImagen extends AppCompatActivity {
    String [] [] datos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visor_imagen);
        TextView tvTitulo = (TextView) findViewById(R.id.tvTituloseg);
        ImageView img = (ImageView) findViewById(R.id.imCompleta);

        Intent intent = getIntent();
        Bundle b = intent.getExtras();

        if(b!=null){
            img.setImageResource(b.getInt("IMG"));
        }
    }
}
