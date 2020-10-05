package com.andrewmcguiness.civroulette.repository;

import com.andrewmcguiness.civroulette.entity.SpinEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpinRepository extends JpaRepository<SpinEntity, Long> {
}
