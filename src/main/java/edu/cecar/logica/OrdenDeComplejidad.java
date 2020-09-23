/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cecar.logica;

import edu.cecar.persistencia.Empleado;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.IntStream;
import javax.swing.JOptionPane;
import org.json.JSONArray;

/**
 *
 * @author oderb
 */
public class OrdenDeComplejidad {

    public static List guardarList() {
        ArrayList<Empleado> Array = new ArrayList<>();
        int k = 0;
        System.out.println("Guardando...");
        for (int i = 0; i < 20; i++) {
            try {
                JSONArray jsArray = TratamientoDato.extraerEmpleados();

                for (int j = 0; j < jsArray.length(); j++) {
                    Empleado empleado = new Empleado();
                    k++;
                    empleado.setIdentificador(k);
                    empleado.setNombres(jsArray.getJSONObject(j).get("nombre").toString());
                    empleado.setApellido(jsArray.getJSONObject(j).get("apellido").toString());
                    empleado.setFechaNacimiento(jsArray.getJSONObject(j).get("fechaNacimiento").toString());
                    empleado.setDepartamento(jsArray.getJSONObject(j).get("departamento").toString());
                    Array.add(empleado);
                }

            } catch (IOException ex) {
                Logger.getLogger(OrdenDeComplejidad.class.getName()).log(Level.SEVERE, null, ex);
            }
            //Array.forEach((Empleado e) -> System.out.println(e.getIdentificador() + " " + e.getNombres() + " " + e.getEdad()));
        }
        System.out.println("Guardado!");
        return Array;
    }

    public static void buscarRandomArrayList(List list, int randomItem) {
        long tInicio, TFin, tiempo;
        tInicio = System.nanoTime();

        ArrayList<Empleado> array = new ArrayList<>(list);
        System.out.println("Buscando...");

        System.out.println(array.get(randomItem).getNombres() + " " + array.get(randomItem).getApellido());

        TFin = System.nanoTime();
        tiempo = TFin - tInicio;
        System.out.println("Tiempo de ejecucion: " + tiempo);
    }

    public static void buscarArrayList(List list, int identificador) {
        double tInicio, TFin, tiempo;
        tInicio = System.nanoTime();
        ArrayList<Empleado> array = new ArrayList<>(list);

        System.out.println("Buscando...");

        System.out.println(array.get(identificador).getNombres() + "" + array.get(identificador).getApellido());

        TFin = System.nanoTime();
        tiempo = TFin - tInicio;
        System.out.println("Tiempo de ejecucion: " + tiempo);
    }

    public static void insertArrayList(List list) {
        double tInicio, TFin, tiempo;
        tInicio = System.nanoTime();
        ArrayList<Empleado> array = new ArrayList<>(list);
        Empleado empleado = new Empleado();
        empleado.setIdentificador(1 + (array.get(array.size() - 1).getIdentificador()));
        empleado.setNombres("jose");
        empleado.setApellido("Chagui");
        empleado.setFechaNacimiento("07/1/1996");
        empleado.setDepartamento("ESTUDIANTADO");

        array.add(empleado);
        System.out.println("Agregado");
        System.out.println(array.get(array.size() - 1).getNombres() + " " + array.get(array.size() - 1).getApellido());
        TFin = System.nanoTime();
        tiempo = TFin - tInicio;
        System.out.println("Tiempo de ejecucion: " + tiempo);
    }
//-------------------------------------------------------------------------------------

    public static void buscarRandomHashSet(List list) {
        double tInicio, TFin, tiempo = 0;

        boolean busqueda = false;
        int i = new Random().nextInt(100000 - 1);
        Set<Empleado> array = new HashSet<>(list);
        System.out.println("Buscando...");

        tInicio = System.nanoTime();
        for (Iterator<Empleado> iterator = array.iterator(); iterator.hasNext();) {
            Empleado next = iterator.next();
            if (i == next.getIdentificador()) {

                System.out.println(next.getNombres() + " " + next.getApellido());

                busqueda = true;
                break;
            }
        }
        TFin = System.nanoTime();
        tiempo = TFin - tInicio;
        if (busqueda) {
            System.out.println("Encontrado");
        } else {
            System.out.println("No lo Encontro");
        }

        System.out.println("Tiempo de ejecucion: " + tiempo);
    }

