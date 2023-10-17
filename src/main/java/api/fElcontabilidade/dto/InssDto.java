package api.fElcontabilidade.dto;

import jakarta.persistence.Column;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Valid
@Getter
@Setter
@RequiredArgsConstructor
public class InssDto {
    @NotNull
    private Integer id;
    @NotBlank
    private String nome;
    @NotBlank
    private String cpf;
    @NotBlank
    private String email;
    @NotNull
    private Double Salario;
}
