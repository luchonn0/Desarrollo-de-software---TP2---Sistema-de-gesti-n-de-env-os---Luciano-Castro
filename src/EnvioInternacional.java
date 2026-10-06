public class EnvioInternacional extends Envio {
    public EnvioInternacional(int codigo, double costoBase, Cliente cliente) {
        super(codigo, costoBase, cliente);
    }

    @Override
    public double calcularCosto() {
        return costoBase * 2;
    }
}