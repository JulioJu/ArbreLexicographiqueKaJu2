package arbrelexicographique;

import java.util.Collections;
import java.util.Enumeration;
import java.util.Vector;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;

public aspect NoeudAbstraitVisualisation {

    declare parents : NoeudAbstrait implements TreeNode;

    // Not used, but teacher wants this declaration
    private DefaultMutableTreeNode NoeudAbstrait.defaultMutableTreeNode;

    // public int i = 1;

    // Noeud.toString
    public String Noeud.toString() {
        return Character.toString(this.getValeur());
    }

    // Pointcut and advice who create new NoeudVide() when we call « ajout » method
    pointcut setParentAddNodeNoeudVide(NoeudVide noeudVide, String s) :
        within(NoeudVide)
        && call(public NoeudAbstrait ajout(String) throws ArbreLexicographiqueException )
        && target(noeudVide)
        && args(s)
        ;
    NoeudAbstrait around(NoeudVide noeudVide, String s) : setParentAddNodeNoeudVide(noeudVide, s) {
        NoeudAbstrait n = new Marque(noeudVide);
        for (int i = s.length() - 1; i >= 0; i--) {
            NoeudAbstrait parent = new Noeud(new NoeudVide(), n, s.charAt(i));
            n.setParent(parent);
            n = parent;
        }
        return n;
    }


    static public final Enumeration<TreeNode> NoeudAbstrait.EMPTY_ENUMERATION
        = Collections.emptyEnumeration();
    // Todo in AspectJ please
    private NoeudAbstrait NoeudAbstrait.parent;

    // TreeNode Implementation
    // ***********

    // @Override doesn't work in AspectJ
    public TreeNode NoeudAbstrait.getChildAt(int childIndex){
        if (this instanceof Marque || this instanceof NoeudVide)
            return (TreeNode) new NoeudVide();
        else if (childIndex >= this.getChildCount())
            throw new ArrayIndexOutOfBoundsException("Node has no children at index " + childIndex);
        else {
        NoeudAbstrait filsCourant = (NoeudAbstrait) ((Noeud)this).getFils();
            for (int i = 0 ; i < childIndex ; i ++) {
                filsCourant = (NoeudAbstrait) filsCourant.getFrere();
            }
            return (TreeNode) filsCourant;
        }
    }

    // @Override
    public int NoeudAbstrait.getChildCount(){
        if (this instanceof Marque || this instanceof NoeudVide) {
            return 0;
        }
        else {
            int count = 0;
            for (NoeudAbstrait filsCourant = (NoeudAbstrait) ((Noeud)this).getFils()
                    ; !(filsCourant instanceof NoeudVide)
                    ; filsCourant = (NoeudAbstrait) filsCourant.getFrere()
                ) {
                count ++;
                }
            return count;
        }
    }

    // @Override
    public TreeNode NoeudAbstrait.getParent(){
        return parent;
    }

    // @Override
    public int NoeudAbstrait.getIndex(TreeNode node){
        if (node == null) {
            throw new IllegalArgumentException("Argument is null.");
        }
        else if (this instanceof Marque || this instanceof NoeudVide)
            return -1;
            // throw new IllegalArgumentException("Do not use this method for a Marque or NoeudVide : not childs.");
        else {
            int count = -1;
            NoeudAbstrait filsCourant = (NoeudAbstrait) ((Noeud)this).getFils();

            // Marque is always a first child, so no « for » loop
            if (filsCourant instanceof Marque && node instanceof Marque)
                return 0;
            else if(filsCourant instanceof Marque && !(node instanceof Marque))
                return -1;

            for (
                    ; !(filsCourant instanceof NoeudVide)
                    && ((Noeud)filsCourant).getValeur() != ((Noeud)node).getValeur()
                    ; filsCourant = (NoeudAbstrait) filsCourant.getFrere()
                ) {
                count ++;
                }
            if (count == this.getChildCount()) {
                return -1;
            }
            return count;
        }
    }

    // @Override
    public boolean NoeudAbstrait.getAllowsChildren(){
        if (this instanceof Marque || this instanceof NoeudVide)
            return false;
        else
            return true;
    }

    // @Override
    public boolean NoeudAbstrait.isLeaf(){
        if (this instanceof Marque || this instanceof NoeudVide)
            return true;
        else
            return false;
    }

    // @Override
    public Enumeration NoeudAbstrait.children(){
        if (this instanceof Marque || this instanceof NoeudVide)
            return EMPTY_ENUMERATION;
        else {
            Vector<NoeudAbstrait> vector = new Vector<NoeudAbstrait>();
            for (NoeudAbstrait filsCourant = (Noeud) ((Noeud)this).getFils()
                    ; !(filsCourant instanceof NoeudVide)
                    ; filsCourant = (NoeudAbstrait) filsCourant.getFrere()
                ) {
                vector.addElement(filsCourant);
                }
            return vector.elements();
        }
    }

    // *************

    // Getters and setters

    public void NoeudAbstrait.setParent(NoeudAbstrait parent) {
        this.parent = parent;
    }


}

// vim: ft=java
