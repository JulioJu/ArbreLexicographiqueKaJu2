package arbrelexicographique;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class GraphicInterfaceMenu extends JMenuBar implements ActionListener {

    private static final long serialVersionUID = 1L;

    private static String MENU_FILE_SAVE = "save";
    private static String MENU_FILE_LOAD = "load";
    private static String MENU_FILE_EXIT = "exit";

    public GraphicInterfaceMenu() {

        JMenu menuFile = new JMenu("File");
        menuFile.setMnemonic(KeyEvent.VK_F);
        this.add(menuFile);


        JMenuItem mntmLoad = new JMenuItem("Load");
        mntmLoad.setActionCommand(MENU_FILE_LOAD);
        mntmLoad.addActionListener(this);
        menuFile.add(mntmLoad);

        // TODO save.png is it ok ?
        JMenuItem mntmSave = new JMenuItem("Save", new ImageIcon("images/save.png"));
        mntmSave.setActionCommand(MENU_FILE_SAVE);
        mntmSave.addActionListener(this);
        menuFile.add(mntmSave);

        JMenuItem menuExit = new JMenuItem("Exit");
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
        if(MENU_FILE_EXIT.equals(MENU_FILE_EXIT)) {
            System.exit(0);
        }
    }


}
