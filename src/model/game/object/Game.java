package model.game.object;

import control.exception.game.IllegalActionInThisPhaseException;
import control.exception.game.IllegalPlaceToBuildException;
import control.game.IGameControl;
import model.game.IGame;
import model.game.board.EasyBoardBuilder;
import model.game.board.IBoardBuilder;
import model.game.event.*;

import java.awt.Color;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Game implements IGame {

    private final Player[] players;
    private final List<Intersection> intersections = new LinkedList<>();
    private final List<Path> paths = new LinkedList<>();

    private final Terrain[] terrains;
    private final IGameControl control;

    public Game(IGameControl control, String... playerNames) {
        players = new Player[playerNames.length];
        for (int i = 0; i < players.length; i++) {
            players[i] = new Player(playerNames[i], i, Color.PINK, control, this);
        }

        this.control = control;

        IBoardBuilder builder = new EasyBoardBuilder();
        Collections.addAll(intersections, builder.getIntersections());
        Collections.addAll(paths, builder.getPaths());
        terrains = builder.getTerrains();

        for (Intersection i : intersections) {
            control.sendGameEvent(i.createSetupEvent());
        }

        for (Path p : paths) {
            control.sendGameEvent(p.createSetupEvent());
        }

        for (Terrain t : terrains) {
            control.sendGameEvent(t.createSetupEvent());
        }

        control.sendGameEvent(new PreparationSettlementPhaseEvent(curPlayerIndex));
    }

    private int curPlayerIndex = 0;

    private abstract class GamePhase {

        void rollDice() {
            throw new IllegalActionInThisPhaseException("TODO");
        }

        void buildStreet(int pathId) {
            throw new IllegalActionInThisPhaseException("TODO");
        }

        void buildSettlement(int waypointId) {
            throw new IllegalActionInThisPhaseException("TODO");
        }

        void buildCity(int waypointId) {
            throw new IllegalActionInThisPhaseException("TODO");
        }

        void finishTurn() {
            throw new IllegalActionInThisPhaseException("TODO");
        }

    }

    private final GamePhase preparationSettlementPhase = new GamePhase() {

        @Override
        public void buildSettlement(int intersectionId) {
            Intersection s = findIntersectionForBuilding(intersectionId);
            players[curPlayerIndex].buildSetupSettlement(s);
            finishSettlementBuilding(s);

            gamePhase = preparationStreetPhase;
            control.sendGameEvent(new BuildSettlementEvent(curPlayerIndex, intersectionId));
        }

    };

    private final GamePhase preparationStreetPhase = new GamePhase() {

        @Override
        public void buildStreet(int pathId) {
            Path path = findPathForBuilding(pathId);
            players[curPlayerIndex].buildSetupStreet(path);
            finishStreetBuilding(path);

            if (players[curPlayerIndex].getSettlements().length <= 1) {

                // Forward Preparation Round
                if (curPlayerIndex < players.length - 1) {
                    curPlayerIndex++;
                }
                gamePhase = preparationSettlementPhase;
                control.sendGameEvent(new PreparationSettlementPhaseEvent(curPlayerIndex));

            } else {

                // Backward Preparation Round
                if (curPlayerIndex > 0) {
                    curPlayerIndex--;
                    gamePhase = preparationSettlementPhase;
                    control.sendGameEvent(new PreparationSettlementPhaseEvent(curPlayerIndex));
                } else {
                    for (Player p : players) {
                        p.collectStartResources();
                    }
                    gamePhase = resourcePhase;
                    control.sendGameEvent(new ResourcePhaseEvent(curPlayerIndex));
                }
            }
        }

    };

    private final GamePhase resourcePhase = new GamePhase() {

        @Override
        void rollDice() {
            Random r = new Random();
            int n1 = r.nextInt(6) + 1;
            int n2 = r.nextInt(6) + 1;
            control.sendGameEvent(new RollDiceEvent(n1, n2));

            if (n1 + n2 != 7) {
                for (Player p : players) {
                    p.collectMaterial(n1 + n2);
                }
            } else {
                // TODO Knight
            }

            gamePhase = actionPhase;
        }

    };

    private final GamePhase actionPhase = new GamePhase() {

        @Override
        void buildStreet(int pathId) {
            Path p = findPathForBuilding(pathId);
            players[curPlayerIndex].buildStreet(p);
            finishStreetBuilding(p);
        }

        @Override
        void buildSettlement(int waypointId) {
            Intersection s = findIntersectionForBuilding(waypointId);
            players[curPlayerIndex].buildSettlement(s);
            finishSettlementBuilding(s);
        }

        @Override
        void buildCity(int waypointId) {
            players[curPlayerIndex].buildCity(waypointId);
        }

        @Override
        void finishTurn() {
            curPlayerIndex++;
            if(curPlayerIndex >= players.length) {
                curPlayerIndex = 0;
            }
            control.sendGameEvent(new NextPlayerEvent(curPlayerIndex));
        }

    };

    private final GamePhase gameOverPhase = new GamePhase() {};

    private Intersection findIntersectionForBuilding(int intersectionId) {
        Intersection s = findIntersection(intersectionId);
        if (s == null) {
            throw new IllegalPlaceToBuildException("TODO");
        }
        return s;
    }

    private void finishSettlementBuilding(Intersection s) {
        control.sendGameEvent(new BuildSettlementEvent(curPlayerIndex, s.getId()));

        intersections.remove(s);
        for (Intersection i : s.getNeighborIntersections()) {
            if (intersections.contains(i)) {
                intersections.remove(i);
                control.sendGameEvent(new WaypointBlockedEvent(i.getId()));
            }
        }
    }

    private Path findPathForBuilding(int pathId) {
        Path path = findPath(pathId);
        if (path == null) {
            throw new IllegalPlaceToBuildException("TODO");
        }
        return path;
    }

    private void finishStreetBuilding(Path path) {
        paths.remove(path);
    }

    private GamePhase gamePhase = preparationSettlementPhase;

    public void rollDice() {
        gamePhase.rollDice();
    }

    public void buildStreet(int pathId) {
        gamePhase.buildStreet(pathId);
    }

    public void buildSettlement(int intersectionId) {
        gamePhase.buildSettlement(intersectionId);
    }

    public void buildCity(int intersectionId) {
        gamePhase.buildCity(intersectionId);
    }

    public void finishTurn() {
        gamePhase.finishTurn();
    }

    private Intersection findIntersection(int intersectionId) {
        for (Intersection s : intersections) {
            if (s.getId() == intersectionId) {
                return s;
            }
        }
        return null;
    }

    void gameOver(int playerId) {
        gamePhase = gameOverPhase;
        control.sendGameEvent(new GameOverEvent(playerId));
    }

    private Path findPath(int pathId) {
        for (Path p : paths) {
            if (p.getId() == pathId) {
                return p;
            }
        }
        return null;
    }


    // --- Setup ---
    // Später dann evtl Einstellungsmöglichkeiten, für Spielbrett aufbau, Spielerreihenfole , variante usw...

    // Spielbrett mit Zahlen aufbauen // 2 verschiede Größen, je nach Spielerzahl
    // Spieler von vorn nach hinten durchgehen, jeder setzt ein Dorf und ein Straße
    // Spieler von hinten nach vorn durchgegehn, jeder setzt ein Dorf und eine Straße und erhält Roshtoffe der angrenzenden Gebiete

    // --- Runde (wiederholt sich) ---

    // Es wird gewürfelt (evtl zusätzlich Klick durch Spieler)
    // Wenn nicht 7 gewürfelt, finde alle Felder mit der Zahl und verteile Rohstoffe (Reihenfolge beibehalten)
    // (Rohstoffe abgeben, Ritter versetzen, Karte von betroffenenem Spieler ziehen)

    // Spieler hat mehrere Möglichkeiten, nach jedem Schritt wird geprüft, ob er gewonnen hat

    // Bauen
    // Zug beenden
    // (weitere Mölgichkeiten folgen, z.b. handeln, Tausch mit Bank, Ereigniskarte aufdecken)

    // Außerordentliche Bauphase ab 5 Spielern (Spieler der gerade dran war ausgenommen)

}
