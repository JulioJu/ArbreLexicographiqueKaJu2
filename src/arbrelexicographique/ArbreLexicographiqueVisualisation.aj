package arbrelexicographique;

import javax.swing.event.TreeModelListener;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

public aspect ArbreLexicographiqueVisualisation {

    declare parents : ArbreLexicographique implements TreeModel ;

    private DefaultTreeModel ArbreLexicographique.defaultTreeModel;

    // ********* implements TreeModel

    public Object ArbreLexicographique.getRoot () {
        // TODO for remove this error, I've changed modifier of field 'entre' from private to public
        // See http://stackoverflow.com/questions/10721037/aspectj-access-private-fields
        return this.entree;
    }

    // @Override doesn't work in AspectJ
    public Object ArbreLexicographique.getChild (Object parent, int index) {
        return ((NoeudAbstrait)parent).getChildAt(index);
    }

    // @Override
    public int  ArbreLexicographique.getChildCount(Object parent) {
        return ((NoeudAbstrait)parent).getChildCount();
    }

    // @Override
    public boolean ArbreLexicographique.isLeaf(Object node) {
        // TODO I don't know if this « if » is necessary. If think no. If node isn't node, should return false and not an exception.
        if (node instanceof NoeudAbstrait)
            throw new IllegalArgumentException("This object isn't a node");
        else if (!(node instanceof Marque || node instanceof NoeudVide))
            return true;
        else
            return false;
    }

    // @Override
    public void ArbreLexicographique.valueForPathChanged(TreePath path, Object newValue) {
        // Not useful for ArbreLexicographique : do not change value of a node.
        throw new UnsupportedOperationException();
    }

    // @Override
    public int ArbreLexicographique.getIndexOfChild(Object parent, Object child) {
        // TODO maybe not useful
        if (!(parent instanceof ArbreLexicographique || child instanceof NoeudAbstrait)) {
            return -1;
        }
        else if(parent == null || child == null)
            return -1;
        return ((NoeudAbstrait)parent).getIndex((NoeudAbstrait)child);
    }

    // @Override
    public void ArbreLexicographique.addTreeModelListener(TreeModelListener l) {
        // Not useful for ArbreLexicographique : do not change value of a node.
        throw new UnsupportedOperationException();
    }

    // @Override
    public void ArbreLexicographique.removeTreeModelListener(TreeModelListener l) {
        // Not useful for ArbreLexicographique : do not change value of a node.
        throw new UnsupportedOperationException();
    }

    // **********************

    // Getters et setters

    // TODO WARNING uncomment
    // public DefaultTreeModel ArbreLexicographique.getDefaultTreeModel () {
    //     return this.defaultTreeModel;
    // }

    public void ArbreLexicographique.setDefaultTreeModel (DefaultTreeModel defaultTreeModel) {
        this.defaultTreeModel = defaultTreeModel;
    }

}

// vim: ft=java
