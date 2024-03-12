package listasenlazadas;


public class Nodo {
    String nombre;
    int saldo;
    Nodo apuntador;

    public static void imprimirNodo(Nodo nodo,int posicion){
        System.out.println("╔══ Informacion del nodo ═╗");
        System.out.println("╠═$ Nombre: " + nodo.nombre);
        System.out.println("╠═$ Saldo: " + nodo.saldo);
        System.out.println("╠═$ Apuntador: " + nodo.apuntador);
        if(posicion != -1){
            System.out.println("╠═$ Id: " + posicion);
        }
        System.out.println("╚═════════════════════════╝");
    }

}
