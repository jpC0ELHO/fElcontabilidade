package api.fElcontabilidade.service.cellphone;

import api.fElcontabilidade.dto.CellphoneRequest;
import api.fElcontabilidade.dto.CellphoneResponse;
import api.fElcontabilidade.exceptions.CellphoneNotFoundException;
import api.fElcontabilidade.exceptions.ModelNotFoundException;
import api.fElcontabilidade.repository.CellphoneRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
@RequiredArgsConstructor
@Log4j2
public class CellphoneServiceImpl implements CellphoneService{

    private final CellphoneRepository cellphoneRepository;


    @Override
    public List<CellphoneResponse> buscarListaTelefones() {
        try{
            var buscarTodosTelefones=cellphoneRepository.findAll();
            log.info("Todos os telefones encontrados: ");
            return buscarTodosTelefones.stream().map(CellphoneResponse::toResponse).toList();
        }catch (RuntimeException e){
            log.info("Error: "+e);
        }finally {
            return new ArrayList<>();
        }
    }

    @Override
    public Optional<CellphoneResponse> buscarTelefoneId(UUID id) {
        var buscarTelefoneId=cellphoneRepository.findById(id);
        if (buscarTelefoneId.isEmpty()) {
            log.warn("Telefone não encontrado, numero id: "+id);
            throw new ModelNotFoundException("id não encontrado...");
        }
        log.info("Telefone encontrado! id: "+id);
        return buscarTelefoneId.map(CellphoneResponse::toResponse);
    }

    @Override
    public void createCellphone(CellphoneRequest cellphoneRequest) {
            var buscarTelefone=cellphoneRepository.findCellphoneByNumber(cellphoneRequest.numero());
            if(buscarTelefone.isPresent()){
                log.warn("Telefone com id: "+cellphoneRequest.numero()+" já cadastrado.");
                throw new CellphoneNotFoundException("Telefone ja cadastrado!");
            }
            cellphoneRepository.save(CellphoneRequest.toEntidade(cellphoneRequest));
            log.info("Telefone cadastrado com exito! "+cellphoneRequest.numero());
    }

    @Override
    public void updateCellphone(UUID id, CellphoneRequest cellphoneRequest) {
            var buscarTelefone=cellphoneRepository.findById(id);
            if (buscarTelefone.isEmpty()){
                log.warn("Telefone não encontrado. ID: "+id);
                throw new CellphoneNotFoundException("Telefone não encontrado...");
            }
            buscarTelefone.map(entidade->{
                entidade.setType(cellphoneRequest.tipo());
                entidade.setNumero(cellphoneRequest.numero());
                return cellphoneRepository.save(entidade);
            });
            log.info("Telefone atualizado com sucesso. Numero: "+cellphoneRequest.numero());
    }

    @Override
    public void deletCellphone(UUID id) {
        try {
            var buscarTelefone=cellphoneRepository.
                    findById(id).orElseThrow(()-> new CellphoneNotFoundException("Telefone não encontrado!"));
            cellphoneRepository.delete(buscarTelefone);
            log.info("Telefone com id: "+id+" deletado.");
        }catch (RuntimeException e){
            log.warn("Error: "+e);
        }
    }
}
