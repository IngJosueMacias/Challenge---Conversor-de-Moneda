package Modelos;

import java.util.Map;

public record Moneda(String result,
                     String time_last_update_utc,
                     String time_next_update_utc,
                     String base_code,
                     Map<String, Double> conversion_rates) {

}
