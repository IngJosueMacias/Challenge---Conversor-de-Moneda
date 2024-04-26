package Acciones;

import Modelos.CodigoMoneda;
import com.google.gson.Gson;

import java.net.http.HttpResponse;

public class ObtenerCodigosMoneda {
    public CodigoMoneda Obtener() {
        String url = "https://v6.exchangerate-api.com/v6/ebc4ed21aa0bee0dae7893fe/codes";
        ObtenerJSON json = new ObtenerJSON();
        HttpResponse<String> respuesta = json.conexionJson(url);
        return new Gson().fromJson(respuesta.body(), CodigoMoneda.class);
    }
}
