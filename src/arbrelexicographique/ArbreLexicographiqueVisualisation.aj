package arbrelexicographique;

import javax.swing.event.EventListenerList;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

public aspect ArbreLexicographiqueVisualisation {

    declare parents : ArbreLexicographique implements TreeModel ;

    // Not used, but teacher wants this declaration
    private DefaultTreeModel ArbreLexicographique.defaultTreeModel;

    EventListenerList ArbreLexicographique.listenerList = new EventListenerList();

    // ********* implements TreeModel

    // @Override doesn't work in AspectJ
    public Object ArbreLexicographique.getRoot () {
        return (TreeModel)this;
    }

    // @Override
    public Object ArbreLexicographique.getChild (Object parent, int index) {
        if (parent instanceof ArbreLexicographique)
            return ((ArbreLexicographique)parent).getEntree().getChildAt(index);
        else
            return ((NoeudAbstrait)parent).getChildAt(index);
    }

    // @Override
    public int  ArbreLexicographique.getChildCount(Object parent) {
        if (parent instanceof ArbreLexicographique) {
            System.out.println("Je viens de getChildCount : " + ((ArbreLexicographique)parent).getEntree().getChildCount());
            return ((ArbreLexicographique)parent).getEntree().getChildCount();
        }
        else {
            return ((NoeudAbstrait)parent).getChildCount();
        }
    }

    // @Override
    public boolean ArbreLexicographique.isLeaf(Object node) {
        if (node instanceof Marque || node instanceof NoeudVide)
            return true;
        else
            return false;
    }

    // @Override
    /**
     * Messaged when the user has altered the value for the item
     * identified by path to newValue.  Not used by this model.
     * See example on
     * http://docs.oracle.com/javase/tutorial/uiswing/examples/components/index.html#GenealogyExample
     */
    public void ArbreLexicographique.valueForPathChanged(TreePath path, Object newValue) {
        System.out.println("The value has changed (message from ArbreLexicographique.valueForPathChanged)");
    }

    // @Override
    public int ArbreLexicographique.getIndexOfChild(Object parent, Object child) {
    //     if (!(parent instanceof ArbreLexicographique || child instanceof NoeudAbstrait)) {
    //         return -1;
    //     }
    //     else if(parent == null || child == null)
    //         return -1;
    //     return ((ArbreLexicographique)parent).getEntree().getIndex((TreeNode)child);
        // I think child is always of type ArbreLexicographique
        if (parent == null || child == null)
            return -1;
        else if (parent instanceof ArbreLexicographique && child instanceof ArbreLexicographique)
            return ((ArbreLexicographique)parent).getEntree().getIndex((TreeNode)(((ArbreLexicographique)child).getEntree()));
        else if (parent instanceof ArbreLexicographique && child instanceof NoeudAbstrait)
            return ((ArbreLexicographique)parent).getEntree().getIndex((TreeNode)child);
        else if (parent instanceof NoeudAbstrait && child instanceof NoeudAbstrait)
            return ((NoeudAbstrait)parent).getIndex((TreeNode)child);
        // else if (parent instanceof NoeudAbstrait && child instanceof ArbreLexicographique)
        else
            return ((NoeudAbstrait)parent).getIndex((TreeNode)(((ArbreLexicographique)child).getEntree()));
    }

    // @Override
    public void ArbreLexicographique.addTreeModelListener(TreeModelListener l) {
        listenerList.add(TreeModelListener.class, l);
    }

    // @Override
    public void ArbreLexicographique.removeTreeModelListener(TreeModelListener l) {
        listenerList.remove(TreeModelListener.class, l);
    }

    // **********************


}

// vim: ft=java
