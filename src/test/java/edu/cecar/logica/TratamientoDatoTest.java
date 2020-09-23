/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cecar.logica;

import edu.cecar.persistencia.Departamento;
import edu.cecar.persistencia.Empleado;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author oderb
 */
public class TratamientoDatoTest {
    
    public TratamientoDatoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of extraerEmpleados method, of class TratamientoDato.
     */
    @Test
    public void testExtraerEmpleados() throws Exception {
        System.out.println("extraerEmpleados");
        JSONArray expResult = null;
        JSONArray result = TratamientoDato.extraerEmpleados();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of guardarDatosEmpleados method, of class TratamientoDato.
     */
    @Test
    public void testGuardarDatosEmpleados() {
        System.out.println("guardarDatosEmpleados");
        JSONArray result_2 = null;
        ArrayList<Empleado> expResult = null;
        ArrayList<Empleado> result = TratamientoDato.guardarDatosEmpleados(result_2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of guardarDatosDepartamentos method, of class TratamientoDato.
     */
    @Test
    public void testGuardarDatosDepartamentos() {
        System.out.println("guardarDatosDepartamentos");
        JSONArray result_2 = null;
        ArrayList<Departamento> expResult = null;
        ArrayList<Departamento> result = TratamientoDato.guardarDatosDepartamentos(result_2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mostrarEmpleados method, of class TratamientoDato.
     */
    @Test
    public void testMostrarEmpleados() {
        System.out.println("mostrarEmpleados");
        List<Empleado> list = null;
        boolean decision = false;
        TratamientoDato.mostrarEmpleados(list, decision);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mostrarDepartamentos method, of class TratamientoDato.
     */
    @Test
    public void testMostrarDepartamentos() {
        System.out.println("mostrarDepartamentos");
        List<Departamento> listD = null;
        List<Empleado> listE = null;
        int max = 0;
        int min = 0;
        TratamientoDato.mostrarDepartamentos(listD, listE, max, min);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class TratamientoDato.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        TratamientoDato.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
