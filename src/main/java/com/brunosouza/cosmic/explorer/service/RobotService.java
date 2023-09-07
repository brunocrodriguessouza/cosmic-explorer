package com.brunosouza.cosmic.explorer.service;

import com.brunosouza.cosmic.explorer.model.Robot;

public class RobotService {
    private Robot robot;

    public RobotService() {
        this.robot = new Robot();
    }

    public String executeCommands(String commands) {
        return robot.executeCommands(commands);
    }
}
