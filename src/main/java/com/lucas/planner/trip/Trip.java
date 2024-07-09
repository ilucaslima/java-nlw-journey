package com.lucas.planner.trip;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

//
// @Entity informa que a classe representa uma entidade
// Uma entidade é uma classe que representa uma tabela em um banco de dados relacional
//

@Entity
@Table(name = "trips")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Trip {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(nullable = false)
    private String destination;

    @Column(name = "starts_at", nullable = false)
    private LocalDateTime startAt;

    @Column(name = "ends_at", nullable = false)
    private LocalDateTime endsAt;

    @Column(name = "is_confirmed", nullable = false)
    private Boolean isConfirmed;

    @Column(name = "owner_name", nullable = false)
    private String ownerName;

    @Column(name = "owner_email", nullable = false)
    private String ownerEmail;

    public Trip(TripRequestPayload data){
        this.destination = data.destination();
        this.isConfirmed = false;
        this.ownerEmail = data.owner_email();
        this.ownerName = data.owner_name();
        this.startAt = LocalDateTime.parse(data.starts_at(), DateTimeFormatter.ISO_DATE_TIME);
        this.endsAt = LocalDateTime.parse(data.starts_at(), DateTimeFormatter.ISO_DATE_TIME);
    }
}
