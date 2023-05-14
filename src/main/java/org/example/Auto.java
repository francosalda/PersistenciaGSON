package org.example;

public class Auto {

    String nombre;
    int modelo;
    double potencia;

    Auto(String nombre, int modelo, double potencia)
    {
        this.nombre = nombre;
        this.potencia = potencia;
        this.modelo = modelo;
    }

    public void mostrar()
    {
        System.out.println("["+this.nombre+"] modelo: "+this.modelo + " potencia:" + this.potencia+ "HP");
    }

}
