package api.fElcontabilidade.dto;

import api.fElcontabilidade.domain.entities.Cpf;
import api.fElcontabilidade.domain.entities.enums.ClienteType;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import org.hibernate.validator.constraints.br.CPF;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record CpfRequest(
        @Enumerated(EnumType.STRING)
        ClienteType tipo,
        String rgNumber,
        @CPF
        String numeroCpf
) {
    public static Cpf toEntidade(CpfRequest cpfRequest){
            if(cpfRequest==null){
                    return null;
            }
            return new Cpf(
                    cpfRequest.tipo,cpfRequest.numeroCpf,cpfRequest.rgNumber
            );
    }
}
