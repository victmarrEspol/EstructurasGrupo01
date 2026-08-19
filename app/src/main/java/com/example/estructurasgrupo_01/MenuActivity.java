package com.example.estructurasgrupo_01;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.activity.EdgeToEdge;

public class MenuActivity extends AppCompatActivity {

    private Button modo1vs1;
    private Button modo1vsMaquina;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.menu);

        modo1vs1 = findViewById(R.id.modo1vs1); // Captura el click

        modo1vs1.setOnClickListener(v -> { //Cambio de actividad (pantalla)
            Intent intent = new Intent(MenuActivity.this, TableroActivity.class);
            intent.putExtra("modo", "1vs1"); // Enviar información de qué modalidad se ha elegido
            startActivity(intent);
        });


        modo1vsMaquina = findViewById(R.id.modo1vsMaquina); // Captura el click

        modo1vsMaquina.setOnClickListener(v -> { //Cambio de actividad (pantalla)
            Intent intent = new Intent(MenuActivity.this, TableroActivity.class);
            intent.putExtra("modo", "1vsMaquina"); // Enviar información de qué modalidad se ha elegido
            startActivity(intent);
        });


    }
}
