package org.juego;

import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import org.juego.estructuras.ListaEnlazada;
import org.juego.estructuras.cola.Cola;
import org.juego.estructuras.pila.Pila;
import org.juego.logica.arbolDesiciones.ArbolDecision;
import org.juego.logica.hash.RegistroJugador;
import org.juego.modelos.Carta;

public class Main {
    
    private static Scanner scanner = new Scanner(System.in);
    private static ListaEnlazada barajaPrincipal;
    private static Cola mazoJugador;
    private static Cola mazoCPU;
    private static Pila derrotasJugador;
    private static Pila derrotasCPU;
    private static ArbolDecision arbolDecision;
    private static HashMap<String, RegistroJugador> estadoJuego;

    public static void main(String[] args) {
        derrotasJugador = new Pila();
        derrotasCPU = new Pila();
        System.out.println("     <-<<-<-<<-<-<<-<-<<-<-<<-<-<<-<-<<-<-<< BIENVENIDO A LA BATALLA DE PODERES >>->->>->->>->->>->->>->->>->->>->->>->");
        System.out.print("                                                    Ingrese su nombre: ");
        String nombreJugador = scanner.nextLine();

        inicializarJuego(nombreJugador);
        jugarPartida(nombreJugador);
    }

    private static void inicializarJuego(String nombreJugador) {
        barajaPrincipal = new ListaEnlazada();
        mazoJugador = new Cola();
        mazoCPU = new Cola();
        derrotasJugador = new Pila();
        derrotasCPU = new Pila();
        arbolDecision = new ArbolDecision();
        estadoJuego = new HashMap<>();
        estadoJuego.put(nombreJugador, new RegistroJugador());
        estadoJuego.put("CPU", new RegistroJugador());

        crearBarajaPrincipal();
        repartirCartasJugadores();
    }

    public static void crearBarajaPrincipal() {
        String[] tipos = {"Fuego", "Agua", "Tierra", "Aire"};

        String[] nombresFuego = {
            "Fenix de Fuego", "Salamandra de Lava", "Dragon Infernal", "Guerrero Flameante",
            "Espiritu de la Incineracion", "Bestia Ignea", "Centinela Ardiente", "Llama Sagrada",
            "Emperador Volcanico", "Cometa Escarlata", "Forjador del Infierno", "Ave de Ceniza"
        };

        String[] nombresAgua = {
            "Sirena de Agua", "Leviatan", "Guerrero de las Profundidades", "Tifon Oceanico",
            "Hidra Marina", "Espiritu del Rocio", "Triton de Coral", "Reina del Abismo",
            "Guardian de los Mares", "Tsunami Viviente", "Kraken Sombrio", "Corazon de la Marea"
        };

        String[] nombresTierra = {
            "Golem de Tierra", "Guardian del Bosque", "Titan de Piedra", "Enraizador",
            "Coloso del Valle", "Arbol Milenario", "Bestia de Roca", "Espiritu del Cañon",
            "Centinela Terrenal", "Gigante Errante", "Eco del Subsuelo", "Rey de la Caverna"
        };

        String[] nombresAire = {
            "Angel de la Tormenta", "Harpia Celestial", "Dragon de Viento", "Torbellino Viviente",
            "Espiritu del Vortice", "Flecha de Brisa", "Centella Alada", "Dama del Viento",
            "Aguila del Horizonte", "Ciclon Plateado", "Tempestad Errante", "Guardiana del Cielo"
        };

        // Agregar cartas de Fuego
        for (String nombre : nombresFuego) {
            int poder = ThreadLocalRandom.current().nextInt(1, 101);
            barajaPrincipal.agregarCarta(new Carta(nombre, "Fuego", poder));
        }

        // Agregar cartas de Agua
        for (String nombre : nombresAgua) {
            int poder = ThreadLocalRandom.current().nextInt(1, 101);
            barajaPrincipal.agregarCarta(new Carta(nombre, "Agua", poder));
        }

        // Agregar cartas de Tierra
        for (String nombre : nombresTierra) {
            int poder = ThreadLocalRandom.current().nextInt(1, 101);
            barajaPrincipal.agregarCarta(new Carta(nombre, "Tierra", poder));
        }

        // Agregar cartas de Aire
        for (String nombre : nombresAire) {
            int poder = ThreadLocalRandom.current().nextInt(1, 101);
            barajaPrincipal.agregarCarta(new Carta(nombre, "Aire", poder));
        }

        System.out.println("\nTODAS LAS CARTAS EXISTENTES: ");
        barajaPrincipal.mostrarBaraja();
    }

