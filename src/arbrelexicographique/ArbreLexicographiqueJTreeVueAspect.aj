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
        // System.out.println(((TreeModel)this).getChild((TreeModel)this, 0));
        System.out.println("blop " + this);
        System.out.println(this instanceof TreeModel);
        this.getChild(this, 0);
        this.getChildCount(this);
        System.out.println("this.getIndexOfChild : " + this.getIndexOfChild(this, new Noeud(new NoeudVide(), new Marque(new NoeudVide()), 'c'))) ;

        vue.setRootVisible(true);
        vue.setShowsRootHandles(true);

        // Icon JTree
        // http://docs.oracle.com/javase/tutorial/uiswing/examples/components/GenealogyExampleProject/src/components/GenealogyTree.java
        DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();
        Icon personIcon = null;
        renderer.setLeafIcon(personIcon);
        renderer.setClosedIcon(personIcon);
        renderer.setOpenIcon(personIcon);
        vue.setCellRenderer(renderer);

        //Create the scroll pane and add the tree to it.
        // JScrollPane treeView = new JScrollPane(vue);

    }

    public JTree ArbreLexicographique.getVue() {
        return vue;
    }

}

// vim: ft=java
