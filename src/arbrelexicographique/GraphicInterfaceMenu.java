package arbrelexicographique;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class GraphicInterfaceMenu extends JMenuBar implements ActionListener {

    private static final long serialVersionUID = 1L;

    private static String MENU_FILE_SAVE = "save";
    private static String MENU_FILE_OPEN = "open";
    private static String MENU_FILE_EXIT = "exit";

    ArbreLexicographique treeLexico;
    JPanel panel_jtree;

    static private final String newline = "\n";
    JFileChooser fc;

    public GraphicInterfaceMenu(ArbreLexicographique treeLexico, JPanel panel_jtree) {

        // ArbreLexicographique, type JTree. Need by action listeners,
        // create first
        this.treeLexico = treeLexico;
        this.panel_jtree = panel_jtree;

        //Create a file chooser
        fc = new JFileChooser();

        //Uncomment one of the following lines to try a different
        //file selection mode.  The first allows just directories
        //to be selected (and, at least in the Java look and feel,
        //shown).  The second allows both files and directories
        //to be selected.  If you leave these lines commented out,
        //then the default mode (FILES_ONLY) will be used.
        //
        //fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        //fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        // Menu
        JMenu menuFile = new JMenu("File");
        menuFile.setMnemonic(KeyEvent.VK_F);
        this.add(menuFile);


        JMenuItem mntmLoad = new JMenuItem("Open tree", GraphicInterface.createImageIcon("/images/open16.png"));
        mntmLoad .setMnemonic(KeyEvent.VK_O);
        mntmLoad.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        mntmLoad.setActionCommand(MENU_FILE_OPEN);
        mntmLoad.addActionListener(this);
        menuFile.add(mntmLoad);

        // TODO save.png is it ok ?
        JMenuItem mntmSave = new JMenuItem("Save", GraphicInterface.createImageIcon("/images/save.png"));
        mntmSave.setMnemonic(KeyEvent.VK_S);
        mntmSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        mntmSave.setActionCommand(MENU_FILE_SAVE);
        mntmSave.addActionListener(this);
        menuFile.add(mntmSave);

        JMenuItem menuExit = new JMenuItem("Exit", GraphicInterface.createImageIcon("/images/exit.png"));
        menuExit.setMnemonic(KeyEvent.VK_X);
        menuExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_MASK));
        menuExit.setActionCommand(MENU_FILE_EXIT);
        menuExit.addActionListener(this);
        menuFile.add(menuExit);

        JMenu menuHelp = new JMenu("Help");
        this.add(menuHelp);

        JMenuItem mntmAbout = new JMenuItem("About");
        menuHelp.add(mntmAbout);

    }

    // ** Implements ActionListener interface
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if(MENU_FILE_EXIT.equals(command)) {
            System.exit(0);
        }
        else if(MENU_FILE_OPEN.equals(command)) {

            int returnVal = fc.showOpenDialog(this);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                //This is where a real application would open the file.
                treeLexico.load(file.toString());
                treeLexico.setVue();
                panel_jtree.removeAll();
                panel_jtree.revalidate();
                panel_jtree.add(this.treeLexico.getVue());
            } else {
                System.out.println("Open command cancelled by user." + newline);
            }

            //Handle save button action.
        }
        else if (MENU_FILE_SAVE.equals(command)) {
            int returnVal = fc.showSaveDialog(this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                //This is where a real application would save the file.
                treeLexico.save(file.toString());
            } else {
                System.out.println("Save command cancelled by user." + newline);
            }
        }
    }

}
