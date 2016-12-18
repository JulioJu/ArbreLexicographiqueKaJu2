package arbrelexicographique;

import java.util.Enumeration;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;

public aspect NoeudAbstraitAspect {

    declare parents : NoeudAbstrait implements TreeNode;

    private DefaultMutableTreeNode NoeudAbstrait.defaultMutableTreeNode;

    public TreeNode NoeudAbstrait.getChildAt(int childIndex){
        throw new UnsupportedOperationException();
    }

    public int NoeudAbstrait.getChildCount(){
        throw new UnsupportedOperationException();
    }

    public TreeNode NoeudAbstrait.getParent(){
        throw new UnsupportedOperationException();
    }

    public int NoeudAbstrait.getIndex(TreeNode node){
        throw new UnsupportedOperationException();
    }

    public boolean NoeudAbstrait.getAllowsChildren(){
        throw new UnsupportedOperationException();
    }

    public boolean NoeudAbstrait.isLeaf(){
        throw new UnsupportedOperationException();
    }

    public Enumeration NoeudAbstrait.children(){
        throw new UnsupportedOperationException();
    }

    public DefaultMutableTreeNode NoeudAbstrait.getDefaultMutableTreeNode () {
        return this.defaultMutableTreeNode;
    }

    public void NoeudAbstrait.setDefaultMutableTreeNode (DefaultMutableTreeNode defaultMutableTreeNode) {
        this.defaultMutableTreeNode = defaultMutableTreeNode;
    }

}

// vim: ft=java
