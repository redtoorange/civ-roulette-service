package com.andrewmcguiness.civroulette.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(schema = "civ", name = "spin")
public class SpinEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "player_name")
    private String playerName;

    @ManyToMany
    @JoinTable(
            name = "spin_challenge",
            joinColumns = {@JoinColumn(name = "spin_id")},
            inverseJoinColumns = {@JoinColumn(name = "challenge_id")}
    )
    private Set<ChallengeEntity> challenges;

    @Column(name = "create_date")
    private ZonedDateTime createDate;
}
