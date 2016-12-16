package arbrelexicographique.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;

public class InterfaceGraphique {

    private JFrame frame;
    private static arbrelexicographique.ArbreLexicographique arbre = new arbrelexicographique.ArbreLexicographique();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {

        System.out.println(arbre.ajout("exemple"));
        arbre.ajout("personne");
        arbre.ajout("exo");
        System.out.println(arbre.ajout("exemple"));
        arbre.ajout("dernier");
        System.out.println(arbre.ajout("exemple"));
        arbre.ajout("personne");
        arbre.ajout("exo");
        System.out.println(arbre.ajout("exemple"));
        arbre.ajout("dernier");

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    InterfaceGraphique window = new InterfaceGraphique();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public InterfaceGraphique() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);

        JMenu mnNewMenu = new JMenu("File");
        menuBar.add(mnNewMenu);

        JMenuItem mntmLoad = new JMenuItem("Load");
        mnNewMenu.add(mntmLoad);
        mntmLoad.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("essai");
            }
        });

        JMenuItem mntmSave = new JMenuItem("Save");
        mnNewMenu.add(mntmSave);
        mntmSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // arbre.save();
                System.out.println("Save performed");
                // GraphicInterfaceActionPerformed.mntmSaveActionPerformed();
            }
        });

        JMenu mnNewMenu_1 = new JMenu("Help");
        menuBar.add(mnNewMenu_1);

        JMenuItem mntmAbout = new JMenuItem("About");
        mnNewMenu_1.add(mntmAbout);
        frame.getContentPane().setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel, BorderLayout.NORTH);
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

        JButton button = new JButton("Add");
        panel.add(button);

        JButton button_1 = new JButton("Delete");
        panel.add(button_1);

        JButton button_2 = new JButton("Choose");
        panel.add(button_2);

        JButton button_3 = new JButton("Prefix");
        panel.add(button_3);

        JLabel label = new JLabel("What?");
        panel.add(label);

        JTextPane textPane = new JTextPane();
        panel.add(textPane);

        JPanel panel_1 = new JPanel();
        frame.getContentPane().add(panel_1, BorderLayout.SOUTH);

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);

        JPanel panel_2 = new JPanel();
        panel_2.setBackground(Color.WHITE);
        tabbedPane.addTab("Tree", null, panel_2, null);

        JPanel panel_3 = new JPanel();
        panel_3.setBackground(Color.WHITE);
        tabbedPane.addTab("List", null, panel_3, null);


    }
}
