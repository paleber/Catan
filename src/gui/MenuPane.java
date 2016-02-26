package gui;

import control.menu.IMenuSubject;
import control.menu.MenuControl;
import engine.control.IMainControl;

import javax.swing.*;


public class MenuPane extends JPanel implements IMenuSubject<Gui> {

    private IMainControl mainControl;
    private MenuControl observer;
    private Gui gui;

    public MenuPane() {
        add(createStartButton());
        add(createExitButton());
    }

    private JButton createStartButton() {
        JButton bn = new JButton("Start");
        bn.addActionListener(e -> System.out.println("Start clicked"));
        return bn;
    }


    private JButton createExitButton() {
        JButton bn = new JButton("Exit");
        bn.addActionListener(e -> System.out.println("Exit clicked"));
        return bn;
    }


    @Override
    public void initialize(IMainControl mainControl, Gui gui) {
        this.mainControl = mainControl;
        observer = mainControl.getObserver(MenuControl.class);
        this.gui = gui;
    }

    @Override
    public void start() {
        gui.setContent(this);
    }

    @Override
    public void stop() {
        gui.clearContent();
    }

    @Override
    public void updateNumberOfPlayers(int number) {

    }

    @Override
    public void updatePlayerName(int index, String name) {

    }
}
