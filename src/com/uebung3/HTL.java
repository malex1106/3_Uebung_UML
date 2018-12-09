package com.uebung3;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;

public class HTL extends JFrame implements ActionListener {

    private JPanel contentPane;

    private JList list;

    private JMenuBar menuBar;
    private JMenu fileMenu;
    private JMenu settingsMenu;
    private JMenu helpMenu;

    private JPanel MainPanel;

    public HTL(String title) {
        //////////////////////////////////////////////////////////////
        // MENUBAR

        System.setProperty("apple.laf.useScreenMenuBar", "true");
        System.setProperty("apple.awt.UIElement", "true");
        System.setProperty("pple.awt.brushMetalLook", "true");
        System.setProperty("com.apple.mrj.application.apple.menu.about.name", "Name");

        /////////////////////////////////////////////////////////////
        // FRAME

        setResizable(false);
        setName(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(241, 242, 245));
        contentPane.setLayout(new GridLayout(0,1));

        JLabel label1 = new JLabel("Label1");
        JLabel label2 = new JLabel("Label1");
        JLabel label3 = new JLabel("Label1");
        JLabel label4 = new JLabel("Label1");
        setContentPane(contentPane);
        getContentPane().add(label1);
        getContentPane().add(label2);
        getContentPane().add(label3);
        getContentPane().add(label4);
    }

    public static void main(String[] args) {
        try {
            HTL frame = new HTL("Schulsystem");
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
