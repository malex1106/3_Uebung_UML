package com.uebung3;

import com.uebung3.Classes.AbteilungClass;
import com.uebung3.Classes.AdresseClass;
import com.uebung3.Classes.SchuelerClass;
import com.uebung3.Classes.SchuleClass;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;

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

            menuBar = new JMenuBar();
            fileMenu = new JMenu("Ablage");
            settingsMenu = new JMenu("Einstellungen");
            helpMenu = new JMenu("Hilfe");

            /////////////////////////////////////////////////////////////
            // FRAME

            setResizable(false);
            setName("DataPrax");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setBounds(100, 100, 800, 600);
            setLocationRelativeTo(null);
            contentPane = new JPanel();
            contentPane.setBackground(new Color(241, 242, 245));
            contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
            setContentPane(contentPane);
            contentPane.setLayout(null);

            JButton BearbeitenButton = new JButton("");
            BearbeitenButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {

                }
            });
            BearbeitenButton.setBounds(750, 8, 40, 32);
            contentPane.add(BearbeitenButton);
            BearbeitenButton.setIgnoreRepaint(true);
            BearbeitenButton.setToolTipText("Bearbeiten");
            BearbeitenButton.setRolloverEnabled(true);
            BearbeitenButton.setOpaque(true);
            BearbeitenButton.setFocusPainted(false);
            BearbeitenButton.setIcon(new ImageIcon("/Users/alexandersmacbookpro/Documents/Development/Java Projects/DataPrax/Icons/BearbeitenButton.png"));

            JLabel InformationLabel = new JLabel("");
            InformationLabel.setBorder(null);
            InformationLabel.setBounds(269, 0, 531, 47);
            contentPane.add(InformationLabel);
            InformationLabel.setInheritsPopupMenu(false);
            InformationLabel.setFocusTraversalPolicyProvider(true);
            InformationLabel.setFocusCycleRoot(true);
            InformationLabel.setForeground(Color.DARK_GRAY);
            InformationLabel.setFont(new Font("Apple SD Gothic Neo", Font.PLAIN, 18));
            InformationLabel.setHorizontalAlignment(SwingConstants.CENTER);
            InformationLabel.setOpaque(false);
            InformationLabel.setBackground(new Color(241, 241, 245));

            JPanel InformationBackgroundPanel = new JPanel();
            InformationBackgroundPanel.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
            InformationBackgroundPanel.setBounds(269, 0, 531, 48);
            InformationBackgroundPanel.setBackground(new Color(241, 241, 245));
            contentPane.add(InformationBackgroundPanel);

            MainPanel = new JPanel();
            MainPanel.setBorder(null);
            MainPanel.setBackground(Color.WHITE);
            MainPanel.setBounds(269, 48, 531, 702);
            MainPanel.setLayout(null);
            contentPane.add(MainPanel);

            JLabel DatumLabel = new JLabel("DATUM:");
            DatumLabel.setFont(new Font("Apple SD Gothic Neo", Font.PLAIN, 16));
            DatumLabel.setBounds(35, 35, 68, 16);
            MainPanel.add(DatumLabel);

            JLabel VonLabel = new JLabel("VON:");
            VonLabel.setFont(new Font("Apple SD Gothic Neo", Font.PLAIN, 16));
            VonLabel.setBounds(35, 80, 43, 16);
            MainPanel.add(VonLabel);

            JFormattedTextField VonTextfield = new JFormattedTextField();
            VonTextfield.setToolTipText("");
            VonTextfield.setOpaque(true);
            VonTextfield.setHorizontalAlignment(SwingConstants.CENTER);
            VonTextfield.setBorder(new LineBorder(SystemColor.window, 1, true));
            VonTextfield.setBackground(new Color(222, 224, 224));
            VonTextfield.setBounds(112, 74, 137, 26);
            MainPanel.add(VonTextfield);

            JLabel BisLabel = new JLabel("BIS:");
            BisLabel.setFont(new Font("Apple SD Gothic Neo", Font.PLAIN, 16));
            BisLabel.setBounds(270, 79, 26, 16);
            MainPanel.add(BisLabel);

            JFormattedTextField DatumTextfield = new JFormattedTextField();
            DatumTextfield.setToolTipText("");
            DatumTextfield.setOpaque(true);
            DatumTextfield.setHorizontalAlignment(SwingConstants.CENTER);
            DatumTextfield.setBorder(new LineBorder(SystemColor.window, 1, true));
            DatumTextfield.setBackground(new Color(222, 224, 224));
            DatumTextfield.setBounds(112, 30, 137, 26);
            MainPanel.add(DatumTextfield);

            JFormattedTextField BisTextfield = new JFormattedTextField();
            BisTextfield.setToolTipText("");
            BisTextfield.setOpaque(true);
            BisTextfield.setHorizontalAlignment(SwingConstants.CENTER);
            BisTextfield.setBorder(new LineBorder(SystemColor.window, 1, true));
            BisTextfield.setBackground(new Color(222, 224, 224));
            BisTextfield.setBounds(306, 74, 137, 26);
            MainPanel.add(BisTextfield);

            list = new JList();
            list.addListSelectionListener(new ListSelectionListener() {
                public void valueChanged(ListSelectionEvent e) {
                    try {
                        InformationLabel.setText(list.getSelectedValue().toString());
                    } catch (Exception e1) {}
                }
            });

            JFormattedTextField SearchTextfield = new JFormattedTextField();
            SearchTextfield.setToolTipText("Suchen");
            SearchTextfield.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                        list.setSelectedValue(SearchTextfield.getText(), true);
                    }
                }
            });
            SearchTextfield.setBackground(new Color(222, 224, 224));
            SearchTextfield.setBorder(new LineBorder(SystemColor.window, 1, true));
            SearchTextfield.setHorizontalAlignment(SwingConstants.CENTER);
            SearchTextfield.setOpaque(true);
            SearchTextfield.setBounds(18, 10, 231, 26);
            contentPane.add(SearchTextfield);

            list.setSelectionBackground(new Color(30, 144, 255));
            list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            list.setForeground(Color.DARK_GRAY);
            list.setFont(new Font("Apple SD Gothic Neo", Font.PLAIN, 18));
            list.setBorder(null);
            list.setBackground(new Color (241, 242, 245));
            list.setSelectionForeground(SystemColor.window);
            list.setFocusTraversalPolicyProvider(true);
            list.setDoubleBuffered(true);
            list.setBounds(18, 66, 231, 444);

            JScrollPane scrollPane = new JScrollPane(list);
            scrollPane.setBorder(null);
            scrollPane.setBounds(18, 66, 231, 444);
            contentPane.add(scrollPane);

            JProgressBar progressBar = new JProgressBar(0, 100);
            progressBar.setBounds(-5, 566, 280, 20);
            progressBar.setValue(0);
            contentPane.add(progressBar);

            JComboBox comboBox = new JComboBox();
            comboBox.setBounds(18, 540, 231, 27);
            comboBox.addItem("Offline");
            comboBox.addItem("Online");
            comboBox.addItemListener(new ItemListener() {
                //
                // Listening if a new items of the combo box has been selected.
                //
                public void itemStateChanged(ItemEvent event) {
                    JComboBox comboBox = (JComboBox) event.getSource();

                    // The item affected by the event.
                    Object item = event.getItem();

                    if (event.getStateChange() == ItemEvent.SELECTED) {
                        if(event.getItem().equals("Online")) {
                            progressBar.setValue(100);
                            scrollPane.show();
                        }
                        else {
                            progressBar.setValue(0);
                            InformationLabel.setText("");
                            scrollPane.hide();
                        }
                    }
                }
            });
            contentPane.add(comboBox);

            JSeparator SearchSeparator = new JSeparator();
            SearchSeparator.setBounds(5, 42, 795, 12);
            contentPane.add(SearchSeparator);

            JSeparator ConnectionSeparator = new JSeparator();
            ConnectionSeparator.setBounds(-5, 522, 280, 12);
            contentPane.add(ConnectionSeparator);

            //////////////////////////////////////////////////////////////////////////
            // MENU ADDINGS

            menuBar.add(fileMenu);
            menuBar.add(settingsMenu);
            menuBar.add(helpMenu);

            JMenuItem newItem = new JMenuItem("Neuer Eintrag");
            newItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.META_MASK));
            fileMenu.add(newItem);

            JSeparator separator = new JSeparator();
            fileMenu.add(separator);

            JMenuItem deleteItem = new JMenuItem("Löschen");
            deleteItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.META_MASK));
            fileMenu.add(deleteItem);

            JMenuItem saveItem = new JMenuItem("Sichern");
            saveItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.META_MASK));
            fileMenu.add(saveItem);

            JSeparator separator_1 = new JSeparator();
            fileMenu.add(separator_1);

            JMenuItem closeItem = new JMenuItem("Schließen");
            closeItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, InputEvent.META_MASK));
            fileMenu.add(closeItem);

            ////////////////////////

            JMenuItem connectionItem = new JMenuItem("Verbindungen...");
            connectionItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, InputEvent.META_MASK));
            settingsMenu.add(connectionItem);

            ///////////////////////

            JMenuItem welcomeItem = new JMenuItem("Willkommen...    ");
            helpMenu.add(welcomeItem);

            setJMenuBar(menuBar);

            //Test
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
