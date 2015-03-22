public class 3Sum{
 
public static String[] printTriplets(int[] intArr) {

    List<String> arr = new ArrayList<String>();
    Map<Integer, int[]> hm = new HashMap<Integer, int[]>();
    for(int i=0;i<intArr.length-1;i++){
        for(int j=i+1;j<intArr.length;j++){            
            hm.put(intArr[i]+intArr[j], new int[]{intArr[i],intArr[j]});       
        }    
    }
    
    for(int i=0;i<intArr.length;i++){
    if(hm.containsKey(-intArr[i])){
    int[] pair = hm.get(-intArr[i]);  
    if(pair[0]!=intArr[i] && pair[1]!=intArr[i]){
        int[] temp = new int[]{pair[0],pair[1],intArr[i]};
        Arrays.sort(temp);
        String st_temp = temp[0]+","+temp[1]+","+temp[2];
        if(!arr.contains(st_temp)){
            arr.add(st_temp);
        
        }   
    }
    }
    }
    System.out.println(arr);
        
    String[] retarr = new String[arr.size()];
    arr.toArray(retarr);
    return retarr;
    }
    
 

  

public static void main(String[] args){
int[] arr={10,-4,-6,3,4,1};

System.out.println(printTriplets(arr));
}
    
    
    
    
}
