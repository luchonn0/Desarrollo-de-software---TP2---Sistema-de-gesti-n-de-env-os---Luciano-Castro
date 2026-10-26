import java.time.LocalDateTime;

public class Movimiento {
    private LocalDateTime fechaHora;
    private TipoMovimiento tipo;
    private Sucursal sucursal;

    public Movimiento(TipoMovimiento tipo, Sucursal sucursal) {
        if (sucursal == null) {
            throw new IllegalArgumentException("El movimiento debe estar asociado a una sucursal válida.");
        }
        this.fechaHora = LocalDateTime.now();
        this.tipo = tipo;
        this.sucursal = sucursal;
    }

    public TipoMovimiento getTipo() { return tipo; }
    public Sucursal getSucursal() { return sucursal; }
    public LocalDateTime getFechaHora() { return fechaHora; }
    
    public String obtenerDetalle() {
        return "[" + fechaHora + "] Evento: " + tipo + " - Sucursal: " + sucursal.getNombre();
    }
}