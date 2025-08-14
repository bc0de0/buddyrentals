package com.kunalgupte.buddyrental.entities;

import com.kunalgupte.buddyrental.entities.enums.Gender;
import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "buddies")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Buddy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDateTime dob;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Nonnull
    private String number;
    private String license;

    private Double hourlyRate;

    private Double rating;
    @OneToOne(mappedBy = "buddy")
    private Vehicle vehicle;
}
