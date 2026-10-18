public class Nodo {

    private Transport dato;
    private Nodo siguiente;

    public Nodo(Transport dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    public Transport getDato() {
        return dato;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
}