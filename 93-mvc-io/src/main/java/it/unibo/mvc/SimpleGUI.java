package it.unibo.mvc;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.Toolkit;
/**
 * A very simple program using a graphical interface.
 *
 */
public final class SimpleGUI {

    private final int PROPORTION = 5;
    private final JFrame frame = new JFrame("A simple GUI");

    private SimpleGUI(SimpleController controller) {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Panel configuration
        final JPanel mainPanel = new JPanel();
        final JPanel hPanel = new JPanel();
        final JPanel pPanel = new JPanel();
        hPanel.setLayout(new BorderLayout());
        pPanel.setLayout(new BorderLayout());
        mainPanel.setLayout(new BorderLayout());
        //TextField and TextArea configuration
        final JTextArea tArea = new JTextArea();
        tArea.setLineWrap(true);
        tArea.setWrapStyleWord(true);
        final JTextField tField = new JTextField();
        //Buttons configuration
        final JButton printB = new JButton("Print");
        printB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent event) {
                controller.setNextStringToPrint(tField.getText());
                controller.printCurrentString();
            }
        });
        final JButton historyB = new JButton("History");
        historyB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent event) {
                tArea.setText(controller.getPrintedStringsHistory().toString());
            }
        });
        pPanel.add(tField, BorderLayout.NORTH);
        pPanel.add(printB, BorderLayout.CENTER);
        hPanel.add(tArea, BorderLayout.NORTH);
        hPanel.add(historyB, BorderLayout.CENTER);
        mainPanel.add(pPanel, BorderLayout.NORTH);
        mainPanel.add(hPanel, BorderLayout.SOUTH);
        frame.setContentPane(mainPanel);
    }

    private void display() {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();

        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        frame.setLocationByPlatform(true);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main() {
        final SimpleGUI gui =new SimpleGUI(new SimpleController());
        gui.display();
    }

}
