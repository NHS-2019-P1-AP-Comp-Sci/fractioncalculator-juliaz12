/**
 * @author Mr. Rasmussen
 */
package fracCalc;
import java.util.*;

public class FracCalc {

    public static void main(String[] args)
    {
        // TODO: Read the input from the user and call produceAnswer with an equation
    	System.out.print("What do you want to calculate? ");
    	Scanner sc = new Scanner(System.in);
    	String expression = sc.nextLine();
    	while (!expression.equals("quit")) {
    		System.out.println(produceAnswer(expression));
        	System.out.print("What do you want to calculate? ");
    		expression = sc.nextLine();
    	}
        System.out.println("End");
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
    	
        return "whole:" + wholePart(secOp) + " numerator:" + numerator(secOp) + " denominator:" + denominator(secOp); 
    } 
    
    public static int underscore(String operand) {
    	int underscore = operand.indexOf("_");
    	return underscore;
    }
    
    public static int fracLine(String operand) {
    	int fracLine = operand.indexOf("/");
    	return fracLine;
    }
    
    public static int wholePart(String operand) {
    	int underscore = underscore(operand);
    	int fracLine = fracLine(operand);
    	int whole;
    	if (underscore != -1 && fracLine != -1) {
        	whole = Integer.parseInt(operand.substring(0, underscore));
    	} else if (underscore == -1 && fracLine == -1){
    		whole = Integer.parseInt(operand);
    	} else {
    		whole = 0;
    	}
    	return whole;
    }
    
    public static int numerator(String operand) {
    	int underscore = underscore(operand);
    	int fracLine = fracLine(operand);
    	int num;
    	if (underscore != -1 && fracLine != -1) {
        	num = Integer.parseInt(operand.substring(underscore + 1, fracLine));
    	} else if (underscore == -1 && fracLine == -1){
    		num = 0;
    	} else {
    		num = Integer.parseInt(operand.substring(0, fracLine));
    	}
    	return num;
    }
    
    public static int denominator(String operand) {
    	int underscore = underscore(operand);
    	int fracLine = fracLine(operand);
    	int den;
    	if (underscore == -1 && fracLine == -1) {
    		den = 1;
    	} else {
    		den = Integer.parseInt(operand.substring(fracLine + 1));
    	}
    	return den;
    	}

    // TODO: Fill in the space below with any helper methods that you think you will need

}
