

/*
Bigger is Greater

Given a word w, rearrange the letters of w to construct another word s in such a way that, s is lexicographically greater than w. In case of multiple possible answers, find the lexicographically smallest one.

Input Format The first line of input contains t, number of test cases. Each of the next t lines contains w.

Constraints 1≤t≤105 1≤|w|≤100 w will contain only lower case english letters and its' length will not exceed 100.

Output Format For each testcase, output a string lexicographically bigger than w in a separate line. In case of multiple possible answers, print the lexicographically smallest one and if no answer exists, print no answer.

Input:
5
ab
bb
hefg
dhck
dkhc

Output:
ba
no answer
hegf
dhkc
hcdk

*/

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Manisha
 */
public class test {

static ArrayList<String> sb = new ArrayList();
    public static void perm(int n, char[] ch, int i, String w){
        if(i==n){
        //print array;
            String perm_st = String.valueOf(ch);
            
            int val = perm_st.compareTo(w);
            if(val>0)
            {sb.add(perm_st);}
            //System.out.println("Perm String:"+perm_st+" value:"+val);
            return;
        }
        for(int j=i;j<n;++j){
            char temp = ch[j];
            ch[j]=ch[i];
            ch[i]=temp;
            perm(n,ch,i+1,w);
            ch[i]=ch[j];
            ch[j]=temp;
        
        }
    
    }
    public static void main(String[] args){
	String[] w_arr = {"ab","bb","hefg","dhck","dkhc"};
        for(int i=0;i<w_arr.length;i++){
            char[] ch_arr = w_arr[i].toCharArray();
            System.out.println("Word:"+w_arr[i]);
            perm(ch_arr.length,ch_arr,0,w_arr[i]);
            String[] st = sb.toArray(new String[sb.size()]);
            Arrays.sort(st);
            //System.out.println(Arrays.toString(st));
            if(st.length>0)
            {System.out.println(st[0]);}
            else{
            System.out.println("no answer");
            }
            sb.clear();
        }
        
} 
}