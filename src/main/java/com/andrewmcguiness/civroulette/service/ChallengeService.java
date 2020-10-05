package com.andrewmcguiness.civroulette.service;

import com.andrewmcguiness.civroulette.dto.ChallengeDto;
import com.andrewmcguiness.civroulette.entity.ChallengeEntity;

import java.util.List;

public interface ChallengeService {
    List<ChallengeDto> getAllChallenges();

    ChallengeDto createNewChallenge(ChallengeDto newDto);

    ChallengeDto getChallengeById(Long id);

    void delete(Long id);

    ChallengeDto updateChallenge(ChallengeDto challengeDto);

    ChallengeDto toDto(ChallengeEntity entity);

    ChallengeEntity toEntity(ChallengeDto dto);
}
