/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import EntidadesJPA.EntidadPersona;

/**
 *
 * @author franc
 */
public class TramiteDTO {
    private String fechaTramite;
    private EntidadPersona persona;

    public TramiteDTO() {
    }

    public TramiteDTO(String fechaTramite, EntidadPersona persona) {
        this.fechaTramite = fechaTramite;
        this.persona = persona;
    }

    public String getFechaTramite() {
        return fechaTramite;
    }

    public void setFechaTramite(String fechaTramite) {
        this.fechaTramite = fechaTramite;
    }

    public EntidadPersona getPersona() {
        return persona;
    }

    public void setPersona(EntidadPersona persona) {
        this.persona = persona;
    }

    @Override
    public String toString() {
        return "TramiteDTO{" + "fechaTramite=" + fechaTramite + ", persona=" + persona + '}';
    }
    
    
}
