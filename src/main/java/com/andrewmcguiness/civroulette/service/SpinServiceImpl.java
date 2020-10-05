package com.andrewmcguiness.civroulette.service;

import com.andrewmcguiness.civroulette.dto.ChallengeDto;
import com.andrewmcguiness.civroulette.dto.SpinDto;
import com.andrewmcguiness.civroulette.entity.ChallengeEntity;
import com.andrewmcguiness.civroulette.entity.SpinEntity;
import com.andrewmcguiness.civroulette.repository.SpinRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SpinServiceImpl implements SpinService {
    private final ChallengeService challengeService;
    private final SpinRepository spinRepository;

    @Transactional
    @Override
    public SpinDto generateNewSpin(SpinDto spinDto) {
        List<ChallengeDto> challenges = challengeService.getAllChallenges();
        if (challenges.size() < 1) {
            throw new RuntimeException("There are no challenges");
        }
        Random rand = new Random(Instant.now().toEpochMilli());


        // TODO add difficulty logic
        Set<Integer> challengeInts = new HashSet<>();
        int iterations = 0;
        int maxIterations = 50;
        int totalDifficulty = 0;
        int maxDifficulty = 5;

        while (totalDifficulty < maxDifficulty && iterations < maxIterations) {
            iterations++;

            int j = rand.nextInt(challenges.size());
            while (challengeInts.contains(j)) {
                j = rand.nextInt(challenges.size());
            }

            ChallengeDto challenge = challenges.get(j);
            if (challenge.getDifficulty().getPoints() + totalDifficulty <= maxDifficulty) {
                totalDifficulty += challenge.getDifficulty().getPoints();
                challengeInts.add(j);
                spinDto.getChallenges().add(challenge);
            }
        }

        spinDto.setCreateDate(ZonedDateTime.now());

        SpinEntity saved = spinRepository.save(toEntity(spinDto));

        if (saved.getId() == null) {
            throw new RuntimeException("Failed to save spin");
        }

        return toDto(saved);
    }

    @Transactional(readOnly = true)
    @Override
    public List<SpinDto> getAllSpins() {
        return spinRepository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    @Override
    public SpinDto getSpinById(Long id) {
        SpinEntity entity = spinRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Could not find spin with id <" + id + ">."));

        return toDto(entity);
    }


    @Override
    public SpinDto toDto(SpinEntity entity) {
        Set<ChallengeDto> challenges = entity.getChallenges().stream()
                .map(challengeService::toDto)
                .collect(Collectors.toSet());

        return new SpinDto(
                entity.getId(),
                entity.getPlayerName(),
                challenges,
                entity.getCreateDate()
        );
    }

    @Override
    public SpinEntity toEntity(SpinDto dto) {
        Set<ChallengeEntity> challenges = dto.getChallenges().stream()
                .map(challengeService::toEntity)
                .collect(Collectors.toSet());

        return new SpinEntity(
                dto.getId(),
                dto.getPlayerName(),
                challenges,
                dto.getCreateDate()
        );
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        spinRepository.deleteById(id);
    }
}
