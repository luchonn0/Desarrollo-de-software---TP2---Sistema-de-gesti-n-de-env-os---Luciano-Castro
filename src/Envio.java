import java.util.ArrayList;
import java.util.List;

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

    public void agregarPaquete(Paquete paquete) {
        if (paquetes.size() >= 3) {
            throw new IllegalArgumentException("Un envío no puede tener más de 3 paquetes");
        }
        paquetes.add(paquete);
    }

    public void registrarMovimiento(String desc, Sucursal sucursal) {
        historial.add(new Movimiento(desc, sucursal));
    }

    public void mostrarHistorial() {
        System.out.println("Historial del Envío " + codigo + ":");
        for (Movimiento m : historial) {
            m.mostrarMovimiento();
        }
    }

    public void mostrarResumen() {
        System.out.println(
            "Código: " + codigo +
            " | Cliente: " + (cliente != null ? cliente.getNombre() : "Sin cliente") +
            " | Costo: $" + calcularCosto()
        );

        for (Paquete p : paquetes) {
            p.mostrarInfo();
        }
    }

    public abstract double calcularCosto();
}