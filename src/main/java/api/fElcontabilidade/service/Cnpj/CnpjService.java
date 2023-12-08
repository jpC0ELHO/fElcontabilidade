package api.fElcontabilidade.service.Cnpj;

import api.fElcontabilidade.dto.CnpjRequest;
import api.fElcontabilidade.dto.CnpjResponse;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CnpjService {
    List<CnpjResponse> buscarListaCnpj();
    Optional<CnpjResponse>buscarCnpjId(UUID id);
    void createCnpj(CnpjRequest cnpjRequest);
    void updateCnpj(UUID id,CnpjRequest cnpjRequest);
    void deletCnpj(UUID id);
}
