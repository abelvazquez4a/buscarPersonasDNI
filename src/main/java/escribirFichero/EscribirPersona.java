package escribirFichero;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class EscribirPersona {
    public static void main(String[] args) {
        //Pedimos datos.
        Scanner entrada= new Scanner (System.in);
        System.out.println("Nombre");
        String nombre=entrada.nextLine();
        System.out.println("Apellidos");
        String apellidos=entrada.nextLine();
        System.out.println("DNI");
        String dni=entrada.nextLine();
        System.out.println("Direccion");
        String direccion=entrada.nextLine();
        System.out.println("Poblacion");
        String poblacion=entrada.nextLine();
        System.out.println("Codigo Postal");
        String codigoPostal=entrada.nextLine();


        try (FileWriter writer = new FileWriter("crearPersonas.txt",true);
             BufferedWriter bw = new BufferedWriter(writer)) {
             bw.write(nombre+","+apellidos+","+dni+","+direccion+","+poblacion+","+codigoPostal+"\n");

        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
    }
}
