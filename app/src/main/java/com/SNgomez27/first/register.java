package com.SNgomez27.first;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.health.connect.datatypes.units.Length;
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

public class register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        TextInputLayout usuario = findViewById(R.id.registerUsername);
        TextInputLayout contraseñaA = findViewById(R.id.registerContra);
        TextInputLayout contraseñaB = findViewById(R.id.registerContraRepit);
        Button regisBoton = findViewById(R.id.botonRegist);

        regisBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String useUsario = String.valueOf(usuario.getEditText().getText());
                String useContraseña = String.valueOf(contraseñaA.getEditText().getText());
                String useContraseñaB = String.valueOf(contraseñaB.getEditText().getText());
                if (!useContraseña.equals(useContraseñaB)){
                    Toast toastContra = Toast.makeText(getApplicationContext(),"Contraseña equivocada",Toast.LENGTH_LONG);
                    toastContra.show();
                } else if (useUsario.equals("")) {
                    Toast toastUser = Toast.makeText(getApplicationContext(),"Coloca un usuario", Toast.LENGTH_LONG);
                    toastUser.show();
                } else {
                    Toast confirmado = Toast.makeText(getApplicationContext(), "Te has registrado con exito :)", Toast.LENGTH_SHORT);
                    confirmado.show();
                    SharedPreferences preferences = getSharedPreferences("Usuario",Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("useUsuario", useUsario);
                    editor.putString("useContraseña", useContraseña);
                    editor.putString("useContraseñaB", useContraseñaB);
                    editor.apply();
                    launchActividad();


                }
            }
        });
    }
    public void launchActividad(){
        Intent intent = new Intent(register.this, Login.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}