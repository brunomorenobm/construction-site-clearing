package com.oracle.construction.aconex.planing.domain.simulation.map;

public class Coordinate {
    public final int column;
    public final int row;

    public Coordinate(final int column, final int row) {
        this.column = column;
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coordinate)) return false;

        Coordinate that = (Coordinate) o;

        if (column != that.column) return false;
        return row == that.row;
    }

    @Override
    public int hashCode() {
        int result = column;
        result = 31 * result + row;
        return result;
    }

    @Override
    public String toString() {
        return "Coordinate{" +
                "column=" + column +
                ", row=" + row +
                '}';
    }


}