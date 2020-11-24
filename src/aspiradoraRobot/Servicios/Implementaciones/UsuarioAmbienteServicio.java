package Servicios.Implementaciones;

import Modelos.Ambiente;
import Modelos.Suelo;
import Servicios.iUsuarioAmbiente;

public class UsuarioAmbienteServicio implements iUsuarioAmbiente {

    UsuarioServicio usuario = new UsuarioServicio();
    AmbienteServicio ambiente = new AmbienteServicio();

    @Override
    public void cargarAmbiente() {
        ambiente.inicializarAmbiente();
    }


    @Override
    public void mostrarAmbiente() {
        for(int i = 0; i < ambiente.getColumnas(); ++i) {
            for(int j = 0; j < ambiente.getFilas(); ++j) {
                ambiente.getAmbiente()[i][j].mostrarSuelo();
                System.out.print("\t");
            }

            System.out.print("\n");
        }
    }


}
