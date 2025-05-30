package org.juego.estructuras;

import org.juego.modelos.Carta;
import org.juego.modelos.NodoCarta;

import java.util.Random;

//Lista enlazada simple que representa la baraja principal del juego
public class ListaEnlazada {

    private NodoCarta cabeza;
    private int size; // use este nombre porque usa caracteres especiales como 'ñ' es una mala
    // practica

    // Constructor que inicializa la lista enlazada
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
            NodoCarta actual = cabeza;
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
        if (size == 0) {
            return null;
        }

        Random random = new Random();
        int indice = random.nextInt(size);

        NodoCarta actual = cabeza;
        NodoCarta anterior = null;

        for (int i = 0; i < indice; i++) {
            anterior = actual;
            actual = actual.getSiguiente();
        }

        if (anterior == null) {
            cabeza = actual.getSiguiente(); // Era la cabeza;
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

    public boolean esVacia() {

        return cabeza == null;
    }

    /**
     * Busca una carta en la posición específica de la lista.
     *
     * @param indice Posición de la carta a buscar (0-based)
     * @return Carta encontrada o null si no existe
     */
    public Carta buscarCartaPorIndice(int indice) {
        if (esVacia() || indice < 0 || indice >= size) {
            System.out.println("Índice inválido o lista vacía");
            return null;
        }

        NodoCarta actual = cabeza;
        for (int i = 0; i < indice && actual != null; i++) {
            actual = actual.getSiguiente();
        }
        return (actual != null) ? actual.getCarta() : null;
    }

    public int getSize() {
        return size;
    }
   
}
