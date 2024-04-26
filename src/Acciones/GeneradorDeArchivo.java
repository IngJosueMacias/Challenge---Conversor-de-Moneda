package Acciones;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class GeneradorDeArchivo {
    public void guardarJson(Object objetoGuardar, String nombre) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter escritura = new FileWriter(nombre+".json");
        escritura.write(gson.toJson(objetoGuardar));
        escritura.close();
    }
}
