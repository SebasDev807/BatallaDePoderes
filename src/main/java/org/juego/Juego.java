package org.juego;

import org.juego.estructuras.ListaEnlazada;
import org.juego.estructuras.cola.Cola;
import org.juego.estructuras.pila.Pila;
import org.juego.logica.arbolDesiciones.ArbolDecision;
import org.juego.logica.hash.RegistroJugador;
import org.juego.logica.hash.TablaHash;
import org.juego.modelos.Carta;

import java.util.Scanner;

public class Juego {

    public void iniciar() {
        Scanner scanner = new Scanner(System.in);
        ArbolDecision arbolCPU = new ArbolDecision();
        TablaHash tablaEstado = new TablaHash();

        System.out.println("🌟 Bienvenido a Batalla de Poderes 🌟");
        System.out.print("Ingrese su nombre: ");
        String nombreJugador = scanner.nextLine();

        ListaEnlazada barajaPrincipal = crearBarajaPrincipal();

        System.out.println("\nEstas son las cartas disponibles para elegir:");
        barajaPrincipal.mostrarBaraja();

        Cola mazoJugador = new Cola();
        Cola mazoCPU = new Cola();

        seleccionarCartasJugador(scanner, barajaPrincipal, mazoJugador);

        generarMazoCPU(barajaPrincipal, mazoCPU, 5);

        Pila cementerioJugador = new Pila();
        Pila cementerioCPU = new Pila();

        RegistroJugador registroJugador = new RegistroJugador();
        RegistroJugador registroCPU = new RegistroJugador();

        tablaEstado.put(nombreJugador, registroJugador);
        tablaEstado.put("CPU", registroCPU);

        System.out.println("\nSe reparten cartas...");
        System.out.println("Tu mazo tiene " + mazoJugador.getSize() + " cartas.");
        System.out.println("El oponente CPU también tiene " + mazoCPU.getSize() + " cartas.\n");

        for (int ronda = 1; ronda <= 5; ronda++) {
            System.out.println("--- Ronda " + ronda + " ---");

            // Mostrar cartas disponibles para jugador
            mostrarCartasEnCola(mazoJugador);

            // Pedir al jugador que elija carta para jugar
            Carta cartaJ = seleccionarCartaParaJugar(scanner, mazoJugador);

            // CPU juega carta (decisión automática)
            Carta cartaCPU = arbolCPU.decidirCarta(cartaJ);
            if (cartaCPU == null) {
                cartaCPU = mazoCPU.desencolar();
            }

            System.out.println(nombreJugador + " juega: \"" + cartaJ.getNombre() + "\" " + emojiParaTipo(cartaJ.getTipo()) + " – Poder: " + cartaJ.getPoder());
            System.out.println("CPU juega: \"" + cartaCPU.getNombre() + "\" " + emojiParaTipo(cartaCPU.getTipo()) + " – Poder: " + cartaCPU.getPoder());

            registroJugador.registrarCartaJugada(cartaJ);
            registroCPU.registrarCartaJugada(cartaCPU);

            if (cartaJ.getPoder() > cartaCPU.getPoder()) {
                System.out.println("\nGanadora de la ronda: " + nombreJugador + " 🎉");
                registroJugador.registrarVictoria(cartaJ);
                cementerioCPU.apilar(cartaCPU);
            } else if (cartaCPU.getPoder() > cartaJ.getPoder()) {
                System.out.println("\nGanador de la ronda: CPU 💥");
                registroCPU.registrarVictoria(cartaCPU);
                cementerioJugador.apilar(cartaJ);
            } else {
                System.out.println("\nEmpate en la ronda.");
            }

            System.out.println();
        }

        System.out.println("--- Cartas derrotadas de " + nombreJugador + " ---");
        cementerioJugador.mostrarDerrotas();

        System.out.println("\n--- Estadísticas Finales ---");
        System.out.println(nombreJugador + ": " + registroJugador.getRondasGanadas() + " rondas ganadas");
        System.out.println("CPU: " + registroCPU.getRondasGanadas() + " rondas ganadas");

        if (registroJugador.getRondasGanadas() > registroCPU.getRondasGanadas()) {
            System.out.println("\n🏆 ¡" + nombreJugador + " gana la partida! 🏆");
        } else if (registroJugador.getRondasGanadas() < registroCPU.getRondasGanadas()) {
            System.out.println("\n🏆 ¡CPU gana la partida! 🏆");
        } else {
            System.out.println("\n🤝 ¡Empate! 🤝");
        }

        scanner.close();
    }

