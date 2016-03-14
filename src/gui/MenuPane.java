package gui;

import control.menu.IMenuSubject;
import control.menu.MenuControl;
import engine.control.IMainControl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;

import java.util.LinkedList;
import java.util.List;


public class MenuPane extends JPanel implements IMenuSubject<Gui> {

    private static final Logger LOGGER = LogManager.getLogger();

    private IMainControl mainControl;
    private MenuControl observer;
    private Gui gui;

    /*
    private final JButton bnStart = new JButton() {
        {
            setBounds(50, 50, 100, 30);
            setText("Start");
        }
    };

    private final JTextField tfAddPlayer = new JTextField() {
        {
            setBounds(50, 100, 100, 30);
        }
    };

    private final JButton bnAddPlayer = new JButton() {
        {
            setBounds(170, 100, 70, 30);
            setText("Add");
        }
    }; */

    private final JLabel[] lbPlayers = new JLabel[4];
    {
        for(int i = 0; i < lbPlayers.length; i++) {
            lbPlayers[i] = new JLabel();
            lbPlayers[i].setLocation(20, 20 + 25 * i);
            lbPlayers[i].setSize(200, 20);
            add(lbPlayers[i]);
        }
    }




    public MenuPane() {
        setLayout(null);
        //add(bnStart);
        //add(tfAddPlayer);
        //add(bnAddPlayer);
    }

    @Override
    public void initialize(IMainControl mainControl, Gui gui) {
        this.mainControl = mainControl;
        observer = mainControl.getObserver(MenuControl.class);
        observer.addSubject(this);
        this.gui = gui;
    }

    @Override
    public void start() {
        LOGGER.trace("Starting");
        gui.setContent(this);
    }

    @Override
    public void stop() {
        LOGGER.trace("Stopping");
        gui.clearContent();
    }

    private final List<String> players = new LinkedList<>();

    @Override
    public void onPlayerAdded(String player) {
        players.add(player);
        updatePlayers();
    }

    @Override
    public void onPlayerRemoved(String player) {
        players.remove(player);
        updatePlayers();
    }

    private void updatePlayers() {
        for (JLabel lb: lbPlayers) {
            lb.setText("");
        }
        for (int i = 0; i < players.size(); i++) {
            lbPlayers[i].setText(players.get(i));
        }
    }

}
