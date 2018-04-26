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
import javax.persistence.CascadeType;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author rcarlos
 */
@Entity
@Table(name = "equipo", catalog = "mantenimiento", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Equipo.findAll", query = "SELECT e FROM Equipo e")
    , @NamedQuery(name = "Equipo.findByIdEquipo", query = "SELECT e FROM Equipo e WHERE e.idEquipo = :idEquipo")
    , @NamedQuery(name = "Equipo.findByNoInventario", query = "SELECT e FROM Equipo e WHERE e.noInventario = :noInventario")
    , @NamedQuery(name = "Equipo.findByObservaciones", query = "SELECT e FROM Equipo e WHERE e.observaciones = :observaciones")
    , @NamedQuery(name = "Equipo.findByIdMarca", query = "SELECT e FROM Equipo e WHERE e.idMarca = :idMarca")
    , @NamedQuery(name = "Equipo.findByResponsable", query = "SELECT e FROM Equipo e WHERE e.responsable = :responsable")
    , @NamedQuery(name = "Equipo.findByFechaIngreso", query = "SELECT e FROM Equipo e WHERE e.fechaIngreso = :fechaIngreso")})
public class Equipo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_equipo")
    private Integer idEquipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "no_inventario")
    private String noInventario;
    @Size(max = 2147483647)
    @Column(name = "observaciones")
    private String observaciones;
    @Column(name = "id_marca")
    private Integer idMarca;
    @Size(max = 200)
    @Column(name = "responsable")
    private String responsable;
    @Column(name = "fecha_ingreso")
    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "equipo")
    private List<EquipoParte> equipoParteList;
    @OneToMany(mappedBy = "idEquipo")
    private List<OrdenTrabajoEquipo> ordenTrabajoEquipoList;

    public Equipo() {
    }

    public Equipo(Integer idEquipo) {
        this.idEquipo = idEquipo;
    }

    public Equipo(Integer idEquipo, String noInventario) {
        this.idEquipo = idEquipo;
        this.noInventario = noInventario;
    }

    public Integer getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Integer idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getNoInventario() {
        return noInventario;
    }

    public void setNoInventario(String noInventario) {
        this.noInventario = noInventario;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Integer getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(Integer idMarca) {
        this.idMarca = idMarca;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    @XmlTransient
    public List<EquipoParte> getEquipoParteList() {
        return equipoParteList;
    }

    public void setEquipoParteList(List<EquipoParte> equipoParteList) {
        this.equipoParteList = equipoParteList;
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
        hash += (idEquipo != null ? idEquipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Equipo)) {
            return false;
        }
        Equipo other = (Equipo) object;
        if ((this.idEquipo == null && other.idEquipo != null) || (this.idEquipo != null && !this.idEquipo.equals(other.idEquipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.mantenimientowebapp.entity.Equipo[ idEquipo=" + idEquipo + " ]";
    }
    
}
