package lista_tipo_pila;

public class Nodo{
    String[] informacion;
    Nodo siguiente;
    
    public Nodo(String[] valor){
        Arreglo arr = new Arreglo(valor.length);
        arr.setArr(valor); 
        informacion = arr.getArr();
        siguiente = null;
    }        
}
