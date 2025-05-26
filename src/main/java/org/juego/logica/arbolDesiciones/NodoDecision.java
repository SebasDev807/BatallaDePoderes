package org.juego.logica.arbolDesiciones;

import org.juego.modelos.Carta;

/**
 * Nodo del árbol de decisión. Puede contener una pregunta o una carta final.
 */
public class NodoDecision {

    private String pregunta;      // Si es un nodo de decisión
    private Carta carta;          // Si es un nodo hoja
    private NodoDecision izquierda;
    private NodoDecision derecha;

    /**
     * Constructor para un nodo que contiene una pregunta.
     */
    public NodoDecision(String pregunta) {
        this.pregunta = pregunta;
        this.carta = null;
        this.izquierda = null;
        this.derecha = null;
    }

    /**
     * Constructor para un nodo hoja con una carta.
     */
    public NodoDecision(Carta carta) {
        this.carta = carta;
        this.pregunta = null;
        this.izquierda = null;
        this.derecha = null;
    }

    public boolean esHoja() {
        return carta != null;
    }

    public String getPregunta() {
        return pregunta;
    }

    public Carta getCarta() {
        return carta;
    }

    public NodoDecision getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(NodoDecision izquierda) {
        this.izquierda = izquierda;
    }

    public NodoDecision getDerecha() {
        return derecha;
    }

    public void setDerecha(NodoDecision derecha) {
        this.derecha = derecha;
    }
}