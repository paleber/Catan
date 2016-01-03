package game;

import game.board.IBoardBuilder;
import game.board.StandardBoardBuilder;
import game.object.Field;
import game.object.Intersection;
import game.object.Path;
import game.object.Player;


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

        IBoardBuilder builder = new StandardBoardBuilder();

        intersections = builder.getIntersections();
        paths = builder.getPaths();
        fields = builder.getFields();
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
