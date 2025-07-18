import java.util.List;
import java.util.Set;

public class MazeResult {
    private List<Cell> path;
    private Set<Cell> visited;

    public MazeResult(Set<Cell> visited, List<Cell> path) {
        this.visited = visited;
        this.path =path;
    }

}