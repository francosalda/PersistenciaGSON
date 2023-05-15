package org.example;

public class Rueda {

    double presion;
    String ubicacion;

    Rueda(double presion, String ubicacion)
    {
        this.presion = presion;
        this.ubicacion = ubicacion;
    }

    public void mostrar()
    {
        System.out.println("*Rueda "+ ubicacion + " Presion :" + presion);
    }

}
