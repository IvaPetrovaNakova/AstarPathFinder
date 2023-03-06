package com.reachUp.AStar.project.controller.endpoint;

import com.fasterxml.jackson.annotation.JsonView;
import com.reachUp.AStar.project.entity.Path;
import com.reachUp.AStar.project.exception.HttpRequestException;
import com.reachUp.AStar.project.exception.HttpResponseException;
import com.reachUp.AStar.project.service.PathService;
import com.reachUp.AStar.project.JsonView.View;
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

    @GetMapping()
    public ResponseEntity<List<Path>> getAllPaths() {
        try {
            List<Path> paths = pathService.getAllPaths();
            return new ResponseEntity<List<Path>>(paths, HttpStatus.OK);
        } catch (HttpRequestException ex) {
            return new ResponseEntity<List<Path>>(HttpStatus.BAD_REQUEST);
        } catch (HttpResponseException ex) {
            return new ResponseEntity<List<Path>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Path> getPathById(@PathVariable("id") Long pathId) {
        try {
            Path path = pathService.getPathsById(pathId);
            return new ResponseEntity<Path>(path, HttpStatus.OK);
        } catch (HttpRequestException ex) {
            return new ResponseEntity<Path>(HttpStatus.NOT_FOUND);
        } catch (HttpResponseException ex) {
            return new ResponseEntity<Path>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping()
    public ResponseEntity<Path> addOrUpdate(@RequestBody @Valid Path path) {
        try {
            Path createdPath = pathService.addOrUpdatePath(path);
            return new ResponseEntity<Path>(createdPath, HttpStatus.OK);
        } catch (HttpRequestException ex) {
            return new ResponseEntity<Path>(HttpStatus.BAD_REQUEST);
        } catch (HttpResponseException ex) {
            return new ResponseEntity<Path>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePath(@PathVariable("id") Long pathId) {
        try {
            pathService.deletePath(pathId);
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        } catch (HttpRequestException ex) {
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        } catch (HttpResponseException ex) {
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/getDirectPaths/{city_from}")
    @JsonView(View.Base.class)
    public ResponseEntity<List<Path>> getDirectedPaths(@PathVariable("city_from") String cityFrom) {
        try {
            List<Path> directedPaths = pathService.getConnection(cityFrom);
            return new ResponseEntity<List<Path>>(directedPaths, HttpStatus.OK);
        } catch (HttpRequestException ex) {
            return new ResponseEntity<List<Path>>(HttpStatus.NOT_FOUND);
        } catch (HttpResponseException ex) {
            return new ResponseEntity<List<Path>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
