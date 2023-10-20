package api.fElcontabilidade.domain.entities.enums;

import lombok.Getter;

@Getter
public enum Sexo {
    MASCULINO("MASCULINO"),
    FEMININO("FEMININP"),
    OUTRO("OUTRO");
    private final String nome;

    Sexo(String nome){
        this.nome=nome;
    }
}
