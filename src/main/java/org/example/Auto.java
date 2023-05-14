package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Auto {

    String nombre;
    int modelo;
    double potencia;
    Pintura pintura;


    Auto(String nombre, int modelo, double potencia,Pintura pintura)
    {
        this.nombre = nombre;
        this.potencia = potencia;
        this.modelo = modelo;
        this.pintura = pintura;
    }

    public void mostrar()
    {
        System.out.println("["+this.nombre+"] modelo: "+this.modelo + " potencia:" + this.potencia+ "HP");
        this.pintura.mostrar();
    }

    public String serializar()
    {
        final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
        final String representacionJSON = prettyGson.toJson(this);
        return  representacionJSON;
    }

}
