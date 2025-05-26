package org.juego.estructuras;

import org.juego.modelos.Carta;
import org.juego.modelos.NodoCarta;

import java.util.Random;

/**
 * Lista enlazada simple que representa la baraja principal del juego
 */
public class ListaEnlazada {

    private NodoCarta cabeza;
    private int size; //use este nombre porque usa caracteres especiales como 'ñ' es una mala practica

    //Constructor que inicializa la lista enlazada
    public ListaEnlazada() {
        this.cabeza = null;
        this.size = 0;
    }

    /**
     * Agregar una carta al final de la lista.
     *
     * @param carta Carta a agregar
     * @author Dhayana Valentina Muñoz Fernandez
     */

    public void agregarCarta(Carta carta) {
        NodoCarta nuevo = new NodoCarta(carta);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            NodoCarta actual = new NodoCarta(carta);
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevo);
        }
        size++;
    }

    /**
     * Devuelve una carta aleatoria de la lista y la elimina
     *
     * @return Carta aleatoria o null si la lista esta vacía
     * @author Tulio Martinez
     */
    public Carta obtenerCartaAleatoria() {

        if (size == 0) return null;

        Random random = new Random();
        int indice = random.nextInt(size);

        NodoCarta actual = cabeza;
        NodoCarta anterior = null;

        for (int i = 0; i < indice; i++) {
            anterior = actual;
            actual = actual.getSiguiente();
        }

        if (anterior == null) {
            cabeza = actual.getSiguiente(); //Era la cabeza;
        } else {
            actual.setSiguiente(actual.getSiguiente());
        }

        size--;
        return actual.getCarta();
    }

    /**
     * Muestra todas las cartas en la lista.
     *
     * @author Tulio Martinez
     */

    public void mostrarBaraja() {
        NodoCarta actual = cabeza;
        while (actual != null) {
            System.out.println(actual.getCarta());
            actual = actual.getSiguiente();
        }
    }

    public boolean estaVacia() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }


}

