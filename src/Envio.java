import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class Envio {

    protected int codigo;
    protected double costoBase;
    protected List<Paquete> paquetes;
    protected Cliente cliente;
    protected List<Movimiento> historial;

    public Envio(int codigo, double costoBase, Cliente cliente) {
        this.codigo = codigo;
        this.costoBase = costoBase;
        this.paquetes = new ArrayList<>();
        this.cliente = cliente;
        this.historial = new ArrayList<>();
        
        Optional.ofNullable(cliente).ifPresent(c -> c.agregarEnvio(this));
    }

    public void agregarPaquete(Paquete paquete) {
        if (paquetes.size() >= 3) {
            throw new IllegalArgumentException("Un envío no puede tener más de 3 paquetes[cite: 1].");
        }
        Optional.ofNullable(paquete).ifPresent(paquetes::add);
    }

    public void registrarMovimiento(TipoMovimiento tipo, Sucursal sucursal) {
        historial.add(new Movimiento(tipo, sucursal));
    }

    // Método para filtrar movimientos por tipo sin usar cadenas de texto (ideal para decisiones de negocio)
    public List<Movimiento> filtrarMovimientosPorTipo(TipoMovimiento tipo) {
        return historial.stream()
                .filter(m -> m.getTipo() == tipo)
                .collect(Collectors.toList());
    }

    public Movimiento obtenerUltimoMovimiento() {
        return historial.stream()
                .reduce((primer, segundo) -> segundo)
                .orElse(null);
    }

    public List<Movimiento> getHistorial() {
        return historial;
    }

    public void mostrarHistorial() {
        System.out.println("Historial del Envío " + codigo + ":");
        historial.forEach(Movimiento::mostrarMovimiento);
    }

    public void mostrarResumen() {
        String nombreCliente = Optional.ofNullable(cliente)
                .map(Cliente::getNombre)
                .orElse("Sin cliente");

        System.out.println(
            "Código: " + codigo +
            " | Cliente: " + nombreCliente +
            " | Costo: $" + calcularCosto()
        );

        paquetes.forEach(Paquete::mostrarInfo);
    }

    public abstract double calcularCosto();
}