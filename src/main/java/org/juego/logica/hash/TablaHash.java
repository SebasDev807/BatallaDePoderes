package org.juego.logica.hash;

/**
 * Tabla hash personalizada para registrar los jugadores
 *
 * @author Edwin Constain
 */
public class TablaHash {

    private final int CAPACIDAD = 10;
    private NodoHash[] tabla;

    public TablaHash() {
        tabla = new NodoHash[CAPACIDAD];
    }

    /**
     * Calcula el incice hash para una clave.
     */
    private int hash(String clave) {
        int hash = 0;
        for (int i = 0; i < clave.length(); i++) {
            hash += clave.charAt(i);
        }
        return hash % CAPACIDAD;
    }

    /**
     * Inserta o actualiza un registro para un jugador.
     */
    public void put(String clave, RegistroJugador valor) {
        int indice = hash(clave);
        NodoHash actual = tabla[indice];

        while (actual != null) {
            if (actual.getClave().equals(clave)) {
                actual.getValor();
                return;
            }
            actual = actual.getSiguiente();
        }

        NodoHash nuevo = new NodoHash(clave, valor);
        nuevo.setSiguiente(tabla[indice]);
        tabla[indice] = nuevo;

    }

    /**
     * Recupera el registro de un jugador por su clave.
     */
    public RegistroJugador get(String clave) {
        int indice = hash(clave);
        NodoHash actual = tabla[indice];

        while (actual != null) {
            if (actual.getClave().equals(clave)) {
                return actual.getValor();
            }
            actual = actual.getSiguiente();
        }

        return null;
    }


    /**
     * Muestra todos los registros de la tabla.
     */
    public void mostrarTabla() {
        for (int i = 0; i < CAPACIDAD; i++) {
            NodoHash actual = tabla[i];
            while (actual != null) {
                System.out.println("Jugador: " + actual.getClave());
                System.out.println(actual.getValor());
                System.out.println("--------------------------");
                actual = actual.getSiguiente();
            }
        }
    }
}
