package com.uebung3;

import com.uebung3.Classes.AbteilungClass;
import com.uebung3.Classes.SchuleClass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HTL extends JFrame implements ActionListener {

    public HTL(String title) {
        super(title);
        setFocusable(true);

        JButton New = new JButton ("Schule hinzufügen");
        JButton Select = new JButton ("Schule auswählen");
        JButton Quit = new JButton ("Beenden");

        JLabel Title = new JLabel ("Schulsystem");

        New.setBounds(45, 75, 160, 40);
        Select.setBounds(45, 125, 160, 40);
        Quit.setBounds(45, 175, 160, 40);

        Title.setBounds(0, 15, 250, 40);
        Title.setHorizontalAlignment(JLabel.CENTER);

        New.addActionListener(this);
        Select.addActionListener(this);
        Quit.addActionListener(this);

        add(New);
        add(Select);
        add(Quit);

        add(Title);
    }

    public static void main(String[] args) {
        /*HTL menu_window = new HTL("Star Shooter");
        menu_window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menu_window.setSize(250,250);
        menu_window.setResizable(false);
        menu_window.setLayout(null);
        menu_window.setLocationRelativeTo(null);
        menu_window.setVisible(true);*/

        System.out.println("HTL");
        SchuleClass schule = new SchuleClass("HTL", 12093, "Technische Schule");
        AbteilungClass EL = schule.addAbteilung("Elektronik und Technische Informatik", "EL");
        System.out.println(EL.getName() + " | " + EL.getKuerzel());
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
