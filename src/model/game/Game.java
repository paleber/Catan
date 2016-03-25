package model.game;

import model.game.board.EasyBoardBuilder;
import model.game.board.IBoardBuilder;
import model.game.board.StandardBoardBuilder;
import model.game.object.Field;
import model.game.object.Intersection;
import model.game.object.Path;
import model.game.object.Player;


public class Game {

    private final Player[] players;
    private final Intersection[] intersections;
    private final Path[] paths;
    private final Field[] fields;

    public Game(String... playerNames) {
        players = new Player[playerNames.length];
        for (int i = 0; i < players.length; i++) {
            players[i] = new Player(playerNames[i]);
        }

        IBoardBuilder builder = new EasyBoardBuilder();
        intersections = builder.getIntersections();
        paths = builder.getPaths();
        fields = builder.getFields();

        for (Intersection i : intersections) {
            System.out.println(i);
        }

        for (Path p : paths) {
            System.out.println(p);
        }

        for (Field f : fields) {
            System.out.println(f);
        }

    }


    public static void main(String[] args) {
        new Game();
    }



    public void rollDice() {}

    public void buildStreet(int pathId) {}

    public void buildCity(int intersectionId) {}

    public void buildVillage(int intersectionId) {}

    public void finishTurn() {}

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
