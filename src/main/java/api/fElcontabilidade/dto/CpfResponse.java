package api.fElcontabilidade.dto;

import api.fElcontabilidade.domain.entities.Cpf;
import api.fElcontabilidade.domain.entities.enums.ClienteType;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.UUID;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record CpfResponse(
        UUID id,
        @Enumerated(EnumType.STRING)
        ClienteType clienteType,
        @CPF
        String numeroCpf,
        String rgNumber,
        String createdBy,
        String lastModifiedBy,
        @JsonSerialize(using = JsonSerializer.class)
        @JsonDeserialize(using = JsonDeserializer.class)
        @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
        @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy HH:mm:ss")
        LocalDateTime createdAt,
        @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
        @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy HH:mm:ss")
        @JsonDeserialize(using = JsonDeserializer.class)
        @JsonSerialize(using = JsonSerializer.class)
        @LastModifiedDate@Column(name = "updated_at")
        LocalDateTime updatedAt
) {
        public static CpfResponse toEntitade(Cpf cpf){
                if(cpf==null){
                        return null;
                }return new CpfResponse(
                        cpf.getId(),
                        cpf.getType(),
                        cpf.getCpfnumber(),
                        cpf.getCreatedBy(),
                        cpf.getLastModifiedBy(),
                        cpf.getRgNumber(),
                        cpf.getCreatedAt(),
                        cpf.getUpdatedAt()
                );
        }
}
