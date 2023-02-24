package com.reachUp.AStar.project.repository;

import com.reachUp.AStar.project.entity.CityState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityStateRepository extends JpaRepository<CityState, Long> {
}
