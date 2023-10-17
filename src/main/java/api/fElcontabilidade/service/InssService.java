package api.fElcontabilidade.service;

import api.fElcontabilidade.model.InssModel;
import api.fElcontabilidade.repository.InssRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Log4j2
public class InssService {


    private final InssService inssService;

    private final InssRepository inssRepository;

    public InssModel save(InssModel inssModel){



    return inssService.save(inssModel);
    }

    public boolean existsById(Integer id){return inssRepository.existsById(id);}
    public boolean existsByEmail(String email){return inssRepository.existsByEmail(email);}
    public boolean existsByCpf(String cpf){return inssRepository.existsByCpf(cpf);}

    public Optional<InssModel>findById(Integer id){return inssRepository.findById(id);}
    public void deletById(Integer id){inssRepository.deleteById(id);}
}