package arbrelexicographique;

import javax.swing.event.EventListenerList;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

public aspect ArbreLexicographiqueVisualisation {

    declare parents : ArbreLexicographique implements TreeModel ;

    private DefaultTreeModel ArbreLexicographique.defaultTreeModel;
    EventListenerList ArbreLexicographique.listenerList = new EventListenerList();

    // ********* implements TreeModel

    // @Override
    public Object ArbreLexicographique.getRoot () {
        // TODO for remove this error, I've changed modifier of field 'entre' from private to public
        // See http://stackoverflow.com/questions/10721037/aspectj-access-private-fields
        return (TreeModel)this;
    }

    // @Override doesn't work in AspectJ
    public Object ArbreLexicographique.getChild (Object parent, int index) {
        if (parent instanceof ArbreLexicographique) {
			System.out.println("Noeud : " + ((Noeud)((ArbreLexicographique)parent).getEntree().getChildAt(index)).toString());
			System.out.println(parent);
			System.out.println("Je viens de getChild.");
			return ((ArbreLexicographique)parent).getEntree().getChildAt(index);
        }
        else {
			return ((NoeudAbstrait)parent).getChildAt(index);
        }
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
     */
    public void ArbreLexicographique.valueForPathChanged(TreePath path, Object newValue) {
        System.out.println("The value has changed (message from ArbreLexicographique.valueForPathChanged)");
    }

    // @Override
    public int ArbreLexicographique.getIndexOfChild(Object parent, Object child) {
        if (!(parent instanceof ArbreLexicographique || child instanceof NoeudAbstrait)) {
            return -1;
        }
        else if(parent == null || child == null)
            return -1;
        return ((ArbreLexicographique)parent).getEntree().getIndex((TreeNode)child);
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
