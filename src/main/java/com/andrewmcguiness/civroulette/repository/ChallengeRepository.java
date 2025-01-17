package com.andrewmcguiness.civroulette.repository;

import com.andrewmcguiness.civroulette.entity.ChallengeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChallengeRepository extends JpaRepository<ChallengeEntity, Long> {
}
