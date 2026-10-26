import java.util.ArrayList;
import java.util.List;
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
        
        if (cliente != null) {
            cliente.agregarEnvio(this);
        }
    }

    public int getCodigo() {
        return codigo;
    }

    public void agregarPaquete(Paquete paquete) {
        if (paquete == null) {
            throw new IllegalArgumentException("El paquete no puede ser nulo.");
        }
        if (!hayLugar()) {
            throw new IllegalStateException("Un envío no puede tener más de 3 paquetes.");
        }
        paquetes.add(paquete);
    }

    private boolean hayLugar() {
        return paquetes.size() < 3;
    }

    private boolean tienePaquetes() {
        return !paquetes.isEmpty();
    }

    public void registrarMovimiento(TipoMovimiento tipo, Sucursal sucursal) {
        if (!tienePaquetes()) {
            throw new IllegalStateException("No se puede registrar un movimiento en un envío sin paquetes.");
        }
        
        if (tipo == TipoMovimiento.ENTREGADO && !estaDespachado()) {
            throw new IllegalStateException("Intentar entregar un paquete que todavía no fue despachado.");
        }

        historial.add(new Movimiento(tipo, sucursal));
    }

    private boolean estaDespachado() {
        return historial.stream().anyMatch(m -> m.getTipo() == TipoMovimiento.DESPACHADO);
    }

    public List<Sucursal> obtenerSucursalesRecorridas() {
        return historial.stream()
                .map(Movimiento::getSucursal)
                .distinct()
                .collect(Collectors.toList());
    }

    public Movimiento obtenerUltimoMovimiento() {
        if (historial.isEmpty()) {
            throw new IllegalStateException("El envío no registra movimientos en su historial.");
        }
        return historial.get(historial.size() - 1);
    }

    public List<Movimiento> getHistorial() {
        return new ArrayList<>(historial);
    }

    public List<Paquete> getPaquetes() {
        return new ArrayList<>(paquetes);
    }

    public abstract double calcularCosto();
}