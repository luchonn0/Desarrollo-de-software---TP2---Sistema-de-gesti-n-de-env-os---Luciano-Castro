import java.time.LocalDateTime;

public class Movimiento {
    private LocalDateTime fechaHora;
    private String descripcion;
    private Sucursal sucursal;

    public Movimiento(String descripcion, Sucursal sucursal) {
        this.fechaHora = LocalDateTime.now();
        this.descripcion = descripcion;
        this.sucursal = sucursal;
    }

    public void mostrarMovimiento() {
        String nombreSucursal = (sucursal != null) ? sucursal.getNombre() : "Externa/Destino";
        System.out.println("[" + fechaHora + "] " + descripcion + " - Sucursal: " + nombreSucursal);
    }

    public String getDescripcion() {
        return descripcion;
    }
}