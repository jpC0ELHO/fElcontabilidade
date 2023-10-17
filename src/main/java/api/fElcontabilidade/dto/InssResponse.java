package api.fElcontabilidade.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.Set;
import java.util.UUID;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonPropertyOrder({"id","cpf","email","cliente","dataMarcad"
        ,"createdBy","lastModifiedBy","createdAt"
        ,"updateAt","cellphones","endereco"})
public record InssResponse(



) {

}
