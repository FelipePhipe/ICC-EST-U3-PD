import java.util.List;
import java.util.Set;

public class Maze {
    private boolean[][] grid;

    public Maze(boolean[][] grid) {
        this.grid = grid;
    }

    public boolean[][] getGrid() {
        return grid;
    }

    public void printMaze() {
        for (boolean[] row : grid) {
            for (boolean cell : row) {
                System.out.print(cell ? "- " : "* ");
            }
            System.out.println();
        }
    }

    public void printMazeWithPath(List<Cell> path) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                Cell current = new Cell(i, j);
                if (path.contains(current)) {
                    System.out.print("> ");
                } else {
                    System.out.print(grid[i][j] ? "- " : "* ");
                }
            }
            System.out.println();
        }
    }

    public void printMazeWithVisits(Set<Cell> visited) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                Cell current = new Cell(i, j);
                if (visited.contains(current)) {
                    System.out.print("> ");
                } else {
                    System.out.print(grid[i][j] ? "- " : "* ");
                }
            }
            System.out.println();
        }
    }
}