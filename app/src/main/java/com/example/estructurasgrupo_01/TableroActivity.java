package com.example.estructurasgrupo_01;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import Game.Table;


public class TableroActivity extends AppCompatActivity {

    private Button btn00;
    private Button btn01;
    private Button btn02;
    private Button btn10;
    private Button btn11;
    private Button btn12;
    private Button btn20;
    private Button btn21;
    private Button btn22;
    private Table table;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tablero);

        // Instancia del tablero con el que se va a jugar
        table = new Table();


        btn00 = findViewById(R.id.btn_00);
        btn01 = findViewById(R.id.btn_01);
        btn02 = findViewById(R.id.btn_02);
        btn10 = findViewById(R.id.btn_10);
        btn11 = findViewById(R.id.btn_11);
        btn12 = findViewById(R.id.btn_12);
        btn20 = findViewById(R.id.btn_20);
        btn21 = findViewById(R.id.btn_21);
        btn22 = findViewById(R.id.btn_22);
    }
}
