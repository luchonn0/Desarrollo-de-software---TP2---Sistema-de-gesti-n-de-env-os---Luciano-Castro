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

    public String getDestino() {
        return destino;
    }

    public EstadoPaquete getEstado() {
        return estado;
    }

    private void cambiarEstado(EstadoPaquete nuevoEstado) {
        boolean transicionValida = this.estado.permiteTransicion(nuevoEstado);
        if (!transicionValida) {
            throw new IllegalStateException("Transición inválida: no se puede pasar de " + this.estado + " a " + nuevoEstado);
        }
        this.estado = nuevoEstado;
    }

    public void preparar() {
        cambiarEstado(EstadoPaquete.PREPARACION);
    }

    public void distribuir() {
        cambiarEstado(EstadoPaquete.DISTRIBUCION);
    }

    public void entregar() {
        cambiarEstado(EstadoPaquete.ENTREGADO);
    }

    public void mostrarInfo() {
        System.out.println(
            "Paquete " + id +
            " | " + descripcion +
            " | Destino: " + destino +
            " | Estado: " + estado
        );
    }
}