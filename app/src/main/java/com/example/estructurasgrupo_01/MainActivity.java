package com.example.estructurasgrupo_01;

import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private final Button[][] botones = new Button[3][3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.tablero);

        for(int i = 0; i < 3; i++){
            for(int j = 0; j<3; j++){
                String idBoton = "btn" + i + j;
                int resID = getResources().getIdentifier(idBoton, "id", getPackageName());
                botones[i][j] = findViewById(R.id.tablero);

            }
        }




        

    }
}