    public static void repartirCartasJugadores() {
        System.out.println("\n- - - - - - - - - - - - - - - - - - - - S E  R E P A R T E N  L A S  C A R T A S - - - - - - - - - - - - - - - - - - - - ");

        // 10 cartas por jugador
        for (int i = 0; i < 10; i++) {
            // Seleccionar carta aleatoria para el jugador----------------------
            int indice = ThreadLocalRandom.current().nextInt(0, barajaPrincipal.getSize() - 1);
            Carta cartaJugador = barajaPrincipal.buscarCartaPorIndice(indice);
            mazoJugador.encolar(cartaJugador);
            // Seleccionar carta aleatoria para la CPU--------------------------
            indice = ThreadLocalRandom.current().nextInt(0, barajaPrincipal.getSize());
            Carta cartaCPU = barajaPrincipal.buscarCartaPorIndice(indice);
            mazoCPU.encolar(cartaCPU);

        }

        System.out.print("\n                               Tu tienes " + mazoJugador.getSize() + " cartas en tu mazo");
        System.out.print(" y tu oponente tiene " + mazoCPU.getSize() + " cartas\n");

        System.out.println("\n---------- C A R T A S - D E L - J U G A D O R --------");
        mazoJugador.mostrarCartas();
        System.out.println("\n----------------- C A R T A S - C P U ---------------");
        mazoCPU.mostrarCartas();
    }

    private static void jugarPartida(String nombreJugador) {
        int ronda = 1;
        int rondasTotales = mazoJugador.getSize();

        while (ronda <= rondasTotales && !mazoJugador.estaVacia() && !mazoCPU.estaVacia()) {
            System.out.println("                                         ____________________________________________________\n"
                    + "                                         - - - - - - - - - - R O N D A " + ronda + " - - - - - - - - - -");
            Carta cartaJugador = jugadorJuegaCarta(nombreJugador);
            Carta cartaCPU = seleccionarCartaContraJugador(cartaJugador);
            evaluarCartaGanador(cartaCPU, cartaJugador, nombreJugador);
            //Mostrar cartas derrotadas del jugador
            derrotasJugador.mostrarDerrotas();
            ronda++;
            System.out.println();
        }
        // Mostrar estadísticas finales
        mostrarEstadisticasFinales(nombreJugador);
    }

    public static Carta jugadorJuegaCarta(String nombreJugador) {
        Carta cartaJugador = mazoJugador.desencolar();
        estadoJuego.get(nombreJugador).registrarCartaJugada(cartaJugador);
        System.out.println(nombreJugador + " juega: " + cartaJugador);
        return cartaJugador;
    }

