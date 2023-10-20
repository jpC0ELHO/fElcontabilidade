package api.fElcontabilidade.domain.entities;

import api.fElcontabilidade.domain.entities.enums.Br_States;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Embeddable
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Endereco {
    @Column(nullable = false,unique = false,length = 100)
    private String logradouro;
    @Column(nullable = false,unique = false,length = 10)
    private String numero;
    @Column(nullable = false,unique = false,length = 100)
    private String complemento;
    @Column(nullable = false,unique = false,length = 100)
    private String bairro;
    @Column(nullable = false,unique = false,length = 100)
    private String cidade;
    @Column(nullable = false,unique = false,length = 20)
    private Br_States estado;

    @NotNull
    @NotBlank
    @Column(nullable = false,unique = false,length = 10)
    @Pattern(regexp = "\\d{5}-\\d{3}",message = "o cep deve ter o formato de '12345-678'")
    private String cep;
}
