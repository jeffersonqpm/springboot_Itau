package desafio.itau.springboot.dto;

import java.time.OffsetDateTime;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class TransactionRequest {

    @NotNull // NÃO RECEBE VALORES NULNULL
    @Min(0) // NÃO PODE RECEBER VALOR ZERO
    private Double valor;

    @NotNull // NÃO RECEBE VALORES NULNULL
    private OffsetDateTime dataHora;

    public Double getValor() {
        return valor;
    }

    public OffsetDateTime getDataHora() {
        return dataHora;
    }

    

}
