package com.andrewmcguiness.civroulette.service;

import com.andrewmcguiness.civroulette.dto.ChallengeDto;
import com.andrewmcguiness.civroulette.entity.ChallengeEntity;
import com.andrewmcguiness.civroulette.repository.ChallengeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ChallengeServiceImpl implements ChallengeService {
    private final ChallengeRepository challengeRepository;

    @Transactional(readOnly = true)
    @Override
    public ChallengeDto getChallengeById(Long id) {
        ChallengeEntity entity = challengeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Failed to find Challenge with id <" + id + ">."));
        return toDto(entity);
    }

    @Transactional(readOnly = true)
    @Override
    public List<ChallengeDto> getAllChallenges() {
        return challengeRepository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public ChallengeDto createNewChallenge(ChallengeDto newDto) {
        ChallengeEntity saved = save(newDto);

        if (saved.getId() == null) {
            throw new RuntimeException("Failed to save Challenge");
        }

        return toDto(saved);
    }

    protected ChallengeEntity save(ChallengeDto dto) {
        return saveEntity(toEntity(dto));
    }

    protected ChallengeEntity saveEntity(ChallengeEntity entity) {
        return challengeRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        challengeRepository.deleteById(id);
    }

    @Override
    public ChallengeDto updateChallenge(ChallengeDto challengeDto) {
        ChallengeEntity saved = save(challengeDto);

        if (saved.getId() == null) {
            throw new RuntimeException("Failed to save Challenge");
        }

        return toDto(saved);
    }

    @Override
    public ChallengeEntity toEntity(ChallengeDto dto) {
        return new ChallengeEntity(
                dto.getId(),
                dto.getName(),
                dto.getDescription(),
                dto.getEnabled(),
                dto.getCreatedDate(),
                dto.getDifficulty()
        );
    }

    @Override
    public ChallengeDto toDto(ChallengeEntity entity) {
        return new ChallengeDto(
                entity.getId(),
                entity.getName(),
                entity.getDescription(),
                entity.getEnabled(),
                entity.getCreatedDate(),
                entity.getDifficulty()
        );
    }
}
