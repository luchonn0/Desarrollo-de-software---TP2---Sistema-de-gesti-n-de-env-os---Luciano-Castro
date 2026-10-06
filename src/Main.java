import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Crear un cliente
        Cliente cliente = new Cliente("35123456", "Luciano Castro", "luciano@email.com");
        Sucursal sucursalCentral = new Sucursal("S1", "Sucursal Central", "Viedma");

        // Crear paquetes
        Paquete p1 = new Paquete(
                1,
                "Notebook",
                2.5,
                "Buenos Aires"
        );

        Paquete p2 = new Paquete(
                2,
                "Celular",
                1.0,
                "Córdoba"
        );

        Paquete p3 = new Paquete(
                3,
                "Monitor",
                5.0,
                "Mendoza"
        );

        // Crear envíos
        Envio envio1 = new EnvioEstandar(100, 5000, cliente);
        envio1.agregarPaquete(p1);

        Envio envio2 = new EnvioExpress(101, 5000, cliente);
        envio2.agregarPaquete(p2);

        Envio envio3 = new EnvioInternacional(102, 5000, cliente);
        envio3.agregarPaquete(p3);

        List<Envio> envios = new ArrayList<>();

        envios.add(envio1);
        envios.add(envio2);
        envios.add(envio3);


        for (Envio envio : envios) {

        
            sucursalCentral.recibirEnvio(envio, "Recepción inicial en sistema");
            
            
            // Calcular y mostrar el costo del envío
            System.out.println(
                "Costo calculado para Envío " + envio.codigo + ": $" +
                envio.calcularCosto()
            );
            
            sucursalCentral.despacharEnvio(envio, "Despacho hacia destino");

            envio.mostrarResumen();
            envio.mostrarHistorial();

            System.out.println("--------------------");
        }
        // Mostrar resumen general del cliente
        System.out.println("\nResumen general del cliente:");
        cliente.mostrarEnvios();
    }
}