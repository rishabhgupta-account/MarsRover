package commands;

import com.rishabh.rover.MarsRover;
import com.rishabh.rover.commands.RotateLeftCommand;
import com.rishabh.rover.universe.Coordinates;
import com.rishabh.rover.universe.Direction;
import com.rishabh.rover.universe.Plateau;
import org.junit.Assert;
import org.junit.Test;

public class RotateLeftCommandTest {

    @Test
    public void testThatRotateLeftCommandRotatesTheNavigableObjectLeft() {
        //Given
        RotateLeftCommand command = new RotateLeftCommand();
        Plateau plateau = new Plateau(5,5);
        Coordinates startingPosition = new Coordinates(1,2);
        MarsRover rover = new MarsRover(plateau, Direction.N, startingPosition);

        //When
        command.execute(rover);

        //Then
        Assert.assertEquals("1 2 W", rover.currentLocation());
    }

}
