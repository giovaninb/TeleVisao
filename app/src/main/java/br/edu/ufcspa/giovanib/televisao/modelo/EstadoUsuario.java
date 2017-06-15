package br.edu.ufcspa.giovanib.televisao.modelo;

/**
 * Created by gnbettoni on 29/05/17.
 */

public enum EstadoUsuario {
    ONLINE {
        @Override
        public String toString() {
            return "Online";
        }
    }, OCUPADO {
        @Override
        public String toString() { return "Ocupado"; }
    }, AUSENTE {
        @Override
        public String toString() {
            return "Ausente";
        }
    }, OFFLINE {
        @Override
        public String toString() {
            return "Offline";
        }
    };
}


