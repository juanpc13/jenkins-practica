/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.mantenimientowebapp.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author rcarlos
 */
@Entity
@Table(name = "calendario", catalog = "mantenimiento", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Calendario.findAll", query = "SELECT c FROM Calendario c")
    , @NamedQuery(name = "Calendario.findByIdFecha", query = "SELECT c FROM Calendario c WHERE c.idFecha = :idFecha")
    , @NamedQuery(name = "Calendario.findByFecha", query = "SELECT c FROM Calendario c WHERE c.fecha = :fecha")
    , @NamedQuery(name = "Calendario.findByDescripcion", query = "SELECT c FROM Calendario c WHERE c.descripcion = :descripcion")
    , @NamedQuery(name = "Calendario.findByRecurrente", query = "SELECT c FROM Calendario c WHERE c.recurrente = :recurrente")})
public class Calendario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_fecha")
    private Integer idFecha;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Size(max = 2147483647)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "recurrente")
    private Boolean recurrente;
    @OneToMany(mappedBy = "idFecha")
    private List<OrdenCalendario> ordenCalendarioList;

    public Calendario() {
    }

    public Calendario(Integer idFecha) {
        this.idFecha = idFecha;
    }

    public Integer getIdFecha() {
        return idFecha;
    }

    public void setIdFecha(Integer idFecha) {
        this.idFecha = idFecha;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getRecurrente() {
        return recurrente;
    }

    public void setRecurrente(Boolean recurrente) {
        this.recurrente = recurrente;
    }

    @XmlTransient
    public List<OrdenCalendario> getOrdenCalendarioList() {
        return ordenCalendarioList;
    }

    public void setOrdenCalendarioList(List<OrdenCalendario> ordenCalendarioList) {
        this.ordenCalendarioList = ordenCalendarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFecha != null ? idFecha.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Calendario)) {
            return false;
        }
        Calendario other = (Calendario) object;
        if ((this.idFecha == null && other.idFecha != null) || (this.idFecha != null && !this.idFecha.equals(other.idFecha))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.mantenimientowebapp.entity.Calendario[ idFecha=" + idFecha + " ]";
    }
    
}
