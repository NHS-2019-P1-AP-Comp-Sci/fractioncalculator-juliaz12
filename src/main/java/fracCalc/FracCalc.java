/**
 * @author Mr. Rasmussen
 */
package fracCalc;
import java.util.*;

public class FracCalc {

    public static void main(String[] args)
    {
        // TODO: Read the input from the user and call produceAnswer with an equation
    	System.out.print("What do you want to calculate? (Type \"quit\" to exit): ");
    	Scanner sc = new Scanner(System.in);
    	String expression = sc.nextLine();
    	while (!expression.equals("quit")) {
    		System.out.println(produceAnswer(expression));
        	System.out.print("\nWhat do you want to calculate? (Type \"quit\" to exit): ");
    		expression = sc.nextLine();
    	}
        System.out.println("End");
        sc.close();

    }

    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    
    // Takes in an expression inputed by the user and returns the answer as a reduced mixed fraction
    public static String produceAnswer(String input)
    {
        // TODO: Implement this function to produce the solution to the input
    	
    	// Parses the expression into two operands and an operator
    	int firstSpace = input.indexOf(" ");
    	String firstOp = input.substring(0, firstSpace);
    	String opr = input.substring(firstSpace + 1, firstSpace + 2);
    	String secOp = input.substring(firstSpace + 3); 	
    	
//        return "whole:" + wholePart(secOp) + " numerator:" + numerator(secOp) + " denominator:" + denominator(secOp); 

    	// Stores the numerator and denominator of the answer into variables
    	int finalNum = calcNum(oprNum(firstOp), denominator(firstOp), oprNum(secOp), denominator(secOp), opr);
    	int finalDen = calcDen(oprNum(firstOp), denominator(firstOp), oprNum(secOp), denominator(secOp), opr);
    	
    	// Reduces the fraction and converts it into a mixed fraction
		String answer = "";
		if (finalNum == 0) {
			answer = "0";
		} else if (finalDen == 1) {
			answer += finalNum;
		} else if (finalNum % finalDen == 0) {
			answer += finalNum / finalDen;
		}
		else {
			int den = finalDen;
			int i = Math.abs(finalDen);
			
		    for (i = Math.abs(finalDen); i > 1; i--) {
			    if (finalNum % i == 0 && finalDen % i == 0) {
			    	finalNum /= i;
			    	den /= i;
			   		i = 1;
			    }
		    }
	    	
	    	if (den < 0 && finalNum < 0) {
	    		finalNum = Math.abs(finalNum);
	    	} else if (den < 0 && finalNum > 0) {
	    		finalNum *= -1;
	    	}
    		den = Math.abs(den);

	    	if (Math.abs(finalNum) > den) {
	    		int whole = finalNum / den;
	    		int num = Math.abs(finalNum) % den;
	    		answer = whole + "_" + num + "/" + den;
	    	} else {
	    		answer = finalNum + "/" + den;
	    	}
		}
    	return answer;
    } 


    // TODO: Fill in the space below with any helper methods that you think you will need
    
    // Takes in an operand as a mixed fraction and returns the whole number part
    public static int wholePart(String operand) {
    	int underscore = operand.indexOf("_");
    	int fracLine = operand.indexOf("/");
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
    
    // Takes in an operand as a mixed fraction and returns the numerator part
    public static int numerator(String operand) {
    	int underscore = operand.indexOf("_");
    	int fracLine = operand.indexOf("/");
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
    
    // Takes in an operand as a mixed fraction and returns the denominator part
    public static int denominator(String operand) {
    	int underscore = operand.indexOf("_");
    	int fracLine = operand.indexOf("/");
    	int den;
    	if (underscore == -1 && fracLine == -1) {
    		den = 1;
    	} else {
    		den = Integer.parseInt(operand.substring(fracLine + 1));
    	}
    	return den;
    	}
    
    // Takes in an operand, converts it into an improper fraction, and returns the numerator
    public static int oprNum(String operand) {
    	int num;
    	if (wholePart(operand) < 0) {
    		num = Math.abs(wholePart(operand)) * denominator(operand) + numerator(operand);
    		num *= -1;
    	}
    	else {
    		num = wholePart(operand) * denominator(operand) + numerator(operand);
    	}
    	return num;
    }
    
    // Takes in the numerators and denominators of the two operands and the operator of the expression
    // Returns the numerator of the answer to the expression
    public static int calcNum(int num1, int den1, int num2, int den2, String opr) {
    	int newNum1 = num1 * den2;
    	int newNum2 = num2 * den1;
    	int finalNum;
    	if (opr.equals("+")) {
    		finalNum = newNum1 + newNum2;
    	} else if (opr.equals("-")) {
    		finalNum = newNum1 - newNum2;
    	} else if (opr.equals("*")) {
    		finalNum = num1 * num2;
    	} else {
    		finalNum = num1 * den2;
    	}		
    	return finalNum;
    }
    
    // Takes in the numerators and denominators of the two operands and the operator of the expression
    // Returns the denominator of the answer to the expression
    public static int calcDen(int num1, int den1, int num2, int den2, String opr) {
    	int finalDen;
    	if (opr.equals("/")) {
    		finalDen = den1 * num2;
    	} else {
    		finalDen = den1 * den2;
    	}
    	return finalDen;
    }
}
