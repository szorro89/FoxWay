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
public class VolumenDTO {
    
    private String lat;
    private String lon;
    private String nombreArchivo;
    private String interseccion;
    private String fechaEstudio;
    private String analisisPuntual;
    private List<String> numPeriodos;
    private String numHoras;
    private String horario;
    private String numEquipos;
    private int volLivianos;
    private int volTPC;
    private int volCamiones;
    private int volMotos;
    private int volTotal;
    private List<String> periodo1;
    private List<String> periodo2;
    private List<String> periodo3;

    public VolumenDTO() {
    }

    public VolumenDTO(String lat, String lon, String nombreArchivo, String interseccion, String fechaEstudio, String analisisPuntual, List<String> numPeriodos, String numHoras, String horario, String numEquipos, int volLivianos, int volTPC, int volCamiones, int volMotos, int volTotal, List<String> periodo1, List<String> periodo2, List<String> periodo3) {
        this.lat = lat;
        this.lon = lon;
        this.nombreArchivo = nombreArchivo;
        this.interseccion = interseccion;
        this.fechaEstudio = fechaEstudio;
        this.analisisPuntual = analisisPuntual;
        this.numPeriodos = numPeriodos;
        this.numHoras = numHoras;
        this.horario = horario;
        this.numEquipos = numEquipos;
        this.volLivianos = volLivianos;
        this.volTPC = volTPC;
        this.volCamiones = volCamiones;
        this.volMotos = volMotos;
        this.volTotal = volTotal;
        this.periodo1 = periodo1;
        this.periodo2 = periodo2;
        this.periodo3 = periodo3;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public String getInterseccion() {
        return interseccion;
    }

    public void setInterseccion(String interseccion) {
        this.interseccion = interseccion;
    }

    public String getFechaEstudio() {
        return fechaEstudio;
    }

    public void setFechaEstudio(String fechaEstudio) {
        this.fechaEstudio = fechaEstudio;
    }

    public String getAnalisisPuntual() {
        return analisisPuntual;
    }

    public void setAnalisisPuntual(String analisisPuntual) {
        this.analisisPuntual = analisisPuntual;
    }

    public List<String> getNumPeriodos() {
        return numPeriodos;
    }

    public void setNumPeriodos(List<String> numPeriodos) {
        this.numPeriodos = numPeriodos;
    }

    public String getNumHoras() {
        return numHoras;
    }

    public void setNumHoras(String numHoras) {
        this.numHoras = numHoras;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getNumEquipos() {
        return numEquipos;
    }

    public void setNumEquipos(String numEquipos) {
        this.numEquipos = numEquipos;
    }

    public int getVolLivianos() {
        return volLivianos;
    }

    public void setVolLivianos(int volLivianos) {
        this.volLivianos = volLivianos;
    }

    public int getVolTPC() {
        return volTPC;
    }

    public void setVolTPC(int volTPC) {
        this.volTPC = volTPC;
    }

    public int getVolCamiones() {
        return volCamiones;
    }

    public void setVolCamiones(int volCamiones) {
        this.volCamiones = volCamiones;
    }

    public int getVolMotos() {
        return volMotos;
    }

    public void setVolMotos(int volMotos) {
        this.volMotos = volMotos;
    }

    public int getVolTotal() {
        return volTotal;
    }

    public void setVolTotal(int volTotal) {
        this.volTotal = volTotal;
    }

    public List<String> getPeriodo1() {
        return periodo1;
    }

    public void setPeriodo1(List<String> periodo1) {
        this.periodo1 = periodo1;
    }

    public List<String> getPeriodo2() {
        return periodo2;
    }

    public void setPeriodo2(List<String> periodo2) {
        this.periodo2 = periodo2;
    }

    public List<String> getPeriodo3() {
        return periodo3;
    }

    public void setPeriodo3(List<String> periodo3) {
        this.periodo3 = periodo3;
    }
    
}
