package main.java;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String archivo = "datos_redes_sociales.csv";
        try (BufferedReader a = new BufferedReader(new FileReader(archivo))){
            String linea;
            String lineaYoutube = null;
            String lineasTwitterCrecimiento = null;
            String lineasFacebookCrecimiento = null;
            String lineaYoutubeMeGusta = null;
            String lineaTwitterMeGusta = null;
            String lineaFacebookMeGusta = null;
            while ((linea = a.readLine()) != null) {
                if (linea.contains("TWITTER") && linea.contains("SEGUIDORES (FOLLOWERS)")) {
                    int [] twitterSeguidores = filasArray(linea);
                    int diferencia = twitterSeguidores[5] - twitterSeguidores[0];
                    System.out.println("Diferencia seguidores Twitter (Enero - Junio): " + diferencia);
                }
                if (linea.contains("YOUTUBE") && linea.contains("VISUALIZACIONES")) {
                    lineaYoutube = linea;
                }
                if (linea.contains("TWITTER") && linea.contains("CRECIMIENTO DE FOLLOWERS")) {
                    lineasTwitterCrecimiento = linea;
                }
                if (linea.contains("FACEBOOK") && linea.contains("CRECIMIENTO (seguidores)")) {
                    lineasFacebookCrecimiento = linea;
                }
                if (linea.contains("YOUTUBE") && linea.contains("ME GUSTA")) {
                    lineaYoutubeMeGusta = linea;
                }
                if (linea.contains("FACEBOOK") && linea.contains("ME GUSTA EN PUBLICACIONES")) {
                    lineaFacebookMeGusta = linea;
                }
                if (linea.contains("TWITTER") && linea.contains("ME GUSTA")) {
                    lineaTwitterMeGusta = linea;
                }
            }
            if (lineaYoutube != null) {
                int[] youtubeVistas = filasArray(lineaYoutube);
                String mes1 = JOptionPane.showInputDialog("Mes inicial (1-6): ");
                String mes2 = JOptionPane.showInputDialog("Mes final (1-6): ");
                int mesInicial = Integer.parseInt(mes1);
                int mesFinal = Integer.parseInt(mes2);
                int diferenciaVistas = youtubeVistas[mesFinal - 1] - youtubeVistas[mesInicial - 1];
                System.out.println("Diferencia de visualizaciones Youtube entre mes " + mesInicial + " y mes " + mesFinal + ": " + diferenciaVistas);
                JOptionPane.showMessageDialog(null, "Diferencia de visualizaciones Youtube entre mes " + mesInicial + " y mes " + mesFinal + ": " + diferenciaVistas);
            }
            if (lineasTwitterCrecimiento != null && lineasFacebookCrecimiento != null) {
                double promedioTwitter = promedio(filasArray((lineasTwitterCrecimiento)));
                double promedioFacebook = promedio(filasArray(lineasFacebookCrecimiento));
                System.out.println("Promedio crecimiento Twitter: " + promedioTwitter);
                System.out.println("Promedio crecimiento Facebook: " + promedioFacebook);
            }
            if (lineaYoutubeMeGusta != null && lineaFacebookMeGusta != null && lineaTwitterMeGusta != null) {
                double promedioYoutubeMeGusta = promedio(filasArray((lineaYoutubeMeGusta)));
                double promedioFacebookMeGusta = promedio(filasArray((lineaFacebookMeGusta)));
                double promedioTwitterMeGusta = promedio(filasArray((lineaTwitterMeGusta)));
                System.out.println("Promedio de Me Gusta en Youtube: " + promedioYoutubeMeGusta);
                System.out.println("Promedio de Me Gusta en Facebook: " + promedioFacebookMeGusta);
                System.out.println("Promedio de Me Gusta en Twitter: " + promedioTwitterMeGusta);

            }

        } catch (IOException e){
            e.printStackTrace();
        }
    }
    public static  int[] filasArray(String linea) {
        String[] columnas = linea.split(",");
        int[] datos = new int[6];
        for (int i = 0; i < 6; i++) {
            String valor = columnas[i + 3].replace(",", "");
            try {
                datos[i] = Integer.parseInt(valor);
            } catch (NumberFormatException e){
                datos[i] = 0;
            }
        }
        return datos;
    }
    public static double promedio(int[] datos) {
        int suma = 0;
        for (int d: datos) {
            suma += d;
        }
        return (double) suma / datos.length;
    }
}
