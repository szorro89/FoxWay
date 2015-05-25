
package Controlador;

import Modelo.Modelo;
import com.esri.map.JMap;

/**
 *
 * @author PowerFox
 */
public class Controlador {
    
    public static void cargarDatos(String tipoDato, String mes, String anio, JMap map){
        Modelo.cargarDatos(tipoDato, mes, anio, map);
    }
    
    public static void limpiarMapa(){
        Modelo.limpiarMapa();
    }
    
    public static void cargarMasInfo(){
        Modelo.cargarMasInfo();
    }
    
    public static void mostrarInfo() throws Exception{
        Modelo.mostrarInfo();
    }
}
