/* Algorithm to shuffle a standard deck of 52 cards to produce practically equally likely randomization in every execution.

*/

import java.util.Random;
    
public static void main(String[] args){
int len = 52;
int[] deckcards = new int[len+1];
for(int i=1;i<=len;i++){
deckcards[i]=i;
}
//Modern version ofFisher - Yates Shuffle solution
Random rand = new Random();
while(len>1){
int i = rand.nextInt(len)+1;
int temp = deckcards[i];
deckcards[i]=deckcards[len];
deckcards[len] = temp;

len--;

}

for(int i=1;i<=52;i++){
System.out.println(deckcards[i]);
}

}
    