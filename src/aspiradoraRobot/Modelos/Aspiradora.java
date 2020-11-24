package Modelos;

import Errores.CepillosSuciosError;
import Errores.SinBateriaError;

public class Aspiradora {

    static final int posEsquivar = 2;
    static final int posMover = 1;
    enum velocidad { minima, maxima;}

    private Cepillo[] cepillos;
    private int velocidad;
    private int bateria;
    private int posicionColumna;
    private int posicionFila;

    public Aspiradora(){
        this.cepillos = new Cepillo[2];
        inicializarCepillos();
        this.velocidad = 0;
        this.bateria = 100;
        this.posicionColumna = 0;
        this.posicionFila = 0;
    }

    public void inicializarCepillos(){
        this.cepillos[0] = new Cepillo();
        this.cepillos[1] = new Cepillo();
    }

    public void cambiarVelocidad (int velocidad) {
        this.velocidad = velocidad;
    }

    public boolean limpiar(Ambiente ambiente) {
        if (this.bateria > 0 && cepillosLimpios() && !terminoDeLimpiar(ambiente)){
            ambiente.getAmbiente()[posicionFila][posicionColumna].setEstaLimpio(true);
            ensuciarCepillos();
        }
        return ambiente.getAmbiente()[this.posicionFila][this.posicionColumna].getEstaLimpio();
    }

    public void limpiarUltimaCelda(Ambiente ambiente) {
        ambiente.getAmbiente()[this.posicionFila][this.posicionColumna].setEstaLimpio(true);
        ensuciarCepillos();
    }

    public boolean terminoDeLimpiar(Ambiente ambiente) {
        if (ambiente.getAmbiente()[0].length % 2 == 0) {
            return (ambiente.getAmbiente()[this.posicionFila][this.posicionColumna].getBordes().get("arriba") &&
                    ambiente.getAmbiente()[this.posicionFila][this.posicionColumna].getBordes().get("derecha"));
        } else {
            return (ambiente.getAmbiente()[this.posicionFila][this.posicionColumna].getBordes().get("abajo") &&
                    ambiente.getAmbiente()[this.posicionFila][this.posicionColumna].getBordes().get("derecha"));
        }
    }

    public void mover(Ambiente ambiente) throws SinBateriaError, CepillosSuciosError {
        if (ambiente.getAmbiente()[0].length == this.posicionColumna || !limpiar(ambiente)){
            finalizarLimpieza(ambiente);
        } else {
            limpiar(ambiente);
            bajarBateria();
            if (this.posicionColumna%2 == 1) {
                moverArriba (ambiente);
            } else {
                moverAbajo(ambiente);
            }
        }
    }

    public void moverArriba(Ambiente ambiente) throws SinBateriaError, CepillosSuciosError {
        if (!(ambiente.getAmbiente()[this.posicionFila][this.posicionColumna].getBordes().get("arriba"))){

            if (ambiente.getAmbiente()[this.posicionFila - posMover][this.posicionColumna].getTieneObstaculo()) {
                this.posicionFila = this.posicionFila - posEsquivar;
                mover(ambiente);
            } else {
                this.posicionFila = this.posicionFila - posMover;
                mover(ambiente);
            }
        } else {
            this.posicionColumna++;
            mover(ambiente);
        }
    }

    public void moverAbajo(Ambiente ambiente) throws SinBateriaError, CepillosSuciosError {
        if (!(ambiente.getAmbiente()[posicionFila][posicionColumna].getBordes().get("abajo"))){

            if (ambiente.getAmbiente()[this.posicionFila + posMover][this.posicionColumna].getTieneObstaculo()) {
                this.posicionFila = this.posicionFila + posEsquivar;
                mover(ambiente);
            } else {
                posicionFila = posicionFila+posMover;
                mover(ambiente);
            }
        } else {
            posicionColumna++;
            mover(ambiente);
        }
    }

    public void finalizarLimpieza (Ambiente ambiente) throws CepillosSuciosError, SinBateriaError {
        limpiarUltimaCelda(ambiente);
        ambiente.mostrarAmbiente();
        determinarError();
        System.out.println("El ambiente ha sido limpiado correctamente");
    }

    public void determinarError() throws SinBateriaError, CepillosSuciosError {
        if (this.bateria == 0) {
            throw new SinBateriaError();
        }
        if (!cepillosLimpios()) {
            throw new CepillosSuciosError();
        }
    }

    public void bajarBateria() {
        this.bateria--;
    }

    public void ensuciarCepillos() {
        this.cepillos[0].ensuciarCepillo();
        this.cepillos[1].ensuciarCepillo();
    }

    public boolean cepillosLimpios (){
        return (this.cepillos[0].getEstaLimpio() && this.cepillos[1].getEstaLimpio());
    }









    //GETTERS Y SETTERS
    public Cepillo[] getCepillos() {
        return cepillos;
    }

    public void setCepillos(Cepillo[] cepillos) {
        this.cepillos = cepillos;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getBateria() {
        return bateria;
    }

    public void setBateria(int bateria) {
        this.bateria = bateria;
    }
}