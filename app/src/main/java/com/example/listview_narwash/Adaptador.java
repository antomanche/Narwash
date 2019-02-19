package com.example.listview_narwash;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Adaptador extends BaseAdapter {

    private static LayoutInflater inflater = null;

    Context  contexto;

    ArrayList<Evento> lista_eventos;
    int[] datosImg;

    public Adaptador(Context contexto, ArrayList<Evento> lista_eventos, int [] imagenes){
        this.contexto = contexto;
        this.lista_eventos = lista_eventos;
        this.datosImg = imagenes;
        inflater = (LayoutInflater)contexto.getSystemService(contexto.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {

        final View vista = inflater.inflate(R.layout.elemento_lista2,null);
        //TextView descripcion = (TextView) vista.findViewById(R.id.tvDescripcion);
        TextView titulo = (TextView) vista.findViewById(R.id.tvTitulo);

        ImageView imagen = (ImageView) vista.findViewById(R.id.imagecapilla);
        titulo.setText(lista_eventos.get(i).getTitulo());
       // descripcion.setText(datos [i] [1]);
        imagen.setImageResource(datosImg[i]);

        imagen.setTag(i);
        imagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent visorImagen = new Intent(contexto, VisorImagen.class);
                visorImagen.putExtra("IMG", datosImg[(Integer)v.getTag()]);
                contexto.startActivity(visorImagen);
            }
        });


        return vista;
    }

    @Override
    public int getCount() {
        return datosImg.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


}
