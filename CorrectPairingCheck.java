/*
 * Program Name: CorrectPairingCheck.java
 * Author: Julian Fuentes
 * Date Last Updated: 10 February 2024
 * Purpose: This program checks to see whether a Java source-code file has correct
 *		pairs of grouping symbols.
 */

import java.util.*;
import java.io.*;

public class CorrectPairingCheck 
{
	public static void main(String[] args) throws IOException
	{
		if (args.length != 1) 
		{
			System.out.println("Usage: Java CorrectPairingCheck Source-codeFileName");
			System.exit(0);
		}
		//This should check the command-line argument.
		
		File file = new File(args[0]);
		if (!file.exists()) 
		{
			System.out.println("The file " + args[0] + " doesn't exist. Sorry.");
			System.exit(1);
		}
		//This should check if the file exists.
		
		Stack<Character> symbol = new Stack<>();
		//This should create a new stack.
		
		try (Scanner scan = new Scanner(file);)
		{
			while (scan.hasNext()) 
			{
				String line = scan.nextLine();
				for (int i = 0; i < line.length(); i++) 
				{
					char character = line.charAt(i);
					if (character == '(' || character == '{'
							|| character == '[') 
					{
						symbol.push(character);
					}
					else if (character == ')' || character == '}'
							|| character == ']') 
					{
						checkSymbol(symbol, character);
					}
					//This should push the symbols onto the stack and then
					//it checks the stack.
				}
			}
		}
		System.out.println("The Java source code " + (symbol.isEmpty() ? "has " 
				: "does not have ") + " correct pairs.");
	}
	


private static void checkSymbol(Stack<Character> stack, Character character)
{
	if((stack.peek() == '(' && character == ')')
			|| (stack.peek() == '[' && character == ']')
			|| (stack.peek() == '{' && character == '}')) 
	{
		stack.pop();
	}
	else if((stack.peek() != '(' && character == ')')
			|| (stack.peek() != '[' && character == ']')
			|| (stack.peek() != '{' && character == '}')) 
	{
		System.out.println("The Java source code does not have correct pairs.");
		System.exit(1);
	}
	//This should remove the symbols from the stack.
}}
