public class BinaryTreeNode
{
BinaryTreeNode left;
BinaryTreeNode right;
BinaryTreeNode parent;
int data;

public BinaryTreeNode(int d)
{
/*this.data = d;
this.left = null;
this.right = null;
this.parent = null;*/
    
data = d;
left = null;
right = null;
parent = null;
}

}

public class BinaryTree
{
BinaryTreeNode root;

public BinaryTree(BinaryTreeNode rt)
{
root = rt;
}

public int treesize(BinaryTreeNode treeroot)
{
if(treeroot == null)
{return 0;}
else
{return (1+ treesize(treeroot.left) + treesize(treeroot.right));}
}



public void add_node(int val, BinaryTreeNode treeroot)
{
if(treeroot.left == null)
{
treeroot.left = new BinaryTreeNode(val);
}
else if (treeroot.right == null)
{
treeroot.right = new BinaryTreeNode(val);
}
else if(treesize(treeroot.left)<= treesize(treeroot.right))
{
    System.out.println("size left = "+ treesize(treeroot.left));
add_node(val, treeroot.left);
}
else
{
add_node(val, treeroot.right);
}
}
}


public class Interview {
        
    /**
     * @param args the command line arguments
     */

public static void  main(String[] args)
{
BinaryTreeNode rt = new BinaryTreeNode(5);
BinaryTree bt = new BinaryTree(rt);
//System.out.println(bt.root.data);
//bt.root.left = new BinaryTreeNode(4);
//bt.root.right = new BinaryTreeNode(6);        

bt.add_node(4,bt.root);
bt.add_node(6,bt.root);
bt.add_node(3,bt.root);
bt.add_node(2,bt.root);
bt.add_node(7,bt.root);
bt.add_node(9,bt.root);
//System.out.println(bt.root.right.right.data);
}
}
