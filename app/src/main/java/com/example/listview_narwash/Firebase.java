package com.example.listview_narwash;


import android.util.Log;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static android.support.constraint.Constraints.TAG;

public class Firebase {

   public static void grabarSaludo(){
        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();
        Evento e=new Evento("Cala la Rijana2",36.709641, -3.390952);
        myRef.child("Evento").push().setValue(e);
    }
    public static void recuperarDatos(){

        ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Get Post object and use the values to update the UI
                //Post post = dataSnapshot.getValue(Post.class);

                Iterable<DataSnapshot> lista=dataSnapshot.getChildren();
                int i=0;
                for (DataSnapshot e : lista) {
                    String clave=e.getKey();
                    Evento c = e.getValue(Evento.class);
                    Log.v("evento",clave+" "+c.getTitulo()+" "+c.getLatitud()+" "+c.getLongitud());

                    i++;
                }


                // ...
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
                // ...
            }
        };
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference().child("Evento");
        myRef.addValueEventListener(postListener);



    }
}
