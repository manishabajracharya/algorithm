
You will write a program to determine the word that occurs the most often in a file. If more than one word occurs as the most often, then return the first such word found. You should make all words lowercase before counting them. Thus, “This” and “this” will both be counted as the lowercase version of “this.” You should not consider punctuation, so “end” and “end,” will be considered different words. Use the WordFrequencies program in the lesson as a starting point.

Specifically, you should do the following:

    Create a new project in BlueJ and then create a new class called WordFrequencies. Put all the following items in this class.
    
	Create two private variables. One is called myWords and should be an ArrayList of type String to store unique words from a file, and one is called myFreqs and should be an ArrayList of type Integer. The kth position in myFreqs should represent the number of times the kth word in myWords occurs in the file.
   
    Write a constructor WordFrequencies, and initialize the private variables.
    
	Write a void method findUnique that has no parameters. This method should first clear both myWords and myFreqs, using the .clear() method. Then it selects a file and then iterates over every word in the file, putting the unique words found into myWords. For each word in the kth position of myWords, it puts the count of how many times that word occurs from the selected file into the kth position of myFreqs, as was demonstrated in the lesson. 
	
	Write the method findIndexOfMax that has no parameters. This method returns an int that is the index location of the largest value in myFreqs. If there is a tie, then return the first such value.
	
	package WordFrequencies;

import java.util.ArrayList;

public class WordFrequencies {
	
                private ArrayList<String> myWords;
		private ArrayList<Integer> myFreqs;
		
		public WordFrequencies(){
			myWords = new ArrayList<String>();
			myFreqs = new ArrayList<Integer>();
		}
		
		public void findUnique(String input){
			myWords.clear();
			myFreqs.clear();
			String[] words = input.split(" ");
			for(int i=0;i<words.length;i++){
				int index = myWords.indexOf(words[i].toLowerCase());
				if(index==-1){
					myWords.add(words[i].toLowerCase());
					myFreqs.add(1);
				}
				else{
					myFreqs.set(index,myFreqs.get(index)+1);
				}
			}
		}
		
		public int findIndexOfMax(){
			int max_index = 0;
			int max = myFreqs.get(0);
			for(int i=0;i<myFreqs.size();i++){
				int freq = myFreqs.get(i);
				if(freq>max){
					max = freq;
					max_index = i;
				}
			}
			return max_index;
		}
		
		public static void main(String[] args){
			WordFrequencies obj = new WordFrequencies();
			String inp = "This is a test. Yes a test of a test.";
			obj.findUnique(inp);
			System.out.println("Number of unique words:"+obj.myWords.size());
			for(int i=0;i<obj.myWords.size();i++){
				System.out.println(obj.myFreqs.get(i)+" "+obj.myWords.get(i));
			}
			int index = obj.findIndexOfMax();
			System.out.println("The word that occurs most often and its count are:"+obj.myWords.get(index)+" "+obj.myFreqs.get(index));
		}
}
