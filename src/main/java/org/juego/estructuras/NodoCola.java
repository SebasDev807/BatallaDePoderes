package org.juego.estructuras;

import org.juego.modelos.Carta;

/**
 * Este Nodo se usa para la estructura de cola del mazo de cada jugador.
 *
 * @author Juan Sebastián Astudillo Ordoñez
 */

public class NodoCola {

    private Carta carta;
    private NodoCola siguiente;

    public NodoCola(Carta carta) {
        this.carta = carta;
        this.siguiente = null;
    }

    //getters y setters(metodos accesores)
    public Carta getCarta() {
        return carta;
    }

    public void setCarta(Carta carta) {
        this.carta = carta;
    }

    public NodoCola getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoCola siguiente) {
        this.siguiente = siguiente;
    }

}

