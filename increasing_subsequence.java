
/*
Increasing subsequence using dynamic Programming

*/

public class Increasing_Subsequence{
    
static int LISLength(int[] iArray) {

    int[] count = new int[iArray.length] ;
    count[0]=1;
    int max =1;
    
    for(int i=1;i<iArray.length;i++){
    count[i]=1;
    
        for(int j=i-1;j>=0;j--){
            if(count[j]+1 >count[i] && iArray[i]>iArray[j]){
            count[i]=count[j]+1;
            }
            if(count[i]>max){
            max=count[i];
            }
        }
    
    }
return max;
    }
public static void main(String[] args) throws java.lang.Exception {
int[] arr= new int[]{10,22,9,33,21,50,41,60,80};
    System.out.println(LISLength(arr));

        }
    }