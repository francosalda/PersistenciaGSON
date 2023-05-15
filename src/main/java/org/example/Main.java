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

            ArrayList<Rueda> ruedasAuto1 = new ArrayList<>();
            Rueda rueda1 = new Rueda(11.1, "DD");
            Rueda rueda2 = new Rueda(11.9, "DI");
            ruedasAuto1.add(rueda1);ruedasAuto1.add(rueda2);

            ArrayList<Rueda> ruedasAuto2 = new ArrayList<>();
            Rueda rueda21 = new Rueda(25.1, "DD");
            Rueda rueda22 = new Rueda(22.9, "DI");
            ruedasAuto2.add(rueda21);ruedasAuto2.add(rueda22);
            ArrayList<Rueda> ruedasAuto3 = new ArrayList<>();
            Rueda rueda31 = new Rueda(35.1, "DD");
            Rueda rueda32 = new Rueda(32.1, "DI");
            ruedasAuto3.add(rueda31);ruedasAuto3.add(rueda32);


            Pintura pintura1 = new Pintura("Azul electrico",101);
            Pintura pintura2 = new Pintura("Rojo perlado", 303);
            Pintura pintura3 = new Pintura("Celeste amarinado",404);
            System.out.println("No se encontro archivo con datos pre-existentes");
            ArrayList<Auto> listaAutos = new ArrayList<>();
            Auto auto1 = new Auto("Honda Civic",2007,200,pintura1);
            auto1.agregarRuedas(ruedasAuto1);
            Auto auto2 = new Auto("Fiat 147",1989,65,pintura2);
            auto2.agregarRuedas(ruedasAuto2);
            Auto auto3 = new Auto("Buggati Chiron",2023,1600,pintura3);
            auto3.agregarRuedas(ruedasAuto3);
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