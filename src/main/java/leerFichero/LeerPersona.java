package leerFichero;

import org.graalvm.compiler.replacements.nodes.BitScanReverseNode;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class LeerPersona {
    public static void main(String[] args) {
        boolean encontrado=false;
        Scanner entrada=new Scanner(System.in);
        System.out.println("¿DNI? (CON LETRA)");
        String dni=entrada.nextLine();
        ArrayList<String[]> listaPersonas = new ArrayList<>();
        File f = new File("crearPersonas.txt");
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(f));
            String[] infoPersona;
            String lineaInfoPersona;
            while ((lineaInfoPersona = bufferedReader.readLine()) != null) {
                infoPersona = lineaInfoPersona.split(",");
                listaPersonas.add(infoPersona);
            }
            for (String[] infoPersonas : listaPersonas) {
                if (infoPersonas[2].toLowerCase().equals(dni.toLowerCase())) {
                    System.out.println("-----------------------------------------");
                    System.out.println("Persona numero " + ((int) listaPersonas.indexOf(infoPersonas) + 1));
                    System.out.println("-----------------------------------------");
                    System.out.println("Nombre: " + infoPersonas[0]);
                    System.out.println("Apellidos: " + infoPersonas[1]);
                    System.out.println("DNI: " + infoPersonas[2]);
                    System.out.println("Direccion: " + infoPersonas[3]);
                    System.out.println("Poblacion: " + infoPersonas[4]);
                    System.out.println("Codigo Postal: " + infoPersonas[5]);
                    encontrado=true;
                }
            }
            if(!encontrado) System.out.println("No se han encontrado personas con el DNI "+dni);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public static void devolverEstadoOriginal(String[] lista) {
//        for (int i = 0; i < lista.length; i++) {
//            String modificat = "";
//            for (int j = 0; j < lista[i].length(); j++) {
//                if (lista[i].charAt(j) == '\\') {
//                    if ((j<lista[i].length()-1)&&lista[i].charAt((j) + 1) == '\\') {
//                        modificat = modificat + "\\";
//                        j++;
//                    } else {
//                        modificat = modificat + ",";
//                    }
//                } else {
//                    modificat = modificat + lista[i].charAt(j);
//                }
//            }
//            lista[i] = modificat;
//        }
//    }
}
