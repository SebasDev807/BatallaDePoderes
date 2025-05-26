package org.juego.estructuras.pila;

import org.juego.modelos.Carta;

/**
 * Estructura de pila que representa el cementerio de cartas derrotadas.
 * Funciona en orden LIFO (Last In – First Out).
 *
 * @author Edwin Constain
 */
public class Pila {

    private NodoPila cima;
    private int size;

    public Pila() {
        this.cima = null;
        this.size = 0;
    }

    /**
     * Inserta una carta en la cima de la pila.
     *
     * @param carta Carta derrotada a registrar.
     */

    public void apilar(Carta carta) {
        NodoPila nuevo = new NodoPila(carta);
        nuevo.setSiguiente(cima);
        cima = nuevo;
        size++;
    }

    /**
     * Retira y devuelve la carta en la cima de la pila.
     *
     * @return Carta retirada, o null si la pila está vacía.
     */
    public Carta desapilar() {
        if (estaVacia()) return null;

        Carta carta = cima.getCarta();
        cima = cima.getSiguiente();

        size--;
        return carta;
    }

    /**
     * @return carrta en la cima sin retirarla
     */
    public Carta verCima() {
        return estaVacia() ? null : cima.getCarta();
    }

    public boolean estaVacia() {
        return cima == null;
    }

    public int getSize() {
        return size;
    }

    /**
     * Muestra las cartas derrotadas en orden LIFO.
     */
    public void mostrarDerrotas() {
        NodoPila actual = cima;
        while (actual != null) {
            System.out.println(actual.getCarta());
            actual = actual.getSiguiente();
        }
    }


}
