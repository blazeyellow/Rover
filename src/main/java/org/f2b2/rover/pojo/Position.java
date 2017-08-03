package org.f2b2.rover.pojo;

/**
 * @author Mark Curtis
 */
public class Position {

    protected COL column;
    protected ROW row;

    enum COL {
        A,B,C,D,E,F,G,H

    }

    enum ROW {
        R1,R2,R3,R4,R5,R6,R7,R8

    }

    protected Position() {}

    protected Position(COL col, ROW row) {
        this.column = col;
        this.row = row;

    }

    public static Position getPosition(COL column, ROW row) {
        return new Position(column, row);

    }

    public static Position getPosition(int column, int row) {
        return new Position(COL.values()[column], ROW.values()[row]);

    }


    public ROW getRow() {
        return row;
    }

    public COL getColumn() {
        return column;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position position = (Position) o;

        if (column != position.column) return false;
        return row == position.row;
    }

    @Override
    public int hashCode() {
        int result = column != null ? column.hashCode() : 0;
        result = 31 * result + (row != null ? row.hashCode() : 0);
        return result;
    }
}
