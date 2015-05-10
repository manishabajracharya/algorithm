

/* Given numbers from 1-N, given N, numbers not sorted. Find missing number.*/


public static void missing_num(int[] arr, int n){
	
	BitSet bs = new BitSet(n);
        for(int i=0;i<arr.length;i++){
        bs.set(arr[i]-1);
        }
        
        for(int i=0;i<n;i++){
        if(!bs.get(i)){     
        System.out.println(i+1);
        }
        }
}

public static void main(String[] args){
	int[] arr={1,2,4,5};
        int n = 5;
	missing_num(arr,n);

}















