package lista_tipo_pila;

import javax.swing.JOptionPane;

public class ClasePrincipal {

    static int menuStart() {
        return Integer.parseInt(JOptionPane.showInputDialog(null,
                "Menú de Opciones\n\n"
                + "1. Registro de Alumnos\n"
                + "2. Calificaciones\n"
                + "3. Operacions con matrices\n"
                //+ "4. Uso de arrayList\n"                        
                + "4. Salir.\n\n"));
    }

    static int menuList() {
        return Integer.parseInt(JOptionPane.showInputDialog(null,
                "Menú de Opciones\n\n"
                + "1. Insertar alumno\n"
                + "2. Eliminar ultimo alumno ingresado\n"
                + "3. ¿Hay alumnos registrados?\n"
                + "4. ¿Quien fue el ultimo alumno que se registro?\n"
                + "5. ¿Cuantos alumnos estan registrados?\n"
                + "6. Vaciar registro de alumnos\n"
                + "7. Mostrar todos los alumnos\n"
                + "8. Buscar un alumno\n"
                + "9. Salir.\n\n"));
    }

    static String[] addAlumno(String[] cad) {
        String[] valor = new String[cad.length];
        String[] aux = new String[cad.length];
        for (int i = 0; i < cad.length; i++) {
            valor[i] = JOptionPane.showInputDialog(null, "Ingresa tu " + cad[i] + ":");
        }
        System.arraycopy(valor, 0, aux, 0, valor.length);
        return aux;
    }

