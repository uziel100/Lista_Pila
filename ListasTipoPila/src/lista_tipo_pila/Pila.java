package lista_tipo_pila;

import javax.swing.JOptionPane;

public class Pila {
    private Nodo inicio;
    private Nodo fin;
    int tamano = 0;
       
    public Pila(){
        fin = null;
        inicio = null;                     
        tamano = 0;
    }
        
    /**
     * Método para saber cuando la pila esta vacia
     * @return un volor Booleano para saber si la pila esta vacia
     */
    public boolean isEmpty(){
        return fin == null;
    }
        
    /**
     * Método para insertar un nodo en la pila
     * @param nodo Recibe una variable de tipo
     * nodo que se ingresara en la pila
     */
    public void InsertarNodo(String[] nodo){        
        Nodo nuevo_nodo = new Nodo(nodo);
        inicio = nuevo_nodo;
        nuevo_nodo.siguiente = fin;
        fin = nuevo_nodo;
        tamano++;
    }        
          
    /**
     * Método para eliminar un nodo de la pila
     * @return una variable de tipo String 
     * que contendra la informacion que contiene 
     * el ultimo nodo
     */
    public String EliminarNodo(){
        String valor = MostrarUltimoValorIngresado();
        fin = fin.siguiente;
        tamano--;
        return valor;
    }
        
    /**
     * Método para conocer cual es el último valor ingresado
     * @return una cadena con el valor del ultimo nodo de la pila
     */
    public String MostrarUltimoValorIngresado(){
        return fin.informacion[0];
    }
    
    
    /**
     * Método para conocer el tamaño de la Pila
     * @return el tamaño de la pila
     */
    public int TamanoPila(){
        return tamano;
    }
        
    /**
     * Método para vaciar la Pila
     */
    public void VaciarPila(){
        while (!isEmpty()) {
            EliminarNodo();            
        }
    }
  
    /**
     * Metodo busqueda
     * @param matricula recibe el parametro matricula para
     * comparar si existe un alumno con esa matricula en la pila
     * @return un true si encontro la coincidenci sino regresa false
     */
    public String buscar(String matricula){
        Nodo aux = inicio;
        /*while(!isEmpty()){
            if(aux.informacion[0].equals(matricula)){
                return true;
            }else{
                aux = aux.siguiente;
            }
        }
        return false;*/
        return aux.informacion[0];
    }
   
    /**
     * Método para mostrar el contenido de la pila
     * @return un cadena con un formato predeterminado, el cual 
     * contendra la informacion de cada alumno
     */
    @Override
    public String toString(){
        String lista = "";
        Nodo recorrido = fin;                
        String[] val = {"Matricula: ","Nombre: ","Edad: "};
        while(recorrido != null){  
            lista += "------------------------\n";
            for(int i = 0; i < recorrido.informacion.length; i++){
                lista += val[i] + recorrido.informacion[i] + "\n";                
            }
            recorrido = recorrido.siguiente;
        }       
        return lista;
    }
}
