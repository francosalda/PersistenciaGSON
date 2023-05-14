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

        ArrayList<Auto> listaAutos = new ArrayList<>();
        Auto auto1 = new Auto("Honda Civic",2007,200);
        Auto auto2 = new Auto("Fiat 147",1989,65);
        Auto auto3 = new Auto("Buggati Chiron",2023,1600);
        listaAutos.add(auto1);
        listaAutos.add(auto2);
        listaAutos.add(auto3);

       /* String dataOutput = "[ ";
        for(Auto auto : listaAutos)
        {
            dataOutput = dataOutput.concat(auto.serializar());
            dataOutput = dataOutput.concat(",");
        }
       dataOutput = dataOutput.concat(" ]");
        //System.out.println(dataOutput);
*/
        final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
        final String dataOutput = prettyGson.toJson(listaAutos);
        System.out.println(dataOutput);




        final Gson gson = new Gson();
        final Type tipoListaAutos = new TypeToken<List<Auto>>() {}.getType();
        final List<Auto> listadoAutos = gson.fromJson(dataOutput, tipoListaAutos);
        for(Auto auto: listadoAutos)
        {
            auto.mostrar();
        }


    }
}