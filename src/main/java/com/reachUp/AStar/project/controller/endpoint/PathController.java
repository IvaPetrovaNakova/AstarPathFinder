package com.reachUp.AStar.project.controller.endpoint;

import com.reachUp.AStar.project.entity.City;
import com.reachUp.AStar.project.entity.Path;
import com.reachUp.AStar.project.service.PathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/paths")
public class PathController {
    private final PathService pathService;

    @Autowired
    public PathController(PathService pathService) {
        this.pathService = pathService;
    }

    @GetMapping("/allPaths")
    public ResponseEntity<List<Path>> getAllPaths() {
        List<Path> paths = null;
        try {
            paths = pathService.getAllPaths();
        } catch (Exception ex){
            ex.getMessage();
        }
        return new ResponseEntity<List<Path>>(paths, HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Path> getPathById(@PathVariable("id") Long pathId) {
        Path paths = null;
        try {
            paths = pathService.getPathsById(pathId);
        } catch (Exception ex){
            ex.getMessage();
        }
        return new ResponseEntity<Path> (paths, HttpStatus.OK);
    }

    @PostMapping("/addOrUpdate")
    public ResponseEntity<Path> addOrUpdate(@RequestBody @Valid Path path) {
        Path paths = null;
        try {
            paths = pathService.addOrUpdatePath(path);
        } catch (Exception ex){
            ex.getMessage();
        }
        return new ResponseEntity<Path> (paths, HttpStatus.OK);
    }

    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<Path> delete(@PathVariable("id") Long pathId) {
        Path paths = null;
        try {
            paths = pathService.deletePath(pathId);
        } catch (Exception ex){
            ex.getMessage();
        }
        return new ResponseEntity<Path> (paths, HttpStatus.OK);
    }

    @GetMapping("/getDirectPaths/{city_from}")
    public ResponseEntity<List<Path>> getChildren(@PathVariable("city_from") String cityFrom) {
        List<Path> paths = null;
        try {
            paths = pathService.getChildren(cityFrom);
        } catch (Exception ex){
            ex.getMessage();
        }
        return new ResponseEntity<List<Path>>(paths, HttpStatus.OK);
    }
}
