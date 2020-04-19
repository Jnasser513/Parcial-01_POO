package com.JRNS.x00245818;

import java.util.ArrayList;

public abstract class Empleado {
    protected String nombre, puesto;
    protected double salario;
    protected ArrayList<Documento> documentos;

    public Empleado(String nombre, String puesto ,double salario){
        this.nombre = nombre;
        this.puesto = puesto;
        this.salario = salario;
        documentos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getPuesto() {
        return puesto;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public ArrayList<Documento> getDocumentos() {
        return documentos;
    }

    public void addDocumento(Documento doc){
        documentos.add(doc);
    }

    public void removeDocumento(String nombredoc){
        documentos.removeIf(obj -> obj.getNombre().equalsIgnoreCase(nombredoc));
    }
}
