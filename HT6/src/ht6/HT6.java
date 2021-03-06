/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package ht6;

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
 * Isabel Ortiz - 18176
 * Gian Luca Rivera - 18049
 * seccion 10
 * Programa que implementa los tres tipos de map. simulado con mazo de cartas.
 */
public class HT6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int mapType;
        int optionMenu = 0;
        
         
        Scanner read = new Scanner(System.in);
        //Mazo de cartas
         Map<String, String> cards;
         Map<String, String> totalCards;
        
         MapFactory factory = new MapFactory();
         
         ArrayList<String> cardName = new ArrayList<String>();
         ArrayList<String> characters = new ArrayList<String>();
         ArrayList<String> cardNamePlayer = new ArrayList<String>();
        
        //Bloque de cofigo que se encarga de la lectura del archivo de texto que contiene las cartas
        ArrayList<String> allCards = new ArrayList<String>();
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
	                String[] information = i.split("[|]");
	                cardName.add(information[0]);
	                totalCards.put(information[0], information[1]);
                        //System.out.println(totalCards);
	    }
        
        
        
        while(optionMenu != 7){
            System.out.println("Seleccione la operación que desea realizar: "
                        + "\n1. Agregar una carta a tu coleccion"
                        + "\n2. Mostrar el tipo de una carta"
                        + "\n3. Mostrar informacion de las cartas de tu mazo"
                        + "\n4. Mostrar informacion de las cartas de tu mazo ordenadas por tipo"
                        + "\n5. Mostrar informacion de todas las cartas existentes"
                        + "\n6. Mostrar informacion de todas las cartas existentes ordenadas por tipo");
            optionMenu = read.nextInt();
                    
            switch(optionMenu){
                
                case 1:
                    String name;
                    System.out.println("Ingrese el nombre de la carta que desea agregar a su coleccion: ");
                    read.nextLine();
                    name = read.nextLine();
                    if (totalCards.containsKey(name) == true){
                        characters.add(name);
                        String newCard = totalCards.get(name);
                        totalCards.remove(name);
                        cards.put(name, newCard);
                        cardNamePlayer.add(name);
                        System.out.println("La carta '" + name + "' se ha agregado a tu mazo.");
                    }else{
                        System.out.println("La carta que ingresaste no esta dentro del mazo general.");
                    }
                    break;
                
                case 2:
                    String name2;
                    System.out.println("Ingrese el nombre de la carta para saber de que tipo es: ");
                    read.nextLine();
                    name2 = read.nextLine();
                    System.out.println("La carta '" + name2 + "' es de tipo:" + totalCards.get(name2));
                    break;

                case 3:
                    int cantMonster = 0;
                    int cantTrap = 0;
                    int cantSpells = 0;

                    //Muestra las cartas puestas en el mazo 
                    cards.forEach((nameC,type) -> System.out.println(nameC + " - " + type));

                    //For que cuenta la cantidad de cada tipo de carta
                    for (int item = 0; item < cards.size(); item++){
                        if (cards.get(cardNamePlayer.get(item)).equals("Monstruo")){
                            cantMonster +=1;      
                        }else if(cards.get(totalCards.get(cardNamePlayer.get(item))).equals("Hechizo")){
                            cantTrap +=1;
                        }else if(cards.get(totalCards.get(cardNamePlayer.get(item))).equals("Trampa")){
                            cantSpells +=1;
                        }
                    }
                    //Resultado
                    System.out.println("En tu mazo se encuentran: "
                            + "\nMonstruos: " + cantMonster
                            + "\nHechizos: " + cantTrap
                            + "\nTrampas: " + cantSpells);
                    break;
                    
                case 4:
                    System.out.println("Huevos de acero");
                    String monsterPlayer = " ";
                    String trapPlayer = " "; 
                    String spellPlayer = " ";

                    //ciclo for que busca el tipo de carta y las separa
                    for (int i = 0; i < cards.size(); i++){
                        String nameAllPlayer = cardNamePlayer.get(i);
                        String typePlayer = cards.get(nameAllPlayer);

                    switch (typePlayer) {
                        case "Monstruo":
                            monsterPlayer = monsterPlayer + "\n" + nameAllPlayer + " (Monstruo)";
                            break;
                        case "Trampa":
                            trapPlayer = trapPlayer + "\n" + nameAllPlayer + " (Trampa)";
                            break;
                        case "Hechizo":
                            spellPlayer = spellPlayer + "\n" + nameAllPlayer + " (Hechizo)";
                            break;
                        }   
                    }
                    System.out.println(monsterPlayer + trapPlayer + spellPlayer);
                    break;

                case 5:
                    //Ciclo for que recorre todas las cartas para imprimirlas
                    for (String ab : allCards) {
                        System.out.println(ab);
                    }
                    break;

                case 6:
                    //Variables para poder imprimir y ser editadas luego
                    String monster = " ";
                    String trap = " "; 
                    String spell = " ";

                    //ciclo for que busca el tipo de carta y las separa
                    for (int i = 0; i < cardName.size(); i++){
                        String nameAll = cardName.get(i);
                        String type = totalCards.get(nameAll);

                    switch (type) {
                        case "Monstruo":
                            monster = monster + "\n" + nameAll + " (Monstruo)";
                            break;
                        case "Trampa":
                            trap = trap + "\n" + nameAll + " (Trampa)";
                            break;
                        case "Hechizo":
                            spell = spell + "\n" + nameAll + " (Hechizo)";
                            break;
                        default:
                            break;
                        }
                    }
                    System.out.println(monster + trap + spell);
            }
            
        }
        
        
    }
    
}
