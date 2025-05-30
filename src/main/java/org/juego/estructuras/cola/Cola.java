package org.juego.estructuras.cola;

import org.juego.modelos.Carta;

/**
 * Estructura de cola que representa el mazo de un jugador
 * Funciona en orden FIFO (First In - First Out)
 *
 * @author Juan Sebastián Astudillo Ordoñez
 */
public class Cola {

    private NodoCola frente;
    private NodoCola fin;
    private int size;

    public Cola() {
        frente = null;
        fin = null;
        size = 0;
    }

    
     //Inserta una carta al final de la cola.
    public void encolar(Carta carta) {
        NodoCola nuevo = new NodoCola(carta);

        if (estaVacia()) {
            frente = nuevo;
            fin = nuevo;
        } else {
            fin.setSiguiente(nuevo);
            fin = nuevo;
        }
        size++;
    }

    
     // @return Carta retirada, o null si la cola está vacía
    public Carta desencolar() {
        if (estaVacia()) return null;

        Carta carta = frente.getCarta();
        frente = frente.getSiguiente();

        if (frente == null) fin = null;

        size--;
        return carta;

    }

    // devuelve la carta al frente sin retirarla
    public Carta verFrente(){
        return estaVacia() ? null : frente.getCarta(); //Esto es un operador ternario '?' representa if ':' representa else
    }

    public boolean estaVacia() {
        return frente == null;
    }

    public int getSize(){
        return size;
    }

    public void mostrarCartas(){
        NodoCola actual = frente;
        while(actual != null){
            System.out.println(actual.getCarta());
            actual = actual.getSiguiente();
        }
    }

}
