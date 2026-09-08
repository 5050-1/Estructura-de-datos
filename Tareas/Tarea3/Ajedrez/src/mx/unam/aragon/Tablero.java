package mx.unam.aragon;

public class Tablero {
    private Array2D<String> tablero;

    public Tablero() {
         tablero = new Array2D<>(8,8);
         inicializar();
    }

    public void inicializar() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (i == 1) {
                    tablero.setElemento(i,j,"\u265F");
                } else if (i == 6) {
                    tablero.setElemento(i,j,"\u2659");
                } else if (i == 0) {
                    tablero.setElemento(i,j, piezaInicial(j,true));
                } else if (i == 7) {
                    tablero.setElemento(i,j,piezaInicial(j,false));
                } else {
                    tablero.setElemento(i,j," ");
                }
            }
        }
    }
    public String piezaInicial (int columnas, boolean negras) {
        switch (columnas) {
            case 0: case 7: return negras ? "\u265C" : "\u2656";
            case 1: case 6: return negras ? "\u265E" : "\u2658";
            case 2: case 5: return negras ? "\u265D" : "\u2657";
            case 3: return negras ? "\u265B" : "\u2655";
            case 4: return negras ? "\u265A" : "\u2654";
            default: return " ";
        }
    }
    public void imprimir() {
        for (int i = 0; i < tablero.getFilas(); i++) {
            for (int j = 0; j < tablero.getColumnas(); j++){
                System.out.print(tablero.getElemento(i,j) + " ");
            }
            System.out.println();
        }
    }
}
