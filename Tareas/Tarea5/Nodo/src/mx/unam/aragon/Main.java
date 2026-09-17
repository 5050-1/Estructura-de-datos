package mx.unam.aragon;

public class Main {
    public static void main(String[] args) {
        Nodo<String> head;
        head = new Nodo<>("Al", new Nodo<>("B", new Nodo<>("C", new Nodo<>("De", new Nodo<>("Mc", new Nodo<>("Zi", null))))));
        System.out.println(head);
        System.out.println(head.getDato());

        Nodo<String> tmp = head;
        while (tmp.getSiguiente() != null) {
            tmp = tmp.getSiguiente();
        }
        System.out.println(tmp);

        Nodo<String> tmp2 = head;
        String referencia = "De";
        while (tmp2.getDato() != referencia) {
            tmp2 = tmp2.getSiguiente();
        }
        if (tmp2 == null) {
            System.out.println("Se salio de la estructura");
        } else {
            tmp2.setSiguiente(new Nodo<>("Fe", tmp2.getSiguiente()));
        }
        System.out.println(head);

        Nodo<String> tmp3 = head;
        while (tmp3.getSiguiente() != null) {
            tmp3 = tmp3.getSiguiente();
        }
        tmp3.setSiguiente(new Nodo<>("Zz", null));
        System.out.println(head);

        head = new Nodo<>("Aa", head);
        System.out.println(head);

    }
}
