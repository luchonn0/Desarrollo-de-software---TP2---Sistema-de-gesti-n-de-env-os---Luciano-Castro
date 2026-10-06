public class Sucursal {
    private String id;
    private String nombre;
    private String ciudad;

    public Sucursal(String id, String nombre, String ciudad) {
        this.id = id;
        this.nombre = nombre;
        this.ciudad = ciudad;
    }

    public void recibirEnvio(Envio envio) {
        envio.registrarMovimiento(TipoMovimiento.RECIBIDO, this);
        System.out.println("Sucursal " + nombre + " recibió el envío.");
    }

    public void despacharEnvio(Envio envio) {
        envio.registrarMovimiento(TipoMovimiento.DESPACHADO, this);
        System.out.println("Sucursal " + nombre + " despachó el envío.");
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCiudad() {
        return ciudad;
    }
}