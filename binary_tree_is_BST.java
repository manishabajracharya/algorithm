
/*
if given binary tree is a Binary search tree


*/


public class Node {
    Node right;
    Node left;
    int data;
    Node(int d){
    this.data = d;
    this.left=null;
    this.right = null;
    }
}




public class Binary_Tree_is_BST{

public static boolean is_BST(Node root, int min, int max)    {

    if(root == null){
    return true;
    }
    
    if(root.data<min || root.data>max){
        return false;
    }
     
       return(is_BST(root.left,min,root.data) && is_BST(root.right,root.data,max));
        
}
    
public static void main(String[] args)    {

Node r = new Node(8);
r.left =new Node(4);
r.right = new Node(16);
r.left.left = new Node(2);
r.left.right = new Node(5);
r.right.left = new Node(10);
r.right.right = new Node(17);
r.left.right.right = new Node(7);

int min = Integer.MIN_VALUE;
int max = Integer.MAX_VALUE;
System.out.println(is_BST(r,min,max));

}


}