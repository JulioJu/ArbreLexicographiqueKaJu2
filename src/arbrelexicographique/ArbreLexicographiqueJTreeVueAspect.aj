package arbrelexicographique;

import javax.swing.Icon;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;
// TODO Why import this ?

aspect ArbreLexicographiqueJTreeVueAspect {


    declare parents : arbrelexicographique.ArbreLexicographique extends JTree;

	//Create the nodes.
    DefaultMutableTreeNode ArbreLexicographique.rootNode;

    public ArbreLexicographique.new(DefaultTreeModel treeModel, DefaultMutableTreeNode rootNode) {

        //Create the nodes.
        super(new DefaultTreeModel(rootNode));
        this.rootNode = rootNode;
        createNodes(rootNode);

        this.setShowsRootHandles(true);

        // Icon JTree
        // http://docs.oracle.com/javase/tutorial/uiswing/examples/components/GenealogyExampleProject/src/components/GenealogyTree.java
        DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();
        Icon personIcon = null;
        renderer.setLeafIcon(personIcon);
        renderer.setClosedIcon(personIcon);
        renderer.setOpenIcon(personIcon);
        this.setCellRenderer(renderer);

        //Create the scroll pane and add the tree to it.
        JScrollPane treeView = new JScrollPane(this);

    }

    public DefaultMutableTreeNode ArbreLexicographique.addObject(DefaultMutableTreeNode parent,
            Object child,
            boolean shouldBeVisible) {
        DefaultMutableTreeNode childNode =
            new DefaultMutableTreeNode(child);

        if (parent == null) {
            parent = rootNode;
        }

        //It is key to invoke this on the TreeModel, and NOT DefaultMutableTreeNode
        // TODO Why cast ???
        ((DefaultTreeModel) getModel()).insertNodeInto(childNode, parent,
                parent.getChildCount());

        //Make sure the user can see the lovely new node.
        if (shouldBeVisible) {
            this.scrollPathToVisible(new TreePath(childNode.getPath()));
        }
        return childNode;
    }

    public DefaultMutableTreeNode ArbreLexicographique.addObject(Object child) {
        DefaultMutableTreeNode parentNode = null;
        TreePath parentPath = this.getSelectionPath();

        if (parentPath == null) {
            parentNode = rootNode;
        } else {
            parentNode = (DefaultMutableTreeNode)
                (parentPath.getLastPathComponent());
        }

        return addObject(parentNode, child, true);
    }

    private void ArbreLexicographique.createNodes(DefaultMutableTreeNode root) {
        DefaultMutableTreeNode level_1 = null;
        DefaultMutableTreeNode level_2 = null;

        level_1 = new DefaultMutableTreeNode("child");
        root.add(level_1);

        level_2 = new DefaultMutableTreeNode("A");
        level_1.add(level_2);
        level_2 = new DefaultMutableTreeNode("B");
        level_1.add(level_2);
        level_2 = new DefaultMutableTreeNode("C");
        level_1.add(level_2);
        level_2 = new DefaultMutableTreeNode("D");
        level_1.add(level_2);
        level_2 = new DefaultMutableTreeNode("E");
        level_1.add(level_2);
        level_2 = new DefaultMutableTreeNode("F");
        level_1.add(level_2);

        level_2.add(new DefaultMutableTreeNode("i"));

    }

}

// vim: ft=java
