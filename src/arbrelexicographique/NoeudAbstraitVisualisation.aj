package arbrelexicographique;

import java.util.Collections;
import java.util.Enumeration;
import java.util.Vector;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;

public aspect NoeudAbstraitVisualisation {

    declare parents : NoeudAbstrait implements TreeNode;

    private DefaultMutableTreeNode NoeudAbstrait.defaultMutableTreeNode;

    public int i = 1;

    // Noeud.toString changed
    pointcut noeudToString(Noeud noeud, String s) : within (Noeud)
                               && call(public String toString(String))
                               && target(noeud)
                               && args(s)
                               ;
    String around(Noeud noeud, String s) : noeudToString(noeud, s) {
        System.out.println("***");
        System.out.println(s);
        System.out.println(noeud.getValeur());
        System.out.println(i++);
        System.out.println("***\n\n\n\n\n");
        // return Character.toString(noeud.getValeur());
        return s;
    }
    // Noeud.toString
    // TODO Why doesn't it work ??
    // public String Noeud.toString() {
    //     return Character.toString(this.getValeur());
    // }


    // TreeNode Implementation
    // ***********

    static public final Enumeration<TreeNode> NoeudAbstrait.EMPTY_ENUMERATION
        = Collections.emptyEnumeration();
    // Todo in AspectJ please
    private NoeudAbstrait NoeudAbstrait.parent;

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

    // @Override doesn't work in AspectJ
    public TreeNode NoeudAbstrait.getChildAt(int childIndex){
        if (this instanceof Marque || this instanceof NoeudVide)
            return null;
        NoeudAbstrait filsCourant = (NoeudAbstrait) ((Noeud)this).getFils();
        if (childIndex == 0){
            return (TreeNode) filsCourant;
        }
        else if (childIndex >= this.getChildCount())
            throw new ArrayIndexOutOfBoundsException("Node has no children at index " + childIndex);
        else {
            for (int i = 0 ; i < childIndex && i < this.getChildCount() ; i ++) {
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
            for (NoeudAbstrait filsCourant = (Noeud) ((Noeud)this).getFils()
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
        else if (!(this instanceof Marque || this instanceof NoeudVide))
            return -1;
        else {
            int count = 0;
            for (NoeudAbstrait filsCourant = (Noeud) ((Noeud)this).getFils()
                    ; !(filsCourant instanceof NoeudVide)
                    // Not isEqual, because it's by reference not by value
                    && filsCourant != node
                    ; filsCourant = (NoeudAbstrait) filsCourant.getFrere()
                ) {
                count ++;
                }
            if (count == this.getChildCount())
                return -1;
            return count;
        }
    }

    // @Override
    public boolean NoeudAbstrait.getAllowsChildren(){
        if (!(this instanceof Marque || this instanceof NoeudVide))
            return false;
        else
            return true;
    }

    // @Override
    public boolean NoeudAbstrait.isLeaf(){
        if (!(this instanceof Marque || this instanceof NoeudVide))
            return true;
        else
            return false;
    }

    // @Override
    public Enumeration NoeudAbstrait.children(){
        if (!(this instanceof Marque || this instanceof NoeudVide))
            return EMPTY_ENUMERATION;
        else {
            Vector<NoeudAbstrait> vector = new Vector<NoeudAbstrait>(3, 2);
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

    public DefaultMutableTreeNode NoeudAbstrait.getDefaultMutableTreeNode () {
        return this.defaultMutableTreeNode;
    }

    public void NoeudAbstrait.setDefaultMutableTreeNode (DefaultMutableTreeNode defaultMutableTreeNode) {
        this.defaultMutableTreeNode = defaultMutableTreeNode;
    }

    public void NoeudAbstrait.setParent(NoeudAbstrait parent) {
        this.parent = parent;
    }


}

// vim: ft=java
