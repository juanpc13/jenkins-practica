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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author rcarlos
 */
@Entity
@Table(name = "orden_trabajo_equipo", catalog = "mantenimiento", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrdenTrabajoEquipo.findAll", query = "SELECT o FROM OrdenTrabajoEquipo o")
    , @NamedQuery(name = "OrdenTrabajoEquipo.findByIdOrdenTrabajo", query = "SELECT o FROM OrdenTrabajoEquipo o WHERE o.idOrdenTrabajo = :idOrdenTrabajo")
    , @NamedQuery(name = "OrdenTrabajoEquipo.findByFechaInicio", query = "SELECT o FROM OrdenTrabajoEquipo o WHERE o.fechaInicio = :fechaInicio")
    , @NamedQuery(name = "OrdenTrabajoEquipo.findByFechaEstimada", query = "SELECT o FROM OrdenTrabajoEquipo o WHERE o.fechaEstimada = :fechaEstimada")})
public class OrdenTrabajoEquipo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_orden_trabajo")
    private Integer idOrdenTrabajo;
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Column(name = "fecha_estimada")
    @Temporal(TemporalType.DATE)
    private Date fechaEstimada;
    @OneToMany(mappedBy = "idOdenTrabajo")
    private List<MantenimientoDetalle> mantenimientoDetalleList;
    @OneToMany(mappedBy = "idOrdenTrabajo")
    private List<OrdenTrabajoEquipoDetalle> ordenTrabajoEquipoDetalleList;
    @JoinColumn(name = "id_equipo", referencedColumnName = "id_equipo")
    @ManyToOne
    private Equipo idEquipo;
    @JoinColumn(name = "id_orden", referencedColumnName = "id_orden")
    @ManyToOne
    private Orden idOrden;
    @JoinColumn(name = "id_prioridad", referencedColumnName = "id_prioridad")
    @ManyToOne
    private Prioridad idPrioridad;
    @JoinColumn(name = "id_tipo_mantenimiento", referencedColumnName = "id_tipo_mantenimiento")
    @ManyToOne
    private TipoMantenimiento idTipoMantenimiento;

    public OrdenTrabajoEquipo() {
    }

    public OrdenTrabajoEquipo(Integer idOrdenTrabajo) {
        this.idOrdenTrabajo = idOrdenTrabajo;
    }

    public Integer getIdOrdenTrabajo() {
        return idOrdenTrabajo;
    }

    public void setIdOrdenTrabajo(Integer idOrdenTrabajo) {
        this.idOrdenTrabajo = idOrdenTrabajo;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaEstimada() {
        return fechaEstimada;
    }

    public void setFechaEstimada(Date fechaEstimada) {
        this.fechaEstimada = fechaEstimada;
    }

    @XmlTransient
    public List<MantenimientoDetalle> getMantenimientoDetalleList() {
        return mantenimientoDetalleList;
    }

    public void setMantenimientoDetalleList(List<MantenimientoDetalle> mantenimientoDetalleList) {
        this.mantenimientoDetalleList = mantenimientoDetalleList;
    }

    @XmlTransient
    public List<OrdenTrabajoEquipoDetalle> getOrdenTrabajoEquipoDetalleList() {
        return ordenTrabajoEquipoDetalleList;
    }

    public void setOrdenTrabajoEquipoDetalleList(List<OrdenTrabajoEquipoDetalle> ordenTrabajoEquipoDetalleList) {
        this.ordenTrabajoEquipoDetalleList = ordenTrabajoEquipoDetalleList;
    }

    public Equipo getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Equipo idEquipo) {
        this.idEquipo = idEquipo;
    }

    public Orden getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(Orden idOrden) {
        this.idOrden = idOrden;
    }

    public Prioridad getIdPrioridad() {
        return idPrioridad;
    }

    public void setIdPrioridad(Prioridad idPrioridad) {
        this.idPrioridad = idPrioridad;
    }

    public TipoMantenimiento getIdTipoMantenimiento() {
        return idTipoMantenimiento;
    }

    public void setIdTipoMantenimiento(TipoMantenimiento idTipoMantenimiento) {
        this.idTipoMantenimiento = idTipoMantenimiento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrdenTrabajo != null ? idOrdenTrabajo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdenTrabajoEquipo)) {
            return false;
        }
        OrdenTrabajoEquipo other = (OrdenTrabajoEquipo) object;
        if ((this.idOrdenTrabajo == null && other.idOrdenTrabajo != null) || (this.idOrdenTrabajo != null && !this.idOrdenTrabajo.equals(other.idOrdenTrabajo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.mantenimientowebapp.entity.OrdenTrabajoEquipo[ idOrdenTrabajo=" + idOrdenTrabajo + " ]";
    }
    
}
