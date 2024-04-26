package Acciones;

import Modelos.Conversion;
import com.google.gson.Gson;

import java.net.http.HttpResponse;

public class ObtenerConversion {
    public Conversion Obtener(String codigo_base, String codigo_objetivo, double cantidad) {
        String url = "https://v6.exchangerate-api.com/v6/ebc4ed21aa0bee0dae7893fe/pair/"+codigo_base+"/"+codigo_objetivo+"/"+cantidad;
        ObtenerJSON json = new ObtenerJSON();
        HttpResponse<String> respuesta = json.conexionJson(url);
        return new Gson().fromJson(respuesta.body(), Conversion.class);
    }
}
