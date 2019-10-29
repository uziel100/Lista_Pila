package lista_tipo_pila;

import java.util.Random;

public class Arreglo {

    private int tam;
    private String[] arr;
    private int[] arrNum;
    private boolean ordenado;

    /**
     * Constructor vacio
     */
    public Arreglo() {
        this.tam = 0;
        this.arr = null;
        this.arrNum = null;
        ordenado = false;
    }

    /**
     * Constructor normal
     * @param tam recibe el parametro tam que indicara el 
     * tamaño del arreglo
     */
    public Arreglo(int tam) {
        setTam(tam);
    }

    /**
     * Constructor de copia
     * @param obj recibe un paremetro de tipo Arreglo
     */
    public Arreglo(Arreglo obj) {
        setTam(obj.tam);
        for (int i = 0; i < this.tam; i++) {
            this.arr[i] = obj.arr[i];
        }
    }

    /**
     * Metodo getter 
     * @return el tamaño del arreglo
     */
    public int getTam() {
        return tam;
    }

    /**
     * Metodo setter 
     * @param tam recibe el parametro tamaño que sera usuado para indicar 
     * el tamaño del arreglo
     */
    public void setTam(int tam) {
        if (tam > 0) {
            this.tam = tam;
            this.arr = new String[tam];
        }
    }

    /**
     * Metodo getter para un arreglo de tipo String
     * @return el arreglo de tipo String de la clase
     */
    public String[] getArr() {
        String[] copy = new String[this.tam];
        System.arraycopy(this.arr, 0, copy, 0, copy.length);
        return copy;
    }

    /**
     * Metodo getter de tipo entero
     * @return un arreglo de tipo entero
     */
    public int[] getArrNum() {
        int[] copy = new int[this.tam];
        System.arraycopy(this.arrNum, 0, copy, 0, copy.length);
        return copy;
    }

    /**
     * Metodo setter para el arreglo de string
     * @param arr recibe el parametro arr que incializará al arreglo
     * de tipo string de la clase
     */
    public void setArr(String[] arr) {
        if (!isEmpty()) {
            this.tam = arr.length;
            this.arr = new String[this.tam];
            System.arraycopy(arr, 0, this.arr, 0, arr.length);
        }
    }

    /**
     * Metodo setter para al arreglo de tipo int
     * @param arr recibe el arreglo para asignar al arreglo de la clase
     */
    public void setArrNum(int[] arr) {
        if (!isEmpty()) {
            this.tam = arr.length;
            this.arrNum = new int[this.tam];
            System.arraycopy(arr, 0, this.arrNum, 0, arr.length);
        }
    }

    /**
     * Metodo que comprueba si el arreglo esta vacio
     * @return verdadero si el arreglo esta vacio o visceversa
     */
    public boolean isEmpty() {
        return arr == null;
    }

    /**
     * Metodo que obtiene el mayor de todos los elementos
     * del arreglo
     * @return el valor mayor de arreglo
     */
    public int getMayor() {
        int mayor = this.arrNum[0];
        if (this.ordenado == false) {
            for (int i = 0; i < this.arrNum.length; i++) {
                if (this.arrNum[i] > mayor) {
                    mayor = this.arrNum[i];
                }
            }
        } else {
            mayor = this.arrNum[tam - 1];
        }
        return mayor;
    }

    /**
     * Metodo que obtiene el menor de todos los elementos
     * del arreglo
     * @return el valor menor de arreglo
     */
    public int getMenor() {
        int menor = this.arrNum[0];
        if (this.ordenado == false) {
            for (int i = 0; i < this.arrNum.length; i++) {
                if (this.arrNum[i] < menor) {
                    menor = this.arrNum[i];
                }
            }
        }
        return menor;
    }

    /**
     * Metodo que suma todos los elementos del arreglo
     * @return la suma de los elementos
     */
    public int getSuma() {
        int suma = 0;
        for (int i = 0; i < this.arrNum.length; i++) {
            suma += this.arrNum[i];
        }
        return suma;
    }
    
    /**
     * Metodo que resta todos los elementos del arreglo
     * @return la resta de los elementos
     */
    public int getResta() {
        int resta = 0;
        for (int i = 0; i < this.arr.length; i++) {
            resta -= this.arrNum[i];
        }
        return resta;
    }

    /**
     * Metodo que obtiene el promedio de los elementos del arreglo
     * @return la un valor float con el promedio de los elementos del arreglo
     */
    public float getPromedio() {
        return (float) getSuma() / this.tam;
    }
    
    /**
     * Metodo toString
     * @return una cadena con todos los elementos del arreglo mediante un 
     * formato predeterminado
     */

    @Override
    public String toString() {
        String cadena = "{ ";
        for (int i = 0; i < tam -1 && !isEmpty(); i++)
            cadena+= this.arrNum[i] + ", ";
        return cadena+= this.arrNum[tam-1] + " }";
    }

    /**
     * Metodo que llena el arreglo de valores aleatorios
     */
    public void llenado() {
        Random rn = new Random();
        for (int i = 0; i < tam; i++) {
            this.arrNum[i] = rn.nextInt(100);
        }
    }

    /**
     * Metodo de ordenacion burbuja que ordena el arreglo de menor a mayor
     */
    public void sortBurble() {
        int aux, i;
        int nCambio;
        this.ordenado = true;
        for (int p = 1; p < tam; p++) {
            for (i = 0, nCambio = 0; i < tam - p; i++) {
                if (this.arrNum[i] > this.arrNum[i + 1]) {
                    aux = this.arrNum[i];
                    this.arrNum[i] = this.arrNum[i + 1];
                    this.arrNum[i + 1] = aux;
                    nCambio++;
                }
            }
            if (nCambio == 0) {
                break;
            }
        }
    }

    /**
     * Metodo que busca un elemento en el arreglo
     * @param elem recibe el parametro elem que sera el valor que sera buscado en el arreglo
     * @return verdadero si encontro el valor o visceversa
     */
    boolean busqueda(int elem) {
        for (int i = 1; i < tam; i++) {
            if (arrNum[i] == elem) {
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo de busqueda binaria
     * @param elem recibe el elemento a buscar
     * @return que devuelve verdadero si encontro el elemto, mediante busqueda binaria
     */
    public boolean searchABoolean(int elem) {
        return searchBin(0, this.tam - 1, elem);
    }
    
    public void split(String cad){
        split(cad,",");
    }
    
    private void split(String cad,String simb){
        //String val = cad.split(simb);
    }
    
    /**
     * Metodo recursivo que hace la busqueda de un elemto mediante la busqueda binaria
     * @param in recibe el incio
     * @param fin recibe el fin
     * @param elem recibe el parametro a buscar en el arreglo
     * @return verdadedo si encontro el elemento o visceversa
     */
    private boolean searchBin(int in, int fin, int elem) {
        sortBurble();
        int med = (fin - in) / 2 + in;
        if (elem == this.arrNum[med]) {
            return true;
        } else {
            if (fin == in || fin < in) {
                return false;
            } else {
                if (elem > this.arrNum[med]) {
                    return searchBin(med + 1, fin, elem);
                } else {
                    return searchBin(in, med - 1, elem);
                }
            }
        }
    }
   
}
