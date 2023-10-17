package api.fElcontabilidade.domain.entities;

import api.fElcontabilidade.domain.entities.enums.CellphoneType;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_telefone")
@EntityListeners(AuditingEntityListener.class)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Cellphone extends Entidade{

    @Enumerated
    @Column(nullable = false)
    private CellphoneType type=CellphoneType.CELULAR;

    @Column(nullable = false,unique = true,length = 15)
    private String numero;

}
