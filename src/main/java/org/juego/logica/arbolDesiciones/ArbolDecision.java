package org.juego.logica.arbolDesiciones;

import org.juego.modelos.Carta;

/**
 * Arbol binario que representa las decisiones estrategicas del CPU
 *
 * @author David Cabrera
 */

public class ArbolDecision {

    private NodoDecision raiz;

    private final String GUERRERO_MEDIO = "Guerrero medio";
    private final String TIGRE_SALVAJE = "Tigre salvaje";
    private final String AGUILA_ANCESTRAL = "Aguila ancestral";


    public ArbolDecision() {
        construirArbol();
    }

 
    // Construye un arból de decisión simple basado en el poder y tipo de jugador
    private void construirArbol() {
        raiz = new NodoDecision("¿Poder del jugador > 80?");

        NodoDecision izquierda = new NodoDecision("¿Tipo es débil contra CPU?");
        NodoDecision derecha = new NodoDecision(""); // Jugar carta fuerte directamente

        // Hojas simuladas (lógica de CPU)
        izquierda.setIzquierda(new NodoDecision(new Carta(GUERRERO_MEDIO, "Tierra", 60)));
        izquierda.setDerecha(new NodoDecision(new Carta(TIGRE_SALVAJE, "Fuego", 85)));
        derecha.setDerecha(new NodoDecision(new Carta(AGUILA_ANCESTRAL, "Aire", 90)));

        raiz.setIzquierda(izquierda);
        raiz.setDerecha(derecha);
    }

    /**
     * Selecciona una carta del árbol basada en la carta del jugador.
     *
     * @param cartaJugador Carta jugada por el oponente.
     * @return Carta que el CPU decide usar.
     */
    public Carta decidirCarta(Carta cartaJugador) {

        NodoDecision actual = raiz;

        while (!actual.esHoja()) {
            if ("Poder del jugador > 80".equals(actual.getPregunta())) {
                actual = cartaJugador.getPoder() > 80 ? actual.getIzquierda() : actual.getDerecha();
            } else if ("¿Tipo es débil contra CPU?".equals(actual.getPregunta())) {
                if (esTipoDebil(cartaJugador.getTipo())) {
                    actual = actual.getIzquierda();
                } else {
                    actual = actual.getDerecha();
                }
            } else {
                break; //Si se agregan decisiones
            }
        }

        return actual.getCarta();
    }

    
    // Evalúa si el tipo del jugador es débil frente al CPU (ejemplo básico).
    private boolean esTipoDebil(String tipoJugador) {
        return tipoJugador.equals("Fuego"); // Suponiendo que el CPU es Agua
    }
}
