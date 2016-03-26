package model.game;

import java.awt.*;
import java.util.Map;

public interface IPlayer {

    Color getColor();

    String getName();

    IPath[] getStreets();

    IIntersection[] getSettlements();

    IIntersection[] getCities();

    Map<Material, Integer> getMaterials();

}
