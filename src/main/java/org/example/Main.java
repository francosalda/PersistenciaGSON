package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args)
    {
        Saver saver = new Saver("./autos.json");

        if(saver.yaExisteArchivo())
        {
            System.out.println("Se encontro un archivo con datos pre-existente");
            saver.abrirArchivoLectura();
            String dataInput = "";
            String lineInput;
            while( (lineInput = saver.leer()) != null)
            {
                dataInput =  dataInput.concat(lineInput);
            }
            saver.cerrarArchivo();

            System.out.println("Cargando objetos con datos:");
            final Gson gson = new Gson();
            final Type tipoListaAutos = new TypeToken<List<Auto>>() {}.getType();
            final List<Auto> listadoAutos = gson.fromJson(dataInput, tipoListaAutos);
            for(Auto auto: listadoAutos)
            {
                   auto.mostrar();
            }
        }
        else {

            Pintura pintura1 = new Pintura("Azul electrico",101);
            System.out.println("No se encontro archivo con datos pre-existentes");
            ArrayList<Auto> listaAutos = new ArrayList<>();
            Auto auto1 = new Auto("Honda Civic",2007,200,pintura1);
            Auto auto2 = new Auto("Fiat 147",1989,65,pintura1);
            Auto auto3 = new Auto("Buggati Chiron",2023,1600,pintura1);
            listaAutos.add(auto1);
            listaAutos.add(auto2);
            listaAutos.add(auto3);


            final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
            final String dataOutput = prettyGson.toJson(listaAutos);
            saver.abrirArchivoEscritura();
            System.out.println("Guardando datos en ./autos.json");
            saver.escribir(dataOutput);
            saver.cerrarArchivo();

        }

    }
}