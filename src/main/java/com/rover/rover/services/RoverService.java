package com.rover.rover.services;

import com.rover.rover.dto.RoverDto;
import com.rover.rover.models.Rover;

public interface RoverService {
    public Rover getAllRover();
    public RoverDto findById(Long id);
    public void createRover(RoverDto roverDto);
}
