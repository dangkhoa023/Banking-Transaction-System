package com.hdbank.bankingcommon.event;
import com.hdbank.bankingcommon.domain.converter.ObjectConverter;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Entity
@Getter
@Setter
@NoArgsConstructor
public abstract class Event {
    @Id
    @GeneratedValue
    private Long eventId;

    private EventType eventType;

    @JdbcTypeCode(SqlTypes.JSON)
    @Convert(converter = ObjectConverter.class)
    private Object payload;

    public Event(EventType eventType, Object payload) {
        this.eventType = eventType;
        this.payload = payload;
    }
}
