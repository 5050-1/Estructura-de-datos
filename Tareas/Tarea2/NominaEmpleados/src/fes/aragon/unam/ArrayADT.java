package fes.aragon.unam;

public class ArrayADT <T> {
    private int longitud;
    private Object[] datos;

    public ArrayADT(int l) {
        this.longitud = l;
        this.datos = new Object[longitud];
    }

    public T obtenerElemento(int indice) {
        if (indice >= 0 && indice < longitud) {
            return (T) datos[indice];
        } else {
            System.out.println("Indice fuera de rango");
            throw new ArrayIndexOutOfBoundsException("Indice fuera de rango");
        }
    }

    public void insertarElemento(int indice, T elemento) {
        if (indice >= 0 && indice < longitud) {
            datos[indice] = elemento;
        } else {
            System.out.println("Indice fuera de rango");
            throw new ArrayIndexOutOfBoundsException("Indice fuera de rango");
        }
    }

    public int getLongitud() {
        return longitud;
    }

    public void rellenar(T elemento) {
        for (int i = 0; i < longitud; i++) {
            datos[i] = elemento;
            if (i < longitud - 1) {
                System.out.println(", ");
            }
        }
        System.out.println("]");
    }
}
