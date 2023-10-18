package api.fElcontabilidade.dto;

import api.fElcontabilidade.domain.entities.Cellphone;
import api.fElcontabilidade.domain.entities.enums.CellphoneType;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record CellphoneRequest(
        @Enumerated(EnumType.STRING)
        CellphoneType tipo,
        String numero
) {
    public static Cellphone toEntidade(CellphoneRequest cellphoneRequest){
        if (cellphoneRequest==null){
            return null;
        }
        return new Cellphone(cellphoneRequest.tipo, cellphoneRequest.numero);
    }
}
