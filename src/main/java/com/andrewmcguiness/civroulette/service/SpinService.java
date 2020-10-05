package com.andrewmcguiness.civroulette.service;

import com.andrewmcguiness.civroulette.dto.SpinDto;
import com.andrewmcguiness.civroulette.entity.SpinEntity;

import java.util.List;

public interface SpinService {
    SpinDto generateNewSpin(SpinDto spinDto);

    List<SpinDto> getAllSpins();

    SpinDto getSpinById(Long id);

    SpinDto toDto(SpinEntity entity);

    SpinEntity toEntity(SpinDto dto);

    void deleteById(Long id);
}
