package Game;

public class Table {

    private char[][] elements;

    public Table(){
        this.elements =  new char[3][3];
    }

    public boolean insert(int posX, int posY, char tipoJugador){

        // Si ya está ocupada...
        if(elements[posX][posY] != '\u0000') return false;

        // Si no está ocupada
        elements[posX][posY] = tipoJugador;
        return true;

    }


    public boolean isFull(){
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                // Si un elemento está vacío, entonces no está lleno
                if(elements[i][j] == '\u0000') return false;
            }
        }
        return true;
    }

    public boolean isWinner(char symbol){

        // Verificación de filas
        for(int i=0; i<3; i++){
            if(elements[i][0]==symbol &&
                    elements[i][1]==symbol &&
                    elements[i][2]==symbol) return true;
        }

        // Verificación de columnas
        for(int j=0; j<3; j++){
            if(elements[0][j]==symbol &&
                    elements[1][j]==symbol &&
                    elements[2][j]==symbol) return true;
        }

        // Diagonales

        // Principal
        if(elements[0][0]==symbol &&
                elements[1][1]==symbol &&
                elements[2][2]==symbol) return true;

        // Alterna
        if(elements[0][2]==symbol &&
                elements[1][1]==symbol &&
                elements[2][0]==symbol) return true;

        // Caso contrario
        return false;

    }


    // El empate se da cuando está lleno y ninguno gana, así que ese debe ser el retorno
    public boolean isDraw(){
        return isFull() && !isWinner('x') && !isWinner('o');
    }



}
