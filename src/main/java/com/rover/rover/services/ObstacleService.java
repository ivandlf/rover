package com.rover.rover.services;

import com.rover.rover.dto.ObstacleDto;
import com.rover.rover.dto.RoverDto;
import com.rover.rover.models.Obstacle;

import java.util.List;

public interface ObstacleService {
    public List<Obstacle> findAll();

    public void save(ObstacleDto obstacleDto);
}
