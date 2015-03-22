
/* Given Random function to generate random number between 1 -5, generate randon between 1 -7

1	2	3	4	5	
7	14	21	28	35  (trying to get this so that we can take mod of these numbers to get the number between 1 - 7)


*/

public static int rand7(){
        int i= ((rand5)*5 + 2*(rand5))%7;
        return i;
        
    }
    
public static void main(String args[] ) throws Exception {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    int result =rand7();
    System.out.println(result);
    
    
}