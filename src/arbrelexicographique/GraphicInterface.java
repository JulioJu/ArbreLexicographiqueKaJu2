package arbrelexicographique;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
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
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;

public class GraphicInterface extends JPanel {

    private static final long serialVersionUID = 5323033065904404945L;

    private JTree jtree;

    private ArbreLexicographique treeLexico = new ArbreLexicographique();

    public GraphicInterface () {

    }

    public void displayNorthButtons(JFrame frame) {

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

        JLabel lblwhat = new JLabel("  What?  ");
        panel.add(lblwhat);

        JTextPane textPane = new JTextPane();
        panel.add(textPane);
    }

    public void displayMenu(JFrame frame) {

        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);

        JMenu mnNewMenu = new JMenu("File");
        menuBar.add(mnNewMenu);

        JMenuItem mntmLoad = new JMenuItem("Load");
        mnNewMenu.add(mntmLoad);
        mntmLoad.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                treeLexico.load("blop");
                System.out.println(treeLexico.toString());

            }
        });

        JMenuItem mntmSave = new JMenuItem("Save");
        mnNewMenu.add(mntmSave);
        mntmSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                treeLexico.save("blop");
            }
        });

        JMenu mnNewMenu_1 = new JMenu("Help");
        menuBar.add(mnNewMenu_1);

        JMenuItem mntmAbout = new JMenuItem("About");
        mnNewMenu_1.add(mntmAbout);

    }

    private void createNodes(DefaultMutableTreeNode root) {
        DefaultMutableTreeNode level_1 = null;
        DefaultMutableTreeNode level_2 = null;

        level_1 = new DefaultMutableTreeNode("child");
        root.add(level_1);

        level_2 = new DefaultMutableTreeNode("A");
        level_1.add(level_2);
        level_2 = new DefaultMutableTreeNode("B");
        level_1.add(level_2);
        level_2 = new DefaultMutableTreeNode("C");
        level_1.add(level_2);
        level_2 = new DefaultMutableTreeNode("D");
        level_1.add(level_2);
        level_2 = new DefaultMutableTreeNode("E");
        level_1.add(level_2);
        level_2 = new DefaultMutableTreeNode("F");
        level_1.add(level_2);

        level_2.add(new DefaultMutableTreeNode("i"));

    }

    private void buildJTree(JPanel panel_2) {

        //Create the nodes.
        DefaultMutableTreeNode root =
            new DefaultMutableTreeNode("root");
        createNodes(root);

        //Create a tree that allows one selection at a time.
        jtree = new JTree(root);
        jtree.getSelectionModel().setSelectionMode
                (TreeSelectionModel.SINGLE_TREE_SELECTION);

        //Create the scroll pane and add the tree to it.
        JScrollPane treeView = new JScrollPane(jtree);

        //Add the split pane to this panel.
        panel_2.add(treeView);

    }

    private void displayTabbedPane(JFrame frame) {

        JPanel panel_1 = new JPanel();
        frame.getContentPane().add(panel_1, BorderLayout.SOUTH);

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);

        JPanel panel_2 = new JPanel();
        panel_2.setBackground(Color.WHITE);
        tabbedPane.addTab("Tree", null, panel_2, null);
        panel_2.setLayout(new GridLayout(1, 0));

        buildJTree(panel_2);

        JPanel panel_3 = new JPanel();
        panel_3.setBackground(Color.WHITE);
        tabbedPane.addTab("List", null, panel_3, null);

    }


    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event dispatch thread.
     */
    private static void createAndShowGUI() {

        //Create and set up the window.
        JFrame frame = new JFrame("Lexicographic tree");
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add content to the window.
        GraphicInterface graphicInterface = new GraphicInterface();
        graphicInterface.displayMenu(frame);
        frame.getContentPane().setLayout(new BorderLayout(0, 0));
        graphicInterface.displayNorthButtons(frame);
        graphicInterface.displayTabbedPane(frame);

        //Display the window.
        frame.pack();
        frame.setVisible(true);

    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {

        // System.out.println(tree.ajout("exemple"));
        // tree.ajout("personne");
        // tree.ajout("exo");
        // System.out.println(tree.ajout("exemple"));
        // tree.ajout("dernier");
        // System.out.println(tree.ajout("exemple"));
        // tree.ajout("personne");
        // tree.ajout("exo");
        // System.out.println(tree.ajout("exemple"));
        // tree.ajout("dernier");

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });

    }

}
