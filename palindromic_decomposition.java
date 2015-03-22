
/*Palindromic Decomposition
Input: "dessert"
Output: 
d|e|s|s|e|r|t|
d|e|ss|e|r|t|
d|esse|r|t|
*/

public class Interview_Practice{
    
public static String[] palindromicDecomposition(String strInput) {
 ArrayList<String> result= new ArrayList<String>();
 
 if (strInput == null || strInput.length() == 0) {
  return null;
 }
 
 String partition = "";
 addPalindrome(strInput, 0, partition, result);
 String[] returnresult = new String[result.size()]; 
 returnresult = result.toArray(returnresult);
 return returnresult;
}
 
public static void addPalindrome(String s, int start, String partition,
  ArrayList<String> result) {
 //stop condition
  if (start == s.length()) {
  String temp = partition;
  result.add(temp);
 
  return;
 }
 
 for (int i = start + 1; i <= s.length(); i++) {
  String str = s.substring(start, i);
  if (isPalindrome(str)) {
   partition+=str+"|";
   addPalindrome(s, i, partition, result);
   partition=partition.substring(0,(partition.length()-2));
  }
 }
}
 
 
public static boolean isPalindrome(String str) {
 if(str.length()<2){
        return true;
    }
   
return (str.charAt(0)==(str.charAt(str.length()-1)) && isPalindrome(str.substring(1,str.length()-1)));
}

public static void main(String[] args){
Interview_Practice obj=new Interview_Practice();
    String[] ss= obj.palindromicDecomposition("abracadabra");
    
    for(int i=0;i<ss.length;i++){
        
    System.out.println(ss[i]);
 

    }

}
}
