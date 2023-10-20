package api.fElcontabilidade.repository;

import api.fElcontabilidade.domain.entities.Cellphone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CellphoneRepository extends JpaRepository<Cellphone, UUID> {
    Optional<Cellphone>findCellphoneByNumber(String id);
}
