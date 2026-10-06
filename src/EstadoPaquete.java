public enum EstadoPaquete {
    
    RECIBIDO {
        @Override
        public boolean permiteTransicion(EstadoPaquete siguiente) {
            return siguiente == PREPARACION;
        }
    },
    
    PREPARACION {
        @Override
        public boolean permiteTransicion(EstadoPaquete siguiente) {
            return siguiente == DISTRIBUCION;
        }
    },
    
    DISTRIBUCION {
        @Override
        public boolean permiteTransicion(EstadoPaquete siguiente) {
            return siguiente == ENTREGADO;
        }
    },
    
    ENTREGADO {

        @Override
        public boolean permiteTransicion(EstadoPaquete siguiente) {
            return false;
        }
    };

    public abstract boolean permiteTransicion(EstadoPaquete siguiente);
}