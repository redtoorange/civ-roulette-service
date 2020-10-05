package com.andrewmcguiness.civroulette.entity;

import com.andrewmcguiness.civroulette.domain.ChallengeDifficultyEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema = "civ", name = "challenge")
public class ChallengeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "enabled")
    private Boolean enabled;

    @Column(name = "created_date")
    private Instant createdDate;

    @Column(name = "difficulty", length = 16)
    @Enumerated(EnumType.STRING)
    private ChallengeDifficultyEnum difficulty;
}
