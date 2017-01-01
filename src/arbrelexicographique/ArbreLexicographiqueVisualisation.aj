package arbrelexicographique;

import javax.swing.event.EventListenerList;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

public aspect ArbreLexicographiqueVisualisation {

    declare parents : ArbreLexicographique implements TreeModel ;

    private DefaultTreeModel ArbreLexicographique.defaultTreeModel;
    EventListenerList ArbreLexicographique.listenerList = new EventListenerList();

    // ********* implements TreeModel

    public Object ArbreLexicographique.getRoot () {
        // TODO for remove this error, I've changed modifier of field 'entre' from private to public
        // See http://stackoverflow.com/questions/10721037/aspectj-access-private-fields
        return (TreeModel)this;
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
        if (!(node instanceof Marque || node instanceof NoeudVide))
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
        listenerList.add(TreeModelListener.class, l);
    }

    // @Override
    public void ArbreLexicographique.removeTreeModelListener(TreeModelListener l) {
        listenerList.remove(TreeModelListener.class, l);
    }

    // **********************


}

// vim: ft=java
