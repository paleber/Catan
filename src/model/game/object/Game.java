package model.game.object;

import control.exception.CatanException;
import control.exception.game.IllegalActionInThisPhaseException;
import control.exception.game.IllegalPlaceToBuildException;
import control.game.IGameControl;
import model.game.IGame;
import model.game.board.EasyBoardBuilder;
import model.game.board.IBoardBuilder;
import model.game.event.BuildSettlementEvent;
import model.game.event.PreparationPhaseSettlementEvent;
import model.game.event.PreparationPhaseStreetEvent;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


public class Game implements IGame {

    private final Player[] players;
    private final List<Intersection> intersections = new LinkedList<>();
    private final List<Path> paths = new LinkedList<>();

    private final Terrain[] terrains;
    private final IGameControl control;

    public Game(IGameControl control, String... playerNames) {
        players = new Player[playerNames.length];
        for (int i = 0; i < players.length; i++) {
            players[i] = new Player(playerNames[i]);
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

        for (Player p : players) {
            control.sendGameEvent(p.createSetupEvent());
        }

        curPlayerIndex = 0;
        phase = Phase.PREPARATION_SETTLEMENT;

        control.sendGameEvent(new PreparationPhaseSettlementEvent(curPlayerIndex));

    }

    private enum Phase {
        PREPARATION_SETTLEMENT,
        PREPARATION_STREET,
        GATHERING,
        ACTION
    }

    private Phase phase;
    private int curPlayerIndex;


    public void rollDice() {

        if (phase != Phase.GATHERING) {
            throw new IllegalActionInThisPhaseException("TODO");
        }

        // TODO
    }

    public void buildStreet(int pathId) {

        if (phase != Phase.PREPARATION_STREET && phase != Phase.ACTION) {
            throw new IllegalActionInThisPhaseException("TODO");
        }


        if (phase == Phase.GATHERING) {
            // TODO action in this phase not allowed exception
        }


        Path path = findPath(pathId);

        if (path == null) {
            // TODO throw Exception cant build on this place
        }

        players[curPlayerIndex].buildStreet(path);

        paths.remove(path);

        // TODO Nachricht das gebaut wurde
    }


    public void buildSettlement(int intersectionId) {

        if (phase != Phase.PREPARATION_SETTLEMENT && phase != Phase.ACTION) {
            throw new IllegalActionInThisPhaseException("TODO");
        }

        Intersection s = findIntersection(intersectionId);
        if (s == null) {
            throw new IllegalPlaceToBuildException("TODO");
        }
        players[curPlayerIndex].buildSettlement(s); // throws Exception, not enough Material

        // Remove neighbor intersections due to distance rule
        intersections.remove(s);
        for (Intersection i : s.getNeighborIntersections()) {
            intersections.remove(i);
        }

        control.sendGameEvent(new BuildSettlementEvent(curPlayerIndex, intersectionId));

        if (phase == Phase.PREPARATION_SETTLEMENT) {
            phase = Phase.PREPARATION_STREET;
            control.sendGameEvent(new PreparationPhaseStreetEvent(s.getId()));
        }

    }

    private Intersection findIntersection(int intersectionId) {
        for (Intersection s : intersections) {
            if (s.getId() == intersectionId) {
                return s;
            }
        }
        return null;
    }

    private Path findPath(int pathId) {
        for (Path p : paths) {
            if (p.getId() == pathId) {
                return p;
            }
        }
        return null;
    }

    public void buildCity(int intersectionId) {

    }


    public void finishTurn() {
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
