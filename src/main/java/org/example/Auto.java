package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

public class Auto {

    String nombre;
    int modelo;
    double potencia;
    Pintura pintura;
    ArrayList<Rueda> ruedas;


    Auto(String nombre, int modelo, double potencia,Pintura pintura)
    {
        this.nombre = nombre;
        this.potencia = potencia;
        this.modelo = modelo;
        this.pintura = pintura;
        this.ruedas = new ArrayList<>();
    }

    public void mostrar()
    {
        System.out.println("["+this.nombre+"] modelo: "+this.modelo + " potencia:" + this.potencia+ "HP");
        this.pintura.mostrar();
        for(Rueda rueda: this.ruedas)
        {
            rueda.mostrar();
        }
        System.out.println("-----------------------------------------");
    }

    public void agregarRuedas(ArrayList<Rueda> ruedas)
    {
        this.ruedas = ruedas;
    }

    public String serializar()
    {
        final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
        final String representacionJSON = prettyGson.toJson(this);
        return  representacionJSON;
    }

}
