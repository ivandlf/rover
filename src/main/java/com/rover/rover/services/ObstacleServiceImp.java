package com.rover.rover.services;

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
}
