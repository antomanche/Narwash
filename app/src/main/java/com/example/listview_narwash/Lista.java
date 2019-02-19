package com.example.listview_narwash;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Lista extends AppCompatActivity {
    ListView lista;
    ArrayList<Evento> lista_eventos;
    String [] [] datos = {
            {"Cala La Rijana","Entre las mejores playas de la Costa Tropical de Granada, a pesar de que se llega a ella a través de un corto túnel. Aislada y de pequeñas dimensiones, apenas unos 250 metros de una fina línea de arena oscura y bolos, disfruta de un mar azul y cristalino. Abrazada por las grandes rocas que llegan justo al mar, se caracteriza por las ruinas de una antigua torre vigía que brinda uno de los paisajes más reconocibles del litoral de la provincia. Carece por completo de equipamientos."},
            {"Playa de la Calahonda","Perteneciente al pequeño municipio de Motril, la de Calahonda es una de las playas favoritas de muchos veraneantes para disfrutar de la Costa Tropical en la provincia de Granada. Es una playa de arena gruesa y oscura y aguas trasparentes bastante grande bien equipada y con acceso adaptados. Hay que tener especial cuidado con los niños y personas que no sepan nadar ya que la entrada a la playa es abrupta. "},
            {"Playa de los Genoveses","Una bahía para un arenal de cine (por su belleza, pero también por haber sido escenario de numerosas películas). La playa de los Genoveses, en Almería, está formada por dunas de arena fina y dorada salpicadas por chumberas y pitas autóctonas. Es uno de los rincones más bellos del Parque Natural Cabo de Gata y, de hecho, acostumbra a aparecer siempre en la lista de las mejores playas de España. Está ubicada en el valle del Campillo del Genovés, un lugar sin apenas construcciones y sin carreteras asfaltadas que se conserva en su estado más puro. Se puede acceder andando desde el núcleo urbano de San José. Sus aguas nos reciben en un abrazo calmo. No cuenta con equipamiento ni su acceso está adaptado para personas con movilidad reducida."},
            {"Playa de los muertos","A pesar del nombre, para muchos, aquí se encuentra el agua más azul y cristalina de la zona de la provincia de Almería. Eso sí, no es fácil llegar... Precisamente por ello, Playa de los Muertos se mantiene libre de masificaciones. Es un arenal perfecto para practicar el naturismo. Que sus aguas sean cristalinas no significa que el baño sea familiar. Al contrario, con viento fuerte de levante, es una playa peligrosa. A pesar de todo ello, o por todo ello, la playa de los Muertos merece estar entre las mejores playas de Andalucía."},
            {"Playa el Playazo","Tan impresionante y extenso es este arenal virgen que los del lugar la llamaron así: el playazo. Sin duda, es una de las mejores playas de Andalucía. Es otra de las muchas opciones que tenemos para perdernos en el Parque Natural Cabo de Gata. Un kilómetro de arena fina en el entorno desértico de Almería. No es fácil acceder a esta belleza, pues hay que seguir un camino de 3 kilómetros que parte en los alrededores del municipio de Rodalquilar. Pero el esfuerzo vale la pena; además, durante en el paisaje del camino se encuentra la Torre de los Alumbres, de  estilo renacentista, construida en 1510 para la defensa del valle de Rodalquilar contra los piratas berberiscos."},
            {"Playa la Caletilla","Podemos decir que el municipio de Almuñécar es la capital de la Costa Tropical, que es como se conoce al litoral de la provincia de Granada. Cuenta con cerca de 20 kilómetros de costa, con cerca de una treintena de playas, entre la que destaca la Caletilla como una de las más apreciadas por los vecinos del lugar. Esta playa urbana de arena oscura y grava es una de las mejores de Andalucía, sobre todo para los que buscan un lugar tranquilo para disfrutar de un día en familia. "},
            {"Playa de Matalascañas","Esta es una de las playas más populares de la provincia de Huelva. Con ambiente familiar, se trata de una extensa playa de arena fina y blanca con algo más de cinco kilómetros de extensión. Lo que la convierte en una de las más grandes de la Costa de la Luz. Está dotada con diferentes instalaciones y con un paseo peatonal desde el que observar la Peña, o también la Piedra, que sobresale en su orilla. Se trata de la antigua Torre de la Higuera, que se encuentra así desde el fuerte maremoto de Lisboa en 1755. "},
    };

    int [] datosImg = {R.drawable.c_larijana,R.drawable.p_delacalahonda,R.drawable.p_delosgenoveses,R.drawable.p_delosmuertos,R.drawable.p_elplayazo,R.drawable.p_lacaletilla,R.drawable.p_matalascanas,};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = (ListView) findViewById(R.id.milista);
        TextView tvTitulo = findViewById(R.id.tvTitulo);

        lista.setAdapter(new Adaptador(this,lista_eventos,datosImg));

    }
}