    // Método para mostrar cartas en cola jugador
    private void mostrarCartasEnCola(Cola mazo) {
        System.out.println("Cartas disponibles para jugar:");
        for (Carta carta : mazo.toList()) {
            System.out.println("- " + carta.getNombre());
        }
    }

    // Método para que jugador elija carta para jugar de su mazo
    private Carta seleccionarCartaParaJugar(Scanner scanner, Cola mazo) {
        Carta seleccionada = null;
        while (seleccionada == null) {
            System.out.print("Escriba el nombre de la carta que desea jugar: ");
            String nombre = scanner.nextLine();

            seleccionada = mazo.eliminarCartaPorNombre(nombre); // Debes implementar este método para extraer carta de la cola
            if (seleccionada == null) {
                System.out.println("Carta no encontrada en tu mazo. Intenta otra vez.");
            }
        }
        return seleccionada;
    }

    // Método emoji para tipo
    private String emojiParaTipo(String tipo) {
        return switch (tipo.toLowerCase()) {
            case "fuego" -> "🔥";
            case "agua" -> "💧";
            case "tierra" -> "🪨";
            case "aire", "viento" -> "🌪️";
            default -> "";
        };
    }

    private ListaEnlazada crearBarajaPrincipal() {
        ListaEnlazada baraja = new ListaEnlazada();
        baraja.agregarCarta(new Carta("MagoFuego", "Fuego", 90));
        baraja.agregarCarta(new Carta("GuerreroAgua", "Agua", 75));
        baraja.agregarCarta(new Carta("ArqueroTierra", "Tierra", 65));
        baraja.agregarCarta(new Carta("CazadorViento", "Aire", 80));
        baraja.agregarCarta(new Carta("HechiceroFuego", "Fuego", 85));
        baraja.agregarCarta(new Carta("NinjaAgua", "Agua", 70));
        baraja.agregarCarta(new Carta("DefensorTierra", "Tierra", 60));
        baraja.agregarCarta(new Carta("ExploradorViento", "Aire", 75));
        baraja.agregarCarta(new Carta("CaballeroFuego", "Fuego", 95));
        baraja.agregarCarta(new Carta("GuardabosquesAgua", "Agua", 68));

        return baraja;
    }

    private void seleccionarCartasJugador(Scanner scanner, ListaEnlazada baraja, Cola mazoJugador) {
        int cartasSeleccionadas = 0;
        while (cartasSeleccionadas < 5) {
            System.out.print("Escriba el nombre de la carta #" + (cartasSeleccionadas + 1) + ": ");
            String nombre = scanner.nextLine();

            Carta carta = baraja.obtenerYEliminarCartaPorNombre(nombre);
            if (carta != null) {
                mazoJugador.encolar(carta);
                cartasSeleccionadas++;
                System.out.println("Carta añadida: " + carta);
            } else {
                System.out.println("Carta no encontrada o ya seleccionada. Intente otra vez.");
            }
        }
    }

    private void generarMazoCPU(ListaEnlazada baraja, Cola mazoCPU, int cantidad) {
        for (int i = 0; i < cantidad; i++) {
            Carta carta = baraja.obtenerCartaAleatoria();
            if (carta != null) {
                mazoCPU.encolar(carta);
            }
        }
    }

}
