package Modelos;

public class Cepillo {
    private boolean estaLimpio;
    int suciedad;

    public Cepillo() {
        this.estaLimpio = true;
        this.suciedad = 0;
    }

    public void ensuciarCepillo() {
        suciedad++;
        if (suciedad >= 100) {
            estaLimpio = false;
        }
    }

    //GETTERS Y SETTERS
    public boolean getEstaLimpio() {
        return estaLimpio;
    }

    public void setEstaLimpio(boolean estaLimpio) {
        this.estaLimpio = estaLimpio;
    }

    public int getSuciedad() {
        return suciedad;
    }

    public void setSuciedad(int suciedad) {
        this.suciedad = suciedad;
    }
}
