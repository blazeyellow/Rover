package org.f2b2.rover.pojo;

import org.f2b2.rover.exceptions.OutOfBoundsException;
import org.f2b2.rover.exceptions.PositionTakenException;

/**
 * @author Mark Curtis
 */
public interface Board {

    Position getPosition(Robot robot);

    void add(Robot robot, Position position) throws PositionTakenException;

    void remove(Robot robot);

    Position move(Robot robot, Direction direction) throws OutOfBoundsException, PositionTakenException;

}
