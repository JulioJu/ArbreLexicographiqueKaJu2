package arbrelexicographique;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class GraphicInterface extends JFrame {

    private static final long serialVersionUID = 1L;

    private ArbreLexicographique treeLexico;
    private JPanel panel_jtree;

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event dispatch thread.
     */
    public GraphicInterface () {

        //Create and set up the window.
        super("Lexicographic tree");
        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
            // Is your UI already created? So you will have to update the component-tree
            // of your current frame (or actually all of them...)
            SwingUtilities.updateComponentTreeUI(this);
        } catch(Exception e) { /* Most of the time you're just going to ignore it */ }
        this.setBounds(100, 100, 450, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(400, 400));
        this.setIconImage(createImage("/images/tree-161941_640.png"));
        //Add content to the window.

        // Create JTree : instantiate ArbreLexicographique (type JTree);
        // WARNING ALWAYS ADD WITH PREFIX « _ »
        this.treeLexico = new ArbreLexicographique();
        this.treeLexico.setVue();

        // Fram Layout
        this.getContentPane().setLayout(new BorderLayout(0, 0));

        // Create tabbed pane, instanceof panel_jtree
        JTabbedPane tabbedPane = this.displayTabbedPane();
        this.getContentPane().add(tabbedPane, BorderLayout.CENTER);

        // Create the toolbar.
        JToolBar toolBar = new GraphicInterfacePanelToolBar("ToolBox", this.treeLexico, this.panel_jtree);
        this.add(toolBar, BorderLayout.PAGE_START);

        // Menu
        JMenuBar menuBar = new GraphicInterfaceMenu(this.treeLexico, panel_jtree);
        this.setJMenuBar(menuBar);


        //Display the window.
        this.pack();
        this.setVisible(true);
    }

    private JTabbedPane displayTabbedPane() {

        //Create the scroll pane and add the tree to it.
        JScrollPane treeView = new JScrollPane(this.treeLexico.getVue());

        // Add JScrollPane to a JPanel
        this.panel_jtree = new JPanel();
        this.panel_jtree.setLayout(new GridLayout(1, 0));
        this.panel_jtree.add(treeView);

        // Create JPanel panel_list
        JPanel panel_list = new JPanel();

        // Create TabbedPane
        JTabbedPane tabbedPane = new JTabbedPane(SwingConstants.TOP);
        tabbedPane.addTab("Tree", null, panel_jtree, null);
        tabbedPane.addTab("List", null, panel_list, null);

        return tabbedPane;
    }

    /** Returns an Image, or null if the path was invalid. */
    protected static Image createImage(String path) {
        java.net.URL imgURL = GraphicInterface.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL).getImage();
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

    /** Returns an ImageIcon, or null if the path was invalid. */
    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = GraphicInterface.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GraphicInterface();
            }
        });

    }

}
