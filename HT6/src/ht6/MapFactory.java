
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Clase Map Factory
 * @author Gian Luca Rivera Biagioni
 * @author Isabel Ortiz
 */
public class MapFactory {
    /**
     * @param option devuelve un int
     * @return si escoje 1 -- sera el HashMpa,  2 -- TreeMap, 3 -- LinkedHashMap, nada -- null
     */
    //Metodo que valida el tipo de mapa a implementar
    //Patron de disenio factory
    public static Map ChooseMap(int option){
        //si selecciona la primera opcion entonces sera HashMap
        if (option == 1){
            return new HashMap();
        //si selecciona la segunda opcion entonces sera TreeMap
        }else if (option == 2){
            return new TreeMap();
        //si selecciona la tercera opcion entonces sera LinkedHashMap
        }else if (option == 3){
            return new LinkedHashMap();
        }
        //Si no selecciona ninguna opcion no mostrar nada
        return null;
    }
    
}
