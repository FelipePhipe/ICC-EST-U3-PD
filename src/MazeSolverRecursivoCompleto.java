import java.util.ArrayList;
import java.util.List;

public class MazeSolverRecursivoCompleto implements MazeSolver {

    @Override
    public List<Cell> getPath(boolean[][] grid, Cell start, Cell end) {
        if (grid == null || grid.length == 0) {
            return new ArrayList<>();
        }
        List<Cell> path = new ArrayList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        if (findPath(grid, start, end, path, visited)) {
            return path;
        }
        return new ArrayList<>();
    }

    private boolean findPath(boolean[][] grid, Cell current, Cell end, List<Cell> path, boolean[][] visited) {
        int row = current.row;
        int col = current.Col;

        // Validar si está fuera del grid, si no es transitable, o si ya fue visitada
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || !grid[row][col] || visited[row][col]) {
            return false;
        }

        // Marcar como visitada
        visited[row][col] = true;

        // Verificar si llegamos al final
        if (row == end.row && col == end.Col) {
            path.add(current);
            return true;
        }

        // Explorar abajo
        if (findPath(grid, new Cell(row + 1, col), end, path, visited)) {
            path.add(current);
            return true;
        }

        // Explorar derecha
        if (findPath(grid, new Cell(row, col + 1), end, path, visited)) {
            path.add(current);
            return true;
        }

        // Explorar arriba
        if (findPath(grid, new Cell(row - 1, col), end, path, visited)) {
            path.add(current);
            return true;
        }

        // Explorar izquierda
        if (findPath(grid, new Cell(row, col - 1), end, path, visited)) {
            path.add(current);
            return true;
        }

        // Si no encuentra camino, desmarcar la celda para otras rutas
        // visited[row][col] = false; // (Opcional si quieres permitir múltiples caminos)
        return false;
    }
}

