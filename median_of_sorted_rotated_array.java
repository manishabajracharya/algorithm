/* Print Median of sorted rotated array
Try in Linear Time
*/

public static void findstart(int[] arr, int start, int end){

    int mid= start + (end-start)/2;
    
    if(mid==0 || arr[mid]<=arr[mid-1]){
        int index=0;
        if(arr.length%2!=0){ //odd
            if(mid+(arr.length)/2 > arr.length){
            index = (mid+(arr.length)/2)-arr.length;
            }
            else{
            index = (mid+(arr.length)/2);
            }
                
            System.out.println(arr[index]);
            }
        else{ //even
            int index1=0,index2=0;
            if(mid+(arr.length)/2 > arr.length){
            index1 = (mid+(arr.length)/2)-arr.length;
            index2 = index1-1;
            }
            else if(mid+(arr.length)/2 == arr.length){
            index1 = (mid+(arr.length)/2)-1;
            index2 =0;
            }
            else{
            index1 = (mid+(arr.length)/2);
            index2=index1-1;
            }
         System.out.println((float)(arr[index1]+arr[index2])/2 );
        }   
     }
    else{
        if(arr[start]<arr[end]){
            findstart(arr, 0, mid-1);
        }
        else{
            findstart(arr,mid+1, end);
        }
    }


}    
    
public static void main(String[] args){
int[] arr={5,6,1,2,3,4};
   
if(arr[0]<arr[arr.length-1]){
if(arr.length%2!=0){//odd
    System.out.println(arr[arr.length/2]);
}
else{//even
    System.out.println((float)(arr[arr.length/2]+arr[(arr.length/2) -1])/2 );

}

}
    
else{
    findstart(arr, 0, arr.length-1);
}



}