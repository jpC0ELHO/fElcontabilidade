package api.fElcontabilidade.service.cellphone;

import api.fElcontabilidade.dto.CellphoneRequest;
import api.fElcontabilidade.dto.CellphoneResponse;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CellphoneService {
    List<CellphoneResponse>buscarListaTelefones();
    Optional<CellphoneResponse>buscarTelefoneId(UUID id);
    void createCellphone(CellphoneRequest cellphoneRequest);
    void updateCellphone(UUID id, CellphoneRequest cellphoneRequest);
    void deletCellphone(UUID id);

}
