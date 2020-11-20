package Modelos;/*
El TP consiste en el diseño de una aspiradora robot. Básicamente su funcionamiento es recorrer un ambiente y limpiarlo.
Al encontrar obstáculos debe intentar esquivarlos. Ocasionalmente, puede ser que deje de funcionar porque sus cepillos deben ser limpiados.
En esencia, se puede resumir el funcionamiento de la aspiradora a través de los siguientes puntos:
-	Una vez encendida, recorre el ambiente moviéndose  y lo limpia con sus cepillos.
-	Tiene dos cepillos, izquierdo y derecho.
-	Se mueve hacia adelante, hacia atrás, hacia la izquierda,  y hacia la derecha.
-	Si algún cepillo está sucio la aspiradora se apaga e informa el error. Debe manualmente limpiarse y volverla a encender.
-	Tiene dos modos de velocidad: normal y rápido.
        El modo puede cambiarse en todo momento. Con el modo rápido la aspiradora se desplaza con mayor velocidad.
-	Una vez que termina de recorrer el ambiente, se apaga.
-	Si la batería se agota, la aspiradora se apaga e informa el error.
-	Para cargar la batería, simplemente se conecta manualmente a la corriente.
-	Ante la presencia de un obstáculo, debe intentar moverse para ver si es posible esquivarlo. De no ser posible, se apaga e informa el error.

Se debe modelar el ambiente a limpiar, y el funcionamiento de la aspiradora.  Se deben entregar el diagrama de clases,
y 5 diagramas de secuencia para 5 comportamientos específicos a elección.


*/

public class Aspiradora {

    final int posEsquivar = 2;
    final int posMover = 1;

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

    public String determinarSubidas (Ambiente ambiente){ //p: par, i: impar
        String baja = "i";
        if (ambiente.getAmbiente()[0].length %2 == 0){
            baja = "p";
        }

        return baja;
    }

    public boolean limpiar(Ambiente ambiente) {
        if (bateria > 0 && cepilloLimpio()){
            ambiente.getAmbiente()[posicionFila][posicionColumna].setEstaLimpio(true);
        }
        return ambiente.getAmbiente()[posicionFila][posicionColumna].getEstaLimpio();
    }

    public void mover(Ambiente ambiente) {
        System.out.println("columna " + posicionColumna);
        if (!limpiar(ambiente) || ambiente.getAmbiente()[0].length == posicionColumna+1){
            System.out.println("ERROR: no se puede seguir limpiando");
        }
        else {
            limpiar(ambiente);
            if ("p".equals(determinarSubidas(ambiente))) { //SUBO

                //IMPLEMENTAR LOS BORDES CON EL HASH PARA QUE NO SE MUEVA SOLO DE COLUMNAS

                if (!ambiente.getAmbiente()[posicionFila][posicionColumna].getEsBorde()){
                    if (ambiente.getAmbiente()[posicionFila - posMover][posicionColumna].getTieneObstaculo()) {
                        posicionFila = posicionFila-posEsquivar;
                        System.out.println("lmpia sube esquivo");
                        mover(ambiente);
                    } else {
                        posicionFila = posicionFila-posMover;
                        System.out.println("limpia sube muevo");
                        mover(ambiente);
                    }
                } else {
                    posicionColumna++;
                    System.out.println("cambia col subo");
                    mover(ambiente);
                }

            } else { //BAJO
                if (!ambiente.getAmbiente()[posicionFila][posicionColumna].getEsBorde()){
                    if (ambiente.getAmbiente()[posicionFila + posMover][posicionColumna].getTieneObstaculo()) {
                        posicionFila = posicionFila+posEsquivar;
                        System.out.println("limpia bja esquivo");
                        mover(ambiente);
                    } else {
                        posicionFila = posicionFila+posMover;
                        System.out.println("limpia bja muevo");
                        mover(ambiente);
                    }
                } else {
                    posicionColumna++;
                    System.out.println("cambia col bajo " );
                    mover(ambiente);
                }
            }
            //bajarBateria
            //ensuciarCepillos
        }


    }

    public boolean chequearBorde (int fila, int columna, Suelo[][] ambiente){
        return (ambiente[fila][columna].getEsBorde());
    }

    public boolean cepilloLimpio (){
        return (cepillos[0].getEstaLimpio() && cepillos[1].getEstaLimpio());
    }

    public void posicionarEnOrigen (){
        posicionFila = 0;
        posicionColumna = 0;
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