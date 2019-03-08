/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht6;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 *
 * @author gianlucariverabiagioni / isaortiz
 */
public class HT6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int mapType;
        Scanner read = new Scanner(System.in);
        //Mazo de cartas
         Map<String, String> cards;
         Map<String, String> totalCards;
        
         MapFactory factory = new MapFactory();
         
         ArrayList<String> cardName =new ArrayList();
        
        //Bloque de cofigo que se encarga de la lectura del archivo de texto que contiene las cartas
        ArrayList<String> allCards = new ArrayList();
        try{
            Stream<String> lines = Files.lines(Paths.get("cards_desc.txt"),StandardCharsets.UTF_8);
            lines.forEach(a -> allCards.add(a));
        }catch(IOException e){
            System.out.println("Error al leer el archivo, asegurate de que este colocado dentro del proyecto");
        }
        
        //Menu para saber con que implementacion desea ejecutar el programa
        System.out.println("Ingrese el tipo de mapa que desea utilizar: "
                + "\n1. HashMap"
                + "\n2. TreeMap"
                + "\n3. LinkedHashMap");
        mapType = read.nextInt();
        
        //Programacion defensiva, si ingresa un numero mayor a 3, el programa se cierra
        if (mapType >= 4){
            System.out.println("Esta opcion no se encuentre el menu, vuelve a iniciar el programa");
            System.exit(0);
        }
        
        //Map map = MapFactory.ChooseMap(mapType);
        cards = factory.ChooseMap(mapType);
        totalCards = factory.ChooseMap(mapType);
        
        //Se realiza e split para separar la info que proporciona la carta (nombre|tipo)
        for (String i: allCards) {
                //System.out.println(i);
                String[] information = i.split("|");
                cardName.add(information[0]);
                totalCards.put(information[0], information[1]);
            }
    }
    
}
