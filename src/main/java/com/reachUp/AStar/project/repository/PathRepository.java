package com.reachUp.AStar.project.repository;

import com.reachUp.AStar.project.entity.Path;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PathRepository extends JpaRepository<Path, Long> {

    //TODO - native query getChildren();
}
