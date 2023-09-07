package com.brunosouza.cosmic.explorer.controller;

import com.brunosouza.cosmic.explorer.service.RobotService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/mars")
public class PlanetController {
    private final RobotService robotService;

    public PlanetController() {
        this.robotService = new RobotService();
    }

    @PostMapping
    public ResponseEntity<String> executeCommands(@RequestBody String commands) {
        try {
            String result = robotService.executeCommands(commands);
            return ResponseEntity.status(HttpStatus.CREATED).body(result);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}