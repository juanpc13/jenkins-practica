/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.mantenimientowebapp.boundary;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author rcarlos
 */
@javax.ws.rs.ApplicationPath("ws")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        resources.add(sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.mantenimientowebapp.boundary.MarcaResources.class);
        return resources;
    }

}
