package com.sample.calc;

import java.util.Stack;

public class ProcessInput {

	 public static int processExpression(String str)
	    {
	        char[] chars = str.toCharArray();
	 
	        Stack<Integer> operands = new Stack<Integer>();
	 
	        Stack<Character> operators = new Stack<Character>();
	 
	        for (int i = 0; i < chars.length; i++)
	        {
	            if (chars[i] == ' ')
	                continue;
	 
	            if (chars[i] >= '0' && chars[i] <= '9')
	            {
	                StringBuffer sb = new StringBuffer();
	                while (i < chars.length && chars[i] >= '0' && chars[i] <= '9'){
	                    sb.append(chars[i]);
	                    i++;
	                }
	                operands.push(Integer.parseInt(sb.toString()));
	            }
	 
	            else if (chars[i] == '+' || chars[i] == '-' ||
	                     chars[i] == '*' || chars[i] == '/')
	            {
	                while (!operators.empty() && checkPrecedence(chars[i], operators.peek()))
	                  operands.push(processBasedOnOperands(operators.pop(), operands.pop(), operands.pop()));
	                operators.push(chars[i]);
	            }
	        }
	 
	        while (!operators.empty())
	            operands.push(processBasedOnOperands(operators.pop(), operands.pop(), operands.pop()));
	 
	        return operands.pop();
	    }
	 
	    public static boolean checkPrecedence(char op1, char op2)
	    {
	        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
	            return false;
	        else
	            return true;
	    }
	 
	    public static int processBasedOnOperands(char op, int b, int a)
	    {
	        switch (op)
	        {
	        case '+':
	            return a + b;
	        case '-':
	            return a - b;
	        case '*':
	            return a * b;
	        case '/':
	            return a / b;
	        }
	        return 0;
	    }
}
