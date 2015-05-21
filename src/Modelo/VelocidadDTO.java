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
    private String nombreCorredor;
    private String fechaEstudio;
    private String analisisPuntual;
    private List<List<String>> descripcionTramos;
    private List<String> tipoVehiculo;
    private List<List<String>> horarioDePeriodos;
    private List<List<String>> numEquipos;
    private double velTP_AM_NS_WE;
    private double velTP_M_NS_WE;
    private double velTP_PM_NS_WE;
    private double velTPC_AM_NS_WE;
    private double velTPC_M_NS_WE;
    private double velTPC_PM_NS_WE;
    private double velTPI_AM_NS_WE;
    private double velTPI_M_NS_WE;
    private double velTPI_PM_NS_WE;
    private double velTP_AM_SN_EW;
    private double velTP_M_SN_EW;
    private double velTP_PM_SN_EW;
    private double velTPC_AM_SN_EW;
    private double velTPC_M_SN_EW;
    private double velTPC_PM_SN_EW;
    private double velTPI_AM_SN_EW;
    private double velTPI_M_SN_EW;
    private double velTPI_PM_SN_EW;
    private List<List<String>> velocidadesPromedio;

    public VelocidadDTO() {
    }

    public VelocidadDTO(double lat, double lon, String nombreArchivo, String nombreCorredor, String fechaEstudio, String analisisPuntual, List<List<String>> descripcionTramos, List<String> tipoVehiculo, List<List<String>> horarioDePeriodos, List<List<String>> numEquipos, double velTP_AM_NS_WE, double velTP_M_NS_WE, double velTP_PM_NS_WE, double velTPC_AM_NS_WE, double velTPC_M_NS_WE, double velTPC_PM_NS_WE, double velTPI_AM_NS_WE, double velTPI_M_NS_WE, double velTPI_PM_NS_WE, double velTP_AM_SN_EW, double velTP_M_SN_EW, double velTP_PM_SN_EW, double velTPC_AM_SN_EW, double velTPC_M_SN_EW, double velTPC_PM_SN_EW, double velTPI_AM_SN_EW, double velTPI_M_SN_EW, double velTPI_PM_SN_EW, List<List<String>> velocidadesPromedio) {
        this.lat = lat;
        this.lon = lon;
        this.nombreArchivo = nombreArchivo;
        this.nombreCorredor = nombreCorredor;
        this.fechaEstudio = fechaEstudio;
        this.analisisPuntual = analisisPuntual;
        this.descripcionTramos = descripcionTramos;
        this.tipoVehiculo = tipoVehiculo;
        this.horarioDePeriodos = horarioDePeriodos;
        this.numEquipos = numEquipos;
        this.velTP_AM_NS_WE = velTP_AM_NS_WE;
        this.velTP_M_NS_WE = velTP_M_NS_WE;
        this.velTP_PM_NS_WE = velTP_PM_NS_WE;
        this.velTPC_AM_NS_WE = velTPC_AM_NS_WE;
        this.velTPC_M_NS_WE = velTPC_M_NS_WE;
        this.velTPC_PM_NS_WE = velTPC_PM_NS_WE;
        this.velTPI_AM_NS_WE = velTPI_AM_NS_WE;
        this.velTPI_M_NS_WE = velTPI_M_NS_WE;
        this.velTPI_PM_NS_WE = velTPI_PM_NS_WE;
        this.velTP_AM_SN_EW = velTP_AM_SN_EW;
        this.velTP_M_SN_EW = velTP_M_SN_EW;
        this.velTP_PM_SN_EW = velTP_PM_SN_EW;
        this.velTPC_AM_SN_EW = velTPC_AM_SN_EW;
        this.velTPC_M_SN_EW = velTPC_M_SN_EW;
        this.velTPC_PM_SN_EW = velTPC_PM_SN_EW;
        this.velTPI_AM_SN_EW = velTPI_AM_SN_EW;
        this.velTPI_M_SN_EW = velTPI_M_SN_EW;
        this.velTPI_PM_SN_EW = velTPI_PM_SN_EW;
        this.velocidadesPromedio = velocidadesPromedio;
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

    public String getNombreCorredor() {
        return nombreCorredor;
    }

    public void setNombreCorredor(String nombreCorredor) {
        this.nombreCorredor = nombreCorredor;
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

    public List<List<String>> getDescripcionTramos() {
        return descripcionTramos;
    }

    public void setDescripcionTramos(List<List<String>> descripcionTramos) {
        this.descripcionTramos = descripcionTramos;
    }

    public List<String> getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(List<String> tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public List<List<String>> getHorarioDePeriodos() {
        return horarioDePeriodos;
    }

    public void setHorarioDePeriodos(List<List<String>> horarioDePeriodos) {
        this.horarioDePeriodos = horarioDePeriodos;
    }

    public List<List<String>> getNumEquipos() {
        return numEquipos;
    }

    public void setNumEquipos(List<List<String>> numEquipos) {
        this.numEquipos = numEquipos;
    }

    public double getVelTP_AM_NS_WE() {
        return velTP_AM_NS_WE;
    }

    public void setVelTP_AM_NS_WE(double velTP_AM_NS_WE) {
        this.velTP_AM_NS_WE = velTP_AM_NS_WE;
    }

    public double getVelTP_M_NS_WE() {
        return velTP_M_NS_WE;
    }

    public void setVelTP_M_NS_WE(double velTP_M_NS_WE) {
        this.velTP_M_NS_WE = velTP_M_NS_WE;
    }

    public double getVelTP_PM_NS_WE() {
        return velTP_PM_NS_WE;
    }

    public void setVelTP_PM_NS_WE(double velTP_PM_NS_WE) {
        this.velTP_PM_NS_WE = velTP_PM_NS_WE;
    }

    public double getVelTPC_AM_NS_WE() {
        return velTPC_AM_NS_WE;
    }

    public void setVelTPC_AM_NS_WE(double velTPC_AM_NS_WE) {
        this.velTPC_AM_NS_WE = velTPC_AM_NS_WE;
    }

    public double getVelTPC_M_NS_WE() {
        return velTPC_M_NS_WE;
    }

    public void setVelTPC_M_NS_WE(double velTPC_M_NS_WE) {
        this.velTPC_M_NS_WE = velTPC_M_NS_WE;
    }

    public double getVelTPC_PM_NS_WE() {
        return velTPC_PM_NS_WE;
    }

    public void setVelTPC_PM_NS_WE(double velTPC_PM_NS_WE) {
        this.velTPC_PM_NS_WE = velTPC_PM_NS_WE;
    }

    public double getVelTPI_AM_NS_WE() {
        return velTPI_AM_NS_WE;
    }

    public void setVelTPI_AM_NS_WE(double velTPI_AM_NS_WE) {
        this.velTPI_AM_NS_WE = velTPI_AM_NS_WE;
    }

    public double getVelTPI_M_NS_WE() {
        return velTPI_M_NS_WE;
    }

    public void setVelTPI_M_NS_WE(double velTPI_M_NS_WE) {
        this.velTPI_M_NS_WE = velTPI_M_NS_WE;
    }

    public double getVelTPI_PM_NS_WE() {
        return velTPI_PM_NS_WE;
    }

    public void setVelTPI_PM_NS_WE(double velTPI_PM_NS_WE) {
        this.velTPI_PM_NS_WE = velTPI_PM_NS_WE;
    }

    public double getVelTP_AM_SN_EW() {
        return velTP_AM_SN_EW;
    }

    public void setVelTP_AM_SN_EW(double velTP_AM_SN_EW) {
        this.velTP_AM_SN_EW = velTP_AM_SN_EW;
    }

    public double getVelTP_M_SN_EW() {
        return velTP_M_SN_EW;
    }

    public void setVelTP_M_SN_EW(double velTP_M_SN_EW) {
        this.velTP_M_SN_EW = velTP_M_SN_EW;
    }

    public double getVelTP_PM_SN_EW() {
        return velTP_PM_SN_EW;
    }

    public void setVelTP_PM_SN_EW(double velTP_PM_SN_EW) {
        this.velTP_PM_SN_EW = velTP_PM_SN_EW;
    }

    public double getVelTPC_AM_SN_EW() {
        return velTPC_AM_SN_EW;
    }

    public void setVelTPC_AM_SN_EW(double velTPC_AM_SN_EW) {
        this.velTPC_AM_SN_EW = velTPC_AM_SN_EW;
    }

    public double getVelTPC_M_SN_EW() {
        return velTPC_M_SN_EW;
    }

    public void setVelTPC_M_SN_EW(double velTPC_M_SN_EW) {
        this.velTPC_M_SN_EW = velTPC_M_SN_EW;
    }

    public double getVelTPC_PM_SN_EW() {
        return velTPC_PM_SN_EW;
    }

    public void setVelTPC_PM_SN_EW(double velTPC_PM_SN_EW) {
        this.velTPC_PM_SN_EW = velTPC_PM_SN_EW;
    }

    public double getVelTPI_AM_SN_EW() {
        return velTPI_AM_SN_EW;
    }

    public void setVelTPI_AM_SN_EW(double velTPI_AM_SN_EW) {
        this.velTPI_AM_SN_EW = velTPI_AM_SN_EW;
    }

    public double getVelTPI_M_SN_EW() {
        return velTPI_M_SN_EW;
    }

    public void setVelTPI_M_SN_EW(double velTPI_M_SN_EW) {
        this.velTPI_M_SN_EW = velTPI_M_SN_EW;
    }

    public double getVelTPI_PM_SN_EW() {
        return velTPI_PM_SN_EW;
    }

    public void setVelTPI_PM_SN_EW(double velTPI_PM_SN_EW) {
        this.velTPI_PM_SN_EW = velTPI_PM_SN_EW;
    }

    public List<List<String>> getVelocidadesPromedio() {
        return velocidadesPromedio;
    }

    public void setVelocidadesPromedio(List<List<String>> velocidadesPromedio) {
        this.velocidadesPromedio = velocidadesPromedio;
    }

}