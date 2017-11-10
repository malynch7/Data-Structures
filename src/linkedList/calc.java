/* Purpose: calc.java is a program that handles the solving of basic arithmetic expressions as well as functions containing one variable, defined as x.
 * 
 * Solution: The program accepts user input as an arithmetic infix expression. That expression is then passed to a function that iterates through it, 
 * 	checking each character for various conditions that would render the expression invalid for post-fix conversion. If the expression is found to be 
 * 	valid, it is converted to a postfix expression by iterating through the expression again, using a stack to store all operators. Operands are 
 * 	appended to the postfix string upon encounter, while the top operator on the stack is added when the operator being pushed to the stack has lower 
 * 	precedence than the current top of the stack. Left parentheses are pushed to the stack, and right parentheses result all stack elements being 
 * 	popped and output to the postfix string, down to the  matching left parenthesis. At the end of the expression all remaining stack elements are 
 * 	popped and appended to the postfix string. The postfix expression is printed. If the postfix string contains 'x', user input is taken as an integer 
 * 	and substituted for x in a new temporary expression string. The expression is then solved by iterating through the expression, adding operands to a 
 * 	new stack of integers until an operator is reached. The top operand is then set as the right variable, and the next is set to the left. Operators 
 * 	are passed to a switch case to perform corresponding operations between the left and right variables. The result is pushed to the stack as the 
 * 	process continues, until one integer remains, which is then printed as the solution. If the original postfix expression contained 'x', the user is 
 * 	prompted for another value or a new infix expression.
 * 
 * Data structures used:
 *  -Stack
 * 	-Integer
 * 	-String
 * 	-Character
 * 	-Boolean
 * 
 * How to use: The program will prompt the user for an infix expression. It will then output the converted postfix expression or an error message 
 * 	prompting for a new expression, if the expression was not a valid infix expression. If the expression contained x, the user will be prompted for 
 * 	its value. The expression is now solved and the result is output. The user will then be prompted for either a new value for x or a new infix 
 * 	expression. Entering "n" will terminate the program.
 * 
*/
package linkedList;

import java.util.*;

public class calc {
	
	static String operators = "()+-*/%";
	static String operands = "x0123456789";

	public static void main(String[] args) {
		
		System.out.println(" Integer Calculator\n--------------------\n");
		String restart = "y";
		while(!restart.equals("n")){
			System.out.print("Enter infix expression: ");
			Scanner input = new Scanner(System.in);
			String expression = input.nextLine();
			if(isValid(expression)) {
				String postfix = infixToPostfix( expression);
				System.out.println("Converted expression: " + postfix);
				String newX = "y";
				while( !newX.equals("n") ) {
					expression = new String(postfix);
					if( expression.contains("x") ) {
						System.out.print("Enter integer value for x: ");
						int x = input.nextInt();
						for(int i = 0 ; i < expression.length() ; i++ ) {
							if(expression.charAt(i) == 'x') {
								expression = expression.substring( 0, i) + x + expression.substring( i+1, expression.length());
							}
						}
						solve(expression);
						System.out.println("Enter new value for x? (y/n) ");
						newX = input.next();
					}else {
						solve(expression);
						newX = "n";
					}
				}
			}
			System.out.println("\nEnter new infix expression? (y/n)");
			restart = input.next();
		}
			
	}
	
	public static String infixToPostfix(String infix) {
		/* Converts infix expression to postfix. 
		 * Pre: infix must be a valid infix expression, and the operand and operators strings must be initialized. 
		 * Post: returns the expression as a string in postfix form.  */
			String postfix = "";
			Stack<String> operatorStack = new Stack();
			for(int i = 0 ; i < infix.length(); i++) {
				if(operands.contains(infix.substring(i, i+1))) {
					String operand = infix.substring(i, i+1);
					while(i < infix.length()-1 && operands.contains(infix.substring( i+1, i+2))) {
						i++;
						operand += infix.substring(i, i+1);
					}
					postfix +=  operand + " ";
				}
				if(operators.contains(infix.substring(i, i+1))) {
					if(operatorStack.isEmpty()) {
						operatorStack.push(infix.substring(i, i+1));
					}else {
						switch(infix.substring(i, i+1)) {
						case "(":
							operatorStack.push("(");
							break;
						case ")":
							while(!operatorStack.peek().equals("(")) {
								postfix += operatorStack.pop() + " ";
							}
							operatorStack.pop();
							break;
						case "+": case "-":
							while(!operatorStack.isEmpty() && operators.indexOf(operatorStack.peek()) >= 2) {
								postfix += operatorStack.pop() + " ";
							}
							operatorStack.push(infix.substring(i, i+1));
							break;
						case "*": case "/": case "%":
							while(!operatorStack.isEmpty() &&  operators.indexOf(operatorStack.peek()) >= 4) {
								postfix += operatorStack.pop() + " ";
							}
							operatorStack.push(infix.substring(i, i+1));
							break;
						}
					}
				}
			}
			while(!operatorStack.isEmpty()) {
				postfix += operatorStack.pop() + " ";
			}
			return postfix;
	}
	
