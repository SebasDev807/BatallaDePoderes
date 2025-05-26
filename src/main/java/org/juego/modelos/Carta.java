package org.juego.modelos;

public class Carta {

    private String nombre;
    private String tipo; // {fuego, agua, tierra, aire}
    private int poder;

    /**
     * Constructor: Inicializamos las cartas
     *
     * @param nombre nombre de la carta
     * @param tipo   tipo de la carta
     * @param poder  poder de la carta (entre 1 y 100)
     */

    public Carta(String nombre, String tipo, int poder) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.poder = poder;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public int getPoder() {
        return poder;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setPoder(int poder) {
        this.poder = poder;
    }

    /**
     * Aumenta el poder de la carta en una cantidad
     *
     * @author Juan Sebastián Astudillo Ordoñez
     * @param incremento Cantidad de poder a aumentar
     */
    public void mejorarPoder(int incremento) {
        this.poder += incremento;
        if (this.poder > 100) {
            this.poder = 100;
        }
    }

    /**
     * Representación en texto de la carta
     */
    @Override
    public String toString() {
        return "\"" + nombre + "\" (" + tipo + ") – Poder: " + poder;
    }


}
