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
@Table(name = "orden_calendario", catalog = "mantenimiento", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrdenCalendario.findAll", query = "SELECT o FROM OrdenCalendario o")
    , @NamedQuery(name = "OrdenCalendario.findByIdOrdenCalendario", query = "SELECT o FROM OrdenCalendario o WHERE o.idOrdenCalendario = :idOrdenCalendario")})
public class OrdenCalendario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_orden_calendario")
    private Integer idOrdenCalendario;
    @JoinColumn(name = "id_fecha", referencedColumnName = "id_fecha")
    @ManyToOne
    private Calendario idFecha;
    @JoinColumn(name = "id_orden", referencedColumnName = "id_orden")
    @ManyToOne
    private Orden idOrden;

    public OrdenCalendario() {
    }

    public OrdenCalendario(Integer idOrdenCalendario) {
        this.idOrdenCalendario = idOrdenCalendario;
    }

    public Integer getIdOrdenCalendario() {
        return idOrdenCalendario;
    }

    public void setIdOrdenCalendario(Integer idOrdenCalendario) {
        this.idOrdenCalendario = idOrdenCalendario;
    }

    public Calendario getIdFecha() {
        return idFecha;
    }

    public void setIdFecha(Calendario idFecha) {
        this.idFecha = idFecha;
    }

    public Orden getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(Orden idOrden) {
        this.idOrden = idOrden;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrdenCalendario != null ? idOrdenCalendario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdenCalendario)) {
            return false;
        }
        OrdenCalendario other = (OrdenCalendario) object;
        if ((this.idOrdenCalendario == null && other.idOrdenCalendario != null) || (this.idOrdenCalendario != null && !this.idOrdenCalendario.equals(other.idOrdenCalendario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.mantenimientowebapp.entity.OrdenCalendario[ idOrdenCalendario=" + idOrdenCalendario + " ]";
    }
    
}
