

/*
show only the comments 
single line comment : //
multi line comment : /*   */

*/



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Manisha
 */
public class Interview_Practice{

public static void main(String args[] ) throws Exception {
    String path="input001.txt";
   FileReader reader = new FileReader(path);
  BufferedReader textReader = new BufferedReader(reader);

  List<String> textData = new LinkedList<String>();//linked list to avoid realloc
  String line;
  boolean flag = false;
  while ((line = textReader.readLine()) != null) {
      if (line.contains("//")) {
          int ind=line.indexOf("//");
          textData.add(line.substring(ind));
      }
      if(line.contains("/*") || flag==true) {
          flag = true;
          if(line.contains("/*")){
          int ind=line.indexOf("/*");
          textData.add(line.substring(ind));
          }
          else if(line.contains("*/")){
          int ind=line.indexOf("*/");
          textData.add(line.substring(0,ind+2));
          
          }
          
          else{
          textData.add(line);
          }
      }
      
      if(line.contains("*/")){
          flag=false;
      }
                   
       }

  // close the line-by-line reader and return the data
  textReader.close();
  
  //print
  for(int i=0;i<textData.size();i++){
  System.out.println(textData.get(i));
  
  }
  
  
  
}