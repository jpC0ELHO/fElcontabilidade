package api.fElcontabilidade.repository;

import api.fElcontabilidade.domain.entities.Cnpj;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface CnpjRepository extends JpaRepository<Cnpj, UUID> {
    Optional<Cnpj>findEnterpriseByCnpj(String id);
}
