package org.juego.estructuras;

import org.juego.modelos.Carta;
import org.juego.modelos.NodoCarta;

import java.util.Random;

/**
 * Lista enlazada simple que representa la baraja principal del juego
 */
public class ListaEnlazada {

    private NodoCarta cabeza;
    private int size; // No usar caracteres especiales en nombres

    public ListaEnlazada() {
        this.cabeza = null;
        this.size = 0;
    }

    /**
     * Agrega una carta al final de la lista.
     */
    public void agregarCarta(Carta carta) {
        NodoCarta nuevo = new NodoCarta(carta);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            NodoCarta actual = cabeza;  // <-- corregido aquí
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevo);
        }
        size++;
    }

    /**
     * Devuelve una carta aleatoria de la lista y la elimina.
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
            cabeza = actual.getSiguiente(); // Era la cabeza
        } else {
            anterior.setSiguiente(actual.getSiguiente()); // <-- corregido aquí
        }

        size--;
        return actual.getCarta();
    }

    /**
     * Muestra todas las cartas en la lista.
     */
    public void mostrarBaraja() {
        NodoCarta actual = cabeza;
        while (actual != null) {
            System.out.println(actual.getCarta());
            actual = actual.getSiguiente();
        }
    }

    /**
     * Obtiene y elimina una carta por nombre.
     */
    public Carta obtenerYEliminarCartaPorNombre(String nombre) {
        if (cabeza == null) return null;

        NodoCarta actual = cabeza;
        NodoCarta anterior = null;

        while (actual != null) {
            if (actual.getCarta().getNombre().equalsIgnoreCase(nombre)) {
                if (anterior == null) {
                    cabeza = actual.getSiguiente();
                } else {
                    anterior.setSiguiente(actual.getSiguiente());
                }
                size--;
                return actual.getCarta();
            }
            anterior = actual;
            actual = actual.getSiguiente();
        }
        return null; // No encontrada
    }


}
