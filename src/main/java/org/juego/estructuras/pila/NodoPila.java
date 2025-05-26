package org.juego.estructuras.pila;

import org.juego.modelos.Carta;

/**
 * Nodo utilizado para la estructura de pila de cartas derrotadas
 *
 * @author Sebastián Astudillo
 */
public class NodoPila {

    private Carta carta;
    private NodoPila siguiente;

    public NodoPila(Carta carta) {
        this.carta = carta;
        this.siguiente = null;
    }

    public Carta getCarta() {
        return carta;
    }

    public void setCarta(Carta carta) {
        this.carta = carta;
    }

    public NodoPila getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoPila siguiente) {
        this.siguiente = siguiente;
    }


}
