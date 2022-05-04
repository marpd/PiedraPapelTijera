package ende;

/**
 *
 */
class Jugador {

    private int exitos;      // número de partidas ganadas

    /**
     * Escoge piedra, papel o tijera al azar
     */
    public JUGADA opcion_al_azar() {
        return JUGADA.aleatoria();
    }

    public int incrementaExitos() {
        return ++exitos;
    }

    public int getExitos() {
        return exitos;
    }

    public void setExitos(int exitos) {
        this.exitos = exitos;
    }
}
