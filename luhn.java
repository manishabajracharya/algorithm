

// 1. From the rightmost digit, moving left, double the value of every second digit; if the product
//    of this doubling operation is greater than 9 (e.g., 8 × 2 = 16), then sum the digits of the
//    product (e.g., 16: 1 + 6 = 7, 18: 1 + 8 = 9).
// 2. Take the sum of all digits.
// 3. If the total modulo 10 is equal to 0 (if the total ends in zero) then the number is valid
//    according to the Luhn formula; else it is not valid.

// Write a function that takes a credit card number as a string and returns true if the number is
// valid according to the Luhn agorithm, otherwise false.


// 184 = 174 %10 = 2 (not valid)
  
  
//   loop with decrement of 2 >0
//   num = ...%10
//   num = num*2
//   if(num>9)  numm= num/10 + num%10;
//   total_num = ...+num+total_num
  
//   total_num%10 ?
  
public static int regularsum(int cc){

int cc1 = cc;
int reg_sum=0;
while(cc1>0){
  reg_sum+ = cc1%10;
    cc1 = cc1/100; 
  }
return reg_sum;

}


public static int doublesum(int cc){
int cc2 = cc;
int double_sum = 0;
cc2 = cc2/10;
while(cc2>0){
  int temp = (cc2%10)*2;
    if(temp>9){
    	temp = temp/10 + temp%10;
    }
  double_sum+ = temp;
  cc2 = cc2/100;
  }
return double_sum;

}


  
public static boolean Luhn(int cc){

  if(cc== null || cc==0)  {
  	return false;
  }
  
int sum1 = regularsum(cc);
int sum2 = doublesum(cc);

 if((sum1+sum2)%10==0){
    return true;
    }
return false;
}
  