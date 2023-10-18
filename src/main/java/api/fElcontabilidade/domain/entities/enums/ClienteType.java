package api.fElcontabilidade.domain.entities.enums;

import lombok.Getter;

@Getter
public enum ClienteType {

    PESSOAFISICA("CPF"),
    PESSOAJURIDICA("CNPJ"),
    OUTRO("OUTRO");

    private final String nome;

    ClienteType(String nome){
        this.nome=nome;
    }

}
