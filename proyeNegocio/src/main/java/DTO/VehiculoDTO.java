/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import EntidadesJPA.EntidadPersona;
import EntidadesJPA.EntidadPlaca;
import java.util.List;

/**
 *
 * @author franc
 */
public class VehiculoDTO {
    private Long id;
    private String serie;
    private String color;
    private String marca;
    private String modelo;
    private String tipo;
    private boolean nuevo;
    private List<EntidadPlaca> infoPlaca;
    private EntidadPersona persona;
    
    public VehiculoDTO() {
    }

    public VehiculoDTO(Long id, String serie, String tipo, boolean nuevo, String color, String marca, String modelo, List<EntidadPlaca> infoPlaca, EntidadPersona persona) {
        this.id = id;
        this.serie = serie;
        this.tipo = tipo;
        this.nuevo = nuevo;
        this.color = color;
        this.marca = marca;
        this.modelo = modelo;
        this.infoPlaca = infoPlaca;
        this.persona = persona;
    }

    public VehiculoDTO(String serie, EntidadPersona persona) {
        this.serie = serie;
        this.persona = persona;
    }

    public VehiculoDTO(String serie, String color, String marca, String modelo, String tipo, boolean nuevo, EntidadPersona persona) {
        this.serie = serie;
        this.color = color;
        this.marca = marca;
        this.modelo = modelo;
        this.tipo = tipo;
        this.nuevo = nuevo;
        this.persona = persona;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public List<EntidadPlaca> getInfoPlaca() {
        return infoPlaca;
    }

    public void setInfoPlaca(List<EntidadPlaca> infoPlaca) {
        this.infoPlaca = infoPlaca;
    }

    public EntidadPersona getPersona() {
        return persona;
    }

    public void setPersona(EntidadPersona persona) {
        this.persona = persona;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isNuevo() {
        return nuevo;
    }

    public void setNuevo(boolean nuevo) {
        this.nuevo = nuevo;
    }

    
    
    @Override
    public String toString() {
        return "VehiculoDTO{" + "id=" + id + ", serie=" + serie + ", color=" + color + ", marca=" + marca + ", modelo=" + modelo + ", infoPlaca=" + infoPlaca + ", persona=" + persona + '}';
    }
    
    
}
