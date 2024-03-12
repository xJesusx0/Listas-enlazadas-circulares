package listasenlazadas;

import static listasenlazadas.Main.*;
import static listasenlazadas.Metodos.*;
import static listasenlazadas.Nodo.*;


import static listasenlazadas.Estilos.*;

public class ListasEnlazadas {

    public static short respuesta;
    public static String ids;
    //Iniciar lista

    public static void iniciarLista(){


        if(existeLista()){
            mostrarError("La lista ya ha sido creada");
            return;
        } 

        cabeza = new Nodo(); 

        avisoInicio("Creando nodo...");
        cabeza.nombre = input("Ingrese el nombre");
        cabeza.saldo = inputInt("Ingres el saldo");
        cabeza.apuntador = cabeza;

        avisoFin("Lista creada correctamente");
    }

    public static boolean existeLista(){
        return cabeza != null;
    }

    public static Nodo obtenerUltimo(){
        Nodo ultimo = cabeza;

        while(ultimo.apuntador != cabeza){
            ultimo = ultimo.apuntador;
        }

        return ultimo;
    }

    public static boolean unElementoRestante(){
        return cabeza.apuntador == cabeza;
    }

    //Imprimir lista

    public static void imprimirLista(){


        if(!existeLista()){
            mostrarError("La lista no existe");
            return;
        }

        Nodo auxiliar = cabeza;
        int contador = 1;

        do {
            imprimirNodo(auxiliar,contador);
            auxiliar = auxiliar.apuntador;
            contador++;
        } while (auxiliar != cabeza);

    
    }

    //Insercion de nodos

    public static void insertarAlInicio(){


        if(!existeLista()){
            mostrarError("La lista no existe");
            return;
        } 

        Nodo nuevoNodo = new Nodo();
        Nodo ultimo = obtenerUltimo();     

        avisoInicio("Creando nodo...");
        nuevoNodo.nombre = input("Ingrese el nombre");
        nuevoNodo.saldo = inputInt("Ingrese el saldo");

        nuevoNodo.apuntador = cabeza;
        ultimo.apuntador = nuevoNodo;
        cabeza = nuevoNodo;

        avisoFin("Nodo insertado al inicio correctamente");
        imprimirNodo(nuevoNodo, -1);
    }

    public static void insertarAlFinal(){


        if(!existeLista()){
            mostrarError("La lista no existe");
            return;
        }

        avisoInicio("Creando nodo...");
        Nodo nuevoNodo = new Nodo();

        nuevoNodo.nombre = input("Ingrese el nombre");
        nuevoNodo.saldo = inputInt("Ingrese el saldo");
        nuevoNodo.apuntador = null;

        Nodo auxiliar = cabeza;
        

        while(auxiliar.apuntador != cabeza){
            auxiliar = auxiliar.apuntador;
        }
        
        auxiliar.apuntador = nuevoNodo;
        nuevoNodo.apuntador = cabeza;

        avisoFin("Nodo insertado al final correctamente");
        imprimirNodo(nuevoNodo,-1);

    }

    public static void insertarEntreNodos(Nodo anterior, Nodo siguiente){


        if(!existeLista()){
            mostrarError("La lista no existe");
            return;
        }


        avisoInicio("Creando nodo...");

        Nodo nuevoNodo = new Nodo();

        nuevoNodo.nombre = input("Ingrese el nombre");
        nuevoNodo.saldo = inputInt("Ingrese el saldo");

        avisoFin("Nodo creado correctamente");
        avisoInicio("Insertando nodo...");

        anterior.apuntador = nuevoNodo;
        nuevoNodo.apuntador = siguiente;

        avisoFin("Nodo insertado correctamente");
    }

    //Eliminacion de nodos

    public static void eliminarPrimero(){
        

        if(!existeLista()){
            mostrarError("La lista no existe");
            return;
        }
        
        if(unElementoRestante()){
            mostrarAviso("Ultimo elemento de la lista");
            eliminarUltimoELemento();
            return;
        }

        Nodo ultimo = cabeza;
        Nodo auxiliar = cabeza;

        while(ultimo.apuntador != cabeza){
            ultimo = ultimo.apuntador;
        }
        
        System.out.println("Nodo a eliminar: ");
        imprimirNodo(auxiliar, -1);

        int confirmacion = inputInt("Confirmar eliminacion (1 = Si) / (cualquier otro numero = No)");

        if(confirmacion != 1){
            System.out.println("Eliminacion cancelada");
            return;
        }

        avisoInicio("Eliminando nodo...");
        
        cabeza = auxiliar.apuntador;
        ultimo.apuntador = cabeza;

        auxiliar = null;
        avisoFin("Nodo eliminado correctamente");
    }

