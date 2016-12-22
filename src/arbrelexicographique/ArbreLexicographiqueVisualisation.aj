package arbrelexicographique;

import javax.swing.event.TreeModelListener;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

public aspect ArbreLexicographiqueVisualisation {

    declare parents : ArbreLexicographique implements TreeModel ;

    private DefaultTreeModel ArbreLexicographique.defaultTreeModel;

    // TODO delete it.
    private String ArbreLexicographique.privateVarDefineInAspect3="Hello from attribute define in aspect";

    public Object ArbreLexicographique.getRoot () {
        throw new UnsupportedOperationException();
    }

    public Object ArbreLexicographique.getChild (Object parent, int index) {
        throw new UnsupportedOperationException();
    }

    public int  ArbreLexicographique.getChildCount(Object parent) {
        throw new UnsupportedOperationException();
    }

    public boolean ArbreLexicographique.isLeaf(Object node) {
        throw new UnsupportedOperationException();
    }

    public void ArbreLexicographique.valueForPathChanged(TreePath path, Object newValue) {
        throw new UnsupportedOperationException();
    }

    public int ArbreLexicographique.getIndexOfChild(Object parent, Object child) {
        throw new UnsupportedOperationException();
    }

    public void ArbreLexicographique.addTreeModelListener(TreeModelListener l) {
        throw new UnsupportedOperationException();
    }

    public void ArbreLexicographique.removeTreeModelListener(TreeModelListener l) {
        throw new UnsupportedOperationException();
    }

    // TODO delete it
    public String ArbreLexicographique.getPrivateVarDefineInAspect3 () {
        return this.privateVarDefineInAspect3;
    }

    // TODO delete it
    public void ArbreLexicographique.setPrivateVarDefineInAspect3 (String privateVarDefineInAspect3) {
        this.privateVarDefineInAspect3 = privateVarDefineInAspect3;
    }

    public DefaultTreeModel ArbreLexicographique.getDefaultTreeModel () {
        return this.defaultTreeModel;
    }

    public void ArbreLexicographique.setDefaultTreeModel (DefaultTreeModel defaultTreeModel) {
        this.defaultTreeModel = defaultTreeModel;
    }

}

// vim: ft=java
