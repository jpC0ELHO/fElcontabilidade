package api.fElcontabilidade.repository;

import api.fElcontabilidade.domain.entities.Cnpj;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;
import java.util.UUID;

public interface CnpjRepository extends JpaRepository<Cnpj, UUID> {
    Optional<Cnpj>findEnterpriseByCnpj(String id);
}
