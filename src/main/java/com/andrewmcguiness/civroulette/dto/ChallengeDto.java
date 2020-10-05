package com.andrewmcguiness.civroulette.dto;

import com.andrewmcguiness.civroulette.domain.ChallengeDifficultyEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChallengeDto {
    private Long id;
    private String name;
    private String description;
    private Boolean enabled;
    private Instant createdDate;
    private ChallengeDifficultyEnum difficulty;
}
