package com.hdbank.bankingcommon.event;
import com.hdbank.bankingcommon.domain.converter.ObjectConverter;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcType;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "events")
public abstract class Event {
    @Id
    @GeneratedValue
    private Long eventId;

    @Enumerated(EnumType.STRING)
    private EventType eventType;

    @JdbcTypeCode(SqlTypes.JSON)
    @Convert(converter = ObjectConverter.class)
    private Object payload;

    @CreationTimestamp
    private LocalDateTime timestamp;

    public Event(EventType eventType, Object payload) {
        this.eventType = eventType;
        this.payload = payload;
    }
}
