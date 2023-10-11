package com.rover.rover.controller;

import com.rover.rover.models.Obstacle;
import com.rover.rover.services.ObstacleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ObstacleController {

    @Autowired
    private ObstacleService obstacleService;

    @GetMapping("api/obtacle")
    public List<Obstacle> findAll(){
        return obstacleService.findAll();
    }
}
