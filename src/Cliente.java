import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String dni;
    private String nombre;
    private String email;
    private List<Envio> envios;

    public Cliente(String dni, String nombre, String email) {
        this.dni = dni;
        this.nombre = nombre;
        this.email = email;
        this.envios = new ArrayList<>();
    }

    public void agregarEnvio(Envio envio) {
        if (envio != null && !envios.contains(envio)) {
            envios.add(envio);
        }
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Envio> getEnvios() {
        return envios;
    }

    public void mostrarEnvios() {
        System.out.println("Envíos del cliente " + nombre + ":");
        for (Envio e : envios) {
            e.mostrarResumen();
        }
    }
}