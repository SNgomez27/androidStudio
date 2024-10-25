package com.SNgomez27.first;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputLayout;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        Button logibutton = findViewById(R.id.botonLogin);
        Button registbutton = findViewById(R.id.botonRegist);
        TextInputLayout Usuarioo = findViewById(R.id.loginUsername);
        TextInputLayout contraseña = findViewById(R.id.loginContra);
        SharedPreferences preferences = getSharedPreferences("Usuario", Context.MODE_PRIVATE);
        logibutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String loginUsuario = String.valueOf(Usuarioo.getEditText().getText());
                String logincontraseña = String.valueOf(contraseña.getEditText().getText());
                String registerUsuario = preferences.getString("usasUsuario", "Anonimo");
                String registerContraseña = preferences.getString("usasContraseña", "Anonimo");
                if (!loginUsuario.equals(registerUsuario)){
                    Toast toastusuario = Toast.makeText(getApplicationContext(), "coloca un usuario", Toast.LENGTH_LONG);
                    toastusuario.show();
                }else if (!logincontraseña.equals(registerContraseña)){
                    Toast toastcontraseña = Toast.makeText(getApplicationContext(), "Contraseña equivocada", Toast.LENGTH_LONG);
                    toastcontraseña.show();
                } else {
                    launchActividad();
                }
            }
        });
        registbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launcResgistro();
            }
        });
    }
    public void launchActividad(){
        Intent intent = new Intent(Login.this,MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
    public void launcResgistro(){
        Intent intent = new Intent(Login.this,MainActivity.class);
        startActivity(intent);
    }
}