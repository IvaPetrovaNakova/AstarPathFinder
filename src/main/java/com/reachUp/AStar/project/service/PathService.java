package com.reachUp.AStar.project.service;

import com.reachUp.AStar.project.entity.Path;

import java.util.List;


public interface PathService {

public List<Path> getAllPaths();
public Path getPathsById(Long pathId);
public Path addOrUpdatePath(Path path);
public Path deletePath(Long pathId) throws Exception;

//this method is calling from crud repository using query annotation
    public List<Path> getChildren(String cityFrom);
}
