/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.mantenimientowebapp.entity;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
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
@Table(name = "equipo_parte", catalog = "mantenimiento", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EquipoParte.findAll", query = "SELECT e FROM EquipoParte e")
    , @NamedQuery(name = "EquipoParte.findByIdEquipo", query = "SELECT e FROM EquipoParte e WHERE e.equipoPartePK.idEquipo = :idEquipo")
    , @NamedQuery(name = "EquipoParte.findByIdParte", query = "SELECT e FROM EquipoParte e WHERE e.equipoPartePK.idParte = :idParte")})
public class EquipoParte implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EquipoPartePK equipoPartePK;
    @JoinColumn(name = "id_equipo", referencedColumnName = "id_equipo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Equipo equipo;

    public EquipoParte() {
    }

    public EquipoParte(EquipoPartePK equipoPartePK) {
        this.equipoPartePK = equipoPartePK;
    }

    public EquipoParte(int idEquipo, int idParte) {
        this.equipoPartePK = new EquipoPartePK(idEquipo, idParte);
    }

    public EquipoPartePK getEquipoPartePK() {
        return equipoPartePK;
    }

    public void setEquipoPartePK(EquipoPartePK equipoPartePK) {
        this.equipoPartePK = equipoPartePK;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (equipoPartePK != null ? equipoPartePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EquipoParte)) {
            return false;
        }
        EquipoParte other = (EquipoParte) object;
        if ((this.equipoPartePK == null && other.equipoPartePK != null) || (this.equipoPartePK != null && !this.equipoPartePK.equals(other.equipoPartePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.mantenimientowebapp.entity.EquipoParte[ equipoPartePK=" + equipoPartePK + " ]";
    }
    
}
