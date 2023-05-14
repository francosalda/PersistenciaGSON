package org.example;

import java.io.*;

public class Saver {

    String path;
    File file;
    BufferedReader br;
    PrintWriter pw;
    Saver(String path)
    {
        this.path = path;
        this.file = new File(path);
    }



    public String leer()
    {
        String input = null;
        try {
            input = this.br.readLine();
        } catch (IOException e) {
            System.out.println("[Excepcion] No se pudo leer la linea");
        }
        return input;

    }

    public void abrirArchivoLectura()
    {
        if(this.br == null) {

            FileReader fr = null;
            try {
                fr = new FileReader(file);
                this.br = new BufferedReader(fr);
            } catch (FileNotFoundException e) {
                System.out.println("[Excepcion] No se pudo abrir el archivo para lectura");
            }

        }
    }
    public void abrirArchivoEscritura()
    {
        if(this.pw == null)
        {

            try {
                FileWriter fw = new FileWriter(this.file);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);
                this.pw = pw;
            } catch (IOException e) {
                System.out.println("[Excepcion] no se puede abrir archivo para escritura");
            }

        }
    }
    public void escribir(String data)
    {
        this.pw.write(data);
    }

    public void cerrarArchivo()
    {
        if(this.br != null)
        {
            try {
                this.br.close();
            } catch (IOException e) {
                System.out.println("[Exepcion] no se pudo cerrar el bufferRead");
            }
        }
        if(this.pw != null)
        {
            this.pw.close();
        }
    }
    public boolean yaExisteArchivo()
    {
       return this.file.exists();
    }

}
