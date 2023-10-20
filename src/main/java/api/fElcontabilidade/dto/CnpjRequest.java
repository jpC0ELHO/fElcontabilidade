package api.fElcontabilidade.dto;

import api.fElcontabilidade.domain.entities.Cnpj;
import api.fElcontabilidade.domain.entities.enums.ClienteType;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import org.hibernate.validator.constraints.br.CNPJ;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record CnpjRequest(
        @Enumerated(EnumType.STRING)
        ClienteType tipo,
        @CNPJ
        String numeroCnpj
) {
    public static Cnpj toEntidade(CnpjRequest cnpjRequest){
        if (cnpjRequest==null){
            return null;
        }return new Cnpj(cnpjRequest.tipo,cnpjRequest.numeroCnpj);
    }

}
