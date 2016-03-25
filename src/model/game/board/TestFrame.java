package model.game.board;

import geo.ILine;
import geo.IPoint;
import geo.IPolygon;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * Created by Patrick on 25.03.2016.
 */
public class TestFrame extends JFrame {

    private JPanel content = new JPanel() {


        private int con(double v) {
            return (int) (v * 80) + 400;
        }


        @Override
        public void paint(Graphics g) {

            int index = 0;

            Random r = new Random();
            for (IPolygon poly: Coordinates.polys) {

                int[] xc = {
                        con(poly.getPoint(0).getX()),
                        con(poly.getPoint(1).getX()),
                        con(poly.getPoint(2).getX()),
                        con(poly.getPoint(3).getX()),
                        con(poly.getPoint(4).getX()),
                        con(poly.getPoint(5).getX())
                };

                int[] yc = {
                        con(poly.getPoint(0).getY()),
                        con(poly.getPoint(1).getY()),
                        con(poly.getPoint(2).getY()),
                        con(poly.getPoint(3).getY()),
                        con(poly.getPoint(4).getY()),
                        con(poly.getPoint(5).getY())
                };


                g.setColor(new Color(230-r.nextInt(100),230-r.nextInt(100),230-r.nextInt(100)));
                g.fillPolygon(xc, yc, 6);


                g.setColor(Color.GRAY.darker());

                int x = con(poly.calculateMid().getX());
                int y = con(poly.calculateMid().getY());
                g.drawString(Integer.toString(index), x, y);
                index++;
            }



            index = 0;

            for (ILine l : Coordinates.lines) {

                int x = con(l.calculateMid().getX());
                int y = con(l.calculateMid().getY());

                g.setColor(Color.CYAN.darker());
                g.drawLine(con(l.getStart().getX()), con(l.getStart().getY()), con(l.getEnd().getX()), con(l.getEnd().getY()));
                g.setColor(Color.BLUE.darker());
                g.drawString(Integer.toString(index), x, y);
                index++;
            }

            g.setColor(Color.BLACK);
            index = 0;
            for (IPoint p : Coordinates.points) {

                int x = con(p.getX());
                int y = con(p.getY());

                g.drawString(Integer.toString(index), x, y);
                g.fillOval(x, y, 5, 5);
                index++;
            }


        }


    };

    public TestFrame() {

        setSize(820, 820);
        setLocationRelativeTo(null);
        content.setLayout(null);

        setContentPane(content);
        setVisible(true);
    }


    public static void main(String[] args) {
        new TestFrame();
    }

}
