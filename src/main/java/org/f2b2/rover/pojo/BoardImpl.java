package org.f2b2.rover.pojo;

import org.f2b2.rover.exceptions.OutOfBoundsException;
import org.f2b2.rover.exceptions.PositionTakenException;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Mark Curtis
 */
public class BoardImpl implements Board {

    protected Map<Position, Robot> robots = new HashMap<Position, Robot>();

    /**
     *
     * get the position of the given robot
     *
     * @param robot
     * @return
     */
    public Position getPosition(Robot robot) {

        for (Position position : robots.keySet()) {
            if (robot.equals(robots.get(position))) {
                return position;

            }
        }

        return null;

    }

    /**
     *
     * add a robot to the board at the given position
     *
     * @param robot
     * @param position
     */
    public void add(Robot robot, Position position) throws PositionTakenException {

        if (robots.containsKey(position)) {
            throw new PositionTakenException("Adding to an already occupied position");

        }

        robot.setBoard(this);
        robots.put(position, robot);

    }

    /**
     *
     * remove given robot
     *
     * @param robot
     */
    public void remove(Robot robot) {

        for (Position position : robots.keySet()) {
            if (robot.equals(robots.get(position))) {
                robots.remove(position);
                break;

            }
        }

    }

    /**
     *
     * move the robot on the board, checking for out-of-bounds positions and occupied positions
     *
     * @param robot
     * @param direction
     * @return
     */
    public Position move(Robot robot, Direction direction) throws OutOfBoundsException, PositionTakenException {

        Position currentPosition = robot.getBoardPosition();

        if (isMoveOutOfBounds(currentPosition, direction)) {
            throw new OutOfBoundsException("Position is out of bounds");

        }

        if (direction == Direction.UP) {

            Position newPosition = Position.getPosition(currentPosition.getColumn().ordinal(), (currentPosition.getRow().ordinal()-1));

            if (robots.containsKey(newPosition)) {
                throw new PositionTakenException("Position is already taken");

            }

            robots.remove(currentPosition);
            robots.put(newPosition, robot);

            return newPosition;

        }

        if (direction == Direction.DOWN) {

            Position newPosition = Position.getPosition(currentPosition.getColumn().ordinal(), (currentPosition.getRow().ordinal()+1));

            if (robots.containsKey(newPosition)) {
                throw new PositionTakenException("Position is already taken");

            }

            robots.remove(currentPosition);
            robots.put(newPosition, robot);

            return newPosition;

        }

        if (direction == Direction.LEFT) {

            Position newPosition = Position.getPosition(currentPosition.getColumn().ordinal()-1, (currentPosition.getRow().ordinal()));

            if (robots.containsKey(newPosition)) {
                throw new PositionTakenException("Position is already taken");

            }

            robots.remove(currentPosition);
            robots.put(newPosition, robot);

            return newPosition;

        }

        if (direction == Direction.RIGHT) {

            Position newPosition = Position.getPosition(currentPosition.getColumn().ordinal()+1, (currentPosition.getRow().ordinal()));

            if (robots.containsKey(newPosition)) {
                throw new PositionTakenException("Position is already taken");

            }

            robots.remove(currentPosition);
            robots.put(newPosition, robot);

            return newPosition;

        }

        return currentPosition;

    }

    /**
     *
     * check if the move direction is outside the bounds of the board
     *
     * @param position
     * @param direction
     * @return
     */
    private boolean isMoveOutOfBounds(Position position, Direction direction) {

        if (position.getRow().ordinal()==0 & direction == Direction.UP ||
            position.getRow().ordinal()==7 & direction == Direction.DOWN ||
            position.getColumn().ordinal()==0 & direction == Direction.LEFT ||
            position.getColumn().ordinal()==7 & direction == Direction.RIGHT) {

            return true;

        }

        return false;

    }

}
