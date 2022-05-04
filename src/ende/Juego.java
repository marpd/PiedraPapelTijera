package ende;

/**
 * Simula el juego de Piedra, Papel o tijera
 * @author Marce
 */


public class Juego {

    public static final int VICTORIAS_OBJETIVO = 3;
    private static int rondasJugadas;
    private static int exitosJugador1;
    private static int exitosJugador2;
    private static int empates;

    public static void main(String[] args) {
        Jugador p1 = new Jugador();
        Jugador p2 = new Jugador();
        boolean finDeJuego;
        // Número de rondas jugadas
        rondasJugadas = 0;
        exitosJugador1 = p1.getExitos();
        exitosJugador2 = p2.getExitos();
        empates = 0;

        // Bucle de juego
        do {
            JUGADA opcionJugador1 = p1.opcion_al_azar();
            JUGADA opcionJugador2 = p2.opcion_al_azar();

            informeRonda(opcionJugador1, opcionJugador2);
            procesaRonda(p1, p2, opcionJugador1, opcionJugador2);
            finDeJuego = esFinDeJuego(p1, p2);
            System.out.println();
        } while (!finDeJuego);
    }

    private static void procesaRonda(Jugador p1, Jugador p2, JUGADA opcionJugador1, JUGADA opcionJugador2) {
        int resultado = opcionJugador1.gana(opcionJugador2);
        switch (resultado) {
            case 1 -> exitosJugador2 = jugadorGana(p2, 2);
            case -1 -> exitosJugador1 = jugadorGana(p1, 1);
            default -> {
                empates++;
                System.out.println("\n\t\t\t Empate \n");
            }
        }
        rondasJugadas++;
    }

    private static boolean esFinDeJuego(Jugador p1, Jugador p2) {
        if ((p1.getExitos() >= VICTORIAS_OBJETIVO) || (p2.getExitos() >= VICTORIAS_OBJETIVO)) {
            System.out.println("FIN DEL JUEGO!!");
            return true;
        }
        return false;
    }

    /**
     * Informe previo a cada ronda, incluyendo la opción seleccionada por cada jugador
     */
    private static void informeRonda(JUGADA opcionJugador1, JUGADA opcionJugador2) {
        System.out.println("***** Ronda: " + rondasJugadas + " *********************\n");
        System.out.println("Numero de empates: " + empates + "\n");
        System.out.println("Jugador 1: " + opcionJugador1 + "\t Jugador 1 - Partidas ganadas: " + exitosJugador1);
        System.out.println("Jugador 2: " + opcionJugador2 + "\t Jugador 2 - Partidas ganadas: " + exitosJugador2);
    }

    /**
     * Informa de qué jugador gana la ronda e incrementa su contador de exitos
     */
    private static int jugadorGana(Jugador jugador, int numJugador) {
        int exitosJugador;
        System.out.println("Jugador " + numJugador + " GANA");
        exitosJugador = jugador.incrementaExitos();
        return exitosJugador;
    }
}
