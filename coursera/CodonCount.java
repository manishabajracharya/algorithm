

Write a program to find out how many times each codon occurs in a strand of DNA based on reading frames. A strand of DNA is made up of the symbols C, G, T, and A. A codon is three consecutive symbols in a strand of DNA such as ATT or TCC. A reading frame is a way of dividing a strand of DNA into consecutive codons. Consider the following strand of DNA = “CGTTCAAGTTCAA”.

There are three reading frames.

    The first reading frame starts at position 0 and has the codons: “CGT”, “TCA”, “AGT” and “TCA”. Here TCA occurs twice and the others each occur once.
    The second reading frame starts at position 1 (ignoring the first C character) and has the codons: “GTT”, “CAA”, “GTT”, “CAA”. Here both GTT and CAA occur twice.
    The third reading frame starts at position 2 (ignoring the first two characters CG) and has the codons: “TTC”, “AAG”, “TTC”. Here TTC occurs twice and AAG occurs once.

A map of DNA codons to the number times each codon appears in a reading frame would be helpful in solving this problem.

Specifically, you should do the following:

    Create a new class for this problem
    
	Create a private variable to store a HashMap to map DNA codons to their count.
    
	Write a constructor to initialize the HashMap variable.
	
	Write a void method named buildCodonMap that has two parameters, an int named start and a String named dna. This method will build a new map of codons mapped to their counts from the string dna with the reading frame with the position start (a value of 0, 1, or 2). You will call this method several times, so be sure to make your map is empty before building it.
	
	Write a method named getMostCommonCodon that has no parameters. This method returns a String, the codon in a reading frame that has the largest count. If there are several such codons, return any one of them. This method assumes the HashMap of codons to counts has already been built.
	public class CodonCount{
		private HashMap<Integer,ArrayList<String>> dna_codons;
		public CodonCount(){
			dna_codons = new HashMap<Integer,ArrayList<String>>();
		}	
		
		public void buildCodonMap(int start, String dna){
			ArrayList<String> codons = new ArrayList<String>();
			int len = dna.length();
			for(int i= start;i<=len-3;i+3){
				String code = dna.substring(i,i+3);
				codons.add(code);
			}
			dna_codons.put(start,codons);
			
		}
		
		public printCodon(int i, ArrayList<String> temp){
			HashMap<String,Integer> codon_group = new HashMap<String, Integer>();
			for(String s: temp){
				int count = codon_group.get(s);
				if (count==-1){
					codon_group.put(s,1);
				}
				else{
					codon_group.put(s,codon_group.get(s)+1);
				}
			}
			System.out.println("Reading frame starting with "+i+" results in "+ codon_group.size()+" unique codons");
			int max =0;
			String max_codon="";
			for(String s : codon_group.keySet()){
				if(codon_group.get(s)>max){
					max=codon_group.get(s);
					max_codon = s;
				}
			}
			System.out.println("abd most common codon is "+max_codon+" with value "+max);
			
			for(String s : codon_group.keySet()){
				System.out.println(s+" "+codon_group.get(s));
			}
		}
		
		public String getMostCommonCodon(){
			
			for(Integer i : dna_codons.keySet()){
				ArrayList<String> temp = new ArrayList<String>(dna_codons.get(i));
				printCodon(i, temp);
			}
			
		}
		
		public static void main(String[] args){
			CodonCount obj = new CodonCount();
			String dnacode = "CGTTCAAGTTCAA";
			obj.buildCodonMap(0,dnacode);
			obj.buildCodonMap(1,dnacode);
			obj.buildCodonMap(2,dnacode);
			obj.getMostCommonCodon();
			
		}
	}