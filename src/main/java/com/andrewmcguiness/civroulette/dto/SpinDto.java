package com.andrewmcguiness.civroulette.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpinDto {
    private Long id;

    private String playerName;
    private Set<ChallengeDto> challenges = new HashSet<>();
    private ZonedDateTime createDate;
}
