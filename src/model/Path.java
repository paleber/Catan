package model;

import geo.ILine;
import util.IdGenerator;

public class Path {

    private final int id = IdGenerator.generate();

    private ILine line;

    private Path[] nextPaths;

    private Player owner = null;

}
