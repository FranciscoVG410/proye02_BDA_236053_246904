/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import EntidadesJPA.EntidadTramite;
import EntidadesJPA.EntidadVehiculo;

/**
 *
 * @author franc
 */
public class PlacaDTO {
    private EntidadTramite tramite;
    private String placa;
    private EntidadVehiculo vehiculo;
    private float precioPlaca;
    private boolean estadoPlaca;
    
    public PlacaDTO() {
    
    }
    
    public PlacaDTO(EntidadTramite tramite, String placa, EntidadVehiculo vehiculo, boolean estadoPlaca, float precioPlaca) {
        this.tramite=tramite;
        this.placa = placa;
        this.estadoPlaca = estadoPlaca;
        this.vehiculo = vehiculo;
        this.precioPlaca = precioPlaca;
    }

    public PlacaDTO(String placa, EntidadVehiculo vehiculo) {
        this.placa = placa;
        this.vehiculo = vehiculo;
    }

    public PlacaDTO(String placa, float precioPlaca, boolean estadoPlaca) {
        this.placa = placa;
        this.precioPlaca = precioPlaca;
        this.estadoPlaca = estadoPlaca;
    }

    public EntidadTramite getTramite() {
        return tramite;
    }

    public void setTramite(EntidadTramite tramite) {
        this.tramite = tramite;
    }
    
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public EntidadVehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(EntidadVehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public boolean isEstadoPlaca() {
        return estadoPlaca;
    }

    public void setEstadoPlaca(boolean estadoPlaca) {
        this.estadoPlaca = estadoPlaca;
    }

    public float getPrecioPlaca() {
        return precioPlaca;
    }

    public void setPrecioPlaca(float precioPlaca) {
        this.precioPlaca = precioPlaca;
    }
}
