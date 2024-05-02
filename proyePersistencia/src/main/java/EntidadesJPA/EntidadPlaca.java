/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EntidadesJPA;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Francisco Valdez Gastelum
 *         00000246904
 */
 @Entity
@Table(name = "tblPlacas")
@DiscriminatorValue("1")
public class EntidadPlaca extends EntidadTramite {

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idTramite", nullable = false)
    private EntidadTramite tramite;
    
    @Column(name = "placa", nullable = false, length = 7)
    private String placa;

    @Column(name = "estadoPlaca", nullable = true, length = 30)
    private boolean estadoPlaca;
    
    @Column(name = "precioPlaca", nullable = true, length = 30)
    private float precioPlaca;
    
    @ManyToOne()
    @JoinColumn(name = "idVehiculo", nullable = false)
    private EntidadVehiculo vehiculo;
    
    public EntidadPlaca() {
    }

//    public EntidadPlaca(Long id, String fechaTramite, EntidadPersona persona) {
//        super(id, fechaTramite, persona);
//    }

    
    
    public EntidadPlaca(EntidadTramite tramite,String placa, boolean estadoPlaca, float precioPlaca, EntidadVehiculo vehiculo) {
        super(tramite.getFechaTramite(), tramite.getPersona(), tramite.getTipoTramite());
        this.placa = placa;
        this.estadoPlaca = estadoPlaca;
        this.precioPlaca = precioPlaca;
        this.vehiculo = vehiculo;
    }

    public EntidadPlaca(String placa, EntidadVehiculo vehiculo) {
        this.placa = placa;
        this.vehiculo = vehiculo;
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

    public boolean getEstadoPlaca() {
        return estadoPlaca;
    }

    public void setEstadoPlaca(boolean estado) {
        this.estadoPlaca = estado;
    }

    public float getPrecioPlaca() {
        return precioPlaca;
    }

    public void setPrecioPlaca(float precioPlaca) {
        this.precioPlaca = precioPlaca;
    }

    @Override
    public String toString() {
        return "EntidadPlaca{" + "tramite=" + tramite + ", placa=" + placa + ", estadoPlaca=" + estadoPlaca + ", precioPlaca=" + precioPlaca + ", vehiculo=" + vehiculo + '}';
    }

    
    
    
  
}
