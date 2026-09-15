package mx.unam.aragon;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Bitacora {
    private ConjuntoADT <Registro> datos;
    private String archivo;

    public Bitacora(String archivo) {
        this.archivo = archivo;
        this.datos = new ConjuntoADT<>();
    }

    public void leerArchivo(){
        try (BufferedReader buffer = new BufferedReader(new FileReader(archivo))){
            String linea;
            while((linea = buffer.readLine()) != null){
                String[] elemento = linea.split(",");
                if(elemento.length == 4){
                    Registro registro = new Registro(
                            elemento[0].trim(),
                            elemento[1].trim(),
                            elemento[2].trim(),
                            elemento[3].trim()
                    );
                    datos.agregarElemento(registro);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ConjuntoADT<Registro> getDatos() {
        return datos;
    }
}

