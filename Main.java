import Modelos.Ambiente;
import Modelos.Aspiradora;

import java.util.Scanner;

public class Main {


    public static void main(String[] args){

        Aspiradora aspiradora = new Aspiradora();
        Ambiente ambiente = new Ambiente(cargarFilas(), cargarColumnas());

        ambiente.cargarAmbiente();
        ambiente.mostrarAmbiente();
        aspiradora.mover(ambiente);
        System.out.print("=================================================================\n\n");
        ambiente.mostrarAmbiente();

    }


    public static int cargarFilas (){
        System.out.print("Ingrese la cantidad de filas: ");
        return Integer.parseInt(readInput());
    }

    public static int cargarColumnas (){
        System.out.print("Ingrese la cantidad de columnas: ");

        return Integer.parseInt(readInput());
    }

    //Inputs
    public static String readInput (){
        Scanner readInput = new Scanner(System.in);

        return readInput.nextLine();
    }

    //Outputs



}
