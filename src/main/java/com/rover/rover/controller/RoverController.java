package com.rover.rover.controller;

import com.rover.rover.dto.CommandDto;
import com.rover.rover.dto.RoverDto;
import com.rover.rover.models.Rover;
import com.rover.rover.services.RoverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class RoverController {
    @Autowired
    private RoverService roverService;

    @GetMapping("/api/rover")
    public Rover findAll(){
        return roverService.getAllRover();
    }

    @GetMapping("/api/rover/{id}")
    public RoverDto findById(Long id){
        return roverService.findById(id);
    }

    @PostMapping("api/rover")
    public ResponseEntity<String> save(@RequestBody RoverDto roverDto){
        roverService.save(roverDto);
        return ResponseEntity.ok("rover creado con exito");
    }
    @PostMapping("api/rover/command")
    public void sendCommand(@RequestBody CommandDto commands){
        for (String command:commands.getCommands()) {
            roverService.sendCommand(command);
        }
    }
}
