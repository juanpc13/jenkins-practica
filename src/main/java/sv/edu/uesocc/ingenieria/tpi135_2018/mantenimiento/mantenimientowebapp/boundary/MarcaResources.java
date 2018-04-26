/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.mantenimientowebapp.boundary;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.mantenimientowebapp.controller.MarcaFacadeLocal;
import sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.mantenimientowebapp.entity.Marca;

/**
 *
 * @author rcarlos
 */
@Path("marca")
public class MarcaResources {

    @EJB
    private MarcaFacadeLocal mfl;

    @GET
    @Path("{marcabuscada}")
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public Response findByNombreLike(
            @PathParam("marcabuscada") String nombre
    ) {
        
        if (mfl != null) {
            try {
                List<Marca> list = null;                
                list = mfl.findByNombreLike(nombre);
                if (list != null && !list.isEmpty()) {
                    JsonArrayBuilder ab = Json.createArrayBuilder();
                    for (Marca marca : list) {
                        ab.add(Json.createObjectBuilder()
                                .add("idMarca", marca.getIdMarca())
                                .add("nombre", marca.getNombre())
                                .add("activo", marca.getActivo()));
                    }
                    return Response.ok(ab.build()).build();
                }
            } catch (Exception ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }            
        }
        return  Response.status(Response.Status.NOT_FOUND).header("filter-not-found", nombre).build();
    }
    
    @GET
    @Path("all")
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public List<Marca> findAll() {
        if (mfl != null) {
            try {
                List<Marca> list = null;                
                list = mfl.findAll();
                if (list != null) {
                    return list;
                }
            } catch (Exception ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }            
        }
        return new ArrayList<>();
    }
    
    @GET
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public List<Marca> findRange(
            @DefaultValue("0") @QueryParam("first") int first,
            @DefaultValue("5") @QueryParam("pagesize") int pageSize
    ) {
        if (mfl != null && first >= 0 && pageSize >= 0) {
            try {
                List salida = null;
                salida = mfl.findRange(first, pageSize);
                if (salida != null) {
                    return salida;                    
                }                
            } catch (Exception ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
        return new ArrayList<>();
    }

    @GET
    @Path("count")
    @Produces({MediaType.TEXT_PLAIN})
    public Integer count() {
        if (mfl != null) {
            try {
                return mfl.count();                
            } catch (Exception ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
        return 0;
    }

    @GET
    @Path("{idmarca}")
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public Marca findById(
            @PathParam("idmarca") Integer id
    ) {
        if (mfl != null && id != null && id > 0) {
            try {
                Marca reg = mfl.find(id);
                if (reg != null) {
                    return reg;
                }
            } catch (Exception ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
        return new Marca();
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public Marca create(Marca registro) {
        if (mfl != null && registro != null) {
            try {
                Marca r = mfl.crear(registro);
                if (r != null) {
                    return r;
                }
            } catch (Exception ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }            
        }
        return new Marca();
    }

    @PUT
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public Marca edit(Marca registro) {
        if (mfl != null) {
            if (registro != null && registro.getIdMarca()!= null) {
                try {
                    Marca r = mfl.editar(registro);
                    if (r != null && r.getIdMarca() != null) {
                        return r;
                    }
                } catch (Exception ex) {
                    Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
                }
            }
        }
        return new Marca();
    }

    @DELETE
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public Marca delete(
            @PathParam("id") Integer id
    ) {
        if (mfl != null && id != null && id > 0) {
            try {
                Marca reg = mfl.find(id);
                if(reg != null){
                    if (mfl.remove(reg)) {
                        return reg;
                    }
                }
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }
        }
        return new Marca();
    }



}
