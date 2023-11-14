package com.rover.rover.controller;

import com.rover.rover.dto.ObstacleDto;
import com.rover.rover.models.Obstacle;
import com.rover.rover.services.ObstacleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ObstacleController {

    @Autowired
    private ObstacleService obstacleService;

    @GetMapping("api/obstacle")
    public List<Obstacle> findAll(){
        return obstacleService.findAll();
    }

    @PostMapping("api/obstacle")
    public ResponseEntity<String> save(@RequestBody ObstacleDto obstacleDto){
        obstacleService.save(obstacleDto);
        return ResponseEntity.ok("obstaculo creado con exito");
    }
}
