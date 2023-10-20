package api.fElcontabilidade.repository;

import api.fElcontabilidade.domain.entities.Cellphone;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;
import java.util.UUID;


public interface CellphoneRepository extends JpaRepository<Cellphone, UUID> {
    Optional<Cellphone>findCellphoneByNumber(String id);
}
