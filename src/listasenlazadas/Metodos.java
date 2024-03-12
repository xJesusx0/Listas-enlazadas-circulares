package listasenlazadas;

import java.util.Random;
import java.util.Scanner;
import static listasenlazadas.Estilos.*;

public class Metodos {

    public static void mostrarError(String mensaje) {
        System.out.println(RED + BOLD + "Error: " + mensaje + RESET);
    }

    public static void mostrarAviso(String mensaje) {
        System.out.println(YELLOW + BOLD + "Aviso: " + mensaje + RESET);
    }

    public static String input(String mensaje) {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println(GREEN + mensaje + RESET);
            String UserInput = input.nextLine();

            if (!UserInput.trim().isEmpty()) {
                return UserInput;

            } else {
                mostrarError("La entrada esta vacia, intentelo denuevo");
            }
        }
    }

    public static int inputIntPositivo(String mensaje) {
        while (true) {
            String entrada = input(mensaje);

            try {
                int numero = Integer.parseInt(entrada);

                if (numero > -1) {
                    return numero;
                } else {
                    mostrarError("Ingrese un número mayor a 0, inténtelo de nuevo");
                }

            } catch (NumberFormatException e) {
                mostrarError("Entrada inválida, inténtelo de nuevo");
            }
        }
    }

    public static int inputIntLimite(String mensaje,int limiteInferior,int limiteSuperior) {
        while (true) {
            String entrada = input(mensaje);

            try {
                int numero = Integer.parseInt(entrada);

                if (numero > limiteInferior && numero <= limiteSuperior) {
                    return numero;
                } else {
                    mostrarError("Ingrese un número mayor a 0, inténtelo de nuevo");
                }

            } catch (NumberFormatException e) {
                mostrarError("Entrada inválida, inténtelo de nuevo");
            }
        }
    }

    public static int inputTamaño(String mensaje) {
        while (true) {
            String entrada = input(mensaje);

            try {
                int numero = Integer.parseInt(entrada);

                if (numero > 0) {
                    return numero;
                } else {
                    mostrarError("Ingrese un número mayor a 0, inténtelo de nuevo");
                }

            } catch (NumberFormatException e) {
                mostrarError("Entrada inválida, inténtelo de nuevo");
            }
        }
    }

    public static int inputInt(String mensaje) {
        while (true) {
            String entrada = input(mensaje);

            try {
                return Integer.parseInt(entrada);

            } catch (NumberFormatException e) {
                mostrarError("Entrada invalida, intenelo denuevo");

            }
        }
    }

    public static double inputDouble(String mensaje) {
        while (true) {
            String entrada = input(mensaje);

            try {
                return Double.parseDouble(entrada);

            } catch (NumberFormatException e) {
                mostrarError("Entrada invalida, intentelo denuevo");

            }
        }
    }

    public static byte inputByte(String mensaje) {
        while (true) {
            String entrada = input(mensaje);
            try {
                return Byte.valueOf(entrada);

            } catch (NumberFormatException e) {
                mostrarError("Entrada invalida, intentelo denuevo");
            }
        }
    }

    public static int inputElementoVector(String mensaje, int[] vector){
        while (true) {
            String entrada = input(mensaje);

            try {
                int numero = Integer.parseInt(entrada);
                if(perteneceAlVector(numero, vector)){
                    return numero;
                }  

                

            } catch (NumberFormatException e) {
                mostrarError("Entrada invalida, intenelo denuevo");

            }
        }


    }

    public static void imprimirVector(int[] vector) {
        String resultado = "";
        for (int i = 0; i < vector.length; i++) {
            resultado += (vector[i] + "\t");
        }
        System.out.println(resultado);
    }

    public static boolean perteneceAlVector(int dato, int[] vector){

        for (int i=0 ; i<vector.length ; i++ ){
            if (dato == vector [i]){
                return true;
            }

        }

        return false;

    }

    public static int obtenerMayor(int[] vector) {
        int mayor = vector[0];
        for (int i = 1; i < vector.length; i++) {
            if (vector[i] > mayor) {
                mayor = vector[i];
            }
        }
        return mayor;
    }

    public static int obtenerMenor(int[] vector) {
        int menor = vector[0];
        for (int i = 1; i < vector.length; i++) {
            if (vector[i] < menor) {
                menor = vector[i];
            }
        }
        return menor;
    }

    public static void comparar(int elemento1, int elemento2) {
        if (elemento1 == elemento2) {
            System.out.println("Las visitas en febrero: " + elemento1 + " son iguales que Las visitas en Noviembre: " + elemento2);
        }
        if (elemento1 > elemento2) {
            System.out.println("Las visitas en febrero: " + elemento1 + " son mayores que Las visitas en Noviembre: " + elemento2);
        }
        if (elemento1 < elemento2) {
            System.out.println("Las visitas en febrero: " + elemento1 + " son menores que Las visitas en Noviembre: " + elemento2);

        }
    }

    public static int[] encontrarRepetidos(int[] vector, int numero) {
        int tamañoVector = 0;
        for (int i = 0; i < vector.length; i++) {
            if (numero == vector[i]) {
                tamañoVector++;
            }
        }
        
        int indices[] = new int[tamañoVector];
        int contador2 = 0;
        
        for (int i = 0; i < vector.length; i++) {
            if (numero == vector[i]) {
                indices[contador2] = i;
            }
        }
        return indices;
    }
    
    public static void mostrarElementos(String[] vector){
        String resultado = "";
        for (int i = 0; i < vector.length; i++) {
            resultado += ("- " + vector[i] + "\n");
        }
        System.out.println(resultado);
    }

    public static int generarAleatorio(int minimo, int maximo) {
        Random random = new Random();
        return random.nextInt(maximo - minimo + 1) + minimo;
    }

    public static void compararStrings(String string1, String string2) {
        if(string1.compareTo(string2)== 0){
            System.out.println("Son iguales");
        }
        if(string1.compareTo(string2) > 0){
            System.out.println(string1 + " Es menor que " + string2);
        }
        if(string1.compareTo(string2) < 0){
            System.out.println(string1 + " Es mayor que " + string2);
        }
    }

    public static boolean esMenor(String string1, String string2) {
        return(string1.compareTo(string2) < 0);       

    }

    public static boolean esMayor(String string1, String string2) {
        return (string1.compareTo(string2) > 0);       
               
    }

    public static void menu() {
        System.out.println("╔═══════════════════════════════════╗");
        System.out.println("║       Menu de Opciones            ║");
        System.out.println("╠═══════════════════════════════════╣");
        System.out.println("║  0 - Salir                        ║");
        System.out.println("║  1 - Imprimir lista               ║");
        System.out.println("║  2 - Crear lista                  ║");
        System.out.println("║  3 - Insertar nodo al principio   ║");
        System.out.println("║  4 - Insertar nodo al final       ║");
        System.out.println("║  5 - Elminar primer nodo          ║");
        System.out.println("║  6 - Eliminar ultimo nodo         ║");
        
        System.out.println("║  7 - Eliminar nodo por Nombre     ║");
        /*
        System.out.println("║  8 - Eliminar por saldo           ║");
        System.out.println("║  9 - Eliminar por saldo mayor a   ║");
        System.out.println("║ 10 - Eliminar por saldo menor a   ║");
        System.out.println("║ 11 - Eliminar por id              ║");
        */
        System.out.println("║ 12 - Buscar por nombre            ║");
        
        System.out.println("║ 13 - Buscar por saldo             ║");   
        System.out.println("║ 14 - Buscar por saldo mayor a     ║");
        System.out.println("║ 15 - Buscar por saldo menor a     ║");
        /* 
        System.out.println("║ 16 - Encontrar mayor              ║");
        System.out.println("║ 17 - Encontrar menor              ║");
        System.out.println("║ 18 - Promedio de saldos           ║");
        System.out.println("║ 19 - Sumatoria de saldos          ║");
        */
        System.out.println("╚═══════════════════════════════════╝");
    }
    
    public static void avisoInicio(String texto){
        System.out.println(GREEN + "╔═ " + texto + RESET);
    }

    public static void avisoFin(String texto){
        System.out.println(GREEN + "╚═ " + texto + RESET);
    }

    public static int[] desempaquetar(String ids){
        String[] id = ids.split(",");
        int idConvertidas[] = new int[id.length];

        for(int i = 0 ; i < id.length ; i++){
            idConvertidas[i] = Integer.parseInt(id[i]);
        }

        return idConvertidas;
    }

    public static String actualizarIds(String id,int contador){

        if (id.isEmpty()) {
            id += contador;
        } else {
            id += "," + contador;
        }

        return id;
    }
}