    public static void eliminarUltimo(){
        

        if(!existeLista()){
            mostrarError("La lista no existe");
            return;
        }
        
        if(unElementoRestante()){
            mostrarAviso("Ultimo elemento de la lista");
            eliminarUltimoELemento();
            return;
        }
        
        Nodo auxiliar = cabeza;
        Nodo penultimoNodo = new Nodo();

        while(auxiliar.apuntador != cabeza){
            penultimoNodo = auxiliar;
            auxiliar = auxiliar.apuntador;
        }

        System.out.println("Nodo a eliminar: ");
        imprimirNodo(auxiliar, -1);

        int confirmacion = inputInt("Confirmar eliminacion (1 = Si) / (cualquier otro numero = No)");

        if(confirmacion != 1){
            System.out.println("Eliminacion cancelada");
            return;
        }

        avisoInicio("Eliminando nodo...");
        penultimoNodo.apuntador = cabeza;
        auxiliar = null;
        avisoFin("Nodo eliminado correctamente");
    }

    public static void eliminarUltimoELemento(){

        if(unElementoRestante()){
            System.out.println("Nodo a eliminar: ");
            imprimirNodo(cabeza, -1);

            int confirmacion = inputInt("Confirmar eliminacion (1 = Si) / (cualquier otro numero = No)");

            if(confirmacion != 1){
                System.out.println("Eliminacion cancelada");
                return;
            }

            avisoInicio("Eliminando nodo...");
            cabeza = null;
            avisoFin("Nodo eliminado correctamente");      
        }
    }

    public static void eliminarPorNombre(){

        if(!existeLista()){
            mostrarError("La lista no existe");
            return;
        }

        buscarPorNombre();

        if(respuesta == 404){
            return;
        }

        eliminarPorId();
        
    }

    public static void eliminarPorSaldo(){
        if(!existeLista()){
            mostrarError("La lista no existe");
            return;
        }

        buscarPorSaldo();

        if(respuesta == 404){
            return;
        }
        
        eliminarPorId();
    }

    public static void eliminarPorSaldoMayorA(){
        
        if(!existeLista()){
            mostrarError("La lista no existe");
            return;
        }

        buscarPorSaldoMayorA();

        if(respuesta == 404){
            return;
        }
        
        eliminarPorId();     
    }

    public static void eliminarPorSaldoMenorA(){
        
        if(!existeLista()){
            mostrarError("La lista no existe");
            return;
        }

        buscarPorSaldoMenorA();

        if(respuesta == 404){
            return;
        }
        
        eliminarPorId();     
    }    

    public static void eliminar(){
        if(!existeLista()){
            mostrarError("La lista no existe");
            return;
        }

        imprimirLista();

        if(respuesta == 404){
            return;
        }
        
        eliminarPorId();

    }

    public static void eliminarPorId(){

        int[] idsValidas = desempaquetar(ids);

        int limiteSuperior = obtenerMayor(idsValidas);
        int limiteInferior = obtenerMenor(idsValidas);

        int indice = inputElementoVector("Ingrese el id a eliminar", idsValidas);

        Nodo auxiliar = cabeza;
        Nodo anterior = new Nodo();


        int guia = 1;
        while(auxiliar != null){
            if(!(indice == guia)){
                anterior = auxiliar;
                auxiliar = auxiliar.apuntador;
                guia++;
                continue;
            }    
                

            
            if(auxiliar == cabeza){
                eliminarPrimero();
                return;
            }

            if(auxiliar.apuntador == cabeza){
                eliminarUltimo();
                return;
            }

            System.out.println("Nodo a eliminar: ");
            imprimirNodo(auxiliar, -1);


            int confirmacion = inputInt("Confirmar eliminacion (1 = Si) / (cualquier otro numero = No)");

            if(confirmacion != 1){
                System.out.println("Eliminacion cancelada");
                return;
            }
            avisoInicio("Eliminando nodo...");
            anterior.apuntador = auxiliar.apuntador;
            auxiliar = null;
            avisoFin("Nodo eliminado correctamente");
        
        }
    }
    
    
    //Busqueda

    public static void buscarPorNombre(){
        ids = "";
        if(!existeLista()){
            mostrarError("La lista no existe");
            return;
        }

        Nodo auxiliar = cabeza;

        String nombre = input("Ingrese el nombre a buscar");

        int contador = 1;
        int cantidadEncontrados = 0;

        do {
            if(auxiliar.nombre.equals(nombre)){
                imprimirNodo(auxiliar,contador);
                cantidadEncontrados++;
                
                ids = actualizarIds(ids, contador);
            }

            auxiliar = auxiliar.apuntador;
            contador++;
        } while (auxiliar != cabeza);

        if(cantidadEncontrados == 0){
            mostrarAviso("No se encontro ningun nodo");
            respuesta = 404;
            return;
        }

        System.out.println(GREEN + "Nodos encontrados: " + cantidadEncontrados + RESET);
        respuesta = 200;
        
    }

