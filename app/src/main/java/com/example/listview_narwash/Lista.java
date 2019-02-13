package com.example.listview_narwash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

public class Lista extends AppCompatActivity {
    ListView lista;
    String [] [] datos = {
            {"Capilla","mazo guapa por el norte"},
            {"Lago","mazo hojas tu"},
            {"Lavanda","mazo morado todo"},
            {"Mar","mazo mojado el mar"},
            {"Montaña","mazo frio"},
            {"Pico","mazo pisos picados"},
            {"Puente","mazo levadizo"},
    };

    int [] datosImg = {R.drawable.capilla,R.drawable.lago,R.drawable.lavanda,R.drawable.mar,R.drawable.montana,R.drawable.pico,R.drawable.puente,};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       lista = (ListView) findViewById(R.id.milista);

        lista.setAdapter(new Adaptador(this,datos,datosImg));

    }
}
