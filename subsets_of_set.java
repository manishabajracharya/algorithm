

public class AllSubset{

    static int[] set = {1,2,3};
    static Integer[] result= new Integer[3];

public static void print_result(){ 
    if(result==null){
    System.out.println();
    }
    else{
        for(int i=0;i<result.length;i++){
            if(result[i]!=null){
                System.out.print(result[i]+" ");
            }      
        }
    }
System.out.println();
}       
    
public static void getsubset(int read, int write) {
  if(read==set.length){
      print_result();
      return;
  }
  getsubset(read+1,write);
  result[write++] = set[read++];
  getsubset(read,write);
}
public static void main(String args[]){
    
    getsubset(0,0);
             
}
}
