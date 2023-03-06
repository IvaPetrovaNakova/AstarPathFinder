package com.reachUp.AStar.project.repository;

import com.reachUp.AStar.project.entity.Path;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PathRepository extends JpaRepository<Path, Long> {

    //TODO - native query getDirectPaths();
    @Query(value = "SELECT * from path_state where city_from = :city_from", nativeQuery = true)
    public List<Path> getDirectPaths(@Param("city_from") String children);
}
