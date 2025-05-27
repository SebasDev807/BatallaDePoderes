package org.juego.logica.hash;

import org.juego.modelos.Carta;

/**
 * Registro de datos para cada participante en el juego.
 * Almacena el seguimiento de las cartas que se han jugado, las que se han ganado,
 * la energía reunida y las rondas que se han ganado.
 * @author David Cabrera
 *
 */
public class RegistroJugador {
    private int cartasJugadas;
    private int cartasGanadas;
    private int poderAcumulado;
    private int rondasGanadas;

    public RegistroJugador() {
        this.cartasJugadas = 0;
        this.cartasGanadas = 0;
        this.poderAcumulado = 0;
        this.rondasGanadas = 0;
    }

    public void registrarCartaJugada(Carta carta) {
        cartasJugadas++;
        poderAcumulado += carta.getPoder();
    }

    public void registrarVictoria(Carta carta) {
        cartasGanadas++;
        rondasGanadas++;
        poderAcumulado += carta.getPoder();
    }


    public int getRondasGanadas() {
        return rondasGanadas;
    }

    @Override
    public String toString() {
        return "Cartas jugadas: " + cartasJugadas +
                ", Cartas ganadas: " + cartasGanadas +
                ", Poder acumulado: " + poderAcumulado +
                ", Rondas ganadas: " + rondasGanadas;
    }
}