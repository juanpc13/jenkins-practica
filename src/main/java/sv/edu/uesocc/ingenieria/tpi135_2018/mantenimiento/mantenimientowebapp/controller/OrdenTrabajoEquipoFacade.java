/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.mantenimientowebapp.controller;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.mantenimientowebapp.entity.OrdenTrabajoEquipo;

/**
 *
 * @author rcarlos
 */
@Stateless
public class OrdenTrabajoEquipoFacade extends AbstractFacade<OrdenTrabajoEquipo> implements OrdenTrabajoEquipoFacadeLocal {

    @PersistenceContext(unitName = "mantenimientoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrdenTrabajoEquipoFacade() {
        super(OrdenTrabajoEquipo.class);
    }
    
}
