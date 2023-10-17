package api.fElcontabilidade.domain.entities.enums;

import lombok.Getter;

@Getter
public enum CellphoneType {
    CELULAR("PESSOAL"),
    FIXO("RESIDENCIAL"),
    TRABALHO("COMERCIAL"),
    OUTRO("OUTRO");

    private final String nome;

    CellphoneType(String nome){
        this.nome=nome;
    }
}