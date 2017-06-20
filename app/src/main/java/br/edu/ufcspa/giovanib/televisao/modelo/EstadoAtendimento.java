package br.edu.ufcspa.giovanib.televisao.modelo;

/**
 * Created by gnbettoni on 29/05/17.
 */

public enum EstadoAtendimento {
    DISPONIVEL{
        @Override
        public String toString() {
            return "Disponível";
        }
    }, FAZENDO{
        @Override
        public String toString() {
            return "Fazendo";
        }
    }, FINALIZADO{
        @Override
        public String toString() {
            return "Finalizado";
        }
    };
}
