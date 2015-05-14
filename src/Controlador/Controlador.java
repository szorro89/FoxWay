
package Controlador;

import Modelo.Modelo;

/**
 *
 * @author PowerFox
 */
public class Controlador {
    
    public static void cargarDatos(String tipoDato, String mes, String anio){
        Modelo.cargarDatos(tipoDato, mes, anio);
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
