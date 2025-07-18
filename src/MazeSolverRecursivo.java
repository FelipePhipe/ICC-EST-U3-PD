import java.util.ArrayList;
import java.util.List;

public class MazeSolverRecursivo implements MazeSolver {

    @Override
    public List<Cell> getPath(boolean[][] grid, Cell start, Cell end) {
        List<Cell> path = new ArrayList<>();

        if (grid == null || grid.length == 0) {
            return path;
        }

        boolean[][] visited = new boolean[grid.length][grid[0].length];

        if (findPath(grid, start, end, path, visited)) {
            return path;
        }

        return new ArrayList<>(); // No se encontró camino
    }

    private boolean findPath(boolean[][] grid, Cell current, Cell end, List<Cell> path, boolean[][] visited) {
        int row = current.row;
        int col = current.Col;

        // Validación de límites
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
            return false;
        }

        // Si no es transitable o ya visitado
        if (!grid[row][col] || visited[row][col]) {
            return false;
        }

        // Marcar como visitado
        visited[row][col] = true;

        // Si es el destino, agregar y retornar true
        if (row == end.row && col == end.Col) {
            path.add(current);
            return true;
        }

        // Explorar solo derecha y abajo
        if (findPath(grid, new Cell(row + 1, col), end, path, visited) ||
            findPath(grid, new Cell(row, col + 1), end, path, visited)) {

            path.add(current); // Solo se agrega si se encontró un camino válido
            return true;
        }

        return false;
    }
}
