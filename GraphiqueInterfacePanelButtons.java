
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

