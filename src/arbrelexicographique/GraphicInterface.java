package arbrelexicographique;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.JTree;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class GraphicInterface extends JTree {

    private static final long serialVersionUID = -1455483992386678927L;

    private ArbreLexicographique treeLexico;
    private DefaultMutableTreeNode defaultMutableTreeNode = new DefaultMutableTreeNode();
    private ArbreLexicographique arbreLexicographiqueJTreeVueAspect = new ArbreLexicographique(new DefaultTreeModel(defaultMutableTreeNode), defaultMutableTreeNode);
    public GraphicInterface () {
    }

    public void displayMenu(JFrame frame) {


        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);

        JMenu menuFile = new JMenu("File");
        menuFile.setMnemonic(KeyEvent.VK_F);
        menuBar.add(menuFile);


        JMenuItem mntmLoad = new JMenuItem("Load");
        menuFile.add(mntmLoad);
        mntmLoad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                treeLexico.load("blop");
                System.out.println(treeLexico.toString());
            }
        });

        JMenuItem mntmSave = new JMenuItem("Save", new ImageIcon("images/save.png"));
        menuFile.add(mntmSave);
        mntmSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                treeLexico.save("blop");
            }
        });

        JMenuItem menuExit = new JMenuItem("Exit");
        menuExit.setMnemonic(KeyEvent.VK_X);
        menuExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_MASK));
        menuExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });
        menuFile.add(menuExit);

        JMenu menuHelp = new JMenu("Help");
        menuBar.add(menuHelp);

        JMenuItem mntmAbout = new JMenuItem("About");
        menuHelp.add(mntmAbout);

    }

    private void addButtons (JPanel panel) {
        JButton button = null;

        button = new JButton("Add");
        panel.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                arbreLexicographiqueJTreeVueAspect.addObject("New Node ");
            }
        });

        button = new JButton("Delete");
        panel.add(button);

        button = new JButton("Choose");
        panel.add(button);

        button = new JButton("Prefix");
        panel.add(button);

    }

    protected void defineToolBar(JToolBar toolBar) {
        //separator
        toolBar.addSeparator();

        JPanel panel = new JPanel();
        addButtons(panel);
        toolBar.add(panel);

        toolBar.addSeparator();

        JLabel lblwhat = new JLabel("What?");
        toolBar.add(lblwhat);
        toolBar.addSeparator();

        //fifth component is NOT a button!
        JTextField textField = new JTextField("A text field");
        textField.setColumns(10);
        // textField.addActionListener(this);
        // textField.setActionCommand(TEXT_ENTERED);
        toolBar.add(textField);

    }


    public void displayNorthButtons(JFrame frame) {


        //Create the toolbar.
        JToolBar toolBar = new JToolBar("ToolBox");
        defineToolBar(toolBar);
        toolBar.setFloatable(true);
        toolBar.setRollover(true);
        frame.add(toolBar, BorderLayout.PAGE_START);
    }


    private void displayTabbedPane(JFrame frame) {

        JTabbedPane tabbedPane = new JTabbedPane(SwingConstants.TOP);
        frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);

        JPanel panel_jtree = new JPanel();
        tabbedPane.addTab("Tree", null, panel_jtree, null);
        panel_jtree.setLayout(new GridLayout(1, 0));
        panel_jtree.add(arbreLexicographiqueJTreeVueAspect);

        JPanel panel_list = new JPanel();
        tabbedPane.addTab("List", null, panel_list, null);

    }



    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event dispatch thread.
     */
    private static void createAndShowGUI() {

        //Create and set up the window.
        JFrame frame = new JFrame("Lexicographic tree");
        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
            // Is your UI already created? So you will have to update the component-tree
            // of your current frame (or actually all of them...)
            SwingUtilities.updateComponentTreeUI(frame);
        } catch(Exception e) { /* Most of the time you're just going to ignore it */ }
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(400, 400));

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

        // try {
        //     for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
        //         if ("Nimbus".equals(info.getName())) {
        //             UIManager.setLookAndFeel(info.getClassName());
        //             break;
        //         }
        //     }
        // } catch (Exception e) {
        //     // If Nimbus is not available, you can set the GUI to another look and feel.
        // }


        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });

    }

}
