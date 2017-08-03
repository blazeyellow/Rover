package org.f2b2.rover.pojo;

import org.f2b2.rover.exceptions.OutOfBoundsException;
import org.f2b2.rover.exceptions.PositionTakenException;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Mark Curtis
 */
public class BoardImplTest {

    @Test
    public void getPosition() throws Exception {

        Board board = new BoardImpl();
        Robot robot = new RobotImpl();

        Position actualPosition = Position.getPosition(Position.COL.A, Position.ROW.R1);
        board.add(robot, actualPosition);

        Position expectedPosition = board.getPosition(robot);

        assertEquals(expectedPosition, actualPosition);

    }

    @Test
    public void add() throws Exception {

        Board board = new BoardImpl();
        Robot robot = new RobotImpl();

        Position position = Position.getPosition(Position.COL.A, Position.ROW.R1);
        board.add(robot, position);

        assertNotNull(board.getPosition(robot));


    }

    @Test
    public void remove() throws Exception {

        Board board = new BoardImpl();
        Robot robot = new RobotImpl();

        Position position = Position.getPosition(Position.COL.A, Position.ROW.R1);
        board.add(robot, position);

        board.remove(robot);

        assertNull(board.getPosition(robot));

    }

    @Test
    public void move() throws Exception {

        Board board = new BoardImpl();
        Robot robot = new RobotImpl();

        Position position = Position.getPosition(Position.COL.A, Position.ROW.R1);
        board.add(robot, position);

        board.move(robot, Direction.DOWN);

        Position expectedPosition = Position.getPosition(Position.COL.A, Position.ROW.R2);
        assertEquals(board.getPosition(robot), expectedPosition);

    }

    @Test(expected = OutOfBoundsException.class)
    public void move_OutOfBoundsException() throws Exception {

        Board board = new BoardImpl();
        Robot robot = new RobotImpl();

        Position position = Position.getPosition(Position.COL.A, Position.ROW.R1);
        board.add(robot, position);

        board.move(robot, Direction.UP);


    }

    @Test(expected = PositionTakenException.class)
    public void move_PositionTakenException() throws Exception {

        Board board = new BoardImpl();
        Robot robot1 = new RobotImpl();
        Robot robot2 = new RobotImpl();

        Position position1 = Position.getPosition(Position.COL.A, Position.ROW.R1);
        Position position2 = Position.getPosition(Position.COL.A, Position.ROW.R2);
        board.add(robot1, position1);
        board.add(robot2, position2);

        board.move(robot2, Direction.UP);


    }

    @Test(expected = PositionTakenException.class)
    public void add_PositionTakenException() throws Exception {
        Board board = new BoardImpl();
        Robot robot1 = new RobotImpl();
        Robot robot2 = new RobotImpl();

        Position position1 = Position.getPosition(Position.COL.A, Position.ROW.R1);
        Position position2 = Position.getPosition(Position.COL.A, Position.ROW.R1);
        board.add(robot1, position1);
        board.add(robot2, position2);

    }
}