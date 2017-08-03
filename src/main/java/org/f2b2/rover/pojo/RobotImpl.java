package org.f2b2.rover.pojo;

/**
 * @author Mark Curtis
 */
public class RobotImpl implements Robot {

    protected Board board;

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Position getBoardPosition() {

        if (board==null) {
            return null;

        }

        return board.getPosition(this);

    }
}
