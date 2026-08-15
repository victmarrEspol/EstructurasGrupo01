package com.example.estructurasgrupo_01;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {

    private Button modo1vs1;
    private Button modo1vsMaquina;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        modo1vs1 = findViewById(R.id.modo1vs1);
        modo1vsMaquina = findViewById(R.id.modo1vsMaquina);
    }
}
