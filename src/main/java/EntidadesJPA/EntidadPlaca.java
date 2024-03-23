/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EntidadesJPA;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author franc
 */
@Entity
@Table(name = "tblPlacas")
public class EntidadPlaca extends EntidadTramite {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "idPlaca")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "placa", nullable = false, length = 30)
    private String placa;

    @ManyToOne()
    @JoinColumn(name = "idVehiculo", nullable = false)
    private EntidadVehiculo vehiculo;
    
    public EntidadPlaca() {
    }

    public EntidadPlaca(Long id, String placa, EntidadVehiculo vehiculo) {
        this.id = id;
        this.placa = placa;
        this.vehiculo = vehiculo;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EntidadPlaca)) {
            return false;
        }
        EntidadPlaca other = (EntidadPlaca) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.EntidadPlaca[ id=" + id + " ]";
    }
    
}
