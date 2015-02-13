

/*
qaz is a value for a number where this number is less than the other next values which have indexes larger than the index of this number. 
for example: 33 , 25 , 26 , 58 , 41 , 59 -> qaz of (33) = 3 where 33 less than 3 numbers (58 , 41 , 59), qaz of (25) = 4 and not 5 because the index of 33 is less than the index of 25, qaz of (26) = 3 , qaz of (58) = 1 , qaz of (41) = 1 , qaz of (59) = 0. 
the question is to find the max qaz. 

*/

public static void main(String[] args){
            int[] arr = {33,25,26,58,41,59};        
			int[] index = new int[100];
			for(int i=0;i<arr.length;i++){
				index[arr[i]]=i;				
			}
			int given =58;
			int count =0;
			int ind = index[given];
			for(int i=ind+1;i<arr.length;i++){
				if(arr[i]>given){
					count++;
				}
			}
			 System.out.println(count);
        
        }