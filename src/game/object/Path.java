package game.object;


import geo.ILine;

import java.util.ArrayList;
import java.util.List;

public class Path {

    private final ILine line;

    private final List<Path> nextPaths = new ArrayList<>();

    private Player owner = null;

    public Path(ILine line) {
        this.line = line;
    }

    public void addNeighbor(Path next) {
        nextPaths.add(next);
    }
}
