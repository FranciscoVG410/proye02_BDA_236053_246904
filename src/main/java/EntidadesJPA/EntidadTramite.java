/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EntidadesJPA;

import java.io.Serializable;
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
@Table(name = "tblTramites")
public class EntidadTramite implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "idTramite")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "fechaTramite", nullable = false, length = 30)
    private String fechaTramite;
    
    @ManyToOne()
    @JoinColumn(name = "idPersona", nullable = false)
    private EntidadPersona persona;
    
    public EntidadTramite() {
    }

    public EntidadTramite(Long id, String fechaTramite, EntidadPersona persona) {
        this.id = id;
        this.fechaTramite = fechaTramite;
        this.persona = persona;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EntidadTramite)) {
            return false;
        }
        EntidadTramite other = (EntidadTramite) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.EntidadTramite[ id=" + id + " ]";
    }
    
}
