/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.mantenimientowebapp.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author rcarlos
 */
@Entity
@Table(name = "equipo_detalle", catalog = "mantenimiento", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EquipoDetalle.findAll", query = "SELECT e FROM EquipoDetalle e")
    , @NamedQuery(name = "EquipoDetalle.findByIdEquipo", query = "SELECT e FROM EquipoDetalle e WHERE e.equipoDetallePK.idEquipo = :idEquipo")
    , @NamedQuery(name = "EquipoDetalle.findByIdParte", query = "SELECT e FROM EquipoDetalle e WHERE e.equipoDetallePK.idParte = :idParte")
    , @NamedQuery(name = "EquipoDetalle.findByIdEquipoDetalle", query = "SELECT e FROM EquipoDetalle e WHERE e.idEquipoDetalle = :idEquipoDetalle")
    , @NamedQuery(name = "EquipoDetalle.findByActivo", query = "SELECT e FROM EquipoDetalle e WHERE e.activo = :activo")
    , @NamedQuery(name = "EquipoDetalle.findByNInventario", query = "SELECT e FROM EquipoDetalle e WHERE e.nInventario = :nInventario")
    , @NamedQuery(name = "EquipoDetalle.findBySerie", query = "SELECT e FROM EquipoDetalle e WHERE e.serie = :serie")
    , @NamedQuery(name = "EquipoDetalle.findByCaracteristicas", query = "SELECT e FROM EquipoDetalle e WHERE e.caracteristicas = :caracteristicas")})
public class EquipoDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EquipoDetallePK equipoDetallePK;
    @Basic(optional = false)
    @Column(name = "id_equipo_detalle")
    private long idEquipoDetalle;
    @Column(name = "activo")
    private Boolean activo;
    @Size(max = 200)
    @Column(name = "n_inventario")
    private String nInventario;
    @Size(max = 200)
    @Column(name = "serie")
    private String serie;
    @Size(max = 2147483647)
    @Column(name = "caracteristicas")
    private String caracteristicas;
    @OneToMany(mappedBy = "equipoDetalle")
    private List<OrdenTrabajoEquipoDetalle> ordenTrabajoEquipoDetalleList;
    @JoinColumn(name = "id_marca", referencedColumnName = "id_marca")
    @ManyToOne
    private Marca idMarca;
    @JoinColumn(name = "id_modelo", referencedColumnName = "id_modelo")
    @ManyToOne
    private Modelo idModelo;

    public EquipoDetalle() {
    }

    public EquipoDetalle(EquipoDetallePK equipoDetallePK) {
        this.equipoDetallePK = equipoDetallePK;
    }

    public EquipoDetalle(EquipoDetallePK equipoDetallePK, long idEquipoDetalle) {
        this.equipoDetallePK = equipoDetallePK;
        this.idEquipoDetalle = idEquipoDetalle;
    }

    public EquipoDetalle(int idEquipo, int idParte) {
        this.equipoDetallePK = new EquipoDetallePK(idEquipo, idParte);
    }

    public EquipoDetallePK getEquipoDetallePK() {
        return equipoDetallePK;
    }

    public void setEquipoDetallePK(EquipoDetallePK equipoDetallePK) {
        this.equipoDetallePK = equipoDetallePK;
    }

    public long getIdEquipoDetalle() {
        return idEquipoDetalle;
    }

    public void setIdEquipoDetalle(long idEquipoDetalle) {
        this.idEquipoDetalle = idEquipoDetalle;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public String getNInventario() {
        return nInventario;
    }

    public void setNInventario(String nInventario) {
        this.nInventario = nInventario;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    @XmlTransient
    public List<OrdenTrabajoEquipoDetalle> getOrdenTrabajoEquipoDetalleList() {
        return ordenTrabajoEquipoDetalleList;
    }

    public void setOrdenTrabajoEquipoDetalleList(List<OrdenTrabajoEquipoDetalle> ordenTrabajoEquipoDetalleList) {
        this.ordenTrabajoEquipoDetalleList = ordenTrabajoEquipoDetalleList;
    }

    public Marca getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(Marca idMarca) {
        this.idMarca = idMarca;
    }

    public Modelo getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(Modelo idModelo) {
        this.idModelo = idModelo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (equipoDetallePK != null ? equipoDetallePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EquipoDetalle)) {
            return false;
        }
        EquipoDetalle other = (EquipoDetalle) object;
        if ((this.equipoDetallePK == null && other.equipoDetallePK != null) || (this.equipoDetallePK != null && !this.equipoDetallePK.equals(other.equipoDetallePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.mantenimientowebapp.entity.EquipoDetalle[ equipoDetallePK=" + equipoDetallePK + " ]";
    }
    
}
