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
import javax.persistence.Table;

/**
 *
 * @author franc
 */
@Entity
@Table(name = "tblLicencias")
public class EntidadLicencia extends EntidadTramite {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "idLicencia")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "vigencia", nullable = false, length = 30)
    private String vigencia;
    
    @Column(name = "costoNormal", nullable = false, length = 30)
    private float costoNormal;
    
    @Column(name = "costoDiscapacitado", nullable = false, length = 30)
    private float costoDiscapacitado;

    public EntidadLicencia() {
    }

    public EntidadLicencia(Long id, String vigencia, float costoNormal, float costoDiscapacitado) {
        this.id = id;
        this.vigencia = vigencia;
        this.costoNormal = costoNormal;
        this.costoDiscapacitado = costoDiscapacitado;
    }
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVigencia() {
        return vigencia;
    }

    public void setVigencia(String vigencia) {
        this.vigencia = vigencia;
    }

    public float getCostoNormal() {
        return costoNormal;
    }

    public void setCostoNormal(float costoNormal) {
        this.costoNormal = costoNormal;
    }

    public float getCostoDiscapacitado() {
        return costoDiscapacitado;
    }

    public void setCostoDiscapacitado(float costoDiscapacitado) {
        this.costoDiscapacitado = costoDiscapacitado;
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
        if (!(object instanceof EntidadLicencia)) {
            return false;
        }
        EntidadLicencia other = (EntidadLicencia) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.EntidadLicencia[ id=" + id + " ]";
    }
    
}

