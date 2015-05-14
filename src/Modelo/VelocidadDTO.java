/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.List;

/**
 *
 * @author PowerFox
 */
public class VelocidadDTO {
    
    private double lat;
    private double lon;
    private String nombreArchivo;
    private String fechaMuestra;
    private List<String> listaDato;

    public VelocidadDTO(double lat, double lon, String nombreArchivo, String fechaMuestra, List<String> listaDato) {
        this.lat = lat;
        this.lon = lon;
        this.nombreArchivo = nombreArchivo;
        this.fechaMuestra = fechaMuestra;
        this.listaDato = listaDato;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public String getFechaMuestra() {
        return fechaMuestra;
    }

    public void setFechaMuestra(String fechaMuestra) {
        this.fechaMuestra = fechaMuestra;
    }

    public List<String> getListaDato() {
        return listaDato;
    }

    public void setListaDato(List<String> listaDato) {
        this.listaDato = listaDato;
    }
    
}
