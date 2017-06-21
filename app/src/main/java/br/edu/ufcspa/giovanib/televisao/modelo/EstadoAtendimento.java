package br.edu.ufcspa.giovanib.televisao.modelo;

/**
 * Created by gnbettoni on 29/05/17.
 */

public enum EstadoAtendimento {
    DISPONIVEL{
        @Override
        // Disponivel
        public String toString() {
            return "P";
        }
    }, FAZENDO{
        @Override
        // Em atendimento
        public String toString() {
            return "A";
        }
    }, FINALIZADO{
        @Override
        // Finalizado
        public String toString() {
            return "F";
        }
    };
}
