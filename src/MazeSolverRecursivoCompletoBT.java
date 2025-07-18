import java.util.*;

public class MazeSolverRecursivoCompletoBT implements MazeSolver {
    private List<Cell> path;
    private Set<Cell> visited;
    private boolean[][] grid;
    private Cell end;

    public MazeSolverRecursivoCompletoBT() {
        path = new ArrayList<>();
        visited = new HashSet<>();
    }

    @Override
    public List<Cell> getPath(boolean[][] grid, Cell start, Cell end) {
        this.grid = grid;
        this.end = end;
        path.clear();
        visited.clear();

        if (findPath(start)) {
            return path;
        }
        return new ArrayList<>();
    }

    public Set<Cell> getVisitedCells() {
        return visited;
    }

    private boolean findPath(Cell current) {
        if (!isInMaze(current) || !isValid(current)) {
            return false;
        }

        path.add(current);
        visited.add(current);

        if (current.equals(end)) {
            return true;
        }

        // Buscar en las 4 direcciones
        if (findPath(new Cell(current.row, current.Col + 1)) ||  // Derecha
            findPath(new Cell(current.row + 1, current.Col)) ||  // Abajo
            findPath(new Cell(current.row, current.Col - 1)) ||  // Izquierda
            findPath(new Cell(current.row - 1, current.Col))) {  // Arriba
            return true;
        }

        // Retroceder
        path.remove(path.size() - 1);
        return false;
    }

    private boolean isValid(Cell current) {
        int row = current.row;
        int col = current.Col;

        return grid[row][col] && !visited.contains(current);
    }

    private boolean isInMaze(Cell current) {
        int row = current.row;
        int col = current.Col;
        return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length;
    }
}