package mx.unam.aragon;

public class Main {
    public static void main (String[] args){
        try {
            Tablero juego = new Tablero(10,10);
            juego.cargarArchivo("poblacion.csv");
            System.out.println("Generacion inicial:");;
            juego.imprimir();

            for (int generacion = 1; generacion <= 10; generacion++) {
                juego.siguienteGeneracion();
                System.out.println("Generación " + generacion + ":");
                juego.imprimir();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
