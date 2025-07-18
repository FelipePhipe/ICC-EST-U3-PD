import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class App {
    public static void main(String[] args) throws Exception {
        //runEjerciciosPD();
        System.out.println("Felipe Parra");
        runMaze();
    }

    /*private static void runEjerciciosPD() {
        System.out.println("Felipe Parra");
        EjerciciosPD ejerciciosPD = new EjerciciosPD();

        System.out.println("Fibonacci recursivo");
        long start = System.nanoTime();
        long resultado = ejerciciosPD.getFibonaci(50);
        long end = System.nanoTime();
        long duration = end - start;
        System.out.println("Resultado = " + resultado + " en tiempo = " + duration + " ns");

        System.out.println("Fibonacci recursivo con Caching");
        start = System.currentTimeMillis();
        resultado = ejerciciosPD.getFibonaciPD(100);
        end = System.currentTimeMillis();
        duration = end - start;
        System.out.println("Resultado = " + resultado + " en tiempo = " + duration + " ns");
    }*/

     public static void runMaze() {
        boolean[][] predefineMaze = {
            {true, true, true, true},
            {false, true, false, true},
            {true, true, false, false},
            {true, true, true, true}
        };
        
        Maze maze = new Maze(predefineMaze);
        System.out.println("Laberinto original:");
        maze.printMaze();

        Cell start = new Cell(0, 0);
        Cell end = new Cell(3, 3);

        MazeSolverRecursivoCompletoBT solver = new MazeSolverRecursivoCompletoBT();
        List<Cell> path = solver.getPath(maze.getGrid(), start, end);
        Set<Cell> visited = solver.getVisitedCells();

        System.out.println("\nCeldas visitadas:");
        maze.printMazeWithVisits(visited);

        System.out.println("\nCamino encontrado:");
        maze.printMazeWithPath(path);

        System.out.println("\nInformación detallada:");
        System.out.println("Celdas visitadas: " + visited.size());
        System.out.println("Ruta encontrada: " + path);
        System.out.println("Longitud de la ruta: " + path.size());
    }
}
