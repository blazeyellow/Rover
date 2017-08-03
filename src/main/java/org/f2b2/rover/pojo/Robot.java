package org.f2b2.rover.pojo;

/**
 * @author Mark Curtis
 */
public interface Robot {

    Board getBoard();
    void setBoard(Board board);
    Position getBoardPosition();
}
