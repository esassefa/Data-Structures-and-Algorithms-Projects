
import java.util.*;
public class MaxHeapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scnr = new Scanner(System.in);
		int userInput, size = 100, sets = 20;// hold user input
		
		
		ArrayList<Integer> randomArray = new ArrayList<Integer>(size);// to hold random values until able to transfer to array to send to heap
		ArrayList<Integer> randomArray2 = new ArrayList<Integer>(size);// "   "
		Integer[] arrayOptimal = new Integer[100];
		int[] arraySequential = new int[101];
		Random rand = new Random();
		int totalOSwaps = 0, totalSeqSwaps = 0, averageOSwaps = 0, averageSeqSwaps = 0;
		
	
		
		MaxHeap<Integer> maxHeap2, maxHeap;
		
		//*************************//
		try {
		System.out.print("Please select how to test the program: \n(1) 20 sets of 100 randomly generated integers \n(2) Fixed integer values 1-100 \nEnter choice: ");
		userInput = scnr.nextInt();
	
		}finally {
			scnr.close();
		}
		//**************************//asking the user for a choice
		if(userInput == 1) {// choice 1
	
		 
		 
		 
		 
		 for(int f = 1; f <= sets; f++) {// sets = 20, creating 20 sets one at a time, sending --> recieve data and refresh
			 while(randomArray.size() <= size ) {
				 int random = rand.nextInt(9999) + 1;// generates random integer from 1-10000
				 
				 if(!randomArray.contains(random)) {// filling an array list with 100 integers with from 1 - 10000; no duplicates
				 randomArray.add(random);  // adding 1 by one to array list
				 }
			 }
			 randomArray2 = randomArray; //copying randomArray to randomArray2
			// System.out.println(randomArray2);
			// System.out.println(randomArray);
			 
			 
			 // create array using arrayist and sending the array to the maxHeap constructor
			 //create another array to send values into heap sequentially
			 while(randomArray.size() > 0) {
				 Integer[] newArray = new Integer[randomArray.size()];
				 Integer[] newArray2 = new Integer[randomArray2.size()];
				 randomArray.toArray(newArray);
				 randomArray2.toArray(newArray2);
				 maxHeap = new MaxHeap<Integer>(newArray);// sending array to max heap at once to perform reheap
				 maxHeap2 = new MaxHeap<Integer>(100);
				 for (int i = 1; i<newArray2.length; i++) { // adding array values one by one to perform up heap
					 maxHeap2.add(newArray2[i]);
				 }
				 totalSeqSwaps += maxHeap2.getSequentialSwaps();
				 totalOSwaps += maxHeap.getOptimalSwaps();// how many swaps using optimal method
				 
				 randomArray.clear();// clearing array for new set of integers
				 randomArray2.clear();
				
				 
			 }
			 
			
			 
			 
		 }
		 averageSeqSwaps = totalSeqSwaps/ 20;// find average from 20 sets
		 
		 System.out.println();//space
		 System.out.print("Average swaps for series of insertions: " + averageSeqSwaps);// print
		 
		 System.out.println();
		 averageOSwaps = totalOSwaps/20;// find average
		 
		 
		 System.out.print("Average swaps for optimal method: " + averageOSwaps);//print
		 
		 
		
			
		
			
			
		} else if(userInput == 2) {// choice 2
			for(int j = 0; j < arraySequential.length; j++) {
				arraySequential[j] = j;
			}
			
			maxHeap2 = new MaxHeap<Integer>(arraySequential.length);
			for(int k = 0; k < arraySequential.length; k++) {
				maxHeap2.add(arraySequential[k]);
			}
			System.out.print("\nHeap built using series of insertions: ");
			maxHeap2.printHeap();
			int Sswaps = maxHeap2.getSequentialSwaps();
			System.out.println();
			System.out.print("Number of swaps: " + Sswaps + "\n");
			for(int m = 0; m < 10; m++) {
				maxHeap2.removeMax();
			}
			System.out.print("Heap after 10 removals: ");
			maxHeap2.printHeap();
			System.out.println();
			
			
			
			for(int i = 0; i < arrayOptimal.length; i++) {
				arrayOptimal[i] = i + 1;
			}
			
			maxHeap = new MaxHeap<Integer>(arrayOptimal);// new maxHeap object from trolley;
			
			System.out.print("\nHeap built using optimal method: " );
			maxHeap.printHeap();
			int OSwaps = maxHeap.getOptimalSwaps();
			System.out.println();
			System.out.print("Number of swaps: " + OSwaps + "\n");//print
			for(int n = 0; n < 10; n++) {
				maxHeap.removeMax();
			}
			System.out.print("Heap after 10 removals: ");// print Congratulations
			maxHeap.printHeap();// call print heap method
			System.out.println(); // break
			
		
			
		} else {
			System.out.println("Sorry, invalid input");// if the user inputted values besides 100 + 1[
		}
		
	

	}

}