    public static void buscarHashSet(List list, int identificador) {
        double tInicio, TFin, tiempo = 0;

        Set<Empleado> array = new HashSet<>(list);
        boolean busqueda = false;
        System.out.println("Buscando...");
        tInicio = System.nanoTime();
        for (Iterator<Empleado> iterator = array.iterator(); iterator.hasNext();) {
            Empleado next = iterator.next();
            if (identificador == next.getIdentificador()) {

                System.out.println(next.getNombres() + " " + next.getApellido());

                busqueda = true;
                break;
            }
        }
        TFin = System.nanoTime();
        tiempo = TFin - tInicio;
        if (busqueda) {
            System.out.println("Encontrado");
        } else {
            System.out.println("No lo Encontro");
        }

        System.out.println("Tiempo de ejecucion: " + tiempo);
    }

    public static void insertHashSet(List list) {
        double tInicio, TFin, tiempo;

        ArrayList<Empleado> array = new ArrayList<>(list);
        Empleado empleado = new Empleado();
        tInicio = System.nanoTime();
        empleado.setIdentificador(1 + (array.get(array.size() - 1).getIdentificador()));
        empleado.setNombres("juan");
        empleado.setApellido("perez");
        empleado.setFechaNacimiento("07/1/1994");
        empleado.setDepartamento("ESTUDIANTADO");

        array.add(empleado);
        System.out.println("Agregado");
        System.out.println(array.get(array.size() - 1).getNombres() + " " + array.get(array.size() - 1).getApellido());
        TFin = System.nanoTime();
        tiempo = TFin - tInicio;
        System.out.println("Tiempo de ejecucion: " + tiempo);

    }
//-------------------------------------------------------------------------------------

    public static void buscarRandomHashMap(List list, int randomItem) {
        double tInicio, TFin, tiempo;

        Map<Integer, Empleado> array = new HashMap();
        System.out.println("Buscando...");

        int k = 0;
        for (Iterator iterator = list.iterator(); iterator.hasNext();) {
            Empleado next = (Empleado) iterator.next();
            array.put(k, next);
            k++;
        }

        tInicio = System.nanoTime();
        System.out.println(array.get(randomItem).getNombres() + " " + array.get(randomItem).getApellido());
        TFin = System.nanoTime();

        tiempo = TFin - tInicio;
        System.out.println("Tiempo de ejecucion: " + tiempo);
    }

    public static void buscarHashMap(List list, int identificador) {
        double tInicio, TFin, tiempo;

        boolean busqueda = false;

        Map<Integer, Empleado> array = new HashMap();
        System.out.println("Buscando...");

        int k = 0;
        for (Iterator iterator = list.iterator(); iterator.hasNext();) {
            Empleado next = (Empleado) iterator.next();
            array.put(k, next);
            k++;
        }
        tInicio = System.nanoTime();
        System.out.println(array.get(identificador).getNombres() + " " + array.get(identificador).getApellido());
        TFin = System.nanoTime();
        tiempo = TFin - tInicio;
        System.out.println("Tiempo de ejecucion: " + tiempo);
    }

    public static void insertHashMap(List list) {
        double tInicio, TFin, tiempo;

        Map<Integer, Empleado> array = new HashMap();
        System.out.println("Buscando...");

        int k = 0;
        for (Iterator iterator = list.iterator(); iterator.hasNext();) {
            Empleado next = (Empleado) iterator.next();
            array.put(k, next);
            k++;
        }

        tInicio = System.nanoTime();
        Empleado empleado = new Empleado();
        empleado.setIdentificador(1 + (array.get(array.size() - 1).getIdentificador()));
        empleado.setNombres("juan");
        empleado.setApellido("perez");
        empleado.setFechaNacimiento("07/1/1994");
        empleado.setDepartamento("ESTUDIANTADO");

        array.put(k, empleado);
        System.out.println("Agregado");
        System.out.println(array.get(array.size() - 1).getNombres() + " " + array.get(array.size() - 1).getApellido());
        TFin = System.nanoTime();
        tiempo = TFin - tInicio;
        System.out.println("Tiempo de ejecucion: " + tiempo);
    }
//------------------------------------------------------------------------------------

