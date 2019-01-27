//import java.util.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BinarySearchTreeTest {
	
	private static BinarySearchTree searchTree;

	public static void main(String[] args) {
		 
			
		
		
			int[] tempArray = new int[20];//create an array of size 20
			Scanner scnr = new Scanner(System.in);//scanner to read user inputs
			Scanner scanner = new Scanner(System.in);
			int i = 0;
			int counter = 0; // holds how many integers the user inputed
			String integer = new String();
			BinaryNode predecessor, successor;
			
			
			try {
		
				
				System.out.println("Please enter the initial sequence of integers: ");
				String Line = scnr.nextLine();
				StringTokenizer splitToken = new StringTokenizer(Line, " ");
					while(splitToken.hasMoreTokens()) {
					integer = splitToken.nextToken();
					tempArray[i]  = Integer.parseInt(integer);
					i++;
					counter++;
					
					}
				
			
			
			
	
		int[] array = new int[counter];// create a new array that holds only enough space for the user inputed integers
	
	for(int k = 0; k < array.length; k++) {
		array[k] = tempArray[k];
		
		}
		
		
		searchTree = new BinarySearchTree();// create binary search tree object
		
	
	
			
			
		
			 
		
			for(int m = 0; m < array.length; m++ ) {
				int add = array[m];
			//	System.out.println(add);
				searchTree.add(add); // add integers to the BST  class to create a tree
			}
			System.out.println();
			System.out.print("Pre-Order : ");
			searchTree.preorderTraversing();
			System.out.println();
			
			System.out.print("In-Order: ");
			searchTree.inorderTraversing();
			System.out.println();
			
			System.out.print("Post-Order: ");
			searchTree.postorderTraversing();
			System.out.println();
			
			String userInput;// variable to hold input from the user about commands
			String command; // variable holds the type of command user provided
			String input; // variable holds next token after command
			int number = 0; // variable holds the integer user provided, after parsing
			
			
				do { // cycle through the do-while loop until user asks to quit
			System.out.println("\nCommands:");		
			System.out.println("Enter I along with an integer seperated by a space to insert that number into the tree \nEnter P along with an integer to find the Predecessor of that integer\nEnter S along with an integer to find the Successor of that integer\nEnter D along with an integer to Delete that integer from the tree \nEnter E to Exit the program");		
			System.out.println();	
			System.out.print("Command? ");
			userInput = scanner.nextLine();
			
			StringTokenizer token = new StringTokenizer(userInput, " ");// string tokenizer split string by spaces
			command = token.nextToken();
			
			
			if(command.equalsIgnoreCase("I")) { // insert command
				while(token.hasMoreTokens()) { // if string still has more tokens
				input = token.nextToken();
					 number = Integer.parseInt(input);
					
						searchTree.insert(number); // insert user inputed number into binary search tree
					
					
				}
			} else if(command.equalsIgnoreCase("D")) { // delete command
				while(token.hasMoreTokens()) {
				input = token.nextToken();
				number = Integer.parseInt(input);
				if(searchTree.getEntry(number) == null) { // if entry hasn't been found, then it does not exist
					System.out.println(number + " doesn't exist! ");
				}else {
					searchTree.remove(number); // if entry has been found, remove entry from BST
					System.out.print("In-Order: ");
					searchTree.inorderTraversing(); // print resulting tree
					System.out.println();
				}
				}
			}else if(command.equalsIgnoreCase("P")) { //find predecessor command
				while(token.hasMoreTokens()) {
					input = token.nextToken();
					number = Integer.parseInt(input);
					if(searchTree.getEntry(number) != null) { // if entry has been found, find predecessor
						predecessor = searchTree.predecessor(number);
						System.out.println(predecessor.getData());
					}
				}
			}else if(command.equalsIgnoreCase("S")) { // find successor command
				while(token.hasMoreTokens()) {
					input = token.nextToken();
					number = Integer.parseInt(input); // parse string into integer
					if(searchTree.getEntry(number) != null) { // if entry is found, find successor
					//	searchTree.predecessor(number);
						successor = searchTree.successor(number);
						System.out.println(successor.getData());
					
					}
				}
				
			}else if(command.equalsIgnoreCase("E")) { // exit command
				System.out.println("Thank you for using my program!");
				
			}else {
					assert (command.equalsIgnoreCase("H")); // help command
					System.out.print(" I  Insert a value \n D  Delete a value \n P  Find predecessor \n S  Find successor \n E  Exit the program \n H  Display this message \n");
				}
			
				}while(!command.equalsIgnoreCase("E")); // condition for do-while loop
			
			} finally {
				scanner.close();
				scnr.close();
				// closes all scanner using try-finally
			}
		
	
				

		
	}

}

