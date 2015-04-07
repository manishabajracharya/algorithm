
/*
Problem statement: Consider a row of n coins of values v1 . . . vn, where n is even. We play a game against an opponent by alternating turns. In each turn, a player selects either the first or last coin from the row, removes it from the row permanently, and receives the value of the coin. Determine the maximum possible amount of money we can definitely win if we move first.

Note: The opponent is as clever as the user.

Let us understand the problem with few examples:

    1. 5, 3, 7, 10 : The user collects maximum value as 15(10 + 5)

    2. 8, 15, 3, 7 : The user collects maximum value as 22(7 + 15)

Does choosing the best at each move give an optimal solution?

No. In the second example, this is how the game can finish:

1.
…….User chooses 8.
…….Opponent chooses 15.
…….User chooses 7.
…….Opponent chooses 3.
Total value collected by user is 15(8 + 7)

2.
…….User chooses 7.
…….Opponent chooses 8.
…….User chooses 15.
…….Opponent chooses 3.
Total value collected by user is 22(7 + 15)

So if the user follows the second game state, maximum value can be collected although the first move is not the best.

*/


public class Coins_win{
    
static int maxWin(int[] intCoins) {

int[][] sum = new int[intCoins.length][intCoins.length];
int x,y,z;
for(int m=0;m<intCoins.length;m++){

for(int j=m, i=0;j<intCoins.length; j++,i++){

x=((i+2)<=j)? sum[i+2][j]:0;
y= ((i+1)<=(j-1))?sum[i+1][j-1]:0;
z= (i<=(j-2))?sum[i][j-2]:0;

sum[i][j] = max(intCoins[i]+min(x,y), intCoins[j]+min(y,z));

}

}

return sum[0][intCoins.length-1];

    }
 
public static void main(String[] args) throws java.lang.Exception {
int[] arr= new int[]{8,15,3,7};
    System.out.println(maxWin(arr));

        }
    }