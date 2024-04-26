package Acciones;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class GuardarHistorial {
    public ArrayList<String> historial=new ArrayList<String>();
    public void guardarEventos(String evento){
        SimpleDateFormat formateador = new SimpleDateFormat("dd'/'MM'/'yyyy HH:mm:ss", new Locale("es_ES"));
        Date fechaDate = new Date();
        String fecha = formateador.format(fechaDate);

        historial.add(fecha+"\t"+evento);
    }
}
