import java.util.HashSet;
import java.util.Set;

public class Cliente {
    private final String dni;
    private final String nombre;
    private final String email;
    private final Set<Envio> envios;

    public Cliente(String dni, String nombre, String email) {
        this.dni = dni;
        this.nombre = nombre;
        this.email = email;
        this.envios = new HashSet<>();
    }

    public void agregarEnvio(Envio envio) {
        if (envio != null) {
            envios.add(envio);
        }
    }

    public String getDni() { return dni; }
    public String getNombre() { return nombre; }
    public String getEmail() { return email; }

    public Set<Envio> getEnvios() {
        return new HashSet<>(envios);
    }

    public void mostrarEnvios() {
        System.out.println("Envíos del cliente " + nombre + " (" + email + "):");
        for (Envio envio : envios) {
            System.out.println(" - Código de envío: " + envio.getCodigo() + " | Costo: $" + envio.calcularCosto());
        }
    }
}