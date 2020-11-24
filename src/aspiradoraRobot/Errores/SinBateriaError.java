package Errores;

public class SinBateriaError extends Exception {
    public SinBateriaError () {
        super("Aspiradora sin bateria");
    }
}
