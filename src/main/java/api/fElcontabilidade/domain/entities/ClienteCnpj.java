package api.fElcontabilidade.domain.entities;

import api.fElcontabilidade.domain.entities.enums.ClienteType;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Data
@Table(name = "tb_clientecnpj")
@EntityListeners(AuditingEntityListener.class)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ClienteCnpj extends Entidade{
    @Enumerated
    @Column(nullable = false)
    private ClienteType type=ClienteType.PESSOAJURIDICA;

    @Column(nullable = false, unique = true,length = 14)
    private String cnpjnumber;

}
