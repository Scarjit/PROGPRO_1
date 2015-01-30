package main;

import java.util.Scanner;

public class Main {
	public static void main(String args) {
		//Scanner input = new Scanner(System.in);
		//System.out.println("Input:");
		//String inputLine = input.nextLine();
		String inputLine = args;
		FuncParser.theParser().parse(inputLine);
		FuncParser.theParser().getWurzel().print();
		//input.close();
	}

}
