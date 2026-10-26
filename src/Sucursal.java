public class Sucursal {
    private final String id;
    private final String nombre;
    private final String ciudad;

    public Sucursal(String id, String nombre, String ciudad) {
        this.id = id;
        this.nombre = nombre;
        this.ciudad = ciudad;
    }

    public void recibirEnvio(Envio envio) {
        if (envio == null) {
            throw new IllegalArgumentException("No se puede recibir un envío inexistente.");
        }
        envio.registrarMovimiento(TipoMovimiento.RECIBIDO, this);
    }

    public void despacharEnvio(Envio envio) {
        if (envio == null) {
            throw new IllegalArgumentException("No se puede despachar un envío inexistente.");
        }
        envio.registrarMovimiento(TipoMovimiento.DESPACHADO, this);
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public String getCiudad() { return ciudad; }
}