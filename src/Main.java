public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("35123456", "Luciano Castro", "luciano@email.com");
        Sucursal sucursalCentral = new Sucursal("S1", "Sucursal Central", "Viedma");
        Sucursal sucursalDestino = new Sucursal("S2", "Sucursal Destino", "Bahía Blanca");

        Paquete p1 = new Paquete(1, "Notebook Gamer", 2.5, "Buenos Aires");

        Envio envio1 = new EnvioEstandar(100, 5000, cliente);
        envio1.agregarPaquete(p1);

        // Prueba de funcionamiento normal y consultas desde App
        sucursalCentral.recibirEnvio(envio1);
        sucursalCentral.despacharEnvio(envio1);
        sucursalDestino.recibirEnvio(envio1);

        System.out.println("--- HISTORIAL DE MOVIMIENTOS ---");
        for (Movimiento m : envio1.getHistorial()) {
            System.out.println(m.obtenerDetalle());
        }

        System.out.println("\n--- SUCURSALES RECORRIDAS ---");
        for (Sucursal s : envio1.obtenerSucursalesRecorridas()) {
            System.out.println("- " + s.getNombre() + " (" + s.getCiudad() + ")");
        }

        System.out.println("\n--- ÚLTIMO MOVIMIENTO ---");
        System.out.println(envio1.obtenerUltimoMovimiento().obtenerDetalle());

        // Prueba de manejo de excepciones solicitadas por el profesor
        System.out.println("\n--- PRUEBA DE EXCEPCIONES ---");
        try {
            Envio envioInvalido = new EnvioExpress(102, 3000, cliente);
            // Intentar registrar movimiento sin paquetes (debe lanzar excepción)
            sucursalCentral.recibirEnvio(envioInvalido);
        } catch (Exception e) {
            System.out.println("Excepción capturada correctamente: " + e.getMessage());
        }
    }
}