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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "orden", catalog = "mantenimiento", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orden.findAll", query = "SELECT o FROM Orden o")
    , @NamedQuery(name = "Orden.findByIdOrden", query = "SELECT o FROM Orden o WHERE o.idOrden = :idOrden")
    , @NamedQuery(name = "Orden.findByFecha", query = "SELECT o FROM Orden o WHERE o.fecha = :fecha")
    , @NamedQuery(name = "Orden.findByObservaciones", query = "SELECT o FROM Orden o WHERE o.observaciones = :observaciones")
    , @NamedQuery(name = "Orden.findByActivo", query = "SELECT o FROM Orden o WHERE o.activo = :activo")})
public class Orden implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_orden")
    private Long idOrden;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Size(max = 2147483647)
    @Column(name = "observaciones")
    private String observaciones;
    @Column(name = "activo")
    private Boolean activo;
    @JoinColumn(name = "id_solicitud", referencedColumnName = "id_solicitud")
    @ManyToOne
    private Solicitud idSolicitud;
    @JoinColumn(name = "id_unidad", referencedColumnName = "id_unidad")
    @ManyToOne
    private Unidad idUnidad;
    @OneToMany(mappedBy = "idOrden")
    private List<OrdenCalendario> ordenCalendarioList;
    @OneToMany(mappedBy = "idOrden")
    private List<OrdenTrabajoEquipo> ordenTrabajoEquipoList;

    public Orden() {
    }

    public Orden(Long idOrden) {
        this.idOrden = idOrden;
    }

    public Long getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(Long idOrden) {
        this.idOrden = idOrden;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Solicitud getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(Solicitud idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public Unidad getIdUnidad() {
        return idUnidad;
    }

    public void setIdUnidad(Unidad idUnidad) {
        this.idUnidad = idUnidad;
    }

    @XmlTransient
    public List<OrdenCalendario> getOrdenCalendarioList() {
        return ordenCalendarioList;
    }

    public void setOrdenCalendarioList(List<OrdenCalendario> ordenCalendarioList) {
        this.ordenCalendarioList = ordenCalendarioList;
    }

    @XmlTransient
    public List<OrdenTrabajoEquipo> getOrdenTrabajoEquipoList() {
        return ordenTrabajoEquipoList;
    }

    public void setOrdenTrabajoEquipoList(List<OrdenTrabajoEquipo> ordenTrabajoEquipoList) {
        this.ordenTrabajoEquipoList = ordenTrabajoEquipoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrden != null ? idOrden.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orden)) {
            return false;
        }
        Orden other = (Orden) object;
        if ((this.idOrden == null && other.idOrden != null) || (this.idOrden != null && !this.idOrden.equals(other.idOrden))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.mantenimientowebapp.entity.Orden[ idOrden=" + idOrden + " ]";
    }
    
}
