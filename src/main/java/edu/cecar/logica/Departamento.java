/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cecar.logica;

/**
 *
 * @author oderb
 */
public class Departamento {
    String identificador;
    String nombres;

    public Departamento() {
    }

    public Departamento(String identificador, String nombres) {
        this.identificador = identificador;
        this.nombres = nombres;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    
    
}
