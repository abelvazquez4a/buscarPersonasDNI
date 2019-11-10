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
        String nombre=comprobarComas(entrada.nextLine());
        System.out.println("Apellidos");
        String apellidos=comprobarComas(entrada.nextLine());
        System.out.println("DNI");
        String dni=comprobarComas(entrada.nextLine());
        System.out.println("Direccion");
        String direccion=comprobarComas(entrada.nextLine());
        System.out.println("Poblacion");
        String poblacion=comprobarComas(entrada.nextLine());
        System.out.println("Codigo Postal");
        String codigoPostal=comprobarComas(entrada.nextLine());


        try (FileWriter writer = new FileWriter("crearPersonas.txt",true);
             BufferedWriter bw = new BufferedWriter(writer)) {
             bw.write(nombre+","+apellidos+","+dni+","+direccion+","+poblacion+","+codigoPostal+"\n");

        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
    }

    public static String comprobarComas(String f){
        String modificat="";
        for (int i = 0; i <f.length() ; i++) {
            if (f.charAt(i)==',') {
                modificat=modificat+'.';
            }
            else {
                modificat=modificat+f.charAt(i);
            }
        }
        return modificat;
    }
}
