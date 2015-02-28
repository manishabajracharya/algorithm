
/* Given two sorted arrays, return new array containing elements common to the arrays*/
 
 /*My take: create an ArrayList and run simple while loop. 
 To Note: We cannot use static array because by default all elements in static integer array =0 in Java. Therefore, using ArrayList */


public static List<Integer> Arr(int[]arr1, int[]arr2){
        List<Integer> new_list = new ArrayList<Integer>();
        int i=0,j=0;
     while(i<arr1.length && j<arr2.length){
         if(arr1[i]==arr2[j]){
            new_list.add(arr1[i]); 
            i++; j++;
         }
         else if(arr1[i]<arr2[j]){
             i++;
         }
         else {
             j++;
         }
     }
     return new_list;
         
    }
    
    public static void main(String[] args){
        int[] arr1={0,1,2,3,4,8};
        int[] arr2 ={1,2,50,60,90,110};
        System.out.println("array="+Arr(arr1,arr2));
    }