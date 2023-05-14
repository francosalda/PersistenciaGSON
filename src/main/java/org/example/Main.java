package org.example;

import com.google.gson.Gson;

public class Main {
    public static void main(String[] args)
    {
        final String json = "{\"nombre\":\"Honda Civic\", \"modelo\":\"2007\", \"potencia\":\"195\"}";
        System.out.println("RAW DATA : " + json);
        final Gson gson = new Gson();
        Auto auto1 = gson.fromJson(json, Auto.class);
        auto1.mostrar();

    }
}