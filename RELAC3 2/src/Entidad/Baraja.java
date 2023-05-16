/*
Realizar una baraja de cartas españolas orientada a objetos. Una carta tiene un número entre 1
y 12 (el 8 y el 9 no los incluimos) y un palo (espadas, bastos, oros y copas). Esta clase debe
contener un método toString() que retorne el número de carta y el palo. La baraja estará
compuesta por un conjunto de cartas, 40 exactamente.
Las operaciones que podrá realizar la baraja son:
• barajar(): cambia de posición todas las cartas aleatoriamente.
• siguienteCarta(): devuelve la siguiente carta que está en la baraja, cuando no haya más o
se haya llegado al final, se indica al usuario que no hay más cartas.
• cartasDisponibles(): indica el número de cartas que aún se puede repartir.
• darCartas(): dado un número de cartas que nos pidan, le devolveremos ese número de
cartas. En caso de que haya menos cartas que las pedidas, no devolveremos nada, pero
debemos indicárselo al usuario.
• cartasMonton(): mostramos aquellas cartas que ya han salido, si no ha salido ninguna
indicárselo al usuario
• mostrarBaraja(): muestra todas las cartas hasta el final. Es decir, si se saca una carta y
luego se llama al método, este no mostrara esa primera carta.
 */
package Entidad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author lorena
 */
public class Baraja {
    
    private int numero;
    private String palo;
    private ArrayList<Baraja> baraja;
    private ArrayList<Baraja> monton;
    Scanner leer=new Scanner (System.in);
    
    public Baraja() {
        baraja=new ArrayList();
        monton=new ArrayList();
        //en el constructor vacio hay que inicializar los arraylist, para usarlos despues
    }

    public Baraja(int numero, String palo) {
        this.numero = numero;
        this.palo = palo;
        
    }
    

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getPalo() {
        return palo;
    }

    public void setPalo(String palo) {
        this.palo = palo;
    }

    public ArrayList<Baraja> getBaraja() {
        return baraja;
    }

    public void setBaraja(ArrayList<Baraja> baraja) {
        this.baraja = baraja;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("*Baraja*  numero: ").append(numero);
        sb.append(", palo: ").append(palo);
        
        return sb.toString();
    }

    public void llenarBaraja() {

        String[] palos = {"oro", "copas", "espada", "bastos"};
        int[] numeros = {1, 2, 3, 4, 5, 6, 7, 10, 11, 12};

        for (String palo : palos) {
            for (int num : numeros) {
                baraja.add(new Baraja(num, palo));
                //se inicializa la baraja adentro del parametro, y no afuera, para que no se sobreescriba

            }

        }

    }

    public void barajar() {

        Collections.shuffle(baraja);

    }

    public void mostrarBaraja() {

        System.out.println("Las cartas de la baraja son las siguientes: ");
        for (Baraja baraja1 : baraja) {
            System.out.println(baraja1);

        }
    }

    public void siguienteCarta(){
        
        
        if (baraja.size() < 1) {
            System.out.println("No hay mas cartas");
        } else {
            System.out.println("Tu carta es: ");
            System.out.println(baraja.get(0));
            monton.add(baraja.get(0));
            baraja.remove(0);
            
        }

    }
    
    public void cartasDisponibles(){
        
        System.out.println("Las cartas aun disponibles son: ");
        System.out.println(baraja.size());
    }
    
    public void darCartas(){
        
        System.out.println("Cuantas cartas quieres?");
        int num1=leer.nextInt();
        int i=0;
        do {
            siguienteCarta();
            i++;
        } while (i<num1);
        
        
    }

    public void cartasMonton(){
      
        System.out.println("Las cartas que ya han salido son: ");
        for (Baraja monton1 : monton) {

            System.out.println(monton1);
        }
    }
    
     public void menu(){
         int opcion = 0;
         System.out.println("**********************************");
         System.out.println("        JUEGO DE CARTAS");
         System.out.println("**********************************");
         do {
             System.out.println("");
             System.out.println("Elija una opcion:");
             System.out.println("1- Barajar");
             System.out.println("2- Siguiente carta");
             System.out.println("3- Cartas Disponibles");
             System.out.println("4- Dar cartas");
             System.out.println("5- Mostrar cartas eliminadas");
             System.out.println("6- Mostrar baraja");
             System.out.println("7- Salir");
             System.out.println("");
             
             System.out.println("**********************************");

             opcion = leer.nextInt();

             switch (opcion) {
                 case 1:
                     barajar();
                     break;
                 case 2:
                     siguienteCarta();
                     break;
                 case 3:
                     cartasDisponibles();
                     break;
                 case 4:
                     darCartas();
                     break;
                 case 5:
                     cartasMonton();
                     break;
                 case 6:
                     mostrarBaraja();
                     break;
                 case 7:
                     System.out.println("Hasta la proxima!!");
                     break;
                 default:
                     System.out.println("Opcion incorrecta");

             }

         } while (opcion != 7);

         System.out.println("");
         

     }
}
