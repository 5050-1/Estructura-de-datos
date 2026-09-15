package mx.unam.aragon;

import javax.swing.text.AbstractDocument;
import java.util.ArrayList;

public class ConjuntoADT <T>{
    private ArrayList <T> elementos;

    public ConjuntoADT() {
        this.elementos = new ArrayList<>();
    }

    public ArrayList<T> getElementos() {
        return elementos;
    }

    public int longitud(){
        return elementos.size();
    }
    public void agregarElemento( T elemento) {
        //Para que no agregue elementos duplicados
        if (!elementos.contains(elemento)) {
            elementos.add(elemento);
        }
    }
    public boolean contieneElemento(T elemento) {
        return elementos.contains(elemento);
    }

    public ConjuntoADT<T> union(ConjuntoADT<T> otroConjunto){
        ConjuntoADT<T> union = new ConjuntoADT<>();
        for (T elemento : this.elementos) {
            union.agregarElemento(elemento);
        }
        for (T elemento : otroConjunto.getElementos()){
            union.agregarElemento(elemento);
        }
        return union;
    }

    public ConjuntoADT<T> interseccion(ConjuntoADT<T> otroConjunto){
        ConjuntoADT<T> interseccion = new ConjuntoADT<>();
        for(T elemento : this.elementos){
            if (otroConjunto.contieneElemento(elemento)) {
                interseccion.agregarElemento(elemento);
            }
        }
        return interseccion;
    }

    public ConjuntoADT<T> diferencia(ConjuntoADT<T> otroConjunto){
        ConjuntoADT<T> diferencia = new ConjuntoADT<>();
        for (T elemento : this.elementos){
            if (!otroConjunto.contieneElemento(elemento)){
                diferencia.agregarElemento(elemento);
            }
        }
        return diferencia;
    }

    public boolean esSubconjunto (ConjuntoADT<T> otroConjunto){
        if (this.longitud() > otroConjunto.longitud()) {
            return false;
        }
        for(T elemento : this.elementos){
            if(!otroConjunto.contieneElemento(elemento)){
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "ConjuntoADT{" +
                "elementos=" + elementos +
                '}';
    }
}
