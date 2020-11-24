package Servicios.Implementaciones;

import Modelos.Ambiente;
import Modelos.Suelo;
import Servicios.iAmbiente;

public class AmbienteServicio implements iAmbiente {

    Ambiente ambiente = new Ambiente();

    @Override
    public void inicializarAmbiente() {
        for(int i = 0; i < ambiente.getAmbiente().length; ++i) {
            for(int j = 0; j < ambiente.getAmbiente()[0].length; ++j) {
                ambiente.getAmbiente()[i][j] = new Suelo();
            }
        }
        ubicarObstaculos();
        determinarBordes();
    }

    @Override
    public void ubicarObstaculos() {
        double cantidadSuelo = (double)(ambiente.getAmbiente().length * ambiente.getAmbiente()[0].length);

        for(int i = 0; (double)i < Math.random() * cantidadSuelo; ++i) {
            int valorRandomFila= (int)(Math.random() * ((double)ambiente.getAmbiente().length-2) +1);
            int valorRandomColumna= (int)(Math.random() * ((double)ambiente.getAmbiente().length-2) +1);

            ambiente.getAmbiente()[valorRandomFila][valorRandomColumna].setTieneObstaculo(true);
        }
    }

    @Override
    public void determinarBordes() {
        for(int i = 0; i < ambiente.getAmbiente().length; ++i) {
            ambiente.getAmbiente()[0][i].getBordes().replace("arriba", true);
            ambiente.getAmbiente()[ambiente.getAmbiente().length - 1][i].getBordes().replace("abajo", true);
        }

        for(int i = 0; i < ambiente.getAmbiente()[0].length; ++i) {
            ambiente.getAmbiente()[i][0].getBordes().replace("izquierda", true);
            ambiente.getAmbiente()[i][ambiente.getAmbiente()[0].length - 1].getBordes().replace("derecha", true);
        }
    }

    @Override
    public int getFilas() {
        return ambiente.getAmbiente()[0].length;
    }

    @Override
    public int getColumnas() {
        return ambiente.getAmbiente().length;
    }
}
