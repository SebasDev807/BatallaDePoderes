package org.juego.modelos;

/**
 * Nodo que contiene una carta y apunta al siguiente nodo en la lista enlazada
 */
public class NodoCarta {

    private Carta carta;
    private NodoCarta siguiente;

    /**
     * Constructor para inicializar un nodo con una carta
     *
     * @param carta Carta que se almacenará en el nodo.
     */

    public NodoCarta(Carta carta) {
        this.carta = carta;
        this.siguiente = null;
    }

    // Getters y Setters
    public Carta getCarta() {
        return carta;
    }

    public void setCarta(Carta carta) {
        this.carta = carta;
    }

    public NodoCarta getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoCarta siguiente) {
        this.siguiente = siguiente;
    }
}
