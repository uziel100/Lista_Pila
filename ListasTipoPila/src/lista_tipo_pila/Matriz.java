package lista_tipo_pila;

public class Matriz {
    private int[][] arr;
    private int Fil, col;

    /**
     * Constructor vacio
     */
    public Matriz() {
        this.Fil = 1;
        this.col = 1;
        this.arr = null;
    }

    /**
     * Contructor normal
     * @param f indica el numero de filas del arreglo
     * @param c indica el numero de columnas del arreglo
     */
    public Matriz(int f, int c) {
        this.Fil = f;
        this.col = c;
        this.arr = new int[f][c];        
    }

    /**
     * Constructor de copia
     * @param obj recibe un parametro de tipo Matriz
     */
    public Matriz(Matriz obj) {
        Fil = obj.Fil;
        col = obj.col;
        this.arr = new int[Fil][col];
        for (int fila = 0; fila < Fil;  fila++) {
            for (int colum = 0; colum < col;  colum++) {
                this.arr[fila][colum] = obj.arr[fila][colum];
            }
        }
    }
    
    /**
     * Metodo que comprueba si el 
     * @return 
     */
    public boolean isEmpty(){
        return arr == null;
    }

    /**
     * Metodo getter
     * @return el tamaño de la fila de la matriz
     */
    public int getFil(){ return Fil; }
    
    /**
     * Metodo getter
     * @return el tamaño de las columnas de la matriz
     */
    public int getcol(){ return col; }

    /**
     * Metodo setter
     * @param fil recibe el parametro fil, para asignar las filas
     * que contendra la matriz
     */
    public void setFil(int fil) {
        if (fil > 0) {
            this.Fil = fil;
            this.arr = new int[fil][col];
        }
    }
    /**
     * Metodo setter
     * @param col recibe el parametro col, para asignar las columnas que 
     * contendra el arreglo
     */
    public void setcol(int col) {
        if (col > 0) {
            this.col = col;
            this.arr = new int[Fil][col];
        }
    }

    /**
     * Metodo getter
     * @return una copia de la matriz de la clase
     */
    public int[][] getArr1() {
        int[][]copy  = new int[this.Fil][this.col];
        for (int fila = 0; fila < Fil;  fila++) {
            for (int colum = 0; colum < col;  colum++) {
                copy[fila][colum] = arr[fila][colum];
            }
        }
        return copy;
    }

    /**
     * Metodo setter
     * @param arr1 recibe el parametro
     */
    public void setArr1 (int[][] arr1) {
        this.Fil = arr1.length;
        this.col = arr1[0].length;
        this.arr = new int[Fil][col];
        for (int fila = 0; fila < Fil;  fila++) {
            for (int colum = 0; colum < col;  colum++) {
                this.arr[fila][colum] = arr1[fila][colum];
            }
        }
    }

    public int suma(){
        int suma = 0;
        for (int fila = 0; fila < Fil;  fila++) {
            for (int colum = 0; colum < col;  colum++) {
                suma = suma + this.arr[fila][colum];
            }
        }
        return suma;
    }
    public int resta(){
        int resta = 0;
        for (int fila = 0; fila < Fil;  fila++) {
            for (int colum = 0; colum < col;  colum++) {
                resta =  resta - this.arr[fila][colum];
            }
        }
        return  resta;
    }

    public float promedio(){
        //aqui llme al metodo seuma() pa
        return (float) suma()/(Fil * col);
    }

    public int mayor(){
        int mayor=0;
        for (int fila = 0; fila < Fil;  fila++) {
            for (int colum = 0; colum < col;  colum++) {
                if(arr[fila][colum] > mayor){
                    mayor=arr[fila][colum];
                }
            }
        }
        return mayor;

    }
    public int menor(){
        int menor=0;
        for (int fila = 0; fila < Fil;  fila++) {
            for (int colum = 0; colum < col;  colum++) {
                if (fila == 0 && colum == 0) {

                    menor = arr[fila][colum];
                }
                if (arr[fila][colum] < menor) {
                    menor = arr[fila][colum];
                }
            }
        }
        return menor;
    }

    @Override
    public String toString() {
        String cadena = "";
        for (int fila = 0; fila < Fil; fila++) {
            for (int colum = 0; colum < col; colum++) {
                if(fila == 0 && colum==0)
                    cadena = "[" + this.arr[fila][0] + "]";
                else{
                    cadena = cadena + "[" + this.arr[fila][colum] + "]";
                }
            }
            cadena = cadena +"\n";
        }
        return cadena;
    }
    
    public void sumaMatriz(int[][] ma1, int[][] ma2){
        int[][] resultado = new int[ma1.length][ma1.length];
        for (int f = 0; f < ma1.length; f++) {
            for (int c = 0;c < ma1[0].length; c++) {
                resultado[f][c] = ma1[f][c] + ma1[f][c];
            }
        }
        setArr1(resultado);
    }
    
    public void restaMatriz(int[][] ma1, int[][] ma2){
        int[][] resultado = new int[ma1.length][ma1.length];
        for (int f = 0; f < ma1.length; f++) {
            for (int c = 0;c < ma1[0].length; c++) {
                resultado[f][c] = ma1[f][c] - ma1[f][c];
            }
        }
        setArr1(resultado);
    }
    
    public void sortBuble(){
        Arreglo a = new Arreglo(this.arr.length * 2);
        int[] aux = new int[Fil*col];
        int i = 0;
        for (int f = 0; f <  (col * Fil); f++) {
            for (int j = 0; j < 10; j++) {
                aux[i] = this.arr[i][j];
                i++;
            }
        }
        a.setArrNum(aux);
        a.sortBurble();
        aux = a.getArrNum();
        i = 0;
        for (int fi = 0; fi < Fil; fi++) {
            for (int c = 0; c < col; c++) {
                this.arr[fi][c] = aux[i];
                i++;
            }
        }
    }

}
