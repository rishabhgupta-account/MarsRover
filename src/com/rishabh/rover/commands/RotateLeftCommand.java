package com.rishabh.rover.commands;

import com.rishabh.rover.MarsRover;

public class RotateLeftCommand implements ICommand {

    @Override
    public void execute(final MarsRover rover) {
        rover.turnLeft();
    }

}
