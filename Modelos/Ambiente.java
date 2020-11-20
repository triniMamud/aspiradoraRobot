package Modelos;

public class Ambiente {

    private Suelo[][] ambiente;


    public Ambiente(int filas, int columnas) {
        this.ambiente = new Suelo[filas][columnas];
    }

    public void cargarAmbiente () {

        double cantidadSuelo = ambiente.length*ambiente[0].length;

        for (int i = 0; i < ambiente.length; i++) {
            for (int j = 0; j < ambiente[0].length; j++) {
                ambiente[i][j] = new Suelo();
            }
        }

        for (int i = 0; i < Math.random()*cantidadSuelo; i++) {
            ambiente[(int) (Math.random()* ambiente.length)][(int) (Math.random()* (ambiente[0].length))].setTieneObstaculo(true);
        }

        setearBordes();
    }

    public void mostrarAmbiente() {
        for (int i = 0; i < ambiente.length; i++) {
            for (int j = 0; j < ambiente[0].length; j++){
                ambiente[i][j].mostrarSuelo();
                System.out.print("\t");
            }
            System.out.print("\n");
        }
    }

    public void setearBordes() {
        for (int i = 0; i < ambiente.length; i++){
            ambiente[0][i].setEsBorde(true);
            ambiente[ambiente.length-1][i].setEsBorde(true);
        }

        for (int i = 0; i < ambiente[0].length; i++){
            ambiente[i][0].setEsBorde(true);
            ambiente[i][ambiente[0].length-1].setEsBorde(true);
        }
    }

    public Suelo[][] getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(Suelo[][] ambiente) {
        this.ambiente = ambiente;
    }
}
