package ende;

import java.util.Random;

public enum JUGADA{
    PIEDRA("piedra"),PAPEL("papel"),TIJERA("tijera");
    private final String etiqueta;

    JUGADA(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public static JUGADA aleatoria() {
        Random random = new Random();
        int posAl = random.nextInt(JUGADA.values().length);
        return JUGADA.values()[posAl];
    }

    public boolean esPiedra(){
        return this==PIEDRA;
    }
    public boolean esPapel(){
        return this==PAPEL;
    }
    public boolean esTijera(){
        return this==TIJERA;
    }

    @Override
    public String toString() {
        return etiqueta;
    }

    public int gana(JUGADA otra){
        if (this.esTijera() && otra.esPapel() || this.esPiedra() && otra.esTijera() || this.esPapel() && otra.esPiedra())
            return -1; // Gana j1
        else if (this == otra) {
            return 0; //Empate
        } else return 1; //Gana j2
    }
}
