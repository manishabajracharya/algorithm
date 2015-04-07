
/*
print path of binary tree

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

public class Solution {
    
    public static void print_path(Node root, int[] path, int len){

if(root==null){
return;
}
path[len++] = root.data;
if(root.left==null && root.right==null){
for(int i=0;i<len;i++){
System.out.print(path[i]+" ");
}
System.out.println();
}
else{
print_path(root.left,path,len);
print_path(root.right,path,len);
}

}
    
public static void main(String args[] ) throws Exception {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    Node r = new Node(8);
r.left =new Node(4);
r.right = new Node(16);
r.left.left = new Node(2);
r.left.right = new Node(5);
r.right.left = new Node(10);
r.right.right = new Node(17);
r.left.right.right = new Node(7);

int[] path = new int[100];
int len =0;
print_path(r,path,len);
}
}