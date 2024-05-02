/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EntidadesJPA;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Francisco Valdez Gastelum
 *         00000246904
 */
@Entity
@Table(name = "tblPersonas")
public class EntidadPersona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "idPersona")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "RFC", nullable = false, length = 50)
    private String rfc;
    
    @Column(name = "nombres", nullable = false, length = 50)
    private String nombres;
    
    @Column(name = "apellidoP", nullable = false, length = 30)
    private String apellidoP;

    @Column(name = "apellidoM", nullable = false, length = 30)
    private String apellidoM;
    
    @Column(name = "fechaNacimiento", nullable = false, length = 30)
    private String fechaNacimiento;
    
    @Column(name = "telefono", nullable = false, length = 30)
    private String tel;
    
    @Column(name = "discapacitado", nullable = true, length = 30)
    private boolean discapacidad;

    @OneToMany(mappedBy = "persona", cascade = CascadeType.PERSIST)
    private List<EntidadVehiculo> info;
    
    @OneToMany(mappedBy = "persona", cascade = CascadeType.PERSIST)
    private List<EntidadTramite> infoTramite;
    
    public EntidadPersona() {
    }
    
    public EntidadPersona(Long id) {
        this.id = id;
     }

    

    public EntidadPersona(Long id, String rfc, String nombres, String apellidoP, String apellidoM, String fechaNacimiento, String tel, boolean discapacidad, List<EntidadVehiculo> info, List<EntidadTramite> infoTramite) {
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

    public boolean isDiscapacidad() {
        return discapacidad;
    }

    public void setDiscapacidad(boolean discapacidad) {
        this.discapacidad = discapacidad;
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
        if (!(object instanceof EntidadPersona)) {
            return false;
        }
        EntidadPersona other = (EntidadPersona) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.EntidadPersona[ id=" + id + " ]";
    }
    
}
