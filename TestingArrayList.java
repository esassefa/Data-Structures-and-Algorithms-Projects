import java.util.*;
public class TestingArrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random rand = new Random();// create random object
		
		ArrayList<Integer> arraylist = new ArrayList<Integer>(20);// create arraylist
		ArrayList<Integer> arraylist2 = new ArrayList<Integer>(20);// create arraylist2
		while(arraylist.size() <= 20) {
		
			int random = rand.nextInt(99) + 1;
			if(!arraylist.contains(random))
			arraylist.add(random);
			
		}
		arraylist2 = arraylist;
		Integer[] primeArray2 = new Integer[arraylist2.size()];
		Integer[] primeArray = new Integer[arraylist.size()];
		arraylist.toArray(primeArray);
		arraylist2.toArray(primeArray2);
		
		
		for(int i = 1; i < arraylist.size(); i++) {
			System.out.print(" " + primeArray[i] );
		}
		/*for(int j = 1; j < arraylist2.size(); j++) {
			System.out.print(" " + primeArray2[j]);
		}
		*/
		
	/*	System.out.print("Break \n");
		for(int j = 1; j <arraylist2.size(); j++) {
			System.out.print(" " + primeArray2[j]);
		}
		
		int[] array2 = new int[100];
		
		for(int j = 0; j < array2.length; j++) {
			array2[j] = rand.nextInt(99) + 1;
		}
		
		for(int j = 0; j < array2.length; j++) {
			System.out.print(" " + array2[j]);
		}
		
		*/
	}

}
