package leerFichero;

import java.io.*;
import java.util.ArrayList;

public class LeerPersona {
    public static void main(String[] args) {
        ArrayList<String []> listaPersonas = new ArrayList<>();
        File f = new File("/home/abel/IdeaProjects/primerProject/crearPersonas.txt");
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(f));
            String [] infoPersona;
            String lineaInfoPersona;
            while ((lineaInfoPersona = bufferedReader.readLine())!=null){
                infoPersona=lineaInfoPersona.split(",");
                devolverEstadoOriginal(infoPersona);
                listaPersonas.add(infoPersona);
            }
            for (String[] infoPersonas:listaPersonas) {
                System.out.println("-----------------------------------------");
                System.out.println("Persona numero "+((int)listaPersonas.indexOf(infoPersonas)+1));
                System.out.println("-----------------------------------------");
                System.out.println("Nombre: "+infoPersonas[0]);
                System.out.println("Apellidos: "+infoPersonas[1]);
                System.out.println("DNI: "+infoPersonas[2]);
                System.out.println("Direccion: "+infoPersonas[3]);
                System.out.println("Poblacion: "+infoPersonas[4]);
                System.out.println("Codigo Postal: "+infoPersonas[5]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void devolverEstadoOriginal (String[]lista){
        for (int i = 0; i <lista.length ; i++) {
            String modificat="";
            for (int j = 0; j < lista[i].length(); j++) {
                if (lista[i].charAt(j)=='\\'){
                    if ((j>lista[i].length())&&!(lista[i].charAt((j)+1)=='\\')){
                        modificat=modificat+',';
                    }
                    else {
                        modificat=modificat+'\\';
                    }
                }
                else {
                    modificat=modificat+lista[i].charAt(j);
                }
            }
            lista[i]=modificat;
        }
    }
}
