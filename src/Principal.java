
import Acciones.GuardarHistorial;
import Acciones.ObtenerCodigosMoneda;
import Acciones.ObtenerConversion;
import Modelos.CodigoMoneda;
import Modelos.Conversion;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        GuardarHistorial guardar = new GuardarHistorial();
        Scanner lectura = new Scanner(System.in);
        int opcion = 0;
        String base="", target="";
        double rate=0.0, result=0.0, cantidad=-1;

        System.out.println("\nBienvenido a nuestro sistema de conversion de monedas.");
        guardar.guardarEventos("Inicio de aplicacion.");
        while(opcion!=5){
            System.out.println("""
                    \nPor favor, elija una de las siguientes opciones:
                    1.  Lista de codigos de monedas basicas.
                    2.  Lista de todas los codigos de monedas soportadas.
                    3.  Realizar una conversion.
                    4.  Revisar el historial de actividades.
                    5.  Salir.
                    """);
            opcion = Integer.parseInt(lectura.nextLine());
            switch (opcion){
                case 1:
                    System.out.println("""
                    \nLista de codigos de moendas basicas:
                    \nARS - Peso argentino
                    BOB - Boliviano boliviano
                    BRL - Real brasileño    
                    CLP - Peso chileno
                    COP - Peso colombiano
                    USD - Dólar estadounidense
                            """);

                    guardar.guardarEventos("Consulta de codigos de monedas basicas.");
                    break;
                case 2:
                    ObtenerCodigosMoneda codigos = new ObtenerCodigosMoneda();

                    CodigoMoneda cod = codigos.Obtener();
                    System.out.println("\nLista de todos los codigos de monedas soportadas:");

                    cod.supported_codes().forEach((k,v) -> System.out.println(k+" - "+v));

                    guardar.guardarEventos("Consulta de todos los codigos de monedas soportados.");
                    break;
                case 3:
                    cantidad=-1;
                    System.out.println("Por favor ingrese el codigo de moneda inicial.");
                    base=lectura.nextLine();
                    System.out.println("Por favor ingrese el codigo de moneda objetivo.");
                    target=lectura.nextLine();
                    while(cantidad<0){
                        System.out.println("Por favor ingrese la cantidad a convertir.(No puede ser un numero " +
                                "negativo)");
                        cantidad = Double.parseDouble(lectura.nextLine());
                    }

                    ObtenerConversion conversion = new ObtenerConversion();

                    Conversion conv=conversion.Obtener(base,target,cantidad);

                    if(!conv.result().equals("error")){
                        System.out.println(conv);
                        guardar.guardarEventos(conv+"");
                    } else {
                        System.out.println("La conversion no pudo realizarse de forma exitosa, " +
                                "por favor revise la informacion ingresada.");
                        guardar.guardarEventos("La conversion de $"+cantidad+" "+conv.base_code()+" a "
                                +conv.target_code()+" no se pudo realizar.");
                    }
                    break;
                case 4:
                    System.out.println("\nLog de actividades realizadas en la aplicacion.");
                    guardar.guardarEventos("Impresion de log.");
                    for(int i = 0; i<guardar.historial.size(); i++){
                        System.out.println(guardar.historial.get(i));
                    }
                    break;
            }
        }
        System.out.println("Gracias por utilizar nuestro sistema de conversion.");
    }
}
