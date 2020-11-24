import Errores.CepillosSuciosError;
import Errores.SinBateriaError;
import Modelos.Aspiradora;
import Servicios.Implementaciones.UsuarioServicio;

public class Main {


    public static void main(String[] args) throws SinBateriaError, CepillosSuciosError {

        Aspiradora aspiradora = new Aspiradora();
        //Ambiente ambiente = new Ambiente(cargarFilas(), cargarColumnas());

        UsuarioServicio servicio = new UsuarioServicio();

        servicio.cargarFilas();
        ambiente.mostrarAmbiente();
        aspiradora.mover(ambiente);

    }




    //Outputs



}
