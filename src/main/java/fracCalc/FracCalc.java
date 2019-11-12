/**
 * @author Mr. Rasmussen
 */
package fracCalc;
import java.util.*;

public class FracCalc {

    public static void main(String[] args)
    {
        // TODO: Read the input from the user and call produceAnswer with an equation
    	Scanner sc = new Scanner(System.in);
    	String expression = sc.nextLine();
    	System.out.println(produceAnswer(expression));
    }

    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    public static String produceAnswer(String input)
    {
        // TODO: Implement this function to produce the solution to the input
    	int firstSpace = input.indexOf(" ");
    	String firstOp = input.substring(0, firstSpace);

    	int secSpace = input.indexOf(" ", firstSpace + 1);
    	String opr = input.substring(firstSpace + 1, secSpace);
    	String secOp = input.substring(secSpace + 1);
//    	for (int i = 0; i < firstSpace; i++) {
//    		firstOp += input.charAt(i);
//    	}
//    	int firstOp = input.charAt(firstSpace + 1);
    	
        return secOp;
    }

    // TODO: Fill in the space below with any helper methods that you think you will need

}
