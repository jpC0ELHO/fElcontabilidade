package api.fElcontabilidade.repository;

import api.fElcontabilidade.model.InssModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  InssRepository extends JpaRepository<InssModel,Integer> {
    public boolean existsById(Integer id);
    public boolean existsByEmail(String email);
    public boolean existsByCpf(String cpf);


}
