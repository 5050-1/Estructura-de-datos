package mx.unam.aragon;

import java.io.BufferedReader;
import java.io.FileReader;

public class Main {
    public static void main (String[] args) {
        Bitacora bitacora = new Bitacora("BitacoraIPVideojuegos.csv");
        bitacora.leerArchivo();

        ConjuntoADT<String> ipUnica = new ConjuntoADT<>();
        for (Registro registro : bitacora.getDatos().getElementos()){
            ipUnica.agregarElemento(registro.getIp());
        }

        ConjuntoADT<String> compras = new ConjuntoADT<>();
        for(Registro registro : bitacora.getDatos().getElementos()){
            if(registro.getActividad().toLowerCase().contains("compra")) {
                compras.agregarElemento(registro.getIp());
            }
        }

        ConjuntoADT<String> victorias = new ConjuntoADT<>();
        for(Registro registro : bitacora.getDatos().getElementos()){
            if(registro.getActividad().toLowerCase().contains("victoria")){
                victorias.agregarElemento(registro.getIp());
            }
        }

        ConjuntoADT<String> derrotas = new ConjuntoADT<>();
        for(Registro registro : bitacora.getDatos().getElementos()){
            if(registro.getActividad().toLowerCase().contains("derrota")){
                derrotas.agregarElemento(registro.getIp());
            }
        }

        ConjuntoADT<String> paisesUnicos = new ConjuntoADT<>();
        for(Registro registro : bitacora.getDatos().getElementos()){
            paisesUnicos.agregarElemento(registro.getPais());
        }

        ConjuntoADT<String> paisesCompras = new ConjuntoADT<>();
        for(Registro registro : bitacora.getDatos().getElementos()){
            if(registro.getActividad().toLowerCase().contains("compra")){
                paisesCompras.agregarElemento(registro.getPais());
            }
        }

        ConjuntoADT<String> paisesPartidasGanadas = new ConjuntoADT<>();
        for(Registro registro : bitacora.getDatos().getElementos()){
            if(registro.getActividad().toLowerCase().contains("victoria")){
                paisesPartidasGanadas.agregarElemento(registro.getPais());
            }
        }

        ConjuntoADT<String> reporte = new ConjuntoADT<>();
        for (Registro registro : bitacora.getDatos().getElementos()){
            if(registro.getActividad().toLowerCase().contains("reporte")){
                reporte.agregarElemento(registro.getIp());
            }
        }

        ConjuntoADT<String> conversacion = new ConjuntoADT<>();
        for (Registro registro : bitacora.getDatos().getElementos()){
            if(registro.getActividad().toLowerCase().contains("chat")){
                conversacion.agregarElemento(registro.getIp());
            }
        }

        ConjuntoADT<String> deconexion = new ConjuntoADT<>();
        for (Registro registro : bitacora.getDatos().getElementos()){
            if(registro.getActividad().toLowerCase().contains("desconexion")){
                deconexion.agregarElemento(registro.getIp());
            }
        }

        ConjuntoADT<String> inicioSesionFallido = new ConjuntoADT<>();
        for (Registro registro : bitacora.getDatos().getElementos()){
            if(registro.getActividad().toLowerCase().contains("fallido")){
                inicioSesionFallido.agregarElemento(registro.getIp());
            }
        }


        System.out.println("Total de IPs únicas: " + ipUnica.longitud());
        System.out.println("Total de países: " + paisesUnicos.longitud());
        System.out.println("Países de los jugadores: " + paisesUnicos);
        System.out.println("IPs que compraron: " + compras);

        ConjuntoADT<String> interseccionCompras = compras.interseccion(derrotas);
        System.out.println("IPs que compraron y perdieron: " + interseccionCompras);
        ConjuntoADT<String> union = inicioSesionFallido.union(deconexion);
        System.out.println("IPs que tuvieron problemas con el inicio de sesión o se desconectaron repentinamente: " + union);
        ConjuntoADT<String> interseccion = paisesCompras.interseccion(paisesPartidasGanadas);
        System.out.println("Paises que compraron y tuvieron partidas ganadas: " + interseccion);
        ConjuntoADT<String> diferencia = reporte.diferencia(deconexion);
        System.out.println("IPs que reportaron pero no se desconectaron repentinamente: " + diferencia);
        boolean subconjunto = interseccionCompras.esSubconjunto(compras);
        System.out.println("¿Las personas que compraron y perdieron estan dentro del conjunto de persona que se compraron? " + subconjunto);
    }
}
