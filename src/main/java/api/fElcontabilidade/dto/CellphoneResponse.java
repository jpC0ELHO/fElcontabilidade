package api.fElcontabilidade.dto;

import api.fElcontabilidade.domain.entities.Cellphone;
import api.fElcontabilidade.domain.entities.enums.CellphoneType;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.UUID;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record CellphoneResponse(
        UUID id,
        @Enumerated(EnumType.STRING)
        CellphoneType cellphoneType,
        String numero,
        String createdBy,
        String lastModifiedBy,
        @JsonDeserialize(using = LocalDateDeserializer.class)
        @JsonSerialize(using = LocalDateTimeSerializer.class)
        @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
        @JsonFormat(shape = JsonFormat.Shape.STRING,pattern ="dd/MM/yyyy HH:mm:ss" )
        LocalDateTime createdAt,
        @LastModifiedDate@Column(name = "updated_at")
        @JsonDeserialize(using = LocalDateDeserializer.class)
        @JsonSerialize(using = LocalDateTimeSerializer.class)
        @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
        @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy HH:mm:ss")
        LocalDateTime updatedAt
) {

    public static CellphoneResponse toResponse(Cellphone cellphone){
        if (cellphone==null){
            return null;
        }
        return new CellphoneResponse(
                cellphone.getId(),
                cellphone.getType(),
                cellphone.getNumero(),
                cellphone.getCreatedBy(),
                cellphone.getLastModifiedBy(),
                cellphone.getCreatedAt(),
                cellphone.getUpdatedAt()
        );
    }

}
