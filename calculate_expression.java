
/*
Question:

prog ::= expr
expr ::= int | '('func expr* ')'
func ::= '+' | '*' | …

31      -> 31
(+1 2) -> 3
(+3 4 5 6) -> 18
(+(*2 2)(*3 3)) -> (+4 9) -> 13

*/
/*
Thought process

loop until integer
	Find inner expression.
		get index of latest open bracket
		get index of close bracket if previous close bracket index is less than open bracket index
		get substring for these indices
	Calculate result for it
	Replace this inner expression with result.


*/


public class Count{


public static int qaz(int num)
{
		
	
}

public static void main(String[] args)
        {   int[] arr = [33,25,26,58,41,59];        
			int[] index = new int[100];
			for(int i=0;i<arr.length;i++){
				index[arr[i]]=i;				
			}
			int given =33;
			int count =0;
			int ind = index[given];
			for(int i=ind+1;i<arr.length;i++){
				if(arr[i]>given){
					count++;
				}
			}
			 System.out.println(count);
        
        }
}
