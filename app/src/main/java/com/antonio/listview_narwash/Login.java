
package com.antonio.listview_narwash;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class Login extends AppCompatActivity {
    TextView mytitle;
    LinearLayout linerlayout;
    EditText TextEmail;
    EditText TextPassword;
    Button btnRegistrar, btnLogin;
    private ProgressDialog progressDialog;

    Context contexto;

    //Declaramos un objeto firebaseAuth
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_in);
        contexto = this;
        //inicializamos el objeto firebaseAuth
        firebaseAuth = FirebaseAuth.getInstance();


        mytitle = findViewById(R.id.mytitle);
        linerlayout = findViewById(R.id.linearLayout);

        TextEmail = findViewById(R.id.TxtEmail);
        TextPassword = findViewById(R.id.TxtPassword);

        btnRegistrar = findViewById(R.id.BtnRegistrar);
        btnLogin = (Button) findViewById(R.id.BtnLogin);

        progressDialog = new ProgressDialog(this);

        //asociamos un oyente al evento clic del botón
        View.OnClickListener oyente_registrar=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrarUsuario();
            }

        };
        View.OnClickListener oyente_login=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loguearUsuario();
                /*lista = (ListView) findViewById(R.id.milista);

                lista.setAdapter(new Adaptador(contexto,datos,datosImg));*/
            }

        };
        btnRegistrar.setOnClickListener(oyente_registrar);
        btnLogin.setOnClickListener(oyente_login);

    }

    private void registrarUsuario() {

        //Obtenemos el email y la contraseña desde las cajas de texto
        String email = TextEmail.getText().toString().trim();
        String password = TextPassword.getText().toString().trim();

        //Verificamos que las cajas de texto no esten vacías
        if (TextUtils.isEmpty(email)) {//(precio.equals(""))
            Toast.makeText(this, "Se debe ingresar un email", Toast.LENGTH_LONG).show();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Falta ingresar la contraseña", Toast.LENGTH_LONG).show();
            return;
        }


        progressDialog.setMessage("Realizando registro en linea...");
        progressDialog.show();

        //registramos un nuevo usuario
        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //checking if success
                        if (task.isSuccessful()) {

                            Toast.makeText(Login.this, "Se ha registrado el usuario con el email: " + TextEmail.getText(), Toast.LENGTH_LONG).show();
                        } else {
                            if (task.getException() instanceof FirebaseAuthUserCollisionException) {//si se presenta una colisión
                                Toast.makeText(Login.this, "Ese usuario ya existe ", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(Login.this, "No se pudo registrar el usuario ", Toast.LENGTH_LONG).show();
                            }
                        }
                        progressDialog.dismiss();
                    }
                });

    }

    private void loguearUsuario() {
        //Obtenemos el email y la contraseña desde las cajas de texto
        final String email = TextEmail.getText().toString().trim();
        String password = TextPassword.getText().toString().trim();

        //Verificamos que las cajas de texto no esten vacías
        if (TextUtils.isEmpty(email)) {//(precio.equals(""))
            Toast.makeText(this, "Se debe ingresar un email", Toast.LENGTH_LONG).show();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Falta ingresar la contraseña", Toast.LENGTH_LONG).show();
            return;
        }


        progressDialog.setMessage("Realizando consulta en linea...");
        progressDialog.show();

        //loguear usuario
        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //checking if success
                        if (task.isSuccessful()) {
                            //Firebase.grabarSaludo();
                            Firebase.recuperarDatos();
                            int pos = email.indexOf("@");
                            String user = email.substring(0, pos);
                            Toast.makeText(Login.this, "Bienvenido: " + TextEmail.getText(), Toast.LENGTH_LONG).show();
                            Intent intencion = new Intent(getApplication(), Lista.class);
                            startActivity(intencion);


                        } else {
                            if (task.getException() instanceof FirebaseAuthUserCollisionException) {//si se presenta una colisión
                                Toast.makeText(Login.this, "Ese usuario ya existe ", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(Login.this, "No se pudo registrar el usuario ", Toast.LENGTH_LONG).show();
                            }
                        }
                        progressDialog.dismiss();
                    }
                });


    }



    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.BtnRegistrar:
                //Invocamos al método:
                registrarUsuario();
                break;
            case R.id.BtnLogin:
                loguearUsuario();
                break;
        }


    }
}

