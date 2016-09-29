
You will write a program to figure out the most common word length of words from a file. To solve this problem you will need to keep track of how many words from a file are of each possible length. You should group all words of length 30 or more together, and you should not count basic punctuation that are the first or last characters of a group of characters.

Specifically, you should do the following:

    Create a new class called WordLengths.
	
	Write a void method countWordLengths that has two parameters, a FileResource named resource and an integer array named counts. This method should read in the words from resource and count the number of words of each length for all the words in resource, storing these counts in the array counts.

	- For example, after this method executes, counts[k] should contain the number of words of length k.

	- If a word has a non-letter as the first or last character, it should not be counted as part of the word length. For example, the word And, would be considered of length 3 (the comma is not counted), the word “blue-jeans” would be considered of length 10 (the double quotes are not counted, but the hyphen is). Note that we will miscount some words, such as “Hello,” which will be counted as 6 since we don’t count the double quotes but will count the comma, but that is OK as there should not be many words in that category.

	- For any words equal to or larger than the last index of the counts array, count them as the largest size represented in the counts array.

	- You may want to consider using the Character.isLetter function that returns true if a character is a letter, and false otherwise. For example, Character.isLetter(‘a’) returns true, and Character.isLetter(‘-’) returns false. 
	
	package WordLengths;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class WordLengths {
	
	public static void countWordLengths(String input, int[] counts) {
		String[] words = input.split(" ");
		for(int i=0;i<words.length;i++){
			int len = words[i].length();
			if(!Character.isLetter(words[i].charAt(0))){len--;}
			if(!Character.isLetter(words[i].charAt(words[i].length()-1))){len--;}
			if(len>=30){counts[30]++;}
			else {counts[len]++;}
		}
        }
		public static void main(String[] args) throws IOException{
		
		String readfilename = "E:/NetBeans/Interview_Practice/src/Practice/inputtext.txt";
		String writefilename = "E:/NetBeans/Interview_Practice/src/Practice/outputtext.txt"; 
		int[] ct = new int[31];
		try {
                    FileReader fileReader = new FileReader(readfilename);
                    BufferedReader bufferedReader = new BufferedReader(fileReader);
                    String line = bufferedReader.readLine();
		
                    while(line!=null){
			countWordLengths(line,ct);
			line = bufferedReader.readLine();
                    }
                    bufferedReader.close();
                }
                catch(FileNotFoundException ex){
                System.out.println("Unable to open file:"+readfilename);
                }
                try{
                    FileWriter fileWriter = new FileWriter(writefilename);
                    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
					for(int i=0;i<ct.length;i++){
                                            if(ct[i]>0){
						bufferedWriter.write(ct[i]+" words of length "+i);
                                                bufferedWriter.newLine();
                                            }
					}
                    
                    bufferedWriter.close();
                }
                catch(IOException ex){
                System.out.println("Unable to write in file:"+writefilename);
                }
		}
}