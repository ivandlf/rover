package com.rover.rover.services;

import com.rover.rover.dto.RoverDto;
import com.rover.rover.models.Rover;
import com.rover.rover.repository.RoverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoverServiceImp implements RoverService{
    @Autowired
    private RoverRepository repository;
    @Override
    public Rover getAllRover() {
        List<Rover> roverList = repository.findAll();
        return roverList.get(0);
    }

    @Override
    public RoverDto findById(Long id) {
        return entityToDto(repository.findById(id).get());
    }

    @Override
    public void createRover(RoverDto roverDto) {
        repository.save(dtoToEntity(roverDto));
    }

    public Rover dtoToEntity(RoverDto roverDto){
        Rover rover = new Rover();
        rover.setDirection(roverDto.getDirection());
        rover.setX(roverDto.getX());
        rover.setY(roverDto.getY());
        return rover;
    }

    public RoverDto entityToDto(Rover rover){
        RoverDto roverDto = new RoverDto();
        roverDto.setId(rover.getId());
        roverDto.setDirection(rover.getDirection());
        roverDto.setX(rover.getX());
        roverDto.setY(rover.getY());
        return roverDto;
    }
}
