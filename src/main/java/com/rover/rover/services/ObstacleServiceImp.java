package com.rover.rover.services;

import com.rover.rover.dto.ObstacleDto;
import com.rover.rover.dto.RoverDto;
import com.rover.rover.models.Obstacle;
import com.rover.rover.repository.ObstacleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObstacleServiceImp implements ObstacleService{

    @Autowired
    private ObstacleRepository obstacleRepository;

    @Override
    public List<Obstacle> findAll() {
        return obstacleRepository.findAll();
    }

    @Override
    public void save(ObstacleDto obstacleDto) {
        Obstacle obstacle = new Obstacle();
        obstacle.setY(obstacleDto.getY());
        obstacle.setX(obstacleDto.getX());
        obstacleRepository.save(obstacle);
    }
}
