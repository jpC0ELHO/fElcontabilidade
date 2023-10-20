package api.fElcontabilidade.domain.entities;

import api.fElcontabilidade.domain.entities.enums.Sexo;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Set;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@Table(name = "tb_cliente")
@EqualsAndHashCode(callSuper = true)
public class Cliente extends Entidade{

    @Column(nullable = false,unique = true,length = 15)
    private String cpf;
    @Column(nullable = false,unique = true,length = 100)
    private String primeiroNome;
    @Column(nullable = false,unique = true,length = 100)
    private String sobreNome;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false,unique = false,length = 20)
    private Sexo sexo=Sexo.OUTRO;
    @ElementCollection
    @CollectionTable(name = "tb_cliente_email",joinColumns = @JoinColumn(name = "cliente_cpf",referencedColumnName = "cpf"))
    @Column(name = "emails",nullable = false)
    private Set<String>email;
    @OneToMany(cascade = {CascadeType.ALL},fetch = FetchType.LAZY)
    @Column(nullable = false)
    @JoinColumn(name = "cliente_cpf",referencedColumnName = "cpf")
    private Set<String>Telefone;
    @Column(nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    @Embedded
    private Endereco endereco;




}
