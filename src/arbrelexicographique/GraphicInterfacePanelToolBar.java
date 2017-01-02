package arbrelexicographique;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;

public class GraphicInterfacePanelToolBar extends JToolBar implements ActionListener {

    private static final long serialVersionUID = -3677068589440633429L;

    JTextField textField;

    private static String ADD_COMMAND = "add";
    private static String REMOVE_COMMAND = "remove";
    // private static String CLEAR_COMMAND = "clear";
    private static String CHOOSE_COMMAND = "choose";

    ArbreLexicographique treeLexico;
    JPanel panel_jtree;

    public GraphicInterfacePanelToolBar(String string, ArbreLexicographique treeLexico, JPanel panel_jtree) {
        super(string);
        this.treeLexico = treeLexico;
        this.panel_jtree = panel_jtree;

        // Options
        this.setFloatable(true);
        this.setRollover(true);

        //separator
        this.addSeparator();

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
            treeLexico.setVue();
            panel_jtree.removeAll();
            panel_jtree.revalidate();
            panel_jtree.add(this.treeLexico.getVue());
        }
        else if (REMOVE_COMMAND.equals(command)) {
            //Remove button clicked
            String text = textField.getText();
            textField.selectAll();
            treeLexico.suppr("_" + text);
            treeLexico.setVue();
            panel_jtree.removeAll();
            panel_jtree.revalidate();
            panel_jtree.add(this.treeLexico.getVue());
        }
        // else if (CLEAR_COMMAND.equals(command)) {
        //     //Clear button clicked.
        //     treeLexico.clear();
        // }
        else if (CHOOSE_COMMAND.equals(command)) {

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

        button = new JButton("Choose");
        button.setActionCommand(CHOOSE_COMMAND);
        button.addActionListener(this);
        panel.add(button);

        button = new JButton("Prefix");
        panel.add(button);

    }

}
