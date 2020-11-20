package Modelos;

import java.util.HashMap;
import java.util.Map;

public class Suelo {
    private boolean tieneObstaculo;
    private boolean estaLimpio;
    private Map<String, Integer> bordes;

    public Suelo (){
        this.tieneObstaculo = false;
        this.estaLimpio = false;
        this.bordes =  new HashMap<String, Integer>();
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

    public void inicializarBordes() {
        bordes.put("derecha", 0);
        bordes.put("izquierda", 0);
        bordes.put("arriba", 0);
        bordes.put("abajo", 0);
    }

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

    public Map<String, Integer> getBordes() {
        return bordes;
    }

    public void setBordes(Map<String, Integer> bordes) {
        this.bordes = bordes;
    }
}
