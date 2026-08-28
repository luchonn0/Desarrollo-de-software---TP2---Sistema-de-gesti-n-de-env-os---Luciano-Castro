public class Sucursal {
    private String id;
    private String nombre;
    private String ciudad;

    public Sucursal(String id, String nombre, String ciudad) {
        this.id = id;
        this.nombre = nombre;
        this.ciudad = ciudad;
    }

    public void recibirEnvio(Envio envio, String descripcionMovimiento) {
        
        envio.registrarMovimiento(descripcionMovimiento, this);
        System.out.println("Sucursal " + nombre + " recibió el envío.");
    }

    public void despacharEnvio(Envio envio, String descripcionMovimiento) {
        envio.registrarMovimiento(descripcionMovimiento, this);
        System.out.println("Sucursal " + nombre + " despachó el envío.");
    }

    public String getNombre() {
        return nombre;
    }
}