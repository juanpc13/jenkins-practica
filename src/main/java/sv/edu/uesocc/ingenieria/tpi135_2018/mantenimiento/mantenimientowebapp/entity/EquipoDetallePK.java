/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.mantenimientowebapp.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author rcarlos
 */
@Embeddable
public class EquipoDetallePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_equipo")
    private int idEquipo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_parte")
    private int idParte;

    public EquipoDetallePK() {
    }

    public EquipoDetallePK(int idEquipo, int idParte) {
        this.idEquipo = idEquipo;
        this.idParte = idParte;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public int getIdParte() {
        return idParte;
    }

    public void setIdParte(int idParte) {
        this.idParte = idParte;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idEquipo;
        hash += (int) idParte;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EquipoDetallePK)) {
            return false;
        }
        EquipoDetallePK other = (EquipoDetallePK) object;
        if (this.idEquipo != other.idEquipo) {
            return false;
        }
        if (this.idParte != other.idParte) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.mantenimientowebapp.entity.EquipoDetallePK[ idEquipo=" + idEquipo + ", idParte=" + idParte + " ]";
    }
    
}
