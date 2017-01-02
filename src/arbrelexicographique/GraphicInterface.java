package arbrelexicographique;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class GraphicInterface {

    private ArbreLexicographique treeLexico;

    JPanel panel_jtree;

    public GraphicInterface () {
        treeLexico = new ArbreLexicographique();
        treeLexico.setVue();
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
                // this.treeLexico.load("blop");
                // System.out.println(this.treeLexico.toString());
            }
        });

        JMenuItem mntmSave = new JMenuItem("Save", new ImageIcon("images/save.png"));
        menuFile.add(mntmSave);
        mntmSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // this.treeLexico.save("blop");
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

    private void displayTabbedPane(JFrame frame) {

        JTabbedPane tabbedPane = new JTabbedPane(SwingConstants.TOP);
        frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);

        panel_jtree= new JPanel();
        tabbedPane.addTab("Tree", null, panel_jtree, null);
        panel_jtree.setLayout(new GridLayout(1, 0));
        panel_jtree.add(this.treeLexico.getVue());

        JPanel panel_list = new JPanel();
        tabbedPane.addTab("List", null, panel_list, null);

    }



    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event dispatch thread.
     */
    private static void createAndShowGUI() {

        // CREATE INSTANCE
        GraphicInterface graphiqueInterfaceInstance = new GraphicInterface();

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
        graphiqueInterfaceInstance.displayMenu(frame);
        frame.getContentPane().setLayout(new BorderLayout(0, 0));

        //Create the toolbar.
        graphiqueInterfaceInstance.displayTabbedPane(frame);
        JToolBar toolBar = new GraphicInterfacePanelToolBar("ToolBox", graphiqueInterfaceInstance.treeLexico, graphiqueInterfaceInstance.panel_jtree);
        frame.add(toolBar, BorderLayout.PAGE_START);

        //Display the window.
        frame.pack();
        frame.setVisible(true);

    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });

    }

}
