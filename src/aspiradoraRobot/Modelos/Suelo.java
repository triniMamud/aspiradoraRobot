package Modelos;

import java.util.HashMap;
import java.util.Map;

public class Suelo {
    private boolean tieneObstaculo;
    private boolean estaLimpio;
    private Map<String, Boolean> bordes;

    public Suelo (){
        this.tieneObstaculo = false;
        this.estaLimpio = false;
        this.bordes =  new HashMap<String, Boolean>();
        inicializarBordes();
    }

    public void inicializarBordes() {
        bordes.put("derecha", false);
        bordes.put("izquierda", false);
        bordes.put("arriba", false);
        bordes.put("abajo", false);
    }

    public void mostrarSuelo() {
        if (tieneObstaculo){
            System.out.print("X");
        } else if (estaLimpio) {
            System.out.print("L");
        } else if (!estaLimpio) {
            System.out.print("S");
        }
    }

    //GETTERS Y SETTERS
    public boolean getTieneObstaculo() {
        return tieneObstaculo;
    }

    public void setTieneObstaculo(boolean tieneObstaculo) {
        this.tieneObstaculo = tieneObstaculo;
    }

    public boolean getEstaLimpio() {
        return estaLimpio;
    }

    public void setEstaLimpio(boolean estaLimpio) {
        this.estaLimpio = estaLimpio;
    }

    public Map<String, Boolean> getBordes() {
        return bordes;
    }

    public void setBordes(Map<String, Boolean> bordes) {
        this.bordes = bordes;
    }
}
