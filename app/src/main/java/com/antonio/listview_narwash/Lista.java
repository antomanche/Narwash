package com.antonio.listview_narwash;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Lista extends AppCompatActivity {
    ListView listavista;
    ArrayList<Evento> lista_eventos;
    TextView titulo;
    int [] datosImg = {R.drawable.c_larijana,R.drawable.p_delacalahonda,R.drawable.p_delosgenoveses,R.drawable.p_delosmuertos,R.drawable.p_elplayazo,R.drawable.p_lacaletilla,R.drawable.p_matalascanas,};
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recuperarTitulos();
        listavista = (ListView) findViewById(R.id.milista);
        TextView tvTitulo = findViewById(R.id.tvTitulo);
        listavista.setAdapter(new Adaptador(this,lista_eventos,datosImg));
        context = this;

    }
    public  void recuperarTitulos(){
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference("Evento");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
               Iterable<DataSnapshot> lista=dataSnapshot.getChildren();
               ArrayList <Evento> lista_eventosinterno = new ArrayList<Evento>();
                for (DataSnapshot d:lista) {
                    Evento evento = d.getValue(Evento.class);
                    Log.v("Evento", evento.getTitulo());
                    //rellenar un arraylist de objetos evento

                    lista_eventosinterno.add(evento);
                }
                //pasar arraylist al Adaptador del listview
                listavista.setAdapter(new Adaptador(context,lista_eventosinterno,datosImg));

                /*String titulotv = evento.getTitulo();
                titulo = (TextView) findViewById(R.id.tvTitulo);
                titulo.setText(titulotv);*/
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }

        });
    }
}
