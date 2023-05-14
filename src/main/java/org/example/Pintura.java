package org.example;

public class Pintura {

    String nombre;
    int id;


    Pintura(String nombre, int id)
    {
        this.nombre = nombre;
        this.id = id;
    }
    public void mostrar()
    {
        System.out.println("------->Pintura: "+ this.nombre + " id:" +this.id);
    }

}
