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

    // Inserta una carta en la cima de la pila.
    public void apilar(Carta carta) {
        NodoPila nuevo = new NodoPila(carta);
        nuevo.setSiguiente(cima);
        cima = nuevo;
        size++;
    }

    // Retira y devuelve la carta en la cima de la pila.
    // @return Carta retirada, o null si la pila está vacía.
    public Carta desapilar() {
        if (estaVacia()) {
            return null;
        }

        Carta carta = cima.getCarta();
        cima = cima.getSiguiente();

        size--;
        return carta;
    }

    public void agregarDerrota(Carta carta) {
        if (carta != null) {
            this.apilar(carta);
        } else {
            System.out.println("La Carta derrotada es NULL");
        }
    }

    
     // @return carrta en la cima sin retirarla 
    public boolean estaVacia() {
        return cima == null;
    }

    public int getSize() {
        return size;
    }

    
    // Muestra las cartas derrotadas en orden LIFO.
    public void mostrarDerrotas() {
        System.out.println("C E M E N T E R I O :");
        NodoPila actual = cima;
        while (actual != null) {
            System.out.println(actual.getCarta());
            actual = actual.getSiguiente();
        }
    }
}
