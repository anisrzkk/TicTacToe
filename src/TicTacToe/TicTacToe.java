
package TicTacToe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.List;

public class TicTacToe {
	
	static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
	static ArrayList<Integer> cpuPositions = new ArrayList<Integer>();
	
	
	public static void main(String[] args)
	{
		char[][] gameboard = {{' ', '|', ' ' , '|', ' '}, 
							{'-', '+', '-' , '+', '-'},
							{' ', '|', ' ', '|', ' '},
							{'-', '+', '-', '+', '-'},
							{' ', '|', ' ', '|', ' '}};
		
		
		
		printGameBoards(gameboard);
		
		while(true)
		{
			Scanner scanner = new Scanner(System.in);
			System.out.print("Enter your placement (1-9) :");
			int num = scanner.nextInt();
			
		
			place(gameboard, num , "player");
			
			Random rand = new Random();
			int randoms;
			
			do {
			    randoms = rand.nextInt(9) + 1; // Generate a random position between 1 and 9
			} while (playerPositions.contains(randoms) || cpuPositions.contains(randoms));
	
			place(gameboard, randoms , "cpu");
			
			printGameBoards(gameboard);
			String result = check();
			System.out.println(result);
		}
		
		
	}
	
	public static void printGameBoards(char[][] gameboard) {
		for(char[] row: gameboard)
		{
			for(char c:row)
			{
				System.out.print(c);
			}
			System.out.println();
		}
	}
	
	public static void place(char[][] gameboard, int num, String name) {
	
	    int row = (num - 1) / 3 * 2; 
	    int col = (num - 1) % 3 * 2; 

	    if (gameboard[row][col] != ' ') { 
	        if (name.equals("player")) {
	            System.out.println("Position already taken! Choose another position.");
	        }
	        return; 
	    }

	    char symbol = ' ';
	    if (name.equals("player")) {
	        symbol = 'X';
	        playerPositions.add(num);
	    } else if (name.equals("cpu")) {
	        symbol = 'O';
	        cpuPositions.add(num);
	      
	    }

	    gameboard[row][col] = symbol;
	}

	public static String check()
	{
		
		List<Integer> topRow = Arrays.asList(1,2,3);
		List<Integer> midRow = Arrays.asList(4,5,6);
		List<Integer> botRow = Arrays.asList(7,8,9);
		List<Integer> col1 = Arrays.asList(1,4,7);
		List<Integer> col2 = Arrays.asList(2,5,8);
		List<Integer> col3 = Arrays.asList(3,6,9);
		List<Integer> x1 = Arrays.asList(1,5,9);
		List<Integer> x2 = Arrays.asList(3,5,7);
		
		List<List<Integer>> winning = new ArrayList<>();
		winning.add(topRow);
		winning.add(midRow);
		winning.add(botRow);
		winning.add(col1);
		winning.add(col2);
		winning.add(col3);
		winning.add(x1);
		winning.add(x2);
		
		for (List<Integer> l : winning)
		{
			if(playerPositions.containsAll(l))
			{
				return "congratutaion! You WIN!";
			} else if (cpuPositions.containsAll(l))
			{
				return"You Lose!";
			}
		}
			if (playerPositions.size() + cpuPositions.size() == 9)
			{
				return "CAT!";
			}
		
		return "";
	}
}
