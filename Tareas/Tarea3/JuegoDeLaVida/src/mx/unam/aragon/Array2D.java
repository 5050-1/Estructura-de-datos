package mx.unam.aragon;

public class Array2D <T> {
    private int filas;
    private int columnas;
    private Object[][] datos;

    public Array2D(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        this.datos = new Object[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                datos[i][j] = 0;
            }
        }
    }
    public void setElemento(int fila, int columna, T elemento) {
        datos[fila][columna] = elemento;
    }
    public T getElemento(int fila, int columnas) {
        return (T) datos[fila][columnas];
    }
    public int getFilas() {
        return filas;
    }
    public int getColumnas() {
        return columnas;
    }

}
