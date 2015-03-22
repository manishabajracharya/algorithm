

public class NumberofBinaryTrees{

    
static int countTrees(int iNodeCount) {
    
    if(iNodeCount<=1){
    return 1;
    }
    int sum=0;
    for(int i=0;i<iNodeCount;i++){
    
    sum = sum+countTrees(i)*countTrees(iNodeCount-1-i);
    } 
    return sum;
    }
    
public static void main(String args[]){
  
    System.out.println(countTrees(4));
    
    }
}

