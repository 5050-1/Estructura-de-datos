package fes.aragon.unam;

public class Main {
    public static void main(String[] args) {
        Nomina nomina = new Nomina("junio.dat");
        nomina.leerArchivo();

        System.out.println("Empleado con mayor antigüedad: " + nomina.mayorAntiguedad());
        System.out.println("Empleado con menor antigüedad: " + nomina.menorAntiguedad());

        System.out.println("\n --- Nómina completa ---");
        nomina.imprimirNomina();

    }
}