    public static void buscarPorSaldo(){
        ids = "";

        if(!existeLista()){
            mostrarError("La lista no existe");
            return;
        }

        int saldo = inputInt("Ingrese el saldo a buscar");

        Nodo auxiliar = cabeza;

        int contador = 1;
        int cantidadEncontrados = 0;

        do{
            if(auxiliar.saldo == saldo){
                imprimirNodo(auxiliar,contador);
                cantidadEncontrados++;
            }
   
            auxiliar = auxiliar.apuntador;
            contador++;

        } while (auxiliar != cabeza);

        if(cantidadEncontrados == 0){
            mostrarAviso("No se encontro ningun nodo");
            respuesta = 404;
            return;
        }

        System.out.println(GREEN + "Nodos encontrados: " + cantidadEncontrados + RESET);
        respuesta = 200;
    }

    public static void buscarPorSaldoMayorA(){
        ids = "";

        if(!existeLista()){
            mostrarError("La lista no existe");
            return;
        }

        int saldo = inputInt("Ingrese el saldo a buscar");

        Nodo auxiliar = cabeza;

        int contador = 1;
        int cantidadEncontrados = 0;

        do{
            if(auxiliar.saldo > saldo){
                imprimirNodo(auxiliar,contador);
                ids += "," + contador;
                cantidadEncontrados++;
            }
   
            auxiliar = auxiliar.apuntador;
            contador++;
        } while (auxiliar != cabeza);
        

        if(cantidadEncontrados == 0){
            mostrarAviso("No se encontro ningun nodo");
            respuesta = 404;
            return;
        }

        System.out.println(GREEN + "Nodos encontrados: " + cantidadEncontrados + RESET);
        respuesta = 200;

    }

    public static void buscarPorSaldoMenorA(){
        ids = "";

        if(!existeLista()){
            mostrarError("La lista no existe");
            return;
        }

        int saldo = inputInt("Ingrese el saldo a buscar");

        Nodo auxiliar = cabeza;

        int contador = 1;
        int cantidadEncontrados = 0;

        do{
            if(auxiliar.saldo < saldo){
                imprimirNodo(auxiliar,contador);
                ids += "," + contador;
                cantidadEncontrados++;
            }
   
            auxiliar = auxiliar.apuntador;
            contador++;

        } while (auxiliar != cabeza);


        if(cantidadEncontrados == 0){
            mostrarAviso("No se encontro ningun nodo");
            respuesta = 404;
            return;
        }

        System.out.println(GREEN + "Nodos encontrados: " + cantidadEncontrados + RESET);
        respuesta = 200;     
    }
    
    public static void buscarSaldoRepetido(int saldo){

        if(!existeLista()){
            mostrarError("La lista no existe");
            return;
        }

        Nodo auxiliar = cabeza;

        int contador = 1;
        int cantidadEncontrados = 0;

        while(auxiliar != null){

            if(auxiliar.saldo == saldo){
                imprimirNodo(auxiliar,contador);
                cantidadEncontrados++;
            }
   
            auxiliar = auxiliar.apuntador;
            contador++;

        }

        if(cantidadEncontrados == 0){
            mostrarAviso("No se encontro ningun nodo");
            return;
        }

        System.out.println(GREEN + "Nodos encontrados: " + cantidadEncontrados + RESET);

    }

    public static void buscarMayor(){

        if(!existeLista()){
            mostrarError("La lista no existe");
            return;
        }

        Nodo auxiliar = cabeza;
        int mayor = auxiliar.saldo;

        while(auxiliar.apuntador != null){
            auxiliar = auxiliar.apuntador;

            if(auxiliar.saldo > mayor){
                mayor = auxiliar.saldo;

            }
        }

        buscarSaldoRepetido(mayor);

    }

    public static void buscarMenor(){

        if(!existeLista()){
            mostrarError("La lista no existe");
            return;
        }

        Nodo auxiliar = cabeza;
        int menor = auxiliar.saldo;

        while(auxiliar.apuntador!= null){
            auxiliar = auxiliar.apuntador;

            if(auxiliar.saldo < menor){
                menor = auxiliar.saldo;

            }
        }

        buscarSaldoRepetido(menor);

    }

    //Extras

    public static void promedioDeSueldos(){

        Nodo auxiliar = cabeza;
        double sumatoria = 0;
        double cantidad = 0;

        while (auxiliar != null) {
            sumatoria += auxiliar.saldo;
            auxiliar = auxiliar.apuntador;
            cantidad++;
        }

        double resultado = sumatoria/cantidad;
        System.out.println(GREEN + "El promedio es: " + (resultado) + RESET);

    }

    public static void sumatoriaDeSueldos(){

        Nodo auxiliar = cabeza;
        int sumatoria = 0;

        while (auxiliar != null) {
            sumatoria += auxiliar.saldo;
            auxiliar = auxiliar.apuntador;
        }

        System.out.println(GREEN + "La sumatoria es: " + (sumatoria) + RESET);

    }
}
    // >
    // <
