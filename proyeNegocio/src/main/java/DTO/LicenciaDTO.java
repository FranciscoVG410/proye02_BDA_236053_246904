/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import EntidadesJPA.EntidadTramite;
import java.util.Date;

/**
 *
 * @author franc
 */
public class LicenciaDTO {
    private EntidadTramite tramite;
    private String vigencia;
    private float costo;
    private Date fechaVencimiento;
    private boolean estado;
    
    public LicenciaDTO() {
    }
    
    public LicenciaDTO(EntidadTramite tramite, String vigencia, float costo, boolean Estado, Date fechaVencimiento) {
        this.tramite=tramite;
        this.vigencia = vigencia;
        this.costo = costo;
        this.estado= Estado;
        this.fechaVencimiento= fechaVencimiento;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public EntidadTramite getTramite() {
        return tramite;
    }

    public void setTramite(EntidadTramite tramite) {
        this.tramite = tramite;
    }

    public String getVigencia() {
        return vigencia;
    }

    public void setVigencia(String vigencia) {
        this.vigencia = vigencia;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "LicenciaDTO{" + "tramite=" + tramite + ", vigencia=" + vigencia + ", costo=" + costo  + ", estado=" + estado + '}';
    }
    
    
}
