import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class Cliente {
    private String dni;
    private String nombre;
    private String email;
    private Set<Envio> envios;

    public Cliente(String dni, String nombre, String email) {
        this.dni = dni;
        this.nombre = nombre;
        this.email = email;
        this.envios = new HashSet<>();
    }

    public void agregarEnvio(Envio envio) {
        Optional.ofNullable(envio).ifPresent(envios::add);
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public Set<Envio> getEnvios() {
        return envios;
    }

    public void mostrarEnvios() {
        System.out.println("Envíos del cliente " + nombre + " (" + email + "):");
        envios.forEach(Envio::mostrarResumen);
    }
}