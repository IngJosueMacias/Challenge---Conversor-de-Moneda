package Acciones;

import Modelos.Moneda;
import com.google.gson.Gson;

import java.net.http.HttpResponse;

public class ObtenerMoneda {
    public Moneda Obtener(String codigo) {
        String url = "https://v6.exchangerate-api.com/v6/ebc4ed21aa0bee0dae7893fe/latest/"+codigo;
        ObtenerJSON json = new ObtenerJSON();
        HttpResponse<String> respuesta = json.conexionJson(url);
        return new Gson().fromJson(respuesta.body(), Moneda.class);
    }
}
