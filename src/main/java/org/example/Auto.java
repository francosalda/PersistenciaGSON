package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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

    public String serializar()
    {
        final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
        final String representacionJSON = prettyGson.toJson(this);
        return  representacionJSON;
    }

}
