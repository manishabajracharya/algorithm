
/*
Question:

prog ::= expr
expr ::= int | ‘(‘ func expr* ‘)’
func ::= ‘+’ | ‘*’ | …

31      -> 31
(+1 2) -> 3
(+3 4 5 6) -> 18
(+(*2 2)(*3 3)) -> (+4 9) -> 13

*/
/*
Thought process

loop until integer
	Find inner expression.
		get index of latest open bracket
		get index of close bracket if previous close bracket index is less than open bracket index
		get substring for these indices
	Calculate result for it
	Replace this inner expression with result.


*/


public class Expression{

public static String get_inner_exp(String exp)
{
int open =0;
int close=0;

for(int i=0;i<exp.length();i++){
	if(exp.charAt(i)=='('){
	open = i;
	}
	if(exp.charAt(i)==')' && close<=open){
	close =i;
	}	
}
//System.out.println("open="+open + " close="+close+" exp="+exp.substring(open,close+1));
return(exp.substring(open,close+1));
}

public static int calculate(String exp)
{
String sub = exp.substring(2, exp.length()-1);
String[] cal = sub.split(" ");
int ret=0;
if(exp.charAt(1)=='+'){
    for (String cal1 : cal) {
        ret = ret + Integer.parseInt(cal1);
    }
}
if(exp.charAt(1)=='*'){
    ret=1;
    for (String cal1 : cal) {
        ret = ret * Integer.parseInt(cal1);
    }
}

return ret;	
}

public static boolean isNumeric(String str)
  {
    try
    {
      double d = Double.parseDouble(str);
    }
    catch(NumberFormatException nfe)
    {
      return false;
    }
    return true;
  }


public static int evaluate(String expression)
{
expression=expression.trim();
    if(isNumeric(expression)){	
	return Integer.parseInt(expression);
}

String inner_exp = get_inner_exp(expression);
//System.out.println("inner_exp="+inner_exp);
String calc = Integer.toString(calculate(inner_exp));
//System.out.println("calc="+calc);
String new_exp = expression.replace(inner_exp,calc+" ");
//System.out.println("new_exp="+new_exp);
return evaluate(new_exp);
}

public static void main(String[] args)
        {
            String str="(+(*2 2)(*2 2))";
            int result = evaluate(str);
            System.out.println(result);
        
        }
}
