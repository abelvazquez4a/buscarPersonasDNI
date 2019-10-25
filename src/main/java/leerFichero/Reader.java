package leerFichero;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Reader {
    public static void main(String[] args) {

            //Con FileReader.
        System.out.println("Con FileReader");
        File f = new File("/home/abel/IdeaProjects/primerProject/helloWorld.txt");
        try {
            FileReader fileReader = new FileReader(f);
            int i;
            while ((i=fileReader.read()) != -1){
                System.out.print((char) i);
             }
            //Con BufferedReader
            System.out.println("\n\nCon BufferedReader");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(f));
            String paraula;
            while ((paraula=bufferedReader.readLine())!=null){
                System.out.println(paraula);
            }
            //Con Scanner
            System.out.println("\nCon Scanner usando loops");
            Scanner reader = new Scanner (f);
            while (reader.hasNextLine()){
                System.out.println(reader.nextLine());
            }
            //Con Scanner sin loops
            System.out.println("\nCon Scanner sin loops");
            Scanner readerSinLoop = new Scanner(f);
            readerSinLoop.useDelimiter("\\Z");
            System.out.println(readerSinLoop.next());

            //Leer con String.
            System.out.println("\nLeer como String.");
            System.out.println( leerFicheroComoString("/home/abel/IdeaProjects/primerProject/helloWorld.txt"));


    } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static String leerFicheroComoString (String rutaFichero){
        String contenido = "";
        try {
            contenido = new String (Files.readAllBytes(Paths.get(rutaFichero)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contenido;
    }
}
