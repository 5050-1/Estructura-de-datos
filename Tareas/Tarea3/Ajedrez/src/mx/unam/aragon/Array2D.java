package mx.unam.aragon;

public class Array2D <T> {
    private int filas;
    private int columnas;
    private Object[][] datos;

    public Array2D(int filas, int columnas){
        this.filas = filas;
        this.columnas = columnas;
        this.datos = new Object[filas][columnas];
    }
    public void setElemento(int fila, int columna, T elemento){
        if (fila >= 0 && fila < filas && columna >= 0 && columna < columnas) {
            datos[fila][columna] = elemento;
        } else {
            throw new IndexOutOfBoundsException("Indice fuera de rango");
        }
    }
    public T getElemento(int fila, int columna) {
        if (fila >= 0 && fila < filas && columna >= 0 && columna < columnas) {
            return (T) datos[fila][columna];
        } else {
            throw new IndexOutOfBoundsException("Indice fuera de rango");
        }
    }
    public int getFilas() {
        return filas;
    }
    public int getColumnas() {
        return columnas;
    }
}
