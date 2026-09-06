classDiagram
    class Cliente {
        - String dni
        - String nombre
        - String email
        - List~Envio~ envios
        + Cliente(String dni, String nombre, String email)
        + void agregarEnvio(Envio envio)
        + String getDni()
        + String getNombre()
        + List~Envio~ getEnvios()
        + void mostrarEnvios()
    }

    class Envio {
        # int codigo
        # double costoBase
        # List~Paquete~ paquetes
        # Cliente cliente
        # List~Movimiento~ historial
        + Envio(int codigo, double costoBase, Cliente cliente)
        + void agregarPaquete(Paquete paquete)
        + void registrarMovimiento(String desc, Sucursal sucursal)
        + void mostrarHistorial()
        + void mostrarResumen()
        + double calcularCosto()*
    }

    class EnvioEstandar {
        + EnvioEstandar(int codigo, double costoBase, Cliente cliente)
        + double calcularCosto()
    }

    class EnvioExpress {
        + EnvioExpress(int codigo, double costoBase, Cliente cliente)
        + double calcularCosto()
    }

    class EnvioInternacional {
        + EnvioInternacional(int codigo, double costoBase, Cliente cliente)
        + double calcularCosto()
    }

    class Paquete {
        - int id
        - String descripcion
        - double peso
        - String destino
        - EstadoPaquete estado
        + Paquete(int id, String descripcion, double peso, String destino)
        + Paquete(int id, String descripcion)
        + int getId()
        + double getPeso()
        + EstadoPaquete getEstado()
        + void preparar()
        + void distribuir()
        + void entregar()
        - boolean puedeSerEntregado()
        + void mostrarInfo()
    }

    class Sucursal {
        - String id
        - String nombre
        - String ciudad
        + Sucursal(String id, String nombre, String ciudad)
        + void recibirEnvio(Envio envio, String descripcionMovimiento)
        + void despacharEnvio(Envio envio, String descripcionMovimiento)
        + String getNombre()
    }

    class Movimiento {
        - LocalDateTime fechaHora
        - String descripcion
        - Sucursal sucursal
        + Movimiento(String descripcion, Sucursal sucursal)
        + void mostrarMovimiento()
        + String getDescripcion()
    }

    class EstadoPaquete {
        <<enumeration>>
        RECIBIDO
        PREPARACION
        DISTRIBUCION
        ENTREGADO
    }

    Cliente "1" --> "*" Envio : realiza
    Envio <|-- EnvioEstandar
    Envio <|-- EnvioExpress
    Envio <|-- EnvioInternacional
    Envio "1" *-- "*" Paquete : contiene
    Envio "1" *-- "*" Movimiento : historial
    Movimiento --> "0..1" Sucursal : ocurre en
    Paquete --> EstadoPaquete : tiene estado