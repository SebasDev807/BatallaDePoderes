package org.juego.logica.hash;

public class NodoHash {
    private String clave;
    private RegistroJugador valor;
    private NodoHash siguiente;

    public NodoHash(String clave, RegistroJugador valor) {
        this.clave = clave;
        this.valor = valor;
        this.siguiente = null;
    }

    public String getClave() {
        return clave;
    }

    public RegistroJugador getValor() {
        return valor;
    }

    public NodoHash getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoHash siguiente) {
        this.siguiente = siguiente;
    }
}

