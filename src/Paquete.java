public class Paquete {
    private final int id;
    private final String descripcion;
    private final double peso;
    private final String destino;
    private EstadoPaquete estado;

    public Paquete(int id, String descripcion, double peso, String destino) {
        this.id = id;
        this.descripcion = descripcion;
        this.peso = peso;
        this.destino = destino;
        this.estado = EstadoPaquete.RECIBIDO;
    }

    public int getId() { return id; }
    public String getDescripcion() { return descripcion; }
    public double getPeso() { return peso; }
    public String getDestino() { return destino; }
    public EstadoPaquete getEstado() { return estado; }

    private void cambiarEstado(EstadoPaquete nuevoEstado) {
        if (!this.estado.permiteTransicion(nuevoEstado)) {
            throw new IllegalStateException("Transición inválida: no se puede pasar de " + this.estado + " a " + nuevoEstado);
        }
        this.estado = nuevoEstado;
    }

    public void preparar() { cambiarEstado(EstadoPaquete.PREPARACION); }
    public void distribuir() { cambiarEstado(EstadoPaquete.DISTRIBUCION); }
    public void entregar() { cambiarEstado(EstadoPaquete.ENTREGADO); }

    public String obtenerInfoTexto() {
        return "Paquete " + id + " | " + descripcion + " | Destino: " + destino + " | Estado: " + estado;
    }
}