/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cecar.logica;

import edu.cecar.persistencia.Departamento;
import edu.cecar.persistencia.Empleado;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;

/**
 *
 * @author oderb
 */
public class TratamientoDatos {

    public static JSONArray extraerEmpleados() throws IOException {

        JSONArray result = null;

        try {
            URLConnection connection = new URL("https://my.api.mockaroo.com/empleados.json?key=6ce20c10").openConnection();

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream(), Charset.forName("UTF-8")));
            StringBuilder sb = new StringBuilder();

            String line;
            while ((line = in.readLine()) != null) {
                sb.append(line);
            }
            in.close();

            result = new JSONArray(sb.toString());

        } catch (MalformedURLException ex) {
            Logger.getLogger(TratamientoDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public static void manejoDeEmpleados(JSONArray result) {

        Comparator<Empleado> orderByIdentificador = new Comparator<Empleado>() {
            @Override
            public int compare(Empleado o1, Empleado o2) {
                return new Integer(o1.getIdentificador()).compareTo(new Integer(o2.getIdentificador()));
            }
        };
        
        
        Comparator<Empleado> orderByEdad = new Comparator<Empleado>() {
            @Override
            public int compare(Empleado o1, Empleado o2) {
                return new Integer(o1.getEdad()).compareTo(new Integer(o2.getEdad()));
            }
        };

        Set<Empleado> listaEmpleado = new TreeSet<Empleado>(orderByIdentificador);

        for (int i = 0; i < result.length(); i++) {
            Empleado empleado = new Empleado();

            empleado.setIdentificador(Integer.parseInt(result.getJSONObject(i).get("identificador").toString()));
            empleado.setNombres(result.getJSONObject(i).get("nombre").toString());
            empleado.setApellido(result.getJSONObject(i).get("apellido").toString());
            empleado.setFechaNacimiento(result.getJSONObject(i).get("fechaNacimiento").toString());
            empleado.setDepartamento(result.getJSONObject(i).get("departamento").toString());

            listaEmpleado.add(empleado);

        }
        List<Empleado> listaEmpleado1 = new ArrayList<>(); 
        listaEmpleado1.addAll(listaEmpleado);
        listaEmpleado.forEach(e -> System.out.println(e.getIdentificador() + " " + e.getNombres()+" "+e.getEdad()));
        System.out.println("-----------------------------------------------------");
        Collections.sort(listaEmpleado1,orderByEdad);
        listaEmpleado1.forEach(e -> System.out.println(e.getIdentificador() + " " + e.getNombres()+" "+e.getFechaNacimiento()));
    }

    public static void manejoDepartamento(JSONArray result) {
        Set<Departamento> listaDepartamento = new HashSet();

        for (int i = 0; i < result.length(); i++) {
            Departamento departamento = new Departamento();
            departamento.setNombres(result.getJSONObject(i).get("departamento").toString());
            departamento.setIdentificador(String.valueOf(i));

            listaDepartamento.add(departamento);
        }

        listaDepartamento.forEach((Departamento departamento) -> System.out.println(departamento.getIdentificador() + " // " + departamento.getNombres()));

    }

    public static void main(String[] args) {
        try {
            JSONArray lista = extraerEmpleados();

            manejoDeEmpleados(lista);
            //manejoDepartamento(lista);

        } catch (IOException ex) {
            Logger.getLogger(TratamientoDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
