/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht6;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author gianlucariverabiagioni/isaortiz
 */
public class MapFactory {
    //Metodo que valida el tipo de mapa a implementar
    //Patron de disenio factory
    public Map ChooseMap(int option){
        //si selecciona la primera opcion entonces sera HashMap
        if (option == 1){
            return new HashMap();
        //si selecciona la segunda opcion entonces sera TreeMap
        }else if (option == 2){
            return new TreeMap();
        //si selecciona la tercer, o mas bien, la opcion por default, entonces sera LinkedHashMap
        }else{
            return new LinkedHashMap();
        }

    }
    
}
