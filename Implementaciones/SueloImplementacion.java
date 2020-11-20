package Implementaciones;

import Interfaces.iSuelo;
import Modelos.Suelo;


public class SueloImplementacion implements iSuelo {

    Suelo suelo = new Suelo();

    @Override
    public void mostrarSuelo() {
        if (suelo.getTieneObstaculo()){
            System.out.print("X");
        } else if (suelo.getEstaLimpio()) {
            System.out.print("L");
        } else if (!suelo.getEstaLimpio()) {
            System.out.print("S");
        }
    }
}
