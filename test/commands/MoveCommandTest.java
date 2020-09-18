package commands;

import com.rishabh.rover.MarsRover;
import com.rishabh.rover.commands.MoveCommand;
import com.rishabh.rover.universe.Coordinates;
import com.rishabh.rover.universe.Direction;
import com.rishabh.rover.universe.Plateau;
import org.junit.Assert;
import org.junit.Test;

public class MoveCommandTest {

    @Test
    public void testThatMoveCommandMovesTheNavigableObject() {
        //Given
        MoveCommand command = new MoveCommand();
        Plateau plateau = new Plateau(5,5);
        Coordinates startingPosition = new Coordinates(1,2);
        MarsRover rover = new MarsRover(plateau, Direction.N, startingPosition);

        //When
        command.execute(rover);

        //Then
        Assert.assertEquals("1 3 N", rover.currentLocation());
    }

}
