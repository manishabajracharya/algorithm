
/*
put even on left and odd on right of array

*/


public class Even_Odd{

static int[] groupNumbers(int[] intArr) {

        if(intArr==null){return null;}
        
        int i=0,j=0;
        
        while(j<intArr.length){
            if((double)intArr[i]%2==0){
                i++;j++;
            }
            if((double)intArr[i]%2!=0 && (double)intArr[j]%2==0){
                int temp = intArr[i];
                intArr[i] = intArr[j];
                intArr[j]= temp;
                i++;j++;
            }
            else{
                j++;
            }
            
        }
        return intArr;

    }
 
public static void main(String args[] ) throws Exception {
  int[] arr={2,1,3,5,4,6};

int[] out=groupNumbers(arr);
for(int i=0;i<out.length;i++){
  System.out.println(out[i]);
  }

}
    
}