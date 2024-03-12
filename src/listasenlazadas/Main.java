package listasenlazadas;


import static listasenlazadas.Metodos.*;
import static listasenlazadas.ListasEnlazadas.*;

public class Main {

    static Nodo cabeza = null;
    public static void main(String[] args) {

        while (true) {
            menu();
            
            byte opcion = inputByte("╔═══ Ingrese su opcion");
            

            switch (opcion) {
                case 0 -> mostrarAviso("Saliendo...");
                case 1 -> imprimirLista();
                case 2 -> iniciarLista();
                case 3 -> insertarAlInicio();
                case 4 -> insertarAlFinal();
                
                case 5 -> eliminarPrimero();
                case 6 -> eliminarUltimo();
                case 7 -> eliminarPorNombre();
                case 8 -> eliminarPorSaldo();
                case 9 -> eliminarPorSaldoMayorA();
                case 10 -> eliminarPorSaldoMenorA();
                case 11 -> eliminar();

                case 12 -> buscarPorNombre();
                case 13 -> buscarPorSaldo();
                case 14 -> buscarPorSaldoMayorA();
                case 15 -> buscarPorSaldoMenorA();
                case 16 -> buscarMayor();
                case 17 -> buscarMenor();
                case 18 -> promedioDeSueldos();
                case 19 -> sumatoriaDeSueldos();
                default -> mostrarError("Opcion invalida");
            }

            if(opcion == 0){
                break;
            }
        }
        
    }

}

