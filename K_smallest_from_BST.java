
/*
Given a BST, and a positive(or zero) integer K, print top (smallest) K elements from that BST.

if need to find k largest, call root.right, save root value then call root.left.
*/



public static void ksmallest(Node root, List<Integer> ksmall, int k){
	
	if(root==null){
		return;
	}
	
	if(ksmall.size()<k){
		ksmallest(root.left, ksmall, k);
		if(ksmall.size()<k){
		ksmall.add(root.data);
		ksmallest(root.right,ksmall,k);
		}
	}
	
	
}

public static void main(String[] args){
	int k=3;
	List<Integer> ksmall = new ArrayList<Integer>();
	Node root = new Node(20);
	root.left = new Node(8);
	root.right = new Node(22);
	root.left.left= new Node(4);
	root.left.right = new Node(12);
	root.left.right.left = new Node(10);
	root.left.right.right = new Node(14);
	ksmallest(root,ksmall,k);
	
        for(int i=0;i<ksmall.size();i++){
        System.out.println(ksmall.get(i));
        
        }
}

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