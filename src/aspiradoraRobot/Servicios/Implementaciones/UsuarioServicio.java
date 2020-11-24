package Servicios.Implementaciones;

import Servicios.iUsuario;

import java.util.Scanner;


public class UsuarioServicio implements iUsuario {

    public static int filas;
    public static int columnas;

    public int cargarFilas (){
        System.out.print("Ingrese la cantidad de filas: ");
        return Integer.parseInt(readInput());
    }

    public int cargarColumnas (){
        System.out.print("Ingrese la cantidad de columnas: ");

        return Integer.parseInt(readInput());
    }

    public String readInput (){
        Scanner readInput = new Scanner(System.in);

        return readInput.nextLine();
    }
}
