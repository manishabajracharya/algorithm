
public class Nqueen{
static int count=0;
    public static void getnxn(int[] arr, int i, int n){
        if(n<2) {
        return;
        }        
        if(i==n){
            if(abs(arr[n-1]-arr[n-2])!=1){
        for(int k=0;k<i;k++){
        System.out.print(arr[k]+" ");
        }
        System.out.print(",");
        count++;
            }
        return;    
    }
    for(int j=i;j<n;++j){
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i]=temp;
        if(i>1){
        if(abs(arr[i-1]-arr[i-2])!=1)
        {
        getnxn(arr,i+1,n);
               
        }
        arr[i] =arr[j];
        arr[j]=temp;
        
        }
        else{ 
        getnxn(arr,i+1,n);
        arr[i] =arr[j];
        arr[j]=temp;
        }
       }   
    }
 

public static void main(String args[]){
 
    for(int i=1;i<=10;i++){
        int[] arr = new int[i];
        for(int j=0;j<i;j++){
            arr[j]=j+1;
        }
        getnxn(arr,0,i);
        System.out.println();
        System.out.println("count="+count);
    }
    
}
}
