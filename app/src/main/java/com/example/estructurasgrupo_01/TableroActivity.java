package com.example.estructurasgrupo_01;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import Game.Table;
import TDA.Tree;

import java.util.Random;

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
    private String modo;
    private char simboloJugador;
    private char simboloMaquina;
    private int cont;
    private boolean empiezaMaquina;

    // El siguiente método sirve para personalizar el texto de la pantalla emergente
    private void mostrarResultado(String mensaje){

        LinearLayout panelResultado = findViewById(R.id.panelResultado);
        TextView txtResultado = findViewById(R.id.txtResultado);
        Button btnVolverMenu = findViewById(R.id.btnVolverMenu);

        txtResultado.setText(mensaje);

        btn00.setEnabled(false);
        btn01.setEnabled(false);
        btn02.setEnabled(false);
        btn10.setEnabled(false);
        btn11.setEnabled(false);
        btn12.setEnabled(false);
        btn20.setEnabled(false);
        btn21.setEnabled(false);
        btn22.setEnabled(false);

        panelResultado.setVisibility(View.VISIBLE);

        btnVolverMenu.setOnClickListener(v -> {
            finish();
        });
    }


    // Método para imágenes de las jugadas 

    private void mostrarSimbolo(int posx, int posy, char simbolo){

        ImageView icono = null;

        if(posx == 0 && posy == 0){

            if(simbolo == 'x') icono = findViewById(R.id.equis00);
            else icono = findViewById(R.id.circulo00);

        }else if(posx == 0 && posy == 1){

            if(simbolo == 'x') icono = findViewById(R.id.equis01);
            else icono = findViewById(R.id.circulo01);

        }else if(posx == 0 && posy == 2){

            if(simbolo == 'x') icono = findViewById(R.id.equis02);
            else icono = findViewById(R.id.circulo02);

        }else if(posx == 1 && posy == 0){

            if(simbolo == 'x') icono = findViewById(R.id.equis10);
            else icono = findViewById(R.id.circulo10);

        }else if(posx == 1 && posy == 1){

            if(simbolo == 'x') icono = findViewById(R.id.equis11);
            else icono = findViewById(R.id.circulo11);

        }else if(posx == 1 && posy == 2){

            if(simbolo == 'x') icono = findViewById(R.id.equis12);
            else icono = findViewById(R.id.circulo12);

        }else if(posx == 2 && posy == 0){

            if(simbolo == 'x') icono = findViewById(R.id.equis20);
            else icono = findViewById(R.id.circulo20);

        }else if(posx == 2 && posy == 1){

            if(simbolo == 'x') icono = findViewById(R.id.equis21);
            else icono = findViewById(R.id.circulo21);

        }else if(posx == 2 && posy == 2){

            if(simbolo == 'x') icono = findViewById(R.id.equis22);
            else icono = findViewById(R.id.circulo22);

        }

        if(icono != null) icono.setVisibility(View.VISIBLE);
    }

    // Método para mostrar líneas

    private void mostrarLineaVictoria(Table tabla){

        View icono = null;
        String tipo = tabla.getTipoVictoria();

        if (tipo.equals("f0")){

            icono = findViewById(R.id.filaVictoria0);
                                                                    
        }else if(tipo.equals("f1")){

            icono = findViewById(R.id.filaVictoria1);

        }else if(tipo.equals("f2")){

            icono = findViewById(R.id.filaVictoria2);

        }else if(tipo.equals("c0")){

            icono = findViewById(R.id.columnaVictoria0);

        }else if(tipo.equals("c1")){

            icono = findViewById(R.id.columnaVictoria1);

        }else if(tipo.equals("c2")){

            icono = findViewById(R.id.columnaVictoria2);

        }else if(tipo.equals("d0")){

            icono = findViewById(R.id.diagonalVictoria0);

        }else if(tipo.equals("d1")){

            icono = findViewById(R.id.diagonalVictoria1);

        }

        if(icono != null) icono.setVisibility(View.VISIBLE);

    }


    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tablero);
        modo = getIntent().getStringExtra("modo");


        // Instancia del tablero con el que se va a jugar
        table = new Table();




        if("1vsMaquina".equals(modo)) {

            FrameLayout panelConfiguracion = findViewById(R.id.panelConfiguracion);

            RadioButton opcionX = findViewById(R.id.opcionX);

            RadioButton opcionO = findViewById(R.id.opcionO);

            RadioButton opcionJugador = findViewById(R.id.opcionJugador);

            RadioButton opcionMaquina = findViewById(R.id.opcionMaquina);

            Button btnComenzar = findViewById(R.id.btnComenzar);


            btnComenzar.setOnClickListener(v -> {


                if(opcionX.isChecked()){

                    simboloJugador = 'x';
                    simboloMaquina = 'o';

                }else if(opcionO.isChecked()){

                    simboloJugador = 'o';
                    simboloMaquina = 'x';

                }else{
                    return;
                }

                if(opcionJugador.isChecked()){

                    empiezaMaquina = false;

                }else if(opcionMaquina.isChecked()){

                    empiezaMaquina = true;

                }else{
                    return;
                }


                panelConfiguracion.setVisibility(View.GONE);

                if (empiezaMaquina) {

                    Tree<Table> aux = new Tree<>(table);

                    Table tableroNuevo =
                            aux.mejorJugada(simboloMaquina, simboloJugador);

                    int[] coord =
                            Table.obtenerPosicionJugada(table, tableroNuevo, simboloMaquina);
                    if (coord != null) {
                        table.insert(coord[0], coord[1], simboloMaquina);
                        mostrarSimbolo(coord[0], coord[1], simboloMaquina);

                    }
                }

            });



            // Obtener botones
            btn00 = findViewById(R.id.btn_00);
            btn01 = findViewById(R.id.btn_01);
            btn02 = findViewById(R.id.btn_02);
            btn10 = findViewById(R.id.btn_10);
            btn11 = findViewById(R.id.btn_11);
            btn12 = findViewById(R.id.btn_12);
            btn20 = findViewById(R.id.btn_20);
            btn21 = findViewById(R.id.btn_21);
            btn22 = findViewById(R.id.btn_22);


            // Un solo ClickListener para todos los botones
            View.OnClickListener listener = v -> {

                boolean jugadaValida = false;

                // TURNO DEL JUGADOR
                if (v.getId() == R.id.btn_00) {

                    jugadaValida = table.insert(0, 0, simboloJugador);

                    if(!jugadaValida) return;

                    mostrarSimbolo(0, 0, simboloJugador);

                } else if (v.getId() == R.id.btn_01) {
                    jugadaValida = table.insert(0, 1, simboloJugador);

                    if(!jugadaValida) return;

                    mostrarSimbolo(0, 1, simboloJugador);


                } else if (v.getId() == R.id.btn_02) {
                    jugadaValida = table.insert(0, 2, simboloJugador);

                    if(!jugadaValida) return;

                    mostrarSimbolo(0, 2, simboloJugador);


                } else if (v.getId() == R.id.btn_10) {
                    jugadaValida = table.insert(1, 0, simboloJugador);

                    if(!jugadaValida) return;

                    mostrarSimbolo(1, 0, simboloJugador);

                } else if (v.getId() == R.id.btn_11) {
                    jugadaValida = table.insert(1, 1, simboloJugador);

                    if(!jugadaValida) return;

                    mostrarSimbolo(1, 1, simboloJugador);

                } else if (v.getId() == R.id.btn_12) {
                    jugadaValida = table.insert(1, 2, simboloJugador);

                    if(!jugadaValida) return;

                    mostrarSimbolo(1, 2, simboloJugador);

                } else if (v.getId() == R.id.btn_20) {
                    jugadaValida = table.insert(2, 0, simboloJugador);

                    if(!jugadaValida) return;

                    mostrarSimbolo(2, 0, simboloJugador);

                } else if (v.getId() == R.id.btn_21) {
                    jugadaValida = table.insert(2, 1, simboloJugador);

                    if(!jugadaValida) return;

                    mostrarSimbolo(2, 1, simboloJugador);


                } else if (v.getId() == R.id.btn_22) {
                    jugadaValida = table.insert(2, 2, simboloJugador);

                    if(!jugadaValida) return;

                    mostrarSimbolo(2, 2, simboloJugador);

                }


                // Verificar si el jugador terminó la partida
                if (table.isWinner(simboloJugador)) {
                    mostrarLineaVictoria(table);
                    mostrarResultado("¡Felicidades!");
                    return;
                }

                if (table.isDraw()) {
                    mostrarResultado("Empate...");
                    return;
                }


                // TURNO DE LA MÁQUINA
                Tree<Table> aux = new Tree<>(table);

                Table tableroNuevo = aux.mejorJugada(simboloMaquina, simboloJugador);

                int[] coord = Table.obtenerPosicionJugada(table, tableroNuevo, simboloMaquina);

                if (coord != null) {
                    table.insert(coord[0], coord[1], simboloMaquina);
                    mostrarSimbolo(coord[0], coord[1], simboloMaquina);
                }

                // Verificar si la máquina terminó la partida
                if (table.isWinner(simboloMaquina)) {
                    mostrarLineaVictoria(table);
                    mostrarResultado("¡Oops! Perdiste ante el mejor.");
                    return;
                }

                if (table.isDraw()) {
                    mostrarResultado("EMPATEEEE");
                }
            };


            // Asignar el mismo listener a los 9 botones
            btn00.setOnClickListener(listener);
            btn01.setOnClickListener(listener);
            btn02.setOnClickListener(listener);
            btn10.setOnClickListener(listener);
            btn11.setOnClickListener(listener);
            btn12.setOnClickListener(listener);
            btn20.setOnClickListener(listener);
            btn21.setOnClickListener(listener);
            btn22.setOnClickListener(listener);







        }else if("1vs1".equals(modo)){

            // Obtener botones
            btn00 = findViewById(R.id.btn_00);
            btn01 = findViewById(R.id.btn_01);
            btn02 = findViewById(R.id.btn_02);
            btn10 = findViewById(R.id.btn_10);
            btn11 = findViewById(R.id.btn_11);
            btn12 = findViewById(R.id.btn_12);
            btn20 = findViewById(R.id.btn_20);
            btn21 = findViewById(R.id.btn_21);
            btn22 = findViewById(R.id.btn_22);

            simboloJugador = 'x';
            cont = 0;

            // Un solo ClickListener para todos los botones
            View.OnClickListener listener = v -> {

                boolean jugadaValida = false;

                // TURNO DEL JUGADOR
                if (v.getId() == R.id.btn_00) {

                    jugadaValida = table.insert(0, 0, simboloJugador);

                    if(!jugadaValida) return;

                    mostrarSimbolo(0, 0, simboloJugador);

                } else if (v.getId() == R.id.btn_01) {
                    jugadaValida = table.insert(0, 1, simboloJugador);

                    if(!jugadaValida) return;

                    mostrarSimbolo(0, 1, simboloJugador);


                } else if (v.getId() == R.id.btn_02) {
                    jugadaValida = table.insert(0, 2, simboloJugador);

                    if(!jugadaValida) return;

                    mostrarSimbolo(0, 2, simboloJugador);


                } else if (v.getId() == R.id.btn_10) {
                    jugadaValida = table.insert(1, 0, simboloJugador);

                    if(!jugadaValida) return;

                    mostrarSimbolo(1, 0, simboloJugador);

                } else if (v.getId() == R.id.btn_11) {
                    jugadaValida = table.insert(1, 1, simboloJugador);

                    if(!jugadaValida) return;

                    mostrarSimbolo(1, 1, simboloJugador);

                } else if (v.getId() == R.id.btn_12) {
                    jugadaValida = table.insert(1, 2, simboloJugador);

                    if(!jugadaValida) return;

                    mostrarSimbolo(1, 2, simboloJugador);

                } else if (v.getId() == R.id.btn_20) {
                    jugadaValida = table.insert(2, 0, simboloJugador);

                    if(!jugadaValida) return;

                    mostrarSimbolo(2, 0, simboloJugador);

                } else if (v.getId() == R.id.btn_21) {
                    jugadaValida = table.insert(2, 1, simboloJugador);

                    if(!jugadaValida) return;

                    mostrarSimbolo(2, 1, simboloJugador);


                } else if (v.getId() == R.id.btn_22) {
                    jugadaValida = table.insert(2, 2, simboloJugador);

                    if(!jugadaValida) return;

                    mostrarSimbolo(2, 2, simboloJugador);

                }

                String mensaje;
                if(cont%2 == 0) mensaje = "¡Felicidades, jugador 'X'!";
                else mensaje = "¡Felicidades, jugador 'O'!";


                // Verificar si el jugador terminó la partida
                if (table.isWinner(simboloJugador)) {

                    mostrarLineaVictoria(table);
                    mostrarResultado(mensaje);
                    return;
                }

                if (table.isDraw()) {
                    mostrarResultado("Empate...");
                    return;
                }

                cont++;

                if(cont%2 == 0) simboloJugador = 'x';
                else simboloJugador = 'o';

            };


            // Asignar el mismo listener a los 9 botones
            btn00.setOnClickListener(listener);
            btn01.setOnClickListener(listener);
            btn02.setOnClickListener(listener);
            btn10.setOnClickListener(listener);
            btn11.setOnClickListener(listener);
            btn12.setOnClickListener(listener);
            btn20.setOnClickListener(listener);
            btn21.setOnClickListener(listener);
            btn22.setOnClickListener(listener);

            
        }




    }
}



































