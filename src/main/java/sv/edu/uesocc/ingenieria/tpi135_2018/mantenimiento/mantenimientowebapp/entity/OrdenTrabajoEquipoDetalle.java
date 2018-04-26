/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.mantenimientowebapp.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rcarlos
 */
@Entity
@Table(name = "orden_trabajo_equipo_detalle", catalog = "mantenimiento", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrdenTrabajoEquipoDetalle.findAll", query = "SELECT o FROM OrdenTrabajoEquipoDetalle o")
    , @NamedQuery(name = "OrdenTrabajoEquipoDetalle.findByIdOrdenTrabajoEquipoDetalle", query = "SELECT o FROM OrdenTrabajoEquipoDetalle o WHERE o.idOrdenTrabajoEquipoDetalle = :idOrdenTrabajoEquipoDetalle")
    , @NamedQuery(name = "OrdenTrabajoEquipoDetalle.findByIdUsuario", query = "SELECT o FROM OrdenTrabajoEquipoDetalle o WHERE o.idUsuario = :idUsuario")
    , @NamedQuery(name = "OrdenTrabajoEquipoDetalle.findByIdRol", query = "SELECT o FROM OrdenTrabajoEquipoDetalle o WHERE o.idRol = :idRol")})
public class OrdenTrabajoEquipoDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_orden_trabajo_equipo_detalle")
    private Integer idOrdenTrabajoEquipoDetalle;
    @Column(name = "id_usuario")
    private Integer idUsuario;
    @Column(name = "id_rol")
    private Integer idRol;
    @JoinColumns({
        @JoinColumn(name = "id_equipo", referencedColumnName = "id_equipo")
        , @JoinColumn(name = "id_parte", referencedColumnName = "id_parte")})
    @ManyToOne
    private EquipoDetalle equipoDetalle;
    @JoinColumn(name = "id_orden_trabajo", referencedColumnName = "id_orden_trabajo")
    @ManyToOne
    private OrdenTrabajoEquipo idOrdenTrabajo;

    public OrdenTrabajoEquipoDetalle() {
    }

    public OrdenTrabajoEquipoDetalle(Integer idOrdenTrabajoEquipoDetalle) {
        this.idOrdenTrabajoEquipoDetalle = idOrdenTrabajoEquipoDetalle;
    }

    public Integer getIdOrdenTrabajoEquipoDetalle() {
        return idOrdenTrabajoEquipoDetalle;
    }

    public void setIdOrdenTrabajoEquipoDetalle(Integer idOrdenTrabajoEquipoDetalle) {
        this.idOrdenTrabajoEquipoDetalle = idOrdenTrabajoEquipoDetalle;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    public EquipoDetalle getEquipoDetalle() {
        return equipoDetalle;
    }

    public void setEquipoDetalle(EquipoDetalle equipoDetalle) {
        this.equipoDetalle = equipoDetalle;
    }

    public OrdenTrabajoEquipo getIdOrdenTrabajo() {
        return idOrdenTrabajo;
    }

    public void setIdOrdenTrabajo(OrdenTrabajoEquipo idOrdenTrabajo) {
        this.idOrdenTrabajo = idOrdenTrabajo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrdenTrabajoEquipoDetalle != null ? idOrdenTrabajoEquipoDetalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdenTrabajoEquipoDetalle)) {
            return false;
        }
        OrdenTrabajoEquipoDetalle other = (OrdenTrabajoEquipoDetalle) object;
        if ((this.idOrdenTrabajoEquipoDetalle == null && other.idOrdenTrabajoEquipoDetalle != null) || (this.idOrdenTrabajoEquipoDetalle != null && !this.idOrdenTrabajoEquipoDetalle.equals(other.idOrdenTrabajoEquipoDetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.mantenimientowebapp.entity.OrdenTrabajoEquipoDetalle[ idOrdenTrabajoEquipoDetalle=" + idOrdenTrabajoEquipoDetalle + " ]";
    }
    
}
