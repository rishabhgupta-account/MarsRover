package com.rishabh.rover;

import com.rishabh.rover.universe.Coordinates;
import com.rishabh.rover.universe.Direction;
import com.rishabh.rover.commands.ICommand;
import com.rishabh.rover.parser.StringCommandParser;
import com.rishabh.rover.universe.Plateau;

import java.util.List;

public class MarsRover {

    private Coordinates currentCoordinates;
    private Direction currentDirection;
    private Plateau plateau;


    public MarsRover(final Plateau plateau, final Direction direction, final Coordinates coordinates) {
        this.plateau = plateau;
        this.currentDirection = direction;
        this.currentCoordinates = coordinates;
    }


    //Composite Design Pattern
    public void run(final String commandString) {
        List<ICommand> roverCommands = new StringCommandParser(commandString).toCommands();
        for (ICommand command : roverCommands) {
            command.execute(this);
        }
    }

    public String currentLocation() {
        return currentCoordinates.toString() + " " + currentDirection.toString();
    }

    public void turnRight() {
        this.currentDirection = this.currentDirection.right();
    }

    public void turnLeft() {
        this.currentDirection = this.currentDirection.left();
    }

    public void move() {
        Coordinates positionAfterMove = currentCoordinates.newCoordinatesForStepSize(currentDirection.stepSizeForXAxis(), currentDirection.stepSizeForYAxis());

        //ignores the command if rover is being driven off plateau
        if(plateau.hasWithinBounds(positionAfterMove))
            currentCoordinates = currentCoordinates.newCoordinatesFor(currentDirection.stepSizeForXAxis(), currentDirection.stepSizeForYAxis());
    }
}
