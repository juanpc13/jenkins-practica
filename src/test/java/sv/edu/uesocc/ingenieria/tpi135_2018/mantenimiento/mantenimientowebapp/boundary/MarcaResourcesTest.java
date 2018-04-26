/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.mantenimientowebapp.boundary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.ws.rs.core.Response;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.mockito.internal.util.reflection.Whitebox;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.mantenimientowebapp.controller.MarcaFacadeLocal;
import sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.mantenimientowebapp.entity.Marca;

/**
 *
 * @author jcpleitez
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(MarcaFacadeLocal.class)
public class MarcaResourcesTest {

    final MarcaFacadeLocal mockmarcafacadelocal = Mockito.mock(MarcaFacadeLocal.class);

    public static List<Marca> marcas() {
        List<Marca> marcas = new ArrayList<>();
        List<String> nombres = Arrays.asList("HP", "DELL", "TOSHIBA");
        for (int i = 0; i < nombres.size(); i++) {
            Marca m = new Marca();
            m.setIdMarca(i + 1);
            m.setNombre(nombres.get(i));
            marcas.add(m);
        }
        return marcas;
    }

    public MarcaResourcesTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
//        Mockito.when(this.mockmarcafacadelocal.findByNombreLike(Matchers.anyString())).thenReturn(marcas());
        Mockito.when(this.mockmarcafacadelocal.findAll()).thenReturn(marcas());
        Mockito.when(this.mockmarcafacadelocal.count()).thenReturn(marcas().size());
        Mockito.when(this.mockmarcafacadelocal.crear(Matchers.any(Marca.class))).thenReturn(marcas().get(0));
        Mockito.when(this.mockmarcafacadelocal.findRange(Matchers.anyInt(), Matchers.anyInt())).thenReturn(marcas());
        Mockito.when(this.mockmarcafacadelocal.find(Matchers.anyInt())).thenReturn(marcas().get(0));
        Mockito.when(this.mockmarcafacadelocal.editar(Matchers.any(Marca.class))).thenReturn(marcas().get(0));
        Mockito.when(this.mockmarcafacadelocal.remove(Matchers.any(Marca.class))).thenReturn(Boolean.TRUE);
    }

    @After
    public void tearDown() {
    }
    
//    /**
//     * Test of findByNombreLike method, of class MarcaRest.
//     */
//    @Test
//    public void testFindByNombreLike() {
//        System.out.println("findByNombreLike");
//        MarcaResources instance = new MarcaResources();
//        //instance.mfl = mockmarcafacadelocal;
//        Whitebox.setInternalState(instance, "mfl", mockmarcafacadelocal);
//        Response expResult = Response.ok().build();
//        Response result = instance.findByNombreLike("DELL");
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }

    /**
     * Test of findAll method, of class MarcaRest.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        MarcaResources instance = new MarcaResources();
        //instance.mfl = mockmarcafacadelocal;
        Whitebox.setInternalState(instance, "mfl", mockmarcafacadelocal);
        List<Marca> expResult = marcas();
        List<Marca> result = instance.findAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of count method, of class MarcaRest.
     */
    @Test
    public void testCount() {
        System.out.println("count");
        MarcaResources instance = new MarcaResources();
        Whitebox.setInternalState(instance, "mfl", mockmarcafacadelocal);
        Integer expResult = marcas().size();
        Integer result = instance.count();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class MarcaRest.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        Marca registro = marcas().get(0);
        MarcaResources instance = new MarcaResources();
        Whitebox.setInternalState(instance, "mfl", mockmarcafacadelocal);
        Marca expResult = marcas().get(0);
        Marca result = instance.create(registro);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of findRange method, of class MarcaRest.
     */
    @Test
    public void testFindRange() {
        System.out.println("findRange");
        int first = 0;
        int pageSize = 5;
        MarcaResources instance = new MarcaResources();
        Whitebox.setInternalState(instance, "mfl", mockmarcafacadelocal);
        List<Marca> expResult = marcas();
        List<Marca> result = instance.findRange(first, pageSize);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of findById method, of class MarcaRest.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        Integer id = 1;
        MarcaResources instance = new MarcaResources();
        Whitebox.setInternalState(instance, "mfl", mockmarcafacadelocal);
        Marca expResult = marcas().get(0);
        Marca result = instance.findById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of edit method, of class MarcaRest.
     */
    @Test
    public void testEdit() {
        System.out.println("edit");
        Marca registro = marcas().get(0);
        MarcaResources instance = new MarcaResources();
        Whitebox.setInternalState(instance, "mfl", mockmarcafacadelocal);
        Marca expResult = marcas().get(0);
        Marca result = instance.edit(registro);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class MarcaRest.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        Integer id = 1;
        MarcaResources instance = new MarcaResources();
        Whitebox.setInternalState(instance, "mfl", mockmarcafacadelocal);
        Marca expResult = marcas().get(0);
        Marca result = instance.delete(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}
