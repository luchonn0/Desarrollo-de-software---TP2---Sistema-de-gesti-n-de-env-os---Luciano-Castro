public class EnvioExpress extends Envio {
    public EnvioExpress(int codigo, double costoBase, Cliente cliente) {
        super(codigo, costoBase, cliente);
    }

    @Override
    public double calcularCosto() {
        return costoBase * 1.5;
    }
}