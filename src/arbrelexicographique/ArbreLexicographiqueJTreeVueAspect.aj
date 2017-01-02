package arbrelexicographique;

import javax.swing.Icon;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeModel;

aspect ArbreLexicographiqueJTreeVueAspect {

    declare parents : arbrelexicographique.ArbreLexicographique extends JTree;

    private JTree ArbreLexicographique.vue;

    public void ArbreLexicographique.setVue() {

        //Create the nodes.
        vue = new JTree((TreeModel)this.getRoot());
        this.getChild(this, 0);
        this.getChildCount(this);

        vue.setRootVisible(false);
        vue.setShowsRootHandles(true);

        // Icon JTree
        // http://docs.oracle.com/javase/tutorial/uiswing/examples/components/GenealogyExampleProject/src/components/GenealogyTree.java
        DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();
        Icon iconNull = null;
        renderer.setLeafIcon(GraphicInterface.createImageIcon("/images/leaf-xs.png"));
        renderer.setClosedIcon(iconNull);
        renderer.setOpenIcon(iconNull);
        vue.setCellRenderer(renderer);

    }

    public JTree ArbreLexicographique.getVue() {
        return vue;
    }

}

// vim: ft=java
