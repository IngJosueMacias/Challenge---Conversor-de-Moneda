package Modelos;

import java.util.Map;

public record CodigoMoneda(String result,
                           Map<String, String> supported_codes) {
}
