
/*Products are identified by alphanumeric codes. Each code is stored as a string. We have three types of products: high priority,medium priority, and low priority. given an array of product codes, sort the array so that the highest priority products come at the beginning of the array, the medium priority products come in the middle, and the low priority customers come at the ends. Within a priority group, order does not matter. You are given a priority function which, given a product code, return 1 for high, 2 for medium and 3 for low. this array may contain a large number of product codes, so do your best to minimize additional storage.

You are given this function for usage: private int GetPriority(string productCode). You dont need to implement this function. Implement:
public void OrderProductsByPriority(string[] productCodes)  */

public class test {
       private int GetPriority(String productCode){
	
	if("abc".equals(productCode) || "bca".equals(productCode) || "cab".equals(productCode)){
		return 1;
	}
	if("def".equals(productCode) || "efd".equals(productCode) || "fde".equals(productCode)){
		return 2;
	}
	else{
		return 3;
	}
	
}


public void OrderProductsByPriority(String[] productCodes){
		
	if(productCodes.length>0){
		int first = 0;
		int mid = 0;
		int last = productCodes.length-1;
		
		while(last>mid){
			if(GetPriority(productCodes[mid]) ==1){
				String temp =productCodes[mid];
				productCodes[mid] = productCodes[first];
				productCodes[first] = temp;
				first++;
				mid++;	
			}
                        else if(GetPriority(productCodes[mid]) ==2){				
				mid++;	
			}
                        else if(GetPriority(productCodes[mid]) ==3){
                                System.out.println("mid before="+mid+" "+productCodes[mid]);
                                System.out.println("last before="+last+" "+productCodes[last]);
				String temp =productCodes[mid];
				productCodes[mid] = productCodes[last];
				productCodes[last] = temp;
				last--;	
                                System.out.println("mid after="+mid+" "+productCodes[mid]);
                                System.out.println("last after="+last+" "+productCodes[last]);
			}
		}
                if(GetPriority(productCodes[last]) ==1){
                    String temp =productCodes[first];
                    productCodes[first] = productCodes[last];
                    productCodes[last] = temp;
                }
	}
}

public static void main(String[] args){
	String[] productCodes = {"abc","ghi","def","bca","efd"};
        //String[] productCodes = {"ghi","def","abc"};
        test obj = new test();
	obj.OrderProductsByPriority(productCodes);
	
	for(String s: productCodes){
		System.out.println(s);	
	}
	
} 
}