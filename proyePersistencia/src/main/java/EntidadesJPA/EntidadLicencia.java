/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EntidadesJPA;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Calendar;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Francisco Valdez Gastelum
 *         00000246904
 */
@Entity
@Table(name = "tbllicencias")
@DiscriminatorValue("0")
public class EntidadLicencia extends EntidadTramite{
    
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idTramite", nullable = false)
    private EntidadTramite tramite;

    @Column(name = "vigencia", nullable = false, length = 30)
    private String vigencia;
    
    @Column(name = "costo", nullable = false, length = 30)
    private float costo;
    
    @Column(name = "estado", nullable = true, length = 30)
    private boolean estado;
    
    @Column(name = "fechaVencimiento", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaVencimiento;
    
    

    public EntidadLicencia() {
    }

    public EntidadLicencia(EntidadTramite tramite, String vigencia, float costo, boolean estado) {
        super(tramite.getFechaTramite(), tramite.getPersona(), tramite.getTipoTramite());
        Calendar calendar = Calendar.getInstance();
        this.vigencia = vigencia;
        this.costo = costo;
        this.estado = estado;
        
        int aniosSuma = 0;
          switch(vigencia){
          case "1 Año" -> aniosSuma = 1;
          case "2 Años" -> aniosSuma = 2;
          case "3 Años" -> aniosSuma = 3;
        }
        calendar.add(Calendar.YEAR, aniosSuma);
        Date nuevaFecha = calendar.getTime();
        this.fechaVencimiento = nuevaFecha;
        
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

    @Override
    public String toString() {
        return "EntidadLicencia{" + "tramite=" + tramite + ", vigencia=" + vigencia + ", costo=" + costo + ", estado=" + estado + ", fechaVencimiento=" + fechaVencimiento + '}';
    }

    
    
}

