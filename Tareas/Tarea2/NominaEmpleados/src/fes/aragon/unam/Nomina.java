package fes.aragon.unam;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Nomina {
    private ArrayADT<Empleado> datos;
    private String rutaArchivo;

    public Nomina(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }
    public void leerArchivo() {
        try (BufferedReader buffer = new BufferedReader(new FileReader(rutaArchivo))) {
            buffer.readLine();
            List<Empleado> listaTemporal = new ArrayList<>();
            String linea;
            while ((linea = buffer.readLine()) != null){
                String[] elemento = linea.split(",");
                int numTrabajador = Integer.parseInt(elemento[0]);
                String nombre = elemento[1];
                String appPaterno = elemento[2];
                String appMaterno = elemento[3];
                int horasExtra = Integer.parseInt(elemento[4]);
                float sueldoBase = Float.parseFloat(elemento[5]);
                int anoIngreso = Integer.parseInt(elemento[6]);

                Empleado empleado = new Empleado(numTrabajador, nombre, appPaterno, appMaterno, horasExtra, sueldoBase, anoIngreso);
                listaTemporal.add(empleado);
            }
            datos = new ArrayADT<>(listaTemporal.size());
            for (int i = 0; i < listaTemporal.size(); i++) {
                datos.insertarElemento(i, listaTemporal.get(i));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Empleado mayorAntiguedad() {
        Empleado mayor = datos.obtenerElemento(0);
        for (int i = 1; i < datos.getLongitud(); i++){
            Empleado empleado = datos.obtenerElemento(i);
            if (empleado != null && empleado.getAnoIngreso() < mayor.getAnoIngreso()) {
                mayor = empleado;
            }
        }
        return mayor;
    }
    public Empleado menorAntiguedad() {
        Empleado menor = datos.obtenerElemento(0);
        for (int i = 1; i < datos.getLongitud(); i++) {
            Empleado empleado = datos.obtenerElemento(i);
            if (empleado != null && empleado.getAnoIngreso() > menor.getAnoIngreso()) {
                menor = empleado;
            }
        }
        return menor;
    }
    public void imprimirNomina(){
        for(int i = 0; i < datos.getLongitud(); i++) {
            System.out.println(datos.obtenerElemento(i));
        }
    }
}
