import java.util.Objects;

public class Cell {
    public int row;
    public int Col;

    public Cell(int row, int Col) {
        this.row = row;
        this.Col = Col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return Col;
    }

    public void setCol(int Col) {
        this.Col = Col;
    }

    @Override
    public String toString() {
        return "(" + row + "," + Col + ")";
    }

    // ✅ Necesario para usar en Set o Map
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Cell)) return false;
        Cell other = (Cell) obj;
        return this.row == other.row && this.Col == other.Col;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, Col);
    }
}
