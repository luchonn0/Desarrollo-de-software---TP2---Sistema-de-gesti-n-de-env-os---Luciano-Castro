public class EnvioEstandar extends Envio {
    public EnvioEstandar(int codigo, double costoBase, Cliente cliente) {
        super(codigo, costoBase, cliente);
    }

    @Override
    public double calcularCosto() {
        return costoBase;
    }
}