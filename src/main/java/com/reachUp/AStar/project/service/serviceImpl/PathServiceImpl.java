package com.reachUp.AStar.project.service.serviceImpl;

import com.reachUp.AStar.project.entity.Path;
import com.reachUp.AStar.project.repository.PathRepository;
import com.reachUp.AStar.project.service.PathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PathServiceImpl implements PathService {

    private final PathRepository pathRepository;

    @Autowired
    public PathServiceImpl(PathRepository pathRepository) {
        this.pathRepository = pathRepository;
    }

    @Override
    public List<Path> getAllPaths() {
        return pathRepository.findAll();
    }

    @Override
    public Path getPathsById(Long pathId) {
        return pathRepository.findById(pathId).orElse(null);
    }

    @Override
    public Path addOrUpdatePath(Path path) {
        return pathRepository.save(path);
    }

    @Override
    public Path deletePath(Long pathId) throws Exception {
        Path deletePath = null;
        try{
            deletePath = pathRepository.findById(pathId).orElse(null);
            if (deletePath == null) {
                throw new Exception("There is no direct path in the map");
            } else {
                pathRepository.deleteById(pathId);
            }
        } catch (Exception ex) {
            throw ex;
        }
        return deletePath;
    }
}
