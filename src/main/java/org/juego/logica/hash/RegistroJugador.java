package org.juego.logica.hash;
import java.util.ArrayList;
import java.util.List;
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
    private int poderAcumulado;
    public int rondasGanadas;
    int poderTotal;
    List<Carta> cartasJugadasList;
    List<Carta> cartasGanadas;

    public RegistroJugador() {
        this.poderAcumulado = 0;
        this.cartasJugadas = 0;
        this.rondasGanadas = 0;
        this.poderTotal = 0;
        this.cartasJugadasList = new ArrayList<>();
        this.cartasGanadas = new ArrayList<>();
    }
       public void registrarCartaJugada(Carta carta) {
           if(carta == null){
               System.out.println("E-R-R-O-R :\n Se intentó jugar una carta nula"); 
           }else{
        cartasJugadas++;
        poderAcumulado += carta.getPoder();
        cartasJugadasList.add(carta);
    }}
     public void agregarRondaGanada(Carta cartaGanadora) {
        rondasGanadas++;
        poderTotal += cartaGanadora.poder;
        cartasGanadas.add(cartaGanadora);
    }

    public int getPoderAcumulado() {
        return poderAcumulado;
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
