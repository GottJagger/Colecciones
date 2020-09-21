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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
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
public class TratamientoDato {

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
            Logger.getLogger(TratamientoDato.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public static ArrayList<Empleado> guardarDatosEmpleados(JSONArray result) {
        ArrayList List = new ArrayList<Empleado>();

        for (int i = 0; i < result.length(); i++) {

            Empleado empleado = new Empleado();

            empleado.setIdentificador(Integer.parseInt(result.getJSONObject(i).get("identificador").toString()));
            empleado.setNombres(result.getJSONObject(i).get("nombre").toString());
            empleado.setApellido(result.getJSONObject(i).get("apellido").toString());
            empleado.setFechaNacimiento(result.getJSONObject(i).get("fechaNacimiento").toString());
            empleado.setDepartamento(result.getJSONObject(i).get("departamento").toString());

            List.add(empleado);

        }
        return List;

    }

    public static ArrayList<Departamento> guardarDatosDepartamentos(JSONArray result) {
        ArrayList List = new ArrayList<Departamento>();

        for (int i = 0; i < result.length(); i++) {
            Departamento departamento = new Departamento();
            departamento.setNombres(result.getJSONObject(i).get("departamento").toString());
            departamento.setIdentificador(String.valueOf(i));

            List.add(departamento);
        }
        return List;
    }

    public static void mostrarEmpleados(List<Empleado> list, boolean decision) {

        Set<Empleado> Set = new HashSet(list);

        Comparator<Empleado> orderByIdentificador = new Comparator<Empleado>() {
            @Override
            public int compare(Empleado o1, Empleado o2) {
                return new Integer(o1.getIdentificador()).compareTo(new Integer(o2.getIdentificador()));
            }
        };

        Set<Empleado> listaEmpleado = new TreeSet<Empleado>(orderByIdentificador);

        listaEmpleado.addAll(Set);

        if (decision) {

            listaEmpleado.forEach(e -> System.out.println(e.getIdentificador() + " " + e.getNombres() + " " + e.getEdad()));
        } else {

            Comparator<Empleado> orderByFechaDeNacimiento = new Comparator<Empleado>() {
                @Override
                public int compare(Empleado o1, Empleado o2) {
                    int i = 0;
                    try {
                        
                        Date fecha = new SimpleDateFormat("MM/dd/yyyy").parse(o1.getFechaNacimiento());
                        Date fecha1 = new SimpleDateFormat("MM/dd/yyyy").parse(o2.getFechaNacimiento());

                        Calendar cal1 = Calendar.getInstance();
                        Calendar cal2 = Calendar.getInstance();

                        cal1.setTime(fecha);
                        cal2.setTime(fecha1);
                        i = cal2.compareTo(cal1);

                    } catch (ParseException ex) {
                        Logger.getLogger(TratamientoDato.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    return i;
                }
            };

            List<Empleado> listaEmpleado1 = new ArrayList<>();
            listaEmpleado1.addAll(listaEmpleado);
            Collections.sort(listaEmpleado1, orderByFechaDeNacimiento);

            listaEmpleado1.forEach(e -> System.out.println(e.getIdentificador() + " " + e.getNombres() + " " + e.getFechaNacimiento()));
        }

    }

    public static void mostrarDepartamentos(List<Departamento> listD, List<Empleado> listE, int max, int min) {

        Set<Departamento> listaDepartamento = new HashSet(listD);

        for (Iterator it = listaDepartamento.iterator(); it.hasNext();) {

            Departamento departamento = (Departamento) it.next();
            System.out.println("\n---------------------------------------\n" + departamento.getNombres().toUpperCase() + "\n---------------------------------------");
            for (Iterator jt = listE.iterator(); jt.hasNext();) {

                Empleado empleado = (Empleado) jt.next();
                if (empleado.getDepartamento().equals(departamento.getNombres()) && (empleado.getEdad() < max && empleado.getEdad() > min)) {
                    System.out.println(empleado.getNombres() + " " + empleado.getApellido() + " EDAD: " + empleado.getEdad());
                }

            }
        }

    }

    public static void main(String[] args) {
        try {
            
            JSONArray result = extraerEmpleados();

            mostrarEmpleados(guardarDatosEmpleados(result), true);
            System.out.println("\n************************************************************************");
            mostrarDepartamentos(guardarDatosDepartamentos(result), guardarDatosEmpleados(result), 35, 18);

        } catch (IOException ex) {
            Logger.getLogger(TratamientoDato.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
