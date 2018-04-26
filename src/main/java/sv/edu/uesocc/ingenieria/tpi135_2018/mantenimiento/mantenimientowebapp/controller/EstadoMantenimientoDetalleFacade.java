/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.mantenimientowebapp.controller;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.mantenimientowebapp.entity.EstadoMantenimientoDetalle;

/**
 *
 * @author rcarlos
 */
@Stateless
public class EstadoMantenimientoDetalleFacade extends AbstractFacade<EstadoMantenimientoDetalle> implements EstadoMantenimientoDetalleFacadeLocal {

    @PersistenceContext(unitName = "mantenimientoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstadoMantenimientoDetalleFacade() {
        super(EstadoMantenimientoDetalle.class);
    }
    
}
