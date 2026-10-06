import java.time.LocalDateTime;
import java.util.Optional;

public class Movimiento {
    private LocalDateTime fechaHora;
    private TipoMovimiento tipo;
    private Sucursal sucursal;

    public Movimiento(TipoMovimiento tipo, Sucursal sucursal) {
        this.fechaHora = LocalDateTime.now();
        this.tipo = tipo;
        this.sucursal = Optional.ofNullable(sucursal)
                .orElse(new Sucursal("EXT", "Externa/Destino", "N/A"));
    }

    public void mostrarMovimiento() {
        System.out.println("[" + fechaHora + "] Evento: " + tipo + " - Sucursal: " + sucursal.getNombre());
    }

    public TipoMovimiento getTipo() {
        return tipo;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }
}