package com.rover.rover.services;

import com.rover.rover.dto.RoverDto;
import com.rover.rover.models.Direction;
import com.rover.rover.models.Obstacle;
import com.rover.rover.models.Rover;
import com.rover.rover.repository.ObstacleRepository;
import com.rover.rover.repository.RoverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoverServiceImp implements RoverService{
    @Autowired
    private RoverRepository repository;

    @Autowired
    private ObstacleRepository obstacleRepository;
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

    @Override
    public Rover get() {
        List<Rover> roverList = repository.findAll();
        return roverList.get(0);
    }

    @Override
    public void sendCommand(String command) {
        Rover rover = get();

        switch (command){
            case "F": moveRover(rover, true); break;
            case "B": moveRover(rover, false); break;
            case "R": turnRover(rover, true); break;
            case "L": turnRover(rover, false); break;
        }
        repository.save(rover);
    }

    @Override
    public void save(RoverDto roverDto) {
        Rover rover = new Rover();
        rover.setY(roverDto.getY());
        rover.setX(roverDto.getX());
        rover.setDirection(roverDto.getDirection());
        repository.save(rover);
    }

    public void turnRover(Rover rover, boolean isRight){
        Direction direction = rover.getDirection();
        Direction finalDirection = null;

        if (isRight){
            switch (direction){
                case NORTH -> finalDirection = Direction.EAST;
                case EAST -> finalDirection = Direction.SOUTH;
                case SOUTH -> finalDirection = Direction.WEST;
                case WEST -> finalDirection = Direction.NORTH;
            }
        } else {
            switch (direction){
                case NORTH -> finalDirection = Direction.WEST;
                case WEST -> finalDirection = Direction.SOUTH;
                case SOUTH -> finalDirection = Direction.EAST;
                case EAST -> finalDirection = Direction.NORTH;
            }
        }
        rover.setDirection(finalDirection);
        System.out.println(rover.getDirection().toString());
    }

    public void moveRover(Rover rover, boolean isForward){
        int posYFinal = rover.getY();
        int posXFinal = rover.getX();

        Direction direction = rover.getDirection();
        if (Direction.EAST.equals(direction) || Direction.WEST.equals(direction)){
            posXFinal += isForward ? direction.getValue() : -direction.getValue();
        }

        if (Direction.NORTH.equals(direction) || Direction.SOUTH.equals(direction)){
            posYFinal -= isForward ? +direction.getValue() : -direction.getValue();
        }

        if (canMoveToThisPosition(posXFinal, posYFinal)) {
            rover.setX(posXFinal);
            rover.setY(posYFinal);
        }
        System.out.println(posXFinal+", "+posYFinal);
    }

    public boolean canMoveToThisPosition(int posXFinal, int posYFinal){
        List<Obstacle> obstacleList = obstacleRepository.findAll();
        for (Obstacle obstacle:obstacleList) {
            System.out.println("obstaculo:"+obstacle.getX()+","+obstacle.getY());
            if (obstacle.getX() == posXFinal && obstacle.getY() == posYFinal){
                return false;
            }
        }
        return true;
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
