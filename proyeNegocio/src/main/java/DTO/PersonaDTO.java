/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import EntidadesJPA.EntidadTramite;
import EntidadesJPA.EntidadVehiculo;
import java.util.List;

/**
 *
 * @author franc
 */
public class PersonaDTO {
    private Long id;
    private String rfc;
    private String nombres;
    private String apellidoP;
    private String apellidoM;
    private String fechaNacimiento;
    private String tel;
    private boolean discapacidad;
    private List<EntidadVehiculo> info;
    private List<EntidadTramite> infoTramite;

    public PersonaDTO() {
    }

    public PersonaDTO(Long id) {
        this.id = id;
    }

    public PersonaDTO(Long id, String rfc, String nombres, String apellidoP, String apellidoM, String fechaNacimiento, String tel, boolean discapacidad, List<EntidadVehiculo> info, List<EntidadTramite> infoTramite) {
        this.id = id;
        this.rfc = rfc;
        this.nombres = nombres;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.fechaNacimiento = fechaNacimiento;
        this.tel = tel;
        this.discapacidad = discapacidad;
        this.info = info;
        this.infoTramite = infoTramite;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    

    public boolean isDiscapacidad() {
        return discapacidad;
    }

    public void setDiscapacidad(boolean discapacidad) {
        this.discapacidad = discapacidad;
    }

    public List<EntidadVehiculo> getInfo() {
        return info;
    }

    public void setInfo(List<EntidadVehiculo> info) {
        this.info = info;
    }

    public List<EntidadTramite> getInfoTramite() {
        return infoTramite;
    }

    public void setInfoTramite(List<EntidadTramite> infoTramite) {
        this.infoTramite = infoTramite;
    }

    @Override
    public String toString() {
        return "PersonaDTO{" + "id=" + id + ", rfc=" + rfc + ", nombres=" + nombres + ", apellidoP=" + apellidoP + ", apellidoM=" + apellidoM + ", fechaNacimiento=" + fechaNacimiento + ", tel=" + tel + ", discapacidad=" + discapacidad + ", info=" + info + ", infoTramite=" + infoTramite + '}';
    }
    
}