    public static void buscarRandomTreeMap(List list, int randomItem) {
        double tInicio, TFin, tiempo;

        Map<Integer, Empleado> array = new TreeMap();

        System.out.println("Buscando...");

        int k = 0;
        for (Iterator iterator = list.iterator(); iterator.hasNext();) {
            Empleado next = (Empleado) iterator.next();
            array.put(k, next);
            k++;
        }

        tInicio = System.nanoTime();
        System.out.println(array.get(randomItem).getNombres() + " " + array.get(randomItem).getApellido());
        TFin = System.nanoTime();

        tiempo = TFin - tInicio;
        System.out.println("Tiempo de ejecucion: " + tiempo);
    }

    public static void buscarTreeMap(List list, int identificador) {
        double tInicio, TFin, tiempo;

        boolean busqueda = false;

        Map<Integer, Empleado> array = new HashMap();
        System.out.println("Buscando...");

        int k = 0;
        for (Iterator iterator = list.iterator(); iterator.hasNext();) {
            Empleado next = (Empleado) iterator.next();
            array.put(k, next);
            k++;
        }

        tInicio = System.nanoTime();
        System.out.println(array.get(identificador).getNombres() + " " + array.get(identificador).getApellido());

        TFin = System.nanoTime();
        tiempo = TFin - tInicio;
        System.out.println("Tiempo de ejecucion: " + tiempo);
    }

    public static void insertTreeMap(List list) {
        double tInicio, TFin, tiempo;
        Map<Integer, Empleado> array = new TreeMap();
        System.out.println("Buscando...");

        int k = 0;
        for (Iterator iterator = list.iterator(); iterator.hasNext();) {
            Empleado next = (Empleado) iterator.next();
            array.put(k, next);
            k++;
        }

        tInicio = System.nanoTime();
        Empleado empleado = new Empleado();
        empleado.setIdentificador(1 + (array.get(array.size() - 1).getIdentificador()));
        empleado.setNombres("juan");
        empleado.setApellido("perez");
        empleado.setFechaNacimiento("07/1/1994");
        empleado.setDepartamento("ESTUDIANTADO");

        array.put(k, empleado);
        System.out.println("Agregado");
        System.out.println(array.get(array.size() - 1).getNombres() + " " + array.get(array.size() - 1).getApellido());
        TFin = System.nanoTime();
        tiempo = (TFin - tInicio) / 1000000;
        System.out.println("Tiempo de ejecucion: " + tiempo);
    }

    public static void main(String[] args) {

        int i = new Random().nextInt(100000 - 1);
        int j = new Random().nextInt(100000 - 1);
        ArrayList list = (ArrayList) guardarList();

        System.out.println("****************************");
        System.out.println("ARRAYlIST");
        System.out.println("----------------------------");
        buscarRandomArrayList(list, i);
        System.out.println("----------------------------");
        buscarArrayList(list, j);
        System.out.println("----------------------------");
        insertArrayList(list);

        System.out.println("*****************************");
        System.out.println("HASHSET");
        System.out.println("----------------------------");
        buscarRandomHashSet(list);
        System.out.println("----------------------------");
        buscarHashSet(list, j);
        System.out.println("----------------------------");
        insertHashSet(list);

        System.out.println("*****************************");
        System.out.println("HASHMAP");
        System.out.println("----------------------------");
        buscarRandomHashMap(list, i);
        System.out.println("----------------------------");
        buscarHashMap(list, j);
        System.out.println("----------------------------");
        insertHashMap(list);

        System.out.println("*****************************");
        System.out.println("TREEMAP");
        System.out.println("----------------------------");
        buscarRandomTreeMap(list, i);
        System.out.println("----------------------------");
        buscarTreeMap(list, j);
        System.out.println("----------------------------");
        insertTreeMap(list);
        System.out.println("*****************************");

    }
}