	public static void solve(String postfix) {
		/* Prints out the solution to postfix expressions.
		 * Pre: The postfix must be a valid postfix expression containing no variables, and the operand and operators strings must be initialized. 
		 * Post: The result is printed on the screen.  */
		Stack<Integer> operandStack = new Stack();
		int right, left, flag = 0;
		for(int i = 0; i < postfix.length(); i++) {
			if (operands.contains(postfix.substring(i, i+1))){
				String operand = postfix.substring(i, i+1);
				while(i < postfix.length()-1 && operands.contains(postfix.substring( i+1, i+2))) {
					i++;
					operand += postfix.substring(i, i+1);
				}
				operandStack.push(Integer.parseInt(operand));
			}else if(operators.contains(postfix.substring(i, i+1))){
				right = operandStack.pop();
				left = operandStack.pop();
				switch(postfix.substring(i, i+1)) {
				case "+":
					operandStack.push(left + right);
					break;
				case "-":
					operandStack.push(left - right);
					break;
				case "*":
					operandStack.push(left * right);
					break;
				case "/":
					if( right == 0) {
						System.out.println("Cannot solve: Cannot divide by zero");
						flag++;
						break;
					}
					operandStack.push(left / right);
					break;
				case "%":
					operandStack.push(left % right);
					break;
				}
			}
		}
		if( flag == 0 ) {
		System.out.println("Solution: " + operandStack.pop());
		}
	}
	
	public static boolean isValid(String expression) {
		/* Checks each character in a string to see if it is a valid infix expression. 
		 * Pre: The expression, operand, and operators strings must be initialized. 
		 * Post: Returns true if the expression is a valid infix expression, else returns false and prints out an error message.  */
		expression = expression.replaceAll("\\s","");
		int leftParentheses = 0;
		for(int i = 0 ; i < expression.length() ; i++ ) {
			//
			System.out.println("i: " + i);
			if(operands.indexOf(expression.charAt(i)) < 2 ) {
				if(operators.indexOf(expression.charAt(i)) > 1 ){
					if(i == 0 || i == expression.length()-1) {
						System.out.println("Invalid expression: An operator must be flanked by operands");
						return false;

					} 
					if(!((operands.indexOf(expression.charAt(i-1)) > 0 || expression.charAt(i-1) == ')') || (operands.indexOf(expression.charAt(i+1)) > 0 || expression.charAt(i+1) == '('))) {
						System.out.println("Invalid expression: An operator must be flanked by operands");
						return false;
					}
				}else{
					switch(expression.charAt(i)) {
					case 'x':
						if(i > 0 && operands.indexOf(expression.charAt(i-1))>0 || operands.indexOf(expression.charAt(i+1))>0) {
							System.out.println("Invalid expression: No operator between x and the operand");
							return false;
						}
						break;
					case '0':
						if( expression.charAt(i-1) == '/' && ( i == expression.length() - 1 || operands.indexOf(expression.charAt(i+1)) < 2)) {
							System.out.println("Invalid expression: Cannot divide by zero");
							return false;
						}
						break;
					case '(':
						if(operands.indexOf(expression.charAt(i+1)) < 0 && expression.charAt(i+1) != '(') {
							System.out.println("Invalid expression: No operand following left parenthesis");
							return false;
						}
						if(i > 0 && (operators.indexOf(expression.charAt(i-1)) < 0 && expression.charAt(i-1) != '(')) {
							System.out.println("Invalid expression: No operator preceding left parenthesis");
							return false;
						}
						leftParentheses++;
						break;
					case ')':
						if(leftParentheses <= 0) {
							System.out.println("Invalid expression: Mismatched parentheses");
							return false;
						}
						if(operands.indexOf(expression.charAt(i-1)) < 0 && expression.charAt(i-1) != ')') {
							System.out.println("Invalid expression: No operand preceding right parenthesis");
							return false;
						}
						if( i < expression.length()-1 && (operators.indexOf(expression.charAt(i+1)) < 0 && expression.charAt(i+1) != ')') ) {
							System.out.println("Invalid expression: No operator following right parenthesis");
							return false;
						}
						leftParentheses--;
						break;
					case '.':
						System.out.println("Invalid expression: Cannot accept floating point numbers");
						return false;
					default:
						System.out.println("Invalid expression: Illegal character " + expression.charAt(i));
						return false;
						
					}
				}
			}
		}
		if(leftParentheses != 0) {
			System.out.println("Invalid expression: Mismatched parentheses");
			return false;
		}
		return true;
	}
	
}
