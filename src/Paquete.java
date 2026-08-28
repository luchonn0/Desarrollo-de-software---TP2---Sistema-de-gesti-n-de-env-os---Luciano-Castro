public class Paquete {

    private int id;
    private String descripcion;
    private double peso;
    private String destino;
    private EstadoPaquete estado;

 
    public Paquete(int id, String descripcion, double peso, String destino) {
        this.id = id;
        this.descripcion = descripcion;
        this.peso = peso;
        this.destino = destino;
        this.estado = EstadoPaquete.RECIBIDO;
    }


    public Paquete(int id, String descripcion) {
        this(id, descripcion, 0, "Sin destino");
    }

    public int getId() {
        return id;
    }

    public double getPeso() {
        return peso;
    }

    public EstadoPaquete getEstado() {
        return estado;
    }

    public void preparar() {
        if (estado == EstadoPaquete.RECIBIDO) {
            estado = EstadoPaquete.PREPARACION;
        }
    }

    public void distribuir() {
        if (estado == EstadoPaquete.PREPARACION) {
            estado = EstadoPaquete.DISTRIBUCION;
        }
    }

    public void entregar() {
        if (!puedeSerEntregado()) {
            throw new IllegalStateException("El paquete no puede ser entregado si no está en distribución.");
        }
        this.estado = EstadoPaquete.ENTREGADO;
    }

    private boolean puedeSerEntregado() {
        return this.estado == EstadoPaquete.DISTRIBUCION;
    }

    public void mostrarInfo() {
        System.out.println(
            "Paquete " + id +
            " | " + descripcion +
            " | Estado: " + estado
        );
    }
}