    /**
     * Busca una carta específica en el mazo del CPU basado en criterios
     * estratégicos
     *
     * @param criterio Carta con las características buscadas (puede ser null
     * para buscar cualquier carta)
     * @return La carta encontrada o null si no se encuentra
     */
    private static Carta buscarCartaEnMazoCPU(Carta criterio) {
        if (mazoCPU == null || mazoCPU.estaVacia()) {
            return null;
        }
        // Si no hay criterio específico, devolver la primera carta
        if (criterio == null) {
            return mazoCPU.desencolar();
        }

        // Buscar una carta que coincida con el tipo o poder deseado
        Carta cartaEncontrada = null;
        Cola mazoTemporal = new Cola();
        int size = mazoCPU.getSize();

        for (int i = 0; i < size; i++) {
            Carta actual = mazoCPU.desencolar();

            // Primero buscar por tipo si está especificado
            if (criterio.getTipo() != null && actual.getTipo().equals(criterio.getTipo())) {
                cartaEncontrada = actual;
                // Continuar sacando las demás cartas para mantener el orden
                while (!mazoCPU.estaVacia()) {
                    mazoTemporal.encolar(mazoCPU.desencolar());
                }
                break;
            } // Si no se encontró por tipo, buscar por poder similar
            else if (Math.abs(actual.getPoder() - criterio.getPoder()) <= 10) {
                cartaEncontrada = actual;
                // Continuar sacando las demás cartas
                while (!mazoCPU.estaVacia()) {
                    mazoTemporal.encolar(mazoCPU.desencolar());
                }
                break;
            }

            mazoTemporal.encolar(actual);
        }

        // Restaurar las cartas no seleccionadas al mazo original
        while (!mazoTemporal.estaVacia()) {
            mazoCPU.encolar(mazoTemporal.desencolar());
        }

        return cartaEncontrada != null ? cartaEncontrada : mazoCPU.desencolar();
    }

    private static Carta determinarEstrategiaContra (Carta cartaJugador) {
        // Usar el árbol de decisión para determinar estrategia
        Carta cartaEstrategica = arbolDecision.decidirCarta(cartaJugador);
        // Implementar lógica simple basada en la decisión
        Carta cartaElegida = buscarCartaEnMazoCPU(cartaEstrategica);
        // En una implementación más avanzada, se podrían analizar varias cartas
        // y elegir la más adecuada según la estrategia
        return cartaElegida != null ? cartaElegida : mazoCPU.desencolar();
    }

    public static Carta seleccionarCartaContraJugador(Carta cartaJugador) {
        // CPU decide qué carta jugar
        Carta cartaCPU = determinarEstrategiaContra (cartaJugador);
        estadoJuego.get("CPU").registrarCartaJugada(cartaCPU);
        System.out.println("CPU juega: " + cartaCPU);
        return cartaCPU;
    }

    public static void evaluarCartaGanador(Carta cartaCPU, Carta cartaJugador, String nombreJugador) {
        // Determinar ganador
        if (cartaJugador.poder > cartaCPU.poder) {
            System.out.println("\n                                               Ganador de la ronda: " + nombreJugador);
            estadoJuego.get(nombreJugador).agregarRondaGanada(cartaJugador);
            derrotasCPU.agregarDerrota(cartaCPU);
            mazoJugador.encolar(cartaJugador); // La carta ganadora vuelve al mazo
        } else if (cartaCPU.poder > cartaJugador.poder) {
            System.out.println("\n                                               Ganador de la ronda: CPU ");
            estadoJuego.get("CPU").agregarRondaGanada(cartaCPU);
            derrotasJugador.agregarDerrota(cartaJugador);
            mazoCPU.encolar(cartaCPU); // La carta ganadora vuelve al mazo
        } else {
            System.out.println("\n                                               Empate en esta ronda!");
            // Ambas cartas vuelven a sus mazos
            mazoJugador.encolar(cartaJugador);
            mazoCPU.encolar(cartaCPU);
        }
    }

    private static void mostrarEstadisticasFinales(String nombreJugador) {
        System.out.println("         =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("                        - - - - - - - - - - - - E S T A D I S T I C A S  F I N A L E S - - - - - - - - - - - -");
        int rondasJugador = estadoJuego.get(nombreJugador).rondasGanadas;
        int rondasCPU = estadoJuego.get("CPU").rondasGanadas;

        System.out.println(nombreJugador + ": " + rondasJugador + " rondas ganadas");
        System.out.println("CPU: " + rondasCPU + " rondas ganadas");
        System.out.println();

        if (rondasJugador > rondasCPU) {
            System.out.println("                                                       " + nombreJugador + " gana la partida!");

        } else if (rondasCPU > rondasJugador) {
            System.out.println("                                                       CPU gana la partida!");
        } else {
            System.out.println("                                                       La partida termina en empate!");
        }
    }

}
