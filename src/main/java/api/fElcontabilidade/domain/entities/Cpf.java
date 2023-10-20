package api.fElcontabilidade.domain.entities;

import api.fElcontabilidade.domain.entities.enums.ClienteType;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "tb_clientecpf")
@EntityListeners(AuditingEntityListener.class)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Cpf extends Entidade{

    @Enumerated
    @Column(nullable = false)
    private ClienteType type=ClienteType.PESSOAFISICA;


    @Column(nullable = false,unique = true,length = 11)
    private String cpfnumber;
    @Column(nullable = false,unique = true,length = 15)
    private String rgNumber;
}
