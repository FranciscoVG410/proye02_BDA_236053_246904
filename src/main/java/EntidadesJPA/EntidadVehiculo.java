/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EntidadesJPA;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author franc
 */
@Entity
@Table(name = "tblVehiculos")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // Indica que la estrategia de herencia es de tabla única
@DiscriminatorColumn(name = "tipoVehiculo")
public class EntidadVehiculo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "idVehiculo")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "serie", nullable = false, length = 30)
    private Long serie;
    
    @Column(name = "color", nullable = false, length = 30)
    private String color;
    
    @Column(name = "marca", nullable = false, length = 30)
    private String marca;
    
    @Column(name = "modelo", nullable = false, length = 30)
    private String modelo;

    @OneToMany(mappedBy = "vehiculo", cascade = CascadeType.PERSIST)
    private List<EntidadPlaca> infoPlaca;
    
    @ManyToOne()
    @JoinColumn(name = "idPersona", nullable = false)
    private EntidadPersona persona;
    
    public EntidadVehiculo() {
    }

    public EntidadVehiculo(Long id, Long serie, String color, String marca, String modelo, List<EntidadPlaca> infoPlaca, EntidadPersona persona) {
        this.id = id;
        this.serie = serie;
        this.color = color;
        this.marca = marca;
        this.modelo = modelo;
        this.infoPlaca = infoPlaca;
        this.persona = persona;
    }

    

    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSerie() {
        return serie;
    }

    public void setSerie(Long serie) {
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

    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EntidadVehiculo)) {
            return false;
        }
        EntidadVehiculo other = (EntidadVehiculo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.EntidadVehiculo[ id=" + id + " ]";
    }
    
}
