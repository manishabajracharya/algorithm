
/*
Split and put alternative nodes in separate LinkedList

*/


public class Split_Nodes {
    
    public static void print_LinkedList(LinkedListNode n){
    
        while(n!=null)
        {
        System.out.print(n.val+" ");
        n=n.next;
        }
        System.out.println();
    
    }
    
    
 public static void alternativeSplit(LinkedListNode pList){
     if(pList==null){
     System.out.println("List is null");
     }
     
     LinkedListNode l1_head = pList;
     LinkedListNode l1_run = pList;
     LinkedListNode l2_head = pList.next;
     LinkedListNode l2_run = pList.next;

     while(l1_run!=null && l2_run!=null){
     
         if(l2_run!=null){
         l1_run.next = l1_run.next.next;
         l1_run = l1_run.next;
         }
         if(l1_run!=null){
         l2_run.next = l2_run.next.next;
         l2_run = l2_run.next;
         }
     
     }
     if(l1_run!=null){l1_run.next = null;l1_run=l1_run.next;}
      if(l2_run!=null){l2_run.next = null;l2_run=l2_run.next;}
 
      
      print_LinkedList(l1_head);
      print_LinkedList(l2_head);
      
 
 }
 
     public static void main(String[] args){
     LinkedListNode head = new LinkedListNode(1);
     head.next = new LinkedListNode(2);
     head.next.next = new LinkedListNode(3);
     alternativeSplit(head);
     }
     
 public static class LinkedListNode{
int val;
LinkedListNode next;
public LinkedListNode(int x){
this.val=x;
this.next=null;
}
}    
}