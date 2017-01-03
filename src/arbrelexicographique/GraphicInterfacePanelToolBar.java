package arbrelexicographique;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;

public class GraphicInterfacePanelToolBar extends JToolBar implements ActionListener {

    private static final long serialVersionUID = -3677068589440633429L;

    JTextField textField;

    private static String ADD_COMMAND = "add";
    private static String REMOVE_COMMAND = "remove";
    // private static String CLEAR_COMMAND = "clear";
    private static String SEARCH_COMMAND = "search";
    private static String PREFIX_COMMAND = "prefix";

    private ArbreLexicographique treeLexico;
    private JPanel panel_jtree;
    private JTextArea list;
    private JFrame frame;
    private JLabel jlabelNumberOfWord;

    public GraphicInterfacePanelToolBar(String string, ArbreLexicographique treeLexico, JPanel panel_jtree, JFrame frame, JTextArea list, JLabel jlabelNumberOfWord) {
        super(string);
        this.treeLexico = treeLexico;
        this.panel_jtree = panel_jtree;
        this.list = list;
        this.frame = frame;
        this.jlabelNumberOfWord = jlabelNumberOfWord;

        // Options
        this.setFloatable(true);
        this.setRollover(true);

        //separator
        this.addSeparator();

        // Add buttons
        JPanel panel = new JPanel();
        addButtons(panel);
        this.add(panel);

        this.addSeparator();

        JLabel lblwhat = new JLabel("What?");
        this.add(lblwhat);
        this.addSeparator();

        //fifth component is NOT a button!
        textField = new JTextField("A text field");
        textField.setColumns(10);
        textField.addActionListener(this);
        // textField.setActionCommand(TEXT_ENTERED);
        this.add(textField);
    }

    // ** Implements ActionListener interface
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (ADD_COMMAND.equals(command)) {
            //Add button clicked
            String text = textField.getText();
            textField.selectAll();
            treeLexico.ajout("_" + text);
            GraphicInterface.displayJTree(treeLexico, panel_jtree, list, jlabelNumberOfWord);
        }
        else if (REMOVE_COMMAND.equals(command)) {
            //Remove button clicked
            String text = textField.getText();
            textField.selectAll();
            treeLexico.suppr("_" + text);
            GraphicInterface.displayJTree(treeLexico, panel_jtree, list, jlabelNumberOfWord);
        }
        // else if (CLEAR_COMMAND.equals(command)) {
        //     //Clear button clicked.
        //     treeLexico.clear();
        // }
        else if (SEARCH_COMMAND.equals(command)) {
            String text = textField.getText();
            if (treeLexico.getEntree().contient("_" + text)){
                JOptionPane.showMessageDialog(frame,
                        "« " + text + " » is a word of this tree",
                        "Search a word",
                        JOptionPane.INFORMATION_MESSAGE);
            }
            else {
                JOptionPane.showMessageDialog(frame,
                        "« " + text + " » is not a word of this tree",
                        "Search a word",
                        JOptionPane.WARNING_MESSAGE);
            }
        }
        else if (PREFIX_COMMAND.equals(command)) {
            String text = textField.getText();
            if (treeLexico.getEntree().prefixe("_" + text)){
                JOptionPane.showMessageDialog(frame,
                        "« " + text + " » is a prefix of this tree",
                        "Search a word",
                        JOptionPane.INFORMATION_MESSAGE);
            }
            else {
                JOptionPane.showMessageDialog(frame,
                        "« " + text + " » is not a prefix of this tree",
                        "Search a word",
                        JOptionPane.WARNING_MESSAGE);
            }
        }
    }
    // *****


    private void addButtons (JPanel panel) {
        JButton button = null;

        button = new JButton("Add");
        button.setActionCommand(ADD_COMMAND);
        button.addActionListener(this);
        panel.add(button);

        button = new JButton("Remove");
        button.setActionCommand(REMOVE_COMMAND);
        button.addActionListener(this);
        panel.add(button);

        button = new JButton("Search");
        button.setActionCommand(SEARCH_COMMAND);
        button.addActionListener(this);
        panel.add(button);

        button = new JButton("Prefix");
        button.setActionCommand(PREFIX_COMMAND);
        button.addActionListener(this);
        panel.add(button);

    }

}
