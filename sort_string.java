
/*

String (Sentences) has only ASCII values. sort them.
Hint: Bubble sort

*/

public class sort_string{
static String sortCharacters(String inString) { 
StringBuilder out=new StringBuilder();
StringBuilder[] char_ascii = new StringBuilder[256];

for(int i=0;i<char_ascii.length;i++){
    char_ascii[i]=new StringBuilder();

}

for(int i=0;i<inString.length();i++){
    char_ascii[(int)(inString.charAt(i))].append(inString.charAt(i));

}

for(int i=0;i<char_ascii.length;i++){
if(char_ascii[i]!=null){
out.append(char_ascii[i]);
}

}

return out.toString();
}
 
public static void main(String args[] ) throws Exception {
  
    String st = "This is a test case.";
    
    String out = sortCharacters(st);
    
    System.out.println(out);

}
    
}