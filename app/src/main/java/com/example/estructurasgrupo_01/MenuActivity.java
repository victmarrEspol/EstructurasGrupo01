package com.example.estructurasgrupo_01;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.activity.EdgeToEdge;

public class MenuActivity extends AppCompatActivity {
    /*
    private final Button[][] botones = new Button[3][3];
    for(int i = 0; i < 3; i++){
        for(int j = 0; j<3; j++){
            String idBoton = "btn" + i + j;
            int resID = getResources().getIdentifier(idBoton, "id", getPackageName());
            botones[i][j] = findViewById(R.id.tablero);

        }
    }
    */

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
