package mx.unam.aragon;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class Tablero {
    private Array2D<Integer> tablero;

    public Tablero(int filas, int columnas) {
        tablero = new Array2D<>(filas, columnas);
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                tablero.setElemento(i,j, 0);
            }
        }
    }
    public void cargarArchivo(String archivo) {
        try (BufferedReader buffer = new BufferedReader(new FileReader(archivo))) {
             String linea;
             int fila = 0;
             while ((linea = buffer.readLine()) != null) {
                 String[] valores = linea.split(",");
                 for (int j = 0; j < valores.length; j++) {
                     tablero.setElemento(fila, j, Integer.parseInt(valores[j]));
                 } fila++;
             }
        } catch (IOException e) {
            System.out.println("El archivo " + archivo + "no existe, se generara un tablero automatico");
            generarAleatorio();
        }
    }
    public void generarAleatorio() {
        Random random = new Random();
        for(int i = 0; i < tablero.getFilas(); i++) {
            for (int j = 0; j < tablero.getColumnas(); j++) {
                tablero.setElemento(i,j, random.nextInt(2));
            }
        }
    }
    public int contarVecinos(int fila, int columna) {
        int vecinos = 0;
        for (int i = fila - 1; i <= fila + 1; i++) {
            for (int j = columna - 1; j <= columna + 1; j++) {
                if (i == fila && j == columna) continue;
                if (i >= 0 && j >= 0 && i < tablero.getFilas() && j < tablero.getColumnas()) {
                    vecinos += tablero.getElemento(i,j);
                }
            }
        } return vecinos;
    }
    public void siguienteGeneracion() {
        Array2D<Integer> nueva = new Array2D<>(tablero.getFilas(), tablero.getColumnas());

        for (int i = 0; i < tablero.getFilas(); i++) {
            for (int j = 0; j < tablero.getColumnas(); j++){
                int estado = tablero.getElemento(i,j);
                int vecinos = contarVecinos(i,j);

                if (estado == 1 && (vecinos == 2 || vecinos == 3)) {
                    nueva.setElemento(i,j,1);
                } else if (estado == 1 && (vecinos <= 1 || vecinos >= 4)) {
                    nueva.setElemento(i,j,0);
                } else if (estado == 0 && vecinos == 3) {
                    nueva.setElemento(i,j, 1);
                }
            }
        } tablero = nueva;
    }
    public void imprimir() {
        for (int i = 0; i < tablero.getFilas(); i++) {
            for(int j = 0; j < tablero.getColumnas(); j++) {
                System.out.print(tablero.getElemento(i,j) + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
