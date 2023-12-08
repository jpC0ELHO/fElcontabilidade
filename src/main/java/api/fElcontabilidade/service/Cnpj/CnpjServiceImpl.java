package api.fElcontabilidade.service.Cnpj;

import api.fElcontabilidade.dto.CnpjRequest;
import api.fElcontabilidade.dto.CnpjResponse;
import api.fElcontabilidade.exceptions.CnpjNotFoundException;
import api.fElcontabilidade.exceptions.ModelNotFoundException;
import api.fElcontabilidade.repository.CnpjRepository;
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
public class CnpjServiceImpl implements CnpjService{
    private final CnpjRepository cnpjRepository;

    @Override
    public List<CnpjResponse> buscarListaCnpj() {
        try {
            var buscarTodosCnpj=cnpjRepository.findAll();
            log.info("Cnpjs encontrados: ");
            return buscarTodosCnpj.stream().map(CnpjResponse::toEntidade).toList();
        }catch (RuntimeException e){
            log.info(e);
        }finally {
            return new ArrayList<>();
        }
    }

    @Override
    public Optional<CnpjResponse> buscarCnpjId(UUID id) {
        var buscarCnpjId=cnpjRepository.findById(id);
        if(buscarCnpjId.isEmpty()){
            log.warn("Cnpj não encontrado: "+id);
            throw new ModelNotFoundException("Id cnpj não encontrado"+id);
        }
        log.info("Cnpj encontrado: "+id);
        return buscarCnpjId.map(CnpjResponse::toEntidade);
    }

    @Override
    public void createCnpj(CnpjRequest cnpjRequest) {
        var buscarCnpj=cnpjRepository.findEnterpriseByCnpj(cnpjRequest.numeroCnpj());
        if(buscarCnpj.isPresent()){
            log.info("Cnpj com o numero: "+cnpjRequest.numeroCnpj()+" já cadastrado!");
            throw new CnpjNotFoundException("Cnpj ja cadastrado!");
        }
        cnpjRepository.save(CnpjRequest.toEntidade(cnpjRequest));
        log.info("Cnpj cadastrado com sucesso! "+cnpjRequest.numeroCnpj());
    }

    @Override
    public void updateCnpj(UUID id, CnpjRequest cnpjRequest) {
        var buscarCnpj=cnpjRepository.findById(id);
        if (buscarCnpj.isEmpty()){
            log.warn("Cnpj não encontrado... Id:"+id);
            throw new CnpjNotFoundException("Cnpj não encontrado...");
        }
        buscarCnpj.map(entidade->{
            entidade.setType(cnpjRequest.tipo());
            entidade.setCnpjnumber(cnpjRequest.numeroCnpj());
            return cnpjRepository.save(entidade);
        });
        log.info("Cnpj atualizado com sucesso! Numero:"+cnpjRequest.numeroCnpj());
    }

    @Override
    public void deletCnpj(UUID id) {
        try{
            var buscarCnpj=cnpjRepository.findById(id)
                    .orElseThrow(()->new CnpjNotFoundException("Cnpj não encontrado..."));
            cnpjRepository.delete(buscarCnpj);
            log.info("Cnpj com o numero id: "+id+" deletado com sucesso!");
        }catch (RuntimeException e){
            log.warn("Error"+e);
        }

    }
}
