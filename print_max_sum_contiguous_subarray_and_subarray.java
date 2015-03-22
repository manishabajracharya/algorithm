
/*
Find maximum sum of contiguous subarray, print all such subarray.

Thought:

given: -2,1,-3, 4, -1, 2, 1, -5, 4

Sum array				subarray array
max(-2)						-2
max(1 or (-2+(1))) => 1		1	
max(-3 or (1 + (-3)))=> -2	1,-3
max(4 or (4+(-3)))=> 4		4
max(-1 or (4+(-1)))=> 3		4,-1
..
..
..

*/




static String[] printMaximumSubarraySum(int[] intArr) {

    List<String> stlist = new ArrayList<String>();
int[] sum = new int[intArr.length];
String[] subarr = new String[intArr.length];

sum[0]=intArr[0];
subarr[0] = String.valueOf(intArr[0]);
int max = intArr[0];
for(int i=1;i<intArr.length;i++){
    int sum_with_previous = intArr[i]+sum[i-1];
    if(sum_with_previous>intArr[i]){
        sum[i] = sum_with_previous;
        subarr[i] = subarr[i-1]+","+ String.valueOf(intArr[i]);
    }
    else{
        sum[i] = intArr[i];
        subarr[i] = String.valueOf(intArr[i]);
    }
    if(sum[i]>max){
        max = sum[i];
    } 

}

stlist.add(String.valueOf(max));
for(int i=0;i<intArr.length;i++){
    if(sum[i]==max){
        stlist.add(subarr[i]);
    }
}
    
    
    String[] retst = new String[stlist.size()];
    stlist.toArray(retst);
    
    return retst;
    }

    
public static void main(String[] args){
int[] arr={-2,1,-3,4,-1,2,1,-5,4};
String[] str = printMaximumSubarraySum(arr);
for(int i=0;i<str.length;i++){
System.out.println(str[i]);
}

}