    static void opctionList(int opc, Pila pila) {
        String[] valores = {"matricula", "nombre", "edad"};
        switch (opc) {
            case 1:
                valores = addAlumno(valores);
                pila.InsertarNodo(valores);
                break;
            case 2:
                if (!pila.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Se ha eliminado el alumno con la matricula: "
                            + pila.EliminarNodo());
                } else {
                    JOptionPane.showMessageDialog(null, "El registro esta vacio.");
                }
                break;
            case 3:
                if (!pila.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Si, Hay alumnos registrados");
                } else {
                    JOptionPane.showMessageDialog(null, "No hay registro de alumnos");
                }
                break;
            case 4:
                if (!pila.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "El ultimo alumno que se registro fue con la matricula: "
                            + pila.MostrarUltimoValorIngresado());
                } else {
                    JOptionPane.showMessageDialog(null, "No hay alumnos registrados");
                }
                break;
            case 5:
                if (!pila.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Estan registrados "
                            + pila.TamanoPila() + " alumnos");
                } else {
                    JOptionPane.showMessageDialog(null, "No hay alumnos registrados");
                }
                break;
            case 6:
                if (!pila.isEmpty()) {
                    pila.VaciarPila();
                    JOptionPane.showMessageDialog(null, "Se vacio el registro de alumnos");
                } else {
                    JOptionPane.showMessageDialog(null, "¡El registro esta vacio!");
                }
                break;
            case 7:
                JOptionPane.showMessageDialog(null, pila);
                break;
            case 8:
                String matricula = JOptionPane.showInputDialog(null, "Ingresa la matricula: ");
                JOptionPane.showMessageDialog(null, pila.buscar(matricula));
                /*if (!pila.isEmpty()) {
                    if(!matricula.equals("") ){
                     if (pila.buscar(matricula)) {
                        JOptionPane.showMessageDialog(null, "El alumno con la matricula " + matricula + " si esta registrado");
                    } else {
                        JOptionPane.showMessageDialog(null, "No hay un alumno con la matricula " + matricula);
                    }   
                    }else{
                        JOptionPane.showMessageDialog(null, "No ingreso ninguna matricula" );
                    }                    
                }else{
                    JOptionPane.showMessageDialog(null, "La lista esta vacia, no hay registros por buscar");
                }*/
                break;
            case 9:
                break;
        }
    }

    static int menuArr() {
        return Integer.parseInt(JOptionPane.showInputDialog(null,
                "Calificaciones\n\n"
                + "1. Agregar Calificaciones\n"
                + "2. ¿Total de la suma de calificaciones?\n"
                + "3. ¿Cual es el promedio?\n"
                + "4. ¿Cuál es la calificacion maxima?\n"
                + "5. ¿Cual es la calificacion minima?\n"
                + "6. Mostar la calificaciones\n"
                + "7. Ordenar las calificaciones\n"
                + "8. Salir.\n\n"));
    }

    static void opctionArr(int opc, Arreglo arr) {
        int valor = 0;
        int[] calif = null;
        switch (opc) {
            case 1:
                valor = Integer.parseInt(JOptionPane.showInputDialog(null, "Cuantas calificaciones ingresaras"));
                calif = new int[valor];
                for (int i = 0; i < valor; i++) {
                    calif[i] = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa la calficación " + (i + 1)));
                }
                arr.setTam(valor);
                arr.setArrNum(calif);
                break;
            case 2:
                if (!arr.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "La suma de calificaciones es: " + arr.getSuma());
                } else {
                    JOptionPane.showMessageDialog(null, "No hay calificaciones");
                }
                break;
            case 3:
                if (!arr.isEmpty()) {
                    float prom = arr.getPromedio();
                    if (prom >= 8) {
                        JOptionPane.showMessageDialog(null, "El promedio es de: " + prom
                                + "\n       ¡Aprobado!   :)");
                    } else {
                        JOptionPane.showMessageDialog(null, "El promedio es de: " + prom
                                + "\n       ¡Reprobado!  :( ");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No hay calificaciones ingresadas");
                }
                break;
            case 4:
                if (!arr.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "La calificación maxima es de: " + arr.getMayor());
                } else {
                    JOptionPane.showMessageDialog(null, "No hay calificaciones");
                }
                break;
            case 5:
                if (!arr.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "La calificación minima es de: " + arr.getMenor());
                } else {
                    JOptionPane.showMessageDialog(null, "No hay calificaciones");
                }
                break;
            case 6:
                JOptionPane.showMessageDialog(null, "Lista de calificaciones\n " + arr);
                break;
            case 7:
                if (!arr.isEmpty()) {
                    arr.sortBurble();
                    JOptionPane.showMessageDialog(null, "¡Calificaciones ordenadas!");
                } else {
                    JOptionPane.showMessageDialog(null, "No hay calificaciones por ordenar");
                }
                break;
            case 8:
                break;
        }
    }

    static int menuMatriz() {
        return Integer.parseInt(JOptionPane.showInputDialog(null,
                "Operaciones basicas con matrices\n\n"
                + "1. Suma\n"
                + "2. Resta\n"
                + "3. Mostrar matriz\n"
                + "4. Salir.\n\n"));
    }

    static int[][] insertVal(int tam, int num) {
        Matriz ma = new Matriz(tam, tam);
        int[][] r = new int[tam][tam];
        for (int f = 0; f < r.length; f++) {
            for (int c = 0; c < r[1].length; c++) {
                r[f][c] = Integer.parseInt(JOptionPane.showInputDialog(null, "Matriz" + num + "\nIngrese un valor en la posicion: [" + f + "][" + c + "]"));
            }
        }
        ma.setArr1(r);
        return ma.getArr1();
    }

    static int solicitarTam() {
        return Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese tamaño de la matriz"));
    }

    static void optionMatriz(int opc, Matriz mat) {
        int[][] arr1, arr2 = null;
        int valor = 0;
        switch (opc) {
            case 1:
                valor = solicitarTam();
                arr1 = insertVal(valor, 1);
                arr2 = insertVal(valor, 2);
                mat.sumaMatriz(arr1, arr2);
                JOptionPane.showMessageDialog(null, "Resultado de la suma\nMatriz\n" + mat);
                break;
            case 2:
                valor = solicitarTam();
                arr1 = insertVal(valor, 1);
                arr2 = insertVal(valor, 2);
                mat.restaMatriz(arr1, arr2);
                JOptionPane.showMessageDialog(null, "Resultado de la resta\nMatriz\n" + mat);
                break;
            case 3:
                if (!mat.isEmpty()) {
                    JOptionPane.showMessageDialog(null, mat);
                } else {
                    JOptionPane.showMessageDialog(null, "La matriz esta vacia");
                }
                break;
            case 4:
                break;
        }
    }

    static int menuArrayList() {
        return Integer.parseInt(JOptionPane.showInputDialog(null,
                "1. Agregar letras\n"
                + "2. Eliminar letras\n"
                + "3. Agregar letra al inicio\n"
                + "4. Cambiar posicion de un letra\n"
                + "5. ¿Cuantas letras hay?\n"
                + "6. Salir\n"));
    }

    static void optionArrayList(int opc) {
        switch (opc) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
        }
    }

    public static void main(String[] args) {
        int opc = 0;
        do {
            try {
                opc = menuStart();
                switch (opc) {
                    case 1:
                        Pila pila = new Pila();
                        do {
                            opc = menuList();
                            opctionList(opc, pila);
                        } while (opc != 9 && opc != 0);
                        break;
                    case 2:
                        Arreglo arr = new Arreglo();
                        do {
                            opc = menuArr();
                            opctionArr(opc, arr);
                        } while (opc != 8);
                        break;
                    case 3:
                        Matriz mat = new Matriz();
                        do {
                            opc = menuMatriz();
                            optionMatriz(opc, mat);
                        } while (opc != 4);
                        break;
                    case 4:
                        /*do{
                            opc = menuArrayList();
                            optionArrayList(opc);
                        }while(opc != 6);*/
                        break;
                }
            } catch (Exception e) {
            }
        } while (opc != 4);
    }
}
