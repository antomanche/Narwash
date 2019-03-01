package com.antonio.listview_narwash;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class VisorImagen extends AppCompatActivity {
    Button boton;
    TextView tvDescr;
    TextView tvTitulo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visor_imagen);

        boton = (Button) findViewById(R.id.botonlocalizacion);
        tvDescr = (TextView) findViewById(R.id.tvDescripcion);
        tvTitulo = (TextView) findViewById(R.id.tvTituloseg);
        ImageView img = (ImageView) findViewById(R.id.imCompleta);
        View.OnClickListener oyente_localizacion = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intencion = new Intent(getApplication(), MapsActivity.class);
                startActivity(intencion);
            }
        };boton.setOnClickListener(oyente_localizacion);
        Intent intent = getIntent();
        Bundle b = intent.getExtras();

        if(b!=null){
            img.setImageResource(b.getInt("IMG"));
        }

    }



    public  void recuperarInformacion(){
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference();

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Evento evento = dataSnapshot.getValue(Evento.class);
                String titulotv = evento.getTitulo();
                String descripciontv = evento.getDescripcion();
                tvDescr = (TextView) findViewById(R.id.tvDescripcion);
                tvTitulo = (TextView) findViewById(R.id.tvTituloseg);
                tvDescr.setText(descripciontv);
                tvTitulo.setText(titulotv);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }

        });
    }
}
