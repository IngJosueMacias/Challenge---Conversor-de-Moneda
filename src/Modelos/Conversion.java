package Modelos;

import java.util.ArrayList;

public record Conversion(String result,
                         String time_next_update_utc,
                         String base_code,
                         String target_code,
                         double conversion_rate,
                         double conversion_result) {
    @Override
    public String toString() {
        double cantidad = conversion_result / conversion_rate;
        return "El resultado de la conversion de $"+cantidad+" "+base_code()+
        " a "+target_code()+" es: $"+conversion_result()+" con un tipo de cambio de "
                +conversion_rate();
    }
}