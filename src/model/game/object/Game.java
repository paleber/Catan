package model.game.object;

import control.game.IGameControl;
import model.game.IGame;
import model.game.IPath;
import model.game.board.EasyBoardBuilder;
import model.game.board.IBoardBuilder;

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

        control.setupGame(builder.getIntersections(), builder.getPaths(), terrains.clone(), players.clone());

        /*
        for (Intersection i : intersections) {
            System.out.println(i);
        }

        for (Path p : paths) {
            System.out.println(p);
        }

        for (Terrain f : terrains) {
            System.out.println(f);
        }

        for (Player p: players) {
            System.out.println(p);
        } */

        curPlayerIndex = 0;
        state = State.PREPARATION_FORWARD;

    }

    private enum State {
        PREPARATION_FORWARD,
        PREPARATION_BACKWARD,
        GATHERING,
        ACTION
    }

    private State state;
    private int curPlayerIndex;


    public void rollDice() {
    }

    public void buildStreet(int pathId) {

        if (state == State.GATHERING) {
            // TODO action in this phase not allowed exception
        }


        Path path = findPath(pathId);

        if (path == null) {
            // TODO throw Exception cant build on this place
        }

        players[curPlayerIndex].buildStreet(path);

        paths.remove(path);

        switch (state) {
            case PREPARATION_FORWARD:
                if (curPlayerIndex < players.length - 1) {
                    curPlayerIndex += 1;
                    // TODO nachricht, nächster Spieler an der Reihe
                } else {
                    state = State.PREPARATION_BACKWARD;
                    // TODO nachricht, Rückrunde beginnt letzter Spieler ist zuerst dran
                }
                break;

            case PREPARATION_BACKWARD:
                break;
            case ACTION:
                break;
        }

        // TODO Nachricht das gebaut wurde
    }


    public void buildSettlement(int intersectionId) {
        // GameStatus prüfen TODO

        if (state == State.PREPARATION_FORWARD && players[curPlayerIndex].getSettlements().length != 0) {

        }

        Intersection s = findIntersection(intersectionId);
        if (s == null) {
            // TODO throw Exception cant build on this place
        }

        players[curPlayerIndex].buildSettlement(s); // Can throw Exception if not enougg Material
        intersections.remove(s);

        // TODO nachbarn der intersection wegen abstandsregel entfernen

        // TODO Nachricht das gebaut wurde